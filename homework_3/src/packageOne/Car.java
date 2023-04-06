package packageOne;

public class Car {
	
	public void start() {
		System.out.println("running start");
		startElectricity();
		startCommand();
		startFuelSystem();
	}
	
	private static void startElectricity() {
		System.out.println("running method startElectricity");
	}
	
	private static void startCommand() {
		System.out.println("running method startCommand");
	}
	
	private static void startFuelSystem() {
		System.out.println("running method startFuelSystem");
	}
}
