import java.io.IOException;

import java.net.DatagramPacket;

import java.net.InetAddress;

import java.net.MulticastSocket;

import java.net.UnknownHostException;
 
public class MulticastSocketClient {

final static String INET_ADDR ="224.0.0.3";

final static int PORT = 8888;

public static void main(String[] args) throws UnknownHostException {

InetAddress address = InetAddress.getByName(INET_ADDR);

byte[] buf= new byte[256];

try (MulticastSocket clientSocket = new MulticastSocket(PORT)){
clientSocket.joinGroup(address);

while (true) {

DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
clientSocket.receive(msgPacket);
String msg = new String(buf, 0, buf.length);
System.out.println("Socket 1 received msg: " + msg);
}
}catch (IOException ex) {

    ex.printStackTrace();
}
}
}