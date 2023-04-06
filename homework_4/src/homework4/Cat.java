package homework4;

import java.util.Scanner;

public class Cat extends Animal{
	
	static int counterCat = 0;
	
	public Cat(String name, double run, double swim) {
		super(name, run, swim);
		
		if(run > 200) {
			System.out.println("Incorrect data of " + this.getName() + "'s run. \nPlease, change it(less than 200): ");
			this.setRun(this.input());
		}
		
		if(swim > 0) {
			System.out.println("Incorrect data of " + this.getName() + "'s swim. \nPlease, change it (cat can't swim - enter -1): ");
			this.setSwim(this.input());
		}
		counterCat++;
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
	
	public void output(Animal animal) {
		System.out.println(animal.getName() + " пробіг " + animal.getRun() + " м, та не вміє плавати ");

	}
	
	public static void outputCountCat() {
		System.out.println("Created " + counterCat + " cats");
	}
}
