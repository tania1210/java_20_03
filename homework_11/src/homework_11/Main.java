package homework_11;

import java.util.ArrayList;
import java.util.List;

//import homework_11.Apple;
public class Main {
	public final static double wApple = 1;
	public final static double wOrange = 1.5;
	

	

	public static void main(String[] args) {
		Fruit fruit = new Fruit(20);
		Fruit fruit2 = new Fruit(20);
		
		Box <Apple> box1 = new Box <> (20);
		Box <Orange> box2 = new Box <> (20);
		Box <Apple> box11 = new Box <> (20);

		System.out.println(fruit.add(new Apple(wApple)) + " fruit1");
		System.out.println(fruit.add(new Orange(wOrange)) + " fruit1" );
		System.out.println(fruit.add(new Orange(wOrange)) + " fruit1");
		System.out.println(fruit.add(new Apple(wApple)) + " fruit1");
		System.out.println(fruit.add(new Orange(wOrange)) + " fruit1");
		System.out.println(fruit.add(new Orange(wOrange)) + " fruit1");
		System.out.println(fruit.add(new Apple(wApple)) + " fruit1");
		
		System.out.println(fruit2.add(new Apple(wApple)) + " fruit2");
		System.out.println(fruit2.add(new Orange(wOrange)) + " fruit2" );
		System.out.println(fruit2.add(new Apple(wApple)) + " fruit2");
		System.out.println(fruit2.add(new Apple(wApple)) + " fruit2");
		
		System.out.println("\n");
		
		for(int i = 0; i < fruit.size(); i++) {
			System.out.println("fruit = " + fruit.get(i));
		}
		
		System.out.println("\n");
		for(int i = 0; i < fruit2.size(); i++) {
			System.out.println("fruit2 = " + fruit2.get(i));
		}
		
		System.out.println("\n");
		System.out.println(fruit.addArray(fruit2));
		
		for(int i = 0; i < fruit.size(); i++) {
			System.out.println("new fruit = " + fruit.get(i));
		}
		
		for(int i = 0; i < fruit.size(); i++) {			
			if((fruit.get(i)) instanceof Apple) {
				box1.add((Apple) fruit.get(i));
				System.out.println("is adding to box1");
			} else if((fruit.get(i)) instanceof Orange){
				box2.add((Orange) fruit.get(i));
				System.out.println("is adding to box2");
			} else {
				System.out.println(false);
			}
		}
		System.out.println("\n");
		
		box11.add(new Apple(wApple));

		for(int k = 0; k < box1.size(); k++) {
			System.out.println("box1 = " + box1.get(k) + "\nk = " + k);
		}
		
		System.out.println("\n");
		for(int k = 0; k < box2.size(); k++) {
			System.out.println("box2 = " + box2.get(k) + "\nk = " + k);
		}
		
		System.out.println("\nbox1 after merge: ");
		box1.merge(box11);
		
		for(int k = 0; k < box1.size(); k++) {
			System.out.println("new box1 :" + box1.get(k));
		}

		System.out.println("\nweight = " + box1.getWeight(box1.get(0)));
		System.out.println("weight = " + box2.getWeight(box2.get(0)));

		System.out.println("\ncompare: " + box1.compare(box2.sum));
		System.out.println("compare: " + box1.compare(box1.sum));
		
	}
	
	
	 public static class Apple extends Fruit {
			private double weight;
			
			public Apple(double weight) {
				this.weight = weight;
			}
			
			public void setWeight(double weight) {
				this.weight = weight;
			}
			
			public double getWeight() {
				return weight;
			}
			
		}

	 
	 public static class Orange extends Fruit{
			double weight;
			
			public Orange(double weight) {
				this.weight = weight;
			}
			
			public void setWeight(double weight) {
				this.weight = weight;
			}
			
			public double getWeight() {
				return weight;
			}
		}

	 
	 public static class Fruit <T> {
		 double weight;
		private double sum;
		private int size;
		Object [] fruits;
		
		public Fruit() {
			this(10);
		}
	
		public Fruit(int count) {
			this.fruits = new Object[count];
		}
		
		public int size() {
			return size;
		}
		
		public boolean add(Fruit<? extends Fruit> toAdd) {							
				for(int i = 0; i < fruits.length; i++) {
					if(fruits[i] == null) {
						fruits[i] = toAdd;
						size++;
						return true;
					}
				}
				return false;
		}		
		
		public boolean addArray(Fruit toAdd) {	
			int k = 0;
			System.out.println("length: " + fruits.length);
			for(int i = 0; i < fruits.length; i++) {
				System.out.println("i = " + i + "\nfruits = " + fruits[i]);
				
				if(fruits[i] == null) {
					fruits[i] = toAdd.get(k);
					size++;
					k++;
					if(toAdd.get(k) == null) {
						return true;
					}

					
				}
			}
			return false;
	}	
		
		public Fruit<? extends Fruit> get(int index) {
			return (Fruit<? extends Fruit>) fruits[index];
		}
				
	}
	
	
	public static class Box <T>{
		double sum = 0;
		private int size;
		Object [] boxes;
		
		public Box() {
			this(10);
		}
	
		public Box(int count) {
			this.boxes = new Object[count];
		}
		
		public boolean add(T fruit) {	
			for(int i = 0; i < boxes.length; i++) {
				if(boxes[i] == null) {
					boxes[i] = fruit;
					size++;
					return true;
				}
			}
			return false;
		}
		
		public int size() {
			return size;
		}
		
		public T get(int index) {
			return (T) boxes[index];
		}
	
		public double getWeight(Fruit<? extends Fruit> classType) {			
			if(classType instanceof Apple) {
				for(int i = 0; i < size; i++) {				
					sum += ((Apple) get(i)).getWeight();			
				}	
			}else if(classType instanceof Orange) {
				for(int i = 0; i < size; i++) {
					sum += ((Orange) get(i)).getWeight();
				}
			}else {
				return -1;
			}
			return sum;
		}
		
		public boolean compare(double sum) {
			if(this.sum == sum) {
				return true;
			}else {
				return false;
			}

		}
		
		public void merge(Box box11) {
			size = 0;
			for(int i = 0; i < boxes.length; i++) {
				boxes[i] = box11.get(i);
				size++;
				return;				
			}			
		}
		
		
		
	}
}


