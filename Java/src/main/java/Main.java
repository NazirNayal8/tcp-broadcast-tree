import java.util.Scanner;

public class Main
{
    public static String ROOT = "root";

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        /*
        reads and determines the port number of the server side of the broadcaster process
         */
        int MyPortNumber = readPortNumber(scanner, "Enter the port number that you want to open the connection on:");

        /*
        reads and determines the server address to connect (i.e., its parent)
         */
        String ServerIpAdress = readIpAdress(scanner, "Enter IP address of the server, " +
                "\n or enter LOCALHOST if you are running all the tree on the same machine" +
                "\n or enter ROOT if you want to designate this process as the root of tree");

        int ServerPortNumber = -1;

        if(!ServerIpAdress.equalsIgnoreCase(ROOT))
            ServerPortNumber = readPortNumber(scanner, "Enter the port number of the server to connect: ");

        Broadcaster broadcaster = new Broadcaster(MyPortNumber, ServerPortNumber, ServerIpAdress);

        if(ServerIpAdress.equalsIgnoreCase(ROOT))
        {
            System.out.println("check");
            new Data().run();
        }
    }

    /**
     *
     * @param scanner an instance of System.in scanner
     * @param message the message to be shown to the user, a directive message
     * @return a validated IP address by the user, it keeps asking on invalidated entered ones till the entrance of
     * a valid one
     */
    private static String readIpAdress(Scanner scanner, String message)
    {
        System.out.println(message);
        String IP = scanner.nextLine();
        if(IP.equalsIgnoreCase(ROOT))
            return ROOT;
        while (!validatingIP(IP) && !IP.equalsIgnoreCase(ROOT))
        {
            if(!IP.isEmpty())
                System.out.println("Not a valid IPv4 address");
            IP = scanner.nextLine();
        }
        return IP;
    }

    /**
     *
     * @param scanner an instance of System.in scanner
     * @param message the message to be shown to the user, a directive message
     * @return a validated port number by the user, it keeps asking on invalidated entered ones till the entrance of
     * a valid one
     */
    private static int readPortNumber(Scanner scanner, String message)
    {
        System.out.println(message);
        int portNumer = scanner.nextInt();
        while (portNumer <= 0 || portNumer >= 65535)
        {
            System.out.println("Not a valid port number, you should enter the port number between (0, 65535)");
            portNumer = scanner.nextInt();
        }
        return portNumer;
    }



    /**
     * Validates the input string against a correctly formatted IP address
     * @param IP input IP address
     * @return returns true if the ip address is equal to local host, or if
     * it contains a 4-bytes string of element separated by dots i.e., X.Y.Z.K,
     * otherwise, it returns false.
     */
    private static boolean validatingIP(String IP)
    {
        if(IP.equalsIgnoreCase("localhost"))
        {
            return true;
        }
        try
        {
            if (IP == null || IP.isEmpty())
            {
                return false;
            }

            String[] parts = IP.split("\\.");
            if (parts.length != 4)
            {
                return false;
            }

            for (String s : parts)
            {
                int i = Integer.parseInt(s);
                if ((i < 0) || (i > 255))
                {
                    return false;
                }
            }
            if (IP.endsWith("."))
            {
                return false;
            }

            return true;
        }
        catch (NumberFormatException nfe)
        {
            return false;
        }

    }
}
