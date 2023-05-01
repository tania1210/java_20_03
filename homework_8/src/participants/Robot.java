package participants;

public class Robot implements Participant{
	static String name;
	Racetrack racetrack = new Racetrack();
	Wall wall = new Wall();
	
	public Robot(String name) {
		this.name = name;	
	}
	
	public String getName() {
		return name;
	}
	
	public String run() {
		return "Robot runs " + racetrack.overcome();
	}
	
	public String jump() {
		return "Robot jumps " + wall.overcome();
	}
}
