import java.net.InetAddress;
import java.net.UnknownHostException;

public class SpamChecker {
    // Common DNS-based spam blacklists
    private static final String[] BLACKLISTS = {
        "sbl.spamhaus.org",
        "xbl.spamhaus.org",
        "pbl.spamhaus.org",
        "zen.spamhaus.org",
        "bl.spamcop.net",
        "dnsbl.sorbs.net"
    };

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java SpamChecker <IP or hostname>");
            System.exit(1);
        }

        String input = args[0];
        System.out.println("Checking spam status for: " + input);

        try {
            // Convert hostname to IP if necessary
            InetAddress address = InetAddress.getByName(input);
            String ip = address.getHostAddress();
            System.out.println("Resolved IP address: " + ip);

            // Reverse the IP for DNSBL lookup
            String reversedIp = reverseIp(ip);
            System.out.println("Reversed IP for DNSBL: " + reversedIp);

            // Check against each blacklist
            for (String blacklist : BLACKLISTS) {
                String query = reversedIp + "." + blacklist;
                System.out.print("Checking " + blacklist + "... ");

                try {
                    InetAddress.getByName(query);
                    // If no exception, it's listed
                    System.out.println("LISTED (spam source)");
                } catch (UnknownHostException e) {
                    System.out.println("not listed");
                }
            }

        } catch (UnknownHostException e) {
            System.out.println("Error: Could not resolve " + input);
        }
    }

    // Helper method to reverse IP address for DNSBL lookup
    private static String reverseIp(String ip) {
        if (ip.contains(":")) {
            // IPv6 address (simplified handling)
            return ip; // DNSBLs typically have special handling for IPv6
        } else {
            // IPv4 address
            String[] parts = ip.split("\\.");
            return parts[3] + "." + parts[2] + "." + parts[1] + "." + parts[0];
        }
    }
}