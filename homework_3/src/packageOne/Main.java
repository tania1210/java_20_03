package packageOne;

import java.util.Scanner;

public class Main {
/*Шеленко Юрій Олексійович
 *java developer
 * project@gmail.com
 * +380964124593
 * 30
 * */
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);		
		Employee Oleg = new Employee(s.nextLine(), s.nextLine(), s.nextLine(), s.nextLine(), s.nextInt());
		Oleg.getPib();
		Oleg.getPosition();
		Oleg.getEmail();
		Oleg.getPhone();
		Oleg.getAge();
		
		Car car = new Car();
		car.start();
	}

}
