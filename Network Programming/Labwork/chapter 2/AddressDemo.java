import java.net .*;

public class AddressDemo {

public static void main (String[] args) {

try {

InetAddress address =InetAddress.getByName("www.tufohss.edu.np");

System.out.println(address);

} catch (UnknownHostException ex) {

System.out.println("Could not find.");
}
}
}  