

import java.net .*;

public class ReverseTest {

public static void main (String[] args) throws UnknownHostException {

InetAddress ia= InetAddress.getByName("182.91.80.150");

System.out.println(ia.getCanonicalHostName());
}
}