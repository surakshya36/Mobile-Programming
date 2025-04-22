import java.io .*;

import javax.net.ssl .*;

public class SecureSocketEx {
public static void main(String[] a){

try {

SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
//System.out.println(factory);
SSLSocket socket=(SSLSocket) factory.createSocket("tufohss.edu.np", 443);

String[] supported=socket.getSupportedCipherSuites();
socket.setEnabledCipherSuites(supported);
Writer out = new OutputStreamWriter(socket.getOutputStream(),"US-ASCII");
out.write("GET http://tufohss.edu.np/ HTTP/1.1\r\n");
out.write("Host:tufohss.edu.np \r\n");

out.write("\r\n");

out.flush();

// Read all header fields

BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

String s;

while(!(s=in.readLine()).equals("")){
    System.out.println(s);
}
}
catch(Exception e){}
}
}