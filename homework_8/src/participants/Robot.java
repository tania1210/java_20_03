package participants;

import interfaces.Participant;

public class Robot implements Participant{
	Racetrack racetrack = new Racetrack();
	Wall wall = new Wall();
	
	public String run() {
		return "Robot runs " + racetrack.overcome();
	}
	
	public String jump() {
		return "Robot jumps " + wall.overcome();
	}
}
