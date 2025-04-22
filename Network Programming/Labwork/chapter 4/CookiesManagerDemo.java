import java.net.*;
import java.util.*;

public class CookiesManagerDemo {
    public static void main(String[] args) {
        // Create a CookieManager with default policy
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager); // Set as default
        CookieStore cookieStore = cookieManager.getCookieStore();

        // Create some cookies
        HttpCookie cookieA = new HttpCookie("First", "1");
        HttpCookie cookieB = new HttpCookie("Second", "2");
        
        // Set cookie domains and paths
        cookieA.setDomain(".ambition.edu.np");
        cookieA.setPath("/");
        cookieB.setDomain("example.com");
        cookieB.setPath("/");

        // Add cookies to the store
        URI uri = URI.create("https://www.ambition.edu.np/");
        cookieStore.add(uri, cookieA);
        cookieStore.add(null, cookieB); // null URI for cookies without associated URI

        System.out.println("Cookies successfully added\n");

        // 1. Get cookies associated with specific URI
        List<HttpCookie> cookiesWithURI = cookieStore.get(uri);
        System.out.println("Cookies associated with URI in CookieStore: " + cookiesWithURI + "\n");

        // 2. Get all cookies in the store
        List<HttpCookie> cookieList = cookieStore.getCookies();
        System.out.println("All Cookies in CookieStore: " + cookieList + "\n");

        // 3. Get all URIs in the store
        List<URI> uriList = cookieStore.getURIs();
        System.out.println("URIs in CookieStore: " + uriList + "\n");

        // 4. Remove a specific cookie
        boolean removed = cookieStore.remove(uri, cookieA);
        System.out.println("Removal of Cookie: " + removed);
        List<HttpCookie> remainingCookieList = cookieStore.getCookies();
        System.out.println("Remaining Cookies: " + remainingCookieList + "\n");

        // 5. Remove all cookies
        boolean allRemoved = cookieStore.removeAll();
        System.out.println("Removal of all Cookies: " + allRemoved);
        List<HttpCookie> emptyCookieList = cookieStore.getCookies();
        System.out.println("Empty CookieStore: " + emptyCookieList);
    }
}