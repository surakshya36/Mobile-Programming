import java.nio .*;
import java.util .*;
public class BufferSlicing {
public static void main(String[] args){
    int capacity = 5;
try {
ByteBuffer bb1 = ByteBuffer.allocate(capacity);
bb1.put((byte)10);
bb1.put((byte)20);
System.out.println("Original ByteBuffer: "+ Arrays.toString(bb1.array()));
System.out.println("nposition:"+bb1.position());
System.out.println("\ncapacity:"+bb1.capacity());
ByteBuffer bb2= bb1.slice();
System.out.println("\nshared subsequence ByteBuffer: "+ Arrays.toString(bb2.array()));

System.out.println("nposition: "+ bb2.position());
System.out.println("ncapacity:"+bb2.capacity());
}
catch (IllegalArgumentException e) {
    System.out.println("IllegalArgumentException catched");
}
catch (ReadOnlyBufferException e) {
    System.out.println("ReadOnlyBufferException catched");
}
} 
}