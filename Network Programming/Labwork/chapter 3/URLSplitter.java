import java.net.*;

class URLSplitter {
    public static void main(String args[]) {
        try {
            URI uri = new URI("https://www.google.com/search?q=image#imgrc=ez-ubljHwN9MSM");
            
            System.out.println("The URI is " + uri);
            System.out.println("The scheme is " + uri.getScheme());
            System.out.println("The host is " + uri.getHost());
            System.out.println("The port is " + uri.getPort());
            System.out.println("The path is " + uri.getPath());
            System.out.println("The fragment is " + uri.getFragment());
            System.out.println("The query is " + uri.getQuery());
        } catch (URISyntaxException ex) {
            System.err.println("Invalid URI: " + ex.getMessage());
        }
    }
}