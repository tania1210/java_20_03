package homework_11;

import java.util.ArrayList;
import java.util.List;

//import homework_11.Apple;
public class Test {
	public final static double wApple = 1;
	public final static double wOrange = 1.5;
	

	

	public static void main(String[] args) {
		Fruit fruit = new Fruit(20);
		
		Box <Apple> box1 = new Box <> (20);
		Box <Orange> box2 = new Box <> (20);

		System.out.println(fruit.add(new Apple(wApple)) + " size = " + fruit.size());
		System.out.println(fruit.add(new Orange(wOrange)) + " size = " + fruit.size());
		System.out.println(fruit.add(new Orange(wOrange)) + " size = " + fruit.size());
		System.out.println(fruit.add(new Apple(wApple)) + " size = " + fruit.size());
		System.out.println(fruit.add(new Orange(wOrange)) + " size = " + fruit.size());
		System.out.println(fruit.add(new Orange(wOrange)) + " size = " + fruit.size());
		System.out.println(fruit.add(new Apple(wApple)) + " size = " + fruit.size());

		for(int i = 0; i < fruit.size(); i++) {			
			if((fruit.get(i)) instanceof Apple) {
				box1.add((Apple) fruit.get(i));
				System.out.println(true);
			} else if((fruit.get(i)) instanceof Orange){
				box2.add((Orange) fruit.get(i));
				System.out.println(true);
			} else {
				System.out.println(false);
			}
		}
		
		System.out.println("\n\n");
		for(int k = 0; k < box1.size(); k++) {
			System.out.println("box1 = " + box1.get(k) + "\nk = " + k);
		}
		
		System.out.println("\n\n");
		for(int k = 0; k < box2.size(); k++) {
			System.out.println("box2 = " + box2.get(k) + "\nk = " + k);
		}
//		System.out.println("weight = " + box1.getWeight());
//		System.out.println("get class = " + box1.get(0).getClass());
//		System.out.println("weight = " + box1.getWeightF());//double
		System.out.println("\n\n");
		System.out.println("weight = " + box1.getWeight(box1.get(0)));
		System.out.println("weight = " + box2.getWeight(box2.get(0)));
		
		System.out.println("\n\n");
		System.out.println("compare: " + box1.compare(box2.sum));
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
				if(size > fruits.length/2) {
//					expandArray();
					return false;
				}
				
				for(int i = 0; i < fruits.length; i++) {
					if(fruits[i] == null) {
						fruits[i] = toAdd;
						size++;
//						sum += getWeight();
						return true;
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
//			double sum = 0;			
			
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
		
		
		
		
		
	}
}


