import java.io.*;
import java.net.*;

public class ServerLogs {
    public static void main(String[] args) {
        // Use either forward slashes or escaped backslashes
        String logPath = "D:/Xampp/apache/logs/access.log";  // or "D:\\Xampp\\apache\\logs\\access.log"
        
        try (BufferedReader bins = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(logPath)))) {
            
            System.out.println("Processing log file: " + logPath);
            int lineCount = 0;
            int resolvedCount = 0;
            int unresolvedCount = 0;

            for (String entry = bins.readLine(); entry != null; entry = bins.readLine()) {
                lineCount++;
                
                // Skip empty lines
                if (entry.trim().isEmpty()) {
                    continue;
                }

                int index = entry.indexOf(' ');
                if (index == -1) {
                    System.err.println("Line " + lineCount + ": Invalid log format - " + entry);
                    continue;
                }

                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);
                
                try {
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.printf("\nLine %d:\nIP: %s\nHost: %s\nRequest: %s",
                                    lineCount, ip, address.getHostName(), theRest.trim());
                    resolvedCount++;
                } catch (UnknownHostException ex) {
                    System.out.printf("\nLine %d:\nIP: %s (Hostname not resolvable)\nRequest: %s",
                                    lineCount, ip, theRest.trim());
                    unresolvedCount++;
                }
            }
            
            // Print summary
            System.out.println("\n\n=== Processing Summary ===");
            System.out.println("Total lines processed: " + lineCount);
            System.out.println("Resolved hostnames: " + resolvedCount);
            System.out.println("Unresolved hostnames: " + unresolvedCount);
            
        } catch (FileNotFoundException ex) {
            System.err.println("Error: Log file not found at " + logPath);
            System.err.println("Please verify the path and try again.");
        } catch (IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }
    }
}