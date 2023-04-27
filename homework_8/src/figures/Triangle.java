package figures;

public class Triangle implements Figure{
	
	double a;
	double b;
	
	Triangle(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public double area() {
		return Math.sqrt(a *b);
	}
}
