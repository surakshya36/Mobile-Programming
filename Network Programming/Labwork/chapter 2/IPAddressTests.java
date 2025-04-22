import java.net .*;

public class IPAddressTests {

public static void main(String[] args) {

try {
    InetAddress ia = InetAddress.getByName("2001:4860:4860::8888");
    byte[] address = ia.getAddress();
    if(address.length == 4)
    System.out.println("IPv4");
    else if(address.length==16)
    System.out.println("IPv6");

    } catch (UnknownHostException ex) {

    System.out.println("I'm sorry. I don't know my own address.");
    }
}
}
