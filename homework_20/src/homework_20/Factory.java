package homework_20;

//Абстрактний клас або інтерфейс для меблів
interface Furniture {
 void assemble();
}

//Конкретний клас, який реалізує інтерфейс Furniture - стіл
class Table implements Furniture {
 @Override
 public void assemble() {
     System.out.println("Збирається стіл");
 }
}

//Конкретний клас, який реалізує інтерфейс Furniture - стілець
class Chair implements Furniture {
 @Override
 public void assemble() {
     System.out.println("Збирається стілець");
 }
}

//Фабрика для створення меблів
class FurnitureFactory {
 public Furniture createFurniture(String type) {
     if (type.equalsIgnoreCase("table")) {
         return new Table();
     } else if (type.equalsIgnoreCase("chair")) {
         return new Chair();
     } else {
         throw new IllegalArgumentException("Недопустимий тип меблів: " + type);
     }
 }
}


