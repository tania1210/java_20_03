package homework_11;

import java.util.ArrayList;

//import homework_11.Apple;
public class Main {

	public static void main(String[] args) {
		Fruit<Apple, Orange> fruit = new Fruit();
//		Fruit<Apple> app1 = new Fruit<>();
//		Fruit<Apple> app2 = new Fruit <>();
//		Fruit<Apple> app3 = new Fruit <>();
//		Fruit<Orange> oran1 = new Fruit <>();
//		Fruit<Orange> oran2 = new Fruit <>();
//		Fruit<Orange> oran3 = new Fruit <>();
//		Fruit<Orange> oran4 = new Fruit <>();
		
		Box <Apple, Orange> box1 = new Box <> ();
		Box <Apple, Orange> box2 = new Box <> ();
//		app.addOne("");
//		app.addOne(100);
//		app.addOne(app);
		
//		System.out.println(app.getOne(0) + "\n" + app.getOne(1) + "\n" + app.getOne(2));
		
//		System.out.println(fruit.size());
		System.out.println(fruit.addT(new Apple()) + " size = " + fruit.size());
		System.out.println(fruit.addE(new Orange()) + " size = " + fruit.size());
		System.out.println(fruit.addE(new Orange()) + " size = " + fruit.size());
		System.out.println(fruit.addT(new Apple()) + " size = " + fruit.size());
		System.out.println(fruit.addE(new Orange()) + " size = " + fruit.size());
		System.out.println(fruit.addE(new Orange()) + " size = " + fruit.size());
		System.out.println(fruit.addT(new Apple()) + " size = " + fruit.size());
		
//		fruit.get(app1.get(0));
		System.out.println("\n\n");
		Apple obj;
		int j = 0;
		for(int i = 0; i < fruit.size(); i++) {
//			System.out.println("fruit class = " + fruit.get(i).getClass());
			
			if((fruit.get(i)) instanceof Apple) {
				box1.addT(fruit.get(i));
				System.out.println(true);
				System.out.println("object = " + fruit.get(i) + "   i = " + i);
			} else if((fruit.get(i)) instanceof Orange){
				box2.addE(fruit.get(i));
				System.out.println(true);
				System.out.println("object = " + fruit.get(i) + "   i = " + i);
			} else {
				System.out.println(false);
			}
			

			
			
			
			
			
//			box1.add(fruit.get(i));
			
//			System.out.println(fruit.get(i));
		}
//		System.out.println(box.add() + " size = " + fruit.size());
		

	}
	 public static class Apple{
			String sort;
			String color;
			int weight;
			
		}

	 public static class Orange {
			String sort;
			String color;
			int weight;
			
		}

	public static class Fruit <T, E> {
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
		
		public boolean addT(T toAdd) {				
				//розширення масиву
				if(size > fruits.length/2) {
//					expandArray();
				}
				
				for(int i = 0; i < fruits.length; i++) {
					if(fruits[i] == null) {
//						System.out.println("fruits[i] = " + fruits[i]);
//						System.out.println("toAdd = " + toAdd.getClass());
//						System.out.println("fruits = " + fruits.getClass());

						fruits[i] = toAdd;
						size++;
						return true;
					}
				}
				return false;
		}
		
		public boolean addE(E toAdd) {
			for(int i = 0; i < fruits.length; i++) {
				if(fruits[i] == null) {
//					System.out.println("fruits[i] = " + fruits[i]);
//					System.out.println("toAdd = " + toAdd);

					fruits[i] = toAdd;
					size++;
					return true;
				}
			}
			return false;
		}
		
		public T get(int index) {// throws IndexOutOfBoundsException
//			if(index < 0 || index > (objects.length - 1)) {
//				throw new IndexOutOfBoundsException();
//			}
			return (T) fruits[index];
		}
		
//		public T getObj() {// throws IndexOutOfBoundsException
//			if(index < 0 || index > (objects.length - 1)) {
//				throw new IndexOutOfBoundsException();
//			}
			
//			return ;
//		}
	}
	
	
	public static class Box <T, E>{
		private int size;
		Object [] boxes;
		
		public Box() {
			this(10);
		}
	
		public Box(int count) {
			this.boxes = new Object[count];
		}
		
		public boolean addT(T fruit) {			
			for(int i = 0; i < boxes.length; i++) {
				if(boxes[i] == null) {
					boxes[i] = fruit;
					size++;
					return true;
				}
			}
			return false;
		}
		
		public boolean addE(E fruit) {			
			for(int i = 0; i < boxes.length; i++) {
				if(boxes[i] == null) {
					boxes[i] = fruit;
					size++;
					return true;
				}
			}
			return false;
		}
	
	}
}

