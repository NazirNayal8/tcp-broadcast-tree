import java.io.IOException;

/**
 * This class models a broadcaster process, which consists of a server and client part. Client part connects to the specified
 * parent node in the broadcast tree to receive the update state of the root node, and upon receiving an update, the server part
 * does the broadcast to the children nodes i.e., the set of open, and active TCP connections with the server part of the Broadcaster
 */
public class Broadcaster
{
    /**
     * The server side of the broadcaster process
     */
    NIOServer mServer;

    /**
     * The client side of the broadcaster process
     */
   NIOClient mClient;

    /**
     *
     * @param myPort port number of this broadcaster process (for the server part)
     * @param parentPort port number of the parent node on the broadcast tree (for the client part)
     * @param parentIP IP address of the parent node on the broadcast tree (for the client part)
     */
    public Broadcaster(int myPort, int parentPort, String parentIP)
    {
        /*
        Establishes a server on the port determined by myPort
         */
        try{
            mServer = new NIOServer("localhost",myPort);
            mServer.startServer();

        }catch(IOException e){
            e.printStackTrace();
        }


        /*
        Initiates a connection to the specified server on (serverIP and serverPort) if the node is not
        root
         */
        if ((!parentIP.equalsIgnoreCase(Main.ROOT) && parentPort != -1))
        {
            try{
                mClient = new NIOClient(parentIP, parentPort);
            }catch(IOException e){
                e.printStackTrace();
            }catch(InterruptedException k){
                k.printStackTrace();
            }
        }


    }
}
