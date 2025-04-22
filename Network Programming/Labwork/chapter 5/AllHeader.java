import java.net .*;
import java.io.*;
public class AllHeader {
    public static void main(String[] args) {
        try {
        URL u=new URL("https://tufohss.edu.np");
        
        URLConnection uc = u.openConnection();
        
        for (int j= 1; ; j++) {
        String header = uc.getHeaderField(j);
        if (header == null) break;
        System.out.println(uc.getHeaderFieldKey(j) +": " + header);}
        } catch (MalformedURLException ex) {
            System.err.println("Is not a URL I understand.");
} catch (IOException ex) {System.err.println(ex);}
System.out.println();
    }
}