import java.nio .*;
public class FillingDraining {
public static void main(String[] a) throws Exception {
CharBuffer ch = CharBuffer.allocate(10);
//Buffer Filling
ch.put('H');
ch.put('E');
ch.put('L');
ch.put('L');
ch.put('O');
//Buffer Draining
ch.flip();
while(ch.hasRemaining()){
    System.out.println(ch.get());
}
ch.clear();
System.out.println("After Cleared");
ch.flip();
while(ch.hasRemaining()){
System.out.println(ch.get());
}
}
}