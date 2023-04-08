package homework4;

import java.util.Scanner;

public class Dog extends Animal{

	static int counterDog = 0;
	
	public Dog(String name, double run, double swim) {
		super(name, run, swim);
		this.checking(run, swim);
		counterDog++;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setRun(double run) {
		this.run = run;
	}
	
	public double getRun() {
		return run;
	}
	
	public void setSwim(double swim) {
		this.swim = swim;
	}
	
	public double getSwim() {
		return swim;
	}
	
	public double input() {
		Scanner s = new Scanner(System.in);
		double data = s.nextDouble();
		return data;
	}
	
	public static void outputCountDog() {
		System.out.println("Created " + counterDog + " dogs");
	}
	
	public int checking(double run, double swim) {
		if(run <= 500 || swim <= 10) {
			return 0;
		}else {
			if(run > 500) {
				System.out.println("Incorrect data of " + this.getName() + "'s run. \nPlease, change it(less than 500): ");
				this.setRun(this.input());
			}
			
			if(swim > 10) {
				System.out.println("Incorrect data of " + this.getName() + "'s swim. \nPlease, change it (less than 10): ");
				this.setSwim(this.input());
			}
			return 1;
		}		
	}
}
