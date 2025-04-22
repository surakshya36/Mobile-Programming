import java.net.*;
import java.io.*;

public class ServerChat {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("Server waiting for connection...");
            
            Socket s = ss.accept();
            System.out.println("Client connected: " + s);
            
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            
            String clientMessage;
            do {
                clientMessage = din.readUTF();
                System.out.println("Client says: " + clientMessage);
                dout.writeUTF("Received: " + clientMessage);
                dout.flush();
            } while(!clientMessage.equals("stop"));
            
            s.close();
            ss.close();
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}