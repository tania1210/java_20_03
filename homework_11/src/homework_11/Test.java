package homework_11;

import java.util.ArrayList;
import java.util.List;

//import homework_11.Apple;
public class Test {

	public static void main(String[] args) {
		Fruit fruit = new Fruit(20);
		
		Box <Apple> box1 = new Box <> (20);
		Box <Orange> box2 = new Box <> (20);
//		box1.add("");
//		box1.add(100);
//		box1.add(new Apple());
//		box1.add(new Orange());
		
//		System.out.println(app.getOne(0) + "\n" + app.getOne(1) + "\n" + app.getOne(2));
		
//		System.out.println(fruit.size());
		System.out.println(fruit.add(new Apple()) + " size = " + fruit.size());
		System.out.println(fruit.add(new Orange()) + " size = " + fruit.size());
		System.out.println(fruit.add(new Orange()) + " size = " + fruit.size());
		System.out.println(fruit.add(new Apple()) + " size = " + fruit.size());
		System.out.println(fruit.add(new Orange()) + " size = " + fruit.size());
		System.out.println(fruit.add(new Orange()) + " size = " + fruit.size());
		System.out.println(fruit.add(new Apple()) + " size = " + fruit.size());
//		
////		fruit.get(app1.get(0));
//		System.out.println("\n\n");
//		Apple obj;
//		int j = 0;
		for(int i = 0; i < fruit.size(); i++) {
			
			System.out.println("fruit class = " + fruit.get(i).getClass());
			
			if((fruit.get(i)) instanceof Apple) {
				box1.add((Apple) fruit.get(i));
				System.out.println(true);
//				System.out.println("object = " + fruit.get(i) + "   i = " + i);
			} else if((fruit.get(i)) instanceof Orange){
				box2.add((Orange) fruit.get(i));
				System.out.println(true);
//				System.out.println("object = " + fruit.get(i) + "   i = " + i);
			} else {
				System.out.println(false);
			}
			
			
//			System.out.println(fruit.get(i));
		}
		System.out.println("\n\n");
		for(int k = 0; k < box1.size(); k++) {
			System.out.println("box1 = " + box1.get(k) + "\nk = " + k);
		}
		System.out.println("\n\n");
		for(int k = 0; k < box2.size(); k++) {
			System.out.println("box2 = " + box2.get(k) + "\nk = " + k);
		}
		
//		System.out.println(box.add() + " size = " + fruit.size());
		

	}
	 public static class Apple extends Fruit {
			String sort;
			String color;
			int weight;
			
		}

	 
	 public static class Orange extends Fruit{
			String sort;
			String color;
			int weight;
			
		}

	 
	 public static class Fruit <T> {
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
				//розширення масиву
				if(size > fruits.length/2) {
//					expandArray();
					return false;
				}
				
				for(int i = 0; i < fruits.length; i++) {
					if(fruits[i] == null) {
						fruits[i] = toAdd;
						size++;
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
	
	}
}


