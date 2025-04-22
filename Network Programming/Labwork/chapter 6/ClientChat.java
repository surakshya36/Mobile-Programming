import java.net .*;

import java.io .*;

class ClientChat {

public static void main(String[] a){

try {

try {
    Socket s=new Socket("127.0.0.1",8888); // Socket()

    System.out.println("Server Connected : "+s); // Connect()

    DataInputStream din=new DataInputStream(s.getInputStream());

    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String s1;

do{

    s1=br.readLine();

    dout.writeUTF(s1);
    dout.flush();
    System.out.println("Server Message: I am from server. "+din.readUTF());
}while(!s1.equals("stop"));
s.close();
}
catch(Exception e){
    System.out.println(e);
}
}catch(Exception e){
    System.err.println(e);
}
}
}