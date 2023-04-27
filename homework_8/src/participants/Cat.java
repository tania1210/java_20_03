package participants;

import interfaces.Participant;

public class Cat implements Participant{
	Racetrack racetrack = new Racetrack();
	Wall wall = new Wall();
	
	public String run() {
		return "Cat runs " + racetrack.overcome();
	}
	
	public String jump() {
		return "Cat jumps " + wall.overcome();
	}
}
