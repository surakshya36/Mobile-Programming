import java.net.*;

import javax.net.ssl .*;

public class ClientSocketEx {

public static void main(String[] a){

try {

Socket socket =

((SSLSocketFactory)SSLSocketFactory.getDefault()).createSocket("localhost",1422);

System.out.println("Server Connected : "+socket); // Connect()

socket.close();
}
catch(Exception e){}
}
}