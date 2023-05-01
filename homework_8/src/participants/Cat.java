package participants;

public class Cat implements Participant{
	private static String name;
	Racetrack racetrack = new Racetrack();
	Wall wall = new Wall();
	
	public Cat(String name) {
		this.name = name;	
	}
	
	public String getName() {
		return name;
	}
	
	public String run() {
		return "Cat runs " + racetrack.overcome();
	}
	
	public String jump() {
		return "Cat jumps " + wall.overcome();
	}
}
