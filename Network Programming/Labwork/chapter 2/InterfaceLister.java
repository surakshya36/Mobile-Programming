import java.net .*;
import java.util .*;
public class InterfaceLister {

public static void main(String[] args) throws SocketException {

Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

while (interfaces.hasMoreElements()) {

NetworkInterface ni = interfaces.nextElement(); // get elements from the enumuration.

System.out.println(ni);
}
}
}

