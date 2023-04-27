package figures;

public class Square implements Figure{

	double a;
	
	Square(double a) {
		this.a = a;
	}
	
	public double area() {
		return Math.pow(a, 2);
	}
}
