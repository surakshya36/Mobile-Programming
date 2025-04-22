import java.nio .*;
public class DataConversionTest {
    public static void main(String[] args){
        int capacity = 8;

try {

ByteBuffer bb = ByteBuffer.allocate(capacity);
bb.asIntBuffer()

.put(10)
 
.put(20);
bb.rewind();
System.out.println("Original ByteBuffer: ");
for (int i=1; i <= capacity / 4; i++)
System.out.print(bb.getInt() +"");
bb.rewind();
int value = bb.getInt();

System.out.println("\n\nByte Value: "+ value);

int value1 =bb.getInt();

System.out.println("Next Byte Value: "+ value1);

int value2= bb.getInt();
}
catch (BufferUnderflowException e) {

    System.out.println("\nthere are fewer than "
    
    + "four bytes remaining in this buffer");
    
    System.out.println("Exception Thrown :"+ e);
}
    }
}
