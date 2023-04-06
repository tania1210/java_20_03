package homework4;

public class Animal {
	
	public String name;
	public double run;
	public double swim;
	public static int counter = 0;
	
	public Animal(String name, double run, double swim) {
		this.name = name;
		this.run = run;
		this.swim = swim;
		counter++;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		System.out.println("getName Animal: ");
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
	
	public void output(Animal animal) {
		System.out.println(animal.getName() + " пробіг " + animal.getRun() + " м, та проплив " + animal.getSwim() + " м");

	}
	
	public static void outputCount() {
		System.out.println("\nCreated " + counter + " animals");
	}



}
