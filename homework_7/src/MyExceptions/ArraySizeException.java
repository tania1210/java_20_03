package MyExceptions;

public class ArraySizeException extends ArrayIndexOutOfBoundsException{

    public ArraySizeException () {
        super();
    }
    
    public ArraySizeException (String s) {
        super (s);
    }
    
    public ArraySizeException(int index) {
        super("Array index out of range: " + index);
    }

}
