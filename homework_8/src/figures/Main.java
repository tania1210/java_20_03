package figures;

import java.text.DecimalFormat;

public class Main {
	
	static double figuresArea [] = new double[3];
	
	public static double sumAreas() {
		double res = 0;
		for(double array: figuresArea) {
			res += array;
		}
		return res;
	}
	
	public static void main(String [] args) {
		DecimalFormat f = new DecimalFormat("#0.000");
		Circle circle = new Circle(1);
		Triangle triangle = new Triangle(3, 4);
		Square square = new Square(2);

		figuresArea[0] = circle.area();
		figuresArea[1] = triangle.area();
		figuresArea[2] = square.area();
						
		System.out.println("sum of figures: " + f.format(sumAreas()) );
		
	}
}
