package participants;

import interfaces.Participant;

public class Person implements Participant{
	Racetrack racetrack = new Racetrack();
	Wall wall = new Wall();
	
	public String run() {
		return "Person runs " + racetrack.overcome();
	}
	
	public String jump() {
		return "Person jumps " + wall.overcome();
	}

}
