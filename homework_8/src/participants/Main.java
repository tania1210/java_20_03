package participants;

public class Main {
	
	public static void main(String [] args) {
		Person person = new Person();
		Cat cat = new Cat();
		Robot robot = new Robot();
		
		System.out.println(person.run());
		System.out.println(person.jump());
		System.out.println(cat.run());
		System.out.println(cat.jump());
		System.out.println(robot.run());
		System.out.println(robot.jump());

	}
}
