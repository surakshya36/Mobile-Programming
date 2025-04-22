import java.net .*;

public class TestingReachability {

public static void main(String[] a){

try {

InetAddress net= InetAddress.getByName("8.8.8.8");
if(net.isReachable(100))

System.out.println("Success");

else

System.out.println("Failed");
}
catch(Exception e){
}
}
}