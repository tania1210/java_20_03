package homework4;

import java.util.Scanner;

public class Main {
	
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the name of animal: ");
		String nameAnimal = s.nextLine();
		System.out.println("Enter the length of the distance run: ");
		double runAnimal = s.nextDouble();
		System.out.println("Enter the name of the distance swim: ");
		double swimAnimal = s.nextDouble();
		
		System.out.println("Enter the name of cat: ");
		String nameCat = s.nextLine();
		System.out.println("Enter the length of the distance run: (no more than 200)");
		double runCat = s.nextDouble();
		System.out.println("Enter the name of the distance swim: (if can't swim - enter -1)");
		double swimCat = s.nextDouble();
		
		System.out.println("Enter the name of dog: ");
		String nameDog = s.nextLine();
		System.out.println("Enter the length of the distance run: (no more than 500)");
		double runDog = s.nextDouble();
		System.out.println("Enter the name of the distance swim: (no more than 10)");
		double swimDog = s.nextDouble();
		
		Animal animal1 = new Animal(nameAnimal, runAnimal, swimAnimal);	
		
		Animal cat1 = new Cat(nameCat, runCat, swimCat);
		Animal cat2 = new Cat("Bars", runCat-38, -1);
		Animal cat3 = new Cat("Cake", runCat+6.6, -1);
		
		Animal dog1 = new Dog(nameDog, runDog, swimDog);
		Animal dog2 = new Dog("Barny", runDog+14.3, swimDog-6);

		animal1.output(animal1);
		
		cat1.output(cat1);
		cat2.output(cat2);
		cat3.output(cat3);
		
		dog1.output(dog1);
		dog2.output(dog2);
		
		Animal.outputCount();
		Cat.outputCountCat();
		Dog.outputCountDog();
		
	}

}
