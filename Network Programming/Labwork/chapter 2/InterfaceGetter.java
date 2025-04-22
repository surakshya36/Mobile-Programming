import java.net.*;
import java.util.*;

public class InterfaceGetter {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            if (ni.isLoopback()) {
                System.out.println("Loopback Interface: " + ni.getDisplayName());
                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    System.out.println("  IP: " + addresses.nextElement().getHostAddress());
                }
                break;
            }
        }
    }
}
