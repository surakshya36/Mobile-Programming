import java.net .*;

public class IPAddressandHostname {

public static void main(String[] args) {
try {

InetAddress me = InetAddress.getLocalHost();

String dottedQuad= me.getHostAddress();
System.out.println("My address is " + dottedQuad);
String hostname = me.getHostName();

System.out.println("Local host name: "+hostname);
} catch (UnknownHostException ex) {
System.out.println("I'm sorry. I don't know my own address.");
}
}
}
