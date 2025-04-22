import java.net.*;

public class Inetipv4ipv6Address {
    public static void main(String[] a) {
        try {
            String hostname = "facebook.com";
            System.out.println("Looking up: " + hostname);
            
            // Get all IP addresses for the host
            InetAddress[] addresses = InetAddress.getAllByName(hostname);
            
            if (addresses.length == 0) {
                System.out.println("No addresses found");
                return;
            }
            
            for (InetAddress addr : addresses) {
                if (addr instanceof Inet6Address) {
                    System.out.println("IPv6 = " + addr.getHostAddress());
                } else if (addr instanceof Inet4Address) {
                    System.out.println("IPv4 = " + addr.getHostAddress());
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}