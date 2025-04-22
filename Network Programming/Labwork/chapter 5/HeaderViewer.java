import java.io.*;
import java.net.*;
import java.util.*;

public class HeaderViewer {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java HeaderViewer <URL>");
            System.exit(1);
        }

        try {
            URL u = new URL(args[0]);
            URLConnection uc = u.openConnection();
            
            // Print basic headers
            System.out.println("Content-type: " + uc.getContentType());
            
            if (uc.getContentEncoding() != null) {
                System.out.println("Content-encoding: " + uc.getContentEncoding());
            }
            
            if (uc.getLastModified() != 0) {
                System.out.println("Last modified: " + new Date(uc.getLastModified()));
            }
            
            if (uc.getExpiration() != 0) {
                System.out.println("Expiration date: " + new Date(uc.getExpiration()));
            }
            
            if (uc.getContentLength() != -1) {
                System.out.println("Content-length: " + uc.getContentLength());
            }
            
            // Print all headers
            System.out.println("\nAll Headers:");
            Map<String, List<String>> headers = uc.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                if (key == null) key = "Status";
                System.out.println(key + ": " + entry.getValue());
            }
            
        } catch (MalformedURLException ex) {
            System.err.println(args[0] + " is not a valid URL");
        } catch (IOException ex) {
            System.err.println("Connection error: " + ex.getMessage());
        }
    }
}