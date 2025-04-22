import java.io .*;

import java.net .*;

import java.util .*;

public class DMoz {
    public static void main(String[] args) {

        System.out.print("Enter keyword: ");
        
        Scanner scan = new Scanner(System.in);
        
        String search = scan.nextLine();
        
        try {
            URL u = new URL("http://www.dmoz.org/search?q=" + search);
            try (InputStream in = new BufferedInputStream(u.openStream())) {
                InputStreamReader theHTML = new InputStreamReader(in);
                
                int c;
                
                while ((c= theHTML.read()) !=- 1) {
                System.out.print((char) c);
                }
            }

            scan.close();
            
            }catch (MalformedURLException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}