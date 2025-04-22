import java.io.*;
import java.net.*;

public class SourceViewer {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java SourceViewer <URL>");
            System.exit(1);
        }

        try (InputStream in = new URL(args[0]).openStream();
             BufferedInputStream bin = new BufferedInputStream(in);
             Reader r = new InputStreamReader(bin)) {
            
            char[] buffer = new char[1024];
            int bytesRead;
            while ((bytesRead = r.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, bytesRead));
            }
            
        } catch (MalformedURLException ex) {
            System.err.println(args[0] + " is not a valid URL");
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}