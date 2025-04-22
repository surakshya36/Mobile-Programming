import java.net .*;
import java.io .*;

public class SourceViewer {
    public static void main (String[] args){
        try {
            // Open the URLConnection for reading
            URL u= new URL("https://www.google.com/");
            
            URLConnection uc = u.openConnection();
            
            InputStream stream= uc.getInputStream();
            
            BufferedInputStream buffer = new BufferedInputStream(stream);
            
            InputStreamReader reader = new InputStreamReader(buffer);
            
            int c;
            
            while ((c = reader.read()) !=- 1) {
            System.out.print((char) c);}
            } catch (IOException ex) {
            System.err.println(ex); 
    }
}
}
