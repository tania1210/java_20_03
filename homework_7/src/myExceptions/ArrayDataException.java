package myExceptions;

public class ArrayDataException extends NumberFormatException{
	
	String array;
	int i;
	int j;
	
    public ArrayDataException () {
        super();
    }
    
    public ArrayDataException (String s) {
        super (s);
    }
    
    public void setData (String array, int i, int j) {
    	this.array = array;
    	this.i = i;
    	this.j = j;
    }
        
    static ArrayDataException forInputString(String s, int radix) {
        return new ArrayDataException("For input string: \"" + s + "\"" +
                                         (radix == 10 ?
                                          "" :
                                          " under radix " + radix));
    }
}
