import java.net.URI;
import java.net.URISyntaxException;

public class ResolveURL {
    public static void main(String[] args) {
        String uriBase = "https://www.test.org/";
        String uriRelative = "languages/../java";

        try {
            // Create base and relative URI objects
            URI base = new URI(uriBase);
            System.out.println("Base URI = " + base.toString());
            
            URI relative = new URI(uriRelative);
            System.out.println("Relative URI = " + relative.toString());
            
            // Resolve the relative URI against the base URI
            URI resolved = base.resolve(relative);
            System.out.println("Resolved URI = " + resolved.toString());
            
            // Normalize the resolved URI to remove path navigation (like ../)
            URI normalized = resolved.normalize();
            System.out.println("Normalized URI = " + normalized.toString());
            
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI syntax: " + e.getMessage());
        }
    }
}