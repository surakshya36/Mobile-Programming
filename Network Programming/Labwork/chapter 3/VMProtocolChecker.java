import java.net.*;
import java.io.*;  // Required for IOException

public class VMProtocolChecker {
    public static void main(String[] args) {
        // List of common protocols to test
        String[] protocols = {
            "http", "https", "ftp", "file", "mailto", 
            "telnet", "gopher", "jar", "ws", "wss"
        };

        System.out.println("JVM Protocol Support Checker");
        System.out.println("===========================");

        for (String protocol : protocols) {
            checkProtocolSupport(protocol);
        }
    }

    private static void checkProtocolSupport(String protocol) {
        try {
            // Create URL object to test protocol support
            URL url = new URL(protocol + "://example.com");
            
            // Try to open a connection (more reliable test)
            try {
                URLConnection connection = url.openConnection();
                System.out.printf("%-8s: Supported (%s)\n", 
                               protocol, connection.getClass().getName());
            } catch (IOException e) {
                System.out.printf("%-8s: Supported but connection failed (%s)\n", 
                               protocol, e.getMessage());
            }
        } catch (MalformedURLException e) {
            System.out.printf("%-8s: Not supported (%s)\n", 
                           protocol, e.getMessage());
        }
    }
}