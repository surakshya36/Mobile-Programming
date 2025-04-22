import java.io .*;
import java.net .*;
import java.util .*;
public class LastModified{
    public static void main(String[] args) {
        try {
        
        URL u= new URL("https://tufohss.edu.np/");
        
        HttpURLConnection http=(HttpURLConnection) u.openConnection();
        
        http.setRequestMethod("HEAD");
        
        System.out.println(u +" was last modified at "+ new Date(http.getLastModified()));
        } catch (MalformedURLException ex) {
        
        System.err.println(" is not a URL I understand");
        } catch (IOException ex) {
        
        System.err.println(ex);
        }
        
        System.out.println();
}
}