package homework_20;


public class Main {
	public static void main(String[] args) {
	//Приклад використання шаблону "Фабрика" для створення меблів
	   FurnitureFactory factory = new FurnitureFactory();
	   
	   Furniture table = factory.createFurniture("table");
	   table.assemble(); // Збирається стіл
	   
	   Furniture chair = factory.createFurniture("chair");
	   chair.assemble(); // Збирається стілець
	   
	   
	   System.out.println("\n");
	 //Приклад використання шаблону "Будівельник" для створення автомобіля
	   CarBuilder builder = new CarBuilderImpl();
	   CarDirector director = new CarDirector();
	
	   Car sportsCar = director.constructSportsCar(builder);
	   System.out.println(sportsCar);
	   
	   
	   System.out.println("\n");
	 //Приклад використання шаблону "Стратегія" для обчислення площі фігур
     // Створення об'єкту контексту
     ShapeAreaCalculator calculator = new ShapeAreaCalculator(new Rectangle());

     // Обчислення площі прямокутника
     double[] rectangleDimensions = {10.0, 5.0}; // довжина, ширина
     double rectangleArea = calculator.calculateArea(rectangleDimensions);
     System.out.println("Площа прямокутника: " + rectangleArea);

     // Зміна стратегії на обчислення площі трикутника
     calculator.setStrategy(new Triangle());

     // Обчислення площі трикутника
     double[] triangleDimensions = {6.0, 8.0}; // основа, висота
     double triangleArea = calculator.calculateArea(triangleDimensions);
     System.out.println("Площа трикутника: " + triangleArea);
	}
}


//public class Main {
// public static void main(String[] args) {

// }
//}