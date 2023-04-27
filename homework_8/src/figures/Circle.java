package figures;

public class Circle implements Figure{
	double r;
	
	Circle(double r) {
		this.r = r;
	}
	
	public double area() {
		return Math.PI * Math.pow(r, 2);
	}
}
