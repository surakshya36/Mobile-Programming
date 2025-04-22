import java.net.*;
import java.util.List;

public class NoGovernmentCookies implements CookiePolicy {
    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        // Block if either the URI or cookie domain is from .gov
        if (uri.getAuthority().toLowerCase().endsWith(".gov") ||
            cookie.getDomain().toLowerCase().endsWith(".gov")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Create and set the custom cookie policy
        CookieManager manager = new CookieManager();
        manager.setCookiePolicy(new NoGovernmentCookies());
        CookieHandler.setDefault(manager);

        // Test the policy
        testCookiePolicy();
    }

    private static void testCookiePolicy() {
        try {
            // Create test URIs and cookies
            URI govUri = new URI("https://whitehouse.gov");
            URI comUri = new URI("https://example.com");
            
            HttpCookie govCookie = new HttpCookie("session", "123");
            govCookie.setDomain(".whitehouse.gov");
            
            HttpCookie comCookie = new HttpCookie("session", "456");
            comCookie.setDomain(".example.com");

            // Test the policy
            NoGovernmentCookies policy = new NoGovernmentCookies();
            
            System.out.println("Should accept example.com cookie: " + 
                policy.shouldAccept(comUri, comCookie));  // Should be true
            
            System.out.println("Should accept whitehouse.gov cookie: " + 
                policy.shouldAccept(govUri, govCookie));  // Should be false
            
            // Also test when visiting non-gov site but cookie is from .gov
            System.out.println("Should accept gov cookie on com site: " + 
                policy.shouldAccept(comUri, govCookie)); // Should be false

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}