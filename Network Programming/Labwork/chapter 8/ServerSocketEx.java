
import java.net .*;

import javax.net.ssl .*;

public class ServerSocketEx {

public static void main(String[] a){
try {
ServerSocket serverSocket =

((SSLServerSocketFactory)SSLServerSocketFactory.getDefault()).createServerSocket(1422);

Socket s=serverSocket.accept();

System.out.println(s+"Client Accepted and Connected ..... ");
}
catch(Exception e){}
}
}