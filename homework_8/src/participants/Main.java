package participants;

import java.util.ArrayList;

public class Main {
	
	static ArrayList participantsList = new ArrayList();
	static ArrayList barrierList = new ArrayList();
	
	public static void print() {
			for(int i = 0; i < participantsList.size(); i++) {
				System.out.println("name - " + i + " " + participantsList.get(i));
				System.out.println(participantsList.size());
			}
			System.out.println();
			for(int i = 0; i < barrierList.size(); i++) {
				System.out.println("kind - " + i + " " + barrierList.get(i));
				System.out.println(barrierList.size());
			}
	}
	
	public static void switchs() {
		for(int i = 0; i < participantsList.size(); i++) {
			System.out.println();
			for(int j = 0; j < barrierList.size(); j++) {
				System.out.println(participantsList.get(i) + " went " + barrierList.get(j));
			}
		}
	}
	
	public static void main(String [] args) {
		Person person = new Person("Марк", 2.1, 2);
		participantsList.add(person.getName());
		
		Cat cat = new Cat("Муна");
		participantsList.add(cat.getName());
		
		Robot robot = new Robot("робот-Софія");
		participantsList.add(robot.getName());
		
		barrierList.add(new Racetrack().overcome());
		barrierList.add(new Wall().overcome());

		print();
		switchs();
		
		System.out.println(person.run());
		System.out.println(person.jump());
		
		System.out.println(cat.run());
		System.out.println(cat.jump());
		
		System.out.println(robot.run());
		System.out.println(robot.jump());

	}
}
