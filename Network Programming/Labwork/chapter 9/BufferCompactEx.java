import java.nio .*;
import java.util .*;
public class BufferCompactEx {
public static void main(String[] args) {
// creating object of ByteBuffer // and allocating size capacity
ByteBuffer bb = ByteBuffer.allocate(6);
bb.put((byte)20); bb.put((byte)30); bb.put((byte)40);
System.out.println("Original ByteBuffer: "+ Arrays.toString(bb.array()));
System.out.println("Position:"+ bb.position());
System.out.println("limit:"+ bb.limit());
// Creating a compacted ByteBuffer of same ByteBuffer using compact() method
bb.position(3); ByteBuffer cbb = bb.compact(); cbb.put((byte)99);
System.out.println("nNew Updated Compacted ByteBuffer: " +
Arrays.toString(cbb.array()));
System.out.println("Position:" +cbb.position());
System.out.println("limit: "+ cbb.limit()); }
}
 