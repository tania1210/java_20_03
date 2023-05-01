package participants;

import java.util.ArrayList;

public class Person implements Participant{
	private static String name;
	private static double run;
	private static double jump;
	
	Racetrack racetrack = new Racetrack();
	Wall wall = new Wall();
	
	public Person(String name, double run, double jump) {
		this.name = name;
		this.run= run;
		this.jump= jump;
	}
		
	public String getName() {
		return name;
	}

	public static double getRun() {
		return run;
	}

	public static double getJump() {
		return jump;
	}
	
	public String run() {
		return "Person runs " + racetrack.overcome();
	}
	
	public String jump() {
		return "Person jumps " + wall.overcome();
	}


}
