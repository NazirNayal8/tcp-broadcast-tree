import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.*;

public class NIOClient {

    private SocketChannel client;
    private InetSocketAddress hostAddress ;
    private ByteBuffer buffer = ByteBuffer.allocate(1024);
    private String parentAddress;
    private int parentPort ;


    public NIOClient(String address,int port) throws IOException, InterruptedException{
        parentAddress = address;
        parentPort = port;
        hostAddress = new InetSocketAddress(parentAddress,parentPort);
        startClient();
    }

    public void startClient() {


        try{

            while(true){
                client = SocketChannel.open(hostAddress);
                client.configureBlocking(false);

                buffer.flip();
                buffer.clear();

                buffer.put(Data.HEAT_BEAT_MESSAGE.getBytes());

                buffer.flip();
                client.write(buffer);

                Selector selector = Selector.open();
                client.register(selector, SelectionKey.OP_READ);


                // the selector expects a single response from the server.
                    if(selector.select() <= 0)
                        break;
                    selector.select(); // here maybe I should put an if statement to check if it is greater than zero

                    Iterator keys = selector.selectedKeys().iterator();
                    while(keys.hasNext()){

                        SelectionKey key = (SelectionKey) keys.next();
                        keys.remove();

                        if(!key.isValid())
                            continue;

                        if(key.isReadable())
                            this.read(key);
                    }


            }

        }catch(IOException k){
            log("Input/Output Exception");
            k.printStackTrace();
        }
    }

    private void read(SelectionKey key) throws IOException{
        SocketChannel channel = (SocketChannel) key.channel();
        buffer.flip();
        buffer.clear();
        int num = -1;
        num = channel.read(buffer);

        if(num == -1){
            Socket socket = channel.socket();
            SocketAddress remoteAddress = ((Socket) socket).getRemoteSocketAddress();
            log("Connection closed with server: " + remoteAddress);
            channel.close();
            key.cancel();
            return;
        }
        byte[] data = new byte[num];
        buffer.rewind();
    //    System.arraycopy(buffer.array(), 0, data, 0, num);
     //    String response = new String(data);
        String response = Charset.forName("UTF-8").decode(buffer).toString();


        // modify data in case we got something other than hearbeat message
        if(!response.equalsIgnoreCase(Data.HEAT_BEAT_MESSAGE)){
            Data.setData(response);
        }

        log("Response received from the Server: " + response);

        channel.close();
    }

    private void log(String s) {
        System.out.println(s);
    }

}