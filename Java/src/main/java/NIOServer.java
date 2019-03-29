import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;

public class NIOServer {

    private ServerSocketChannel serverChannel ;
    private Selector selector;
    private InetSocketAddress listenAddress;
    private Map<SocketChannel,List> dataMapper;
    private ByteBuffer buffer = ByteBuffer.allocate(1024);
    private String oldData = new String();

    public NIOServer(String address, int port) throws IOException{
        listenAddress = new InetSocketAddress(address,port);
        dataMapper = new HashMap<SocketChannel,List>();
    }

    public void startServer() throws IOException{
        this.selector = Selector.open();

        serverChannel = ServerSocketChannel.open();

        serverChannel.configureBlocking(false);

        serverChannel.socket().bind(listenAddress);

        serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);

        log("Server started...");



        while(true) {

            this.selector.select();

            Iterator keys = this.selector.selectedKeys().iterator();
            while(keys.hasNext()) {
                SelectionKey key = (SelectionKey) keys.next();
                keys.remove();
                if(!key.isValid())
                    continue;
                if(key.isAcceptable())
                    this.accept(key);
                else if (key.isReadable())
                    this.read(key);

            }
        }

    }

    private void accept(SelectionKey key) throws IOException {
        serverChannel = (ServerSocketChannel)key.channel();
        SocketChannel channel = serverChannel.accept();
        channel.configureBlocking(false);

        Socket socket = channel.socket();
        SocketAddress remoteAddress = socket.getRemoteSocketAddress();
        log("Connected to Child :" + remoteAddress);

        dataMapper.put(channel,new ArrayList());
        channel.register(this.selector,SelectionKey.OP_READ);
    }

    private void read(SelectionKey key) {
        try{

            SocketChannel channel = (SocketChannel)key.channel();
            int numRead = -1;
            numRead = channel.read(buffer);
            if(numRead == -1) {
                this.dataMapper.remove(channel);
                Socket socket = channel.socket();
                SocketAddress remoteAddress = socket.getRemoteSocketAddress();
                log("Connection closed by client: " + remoteAddress);
                channel.close();
                key.cancel();
                return;
            }
            byte[] data = new byte[numRead];
            System.arraycopy(buffer.array(), 0, data, 0, numRead);
            String hearbeat = new String(data);

            buffer.flip();
            buffer.clear();
            if(oldData != Data.getData()){
                oldData = Data.getData();
                buffer.put(oldData.getBytes());
            }else{
                buffer.put(hearbeat.getBytes());
            }
            channel.write(buffer);
            buffer.flip();
            buffer.rewind();
            channel.close();
        }catch(IOException e){
            e.printStackTrace();
        }catch(NullPointerException k){
            System.err.println("NIOServer. StartServer. read");
        }finally{
            try{
                if(serverChannel != null)
                    serverChannel.close();
            }catch (IOException e){
                System.err.println("Server Channel Close Error");
            }
        }
    }


    private void log(String s) {
        System.out.println(s);
    }

}