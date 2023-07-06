package homework_20;

//Клас, що представляє об'єкт "Автомобіль"
class Car {
 private String make;
 private String model;
 private int year;
 private String color;

 public Car(String make, String model, int year, String color) {
     this.make = make;
     this.model = model;
     this.year = year;
     this.color = color;
 }

 // Геттери і сеттери для полів автомобіля

 public String getMake() {
     return make;
 }

 public void setMake(String make) {
     this.make = make;
 }

 public String getModel() {
     return model;
 }

 public void setModel(String model) {
     this.model = model;
 }

 public int getYear() {
     return year;
 }

 public void setYear(int year) {
     this.year = year;
 }

 public String getColor() {
     return color;
 }

 public void setColor(String color) {
     this.color = color;
 }

 @Override
 public String toString() {
     return "Car{" +
             "make='" + make + '\'' +
             ", model='" + model + '\'' +
             ", year=" + year +
             ", color='" + color + '\'' +
             '}';
 }
}

//Інтерфейс будівельника
interface CarBuilder {
 void buildMake(String make);
 void buildModel(String model);
 void buildYear(int year);
 void buildColor(String color);
 Car getResult();
}

//Конкретний будівельник
class CarBuilderImpl implements CarBuilder {
 private Car car;

 public CarBuilderImpl() {
     this.car = new Car("", "", 0, "");
 }

 @Override
 public void buildMake(String make) {
     car.setMake(make);
 }

 @Override
 public void buildModel(String model) {
     car.setModel(model);
 }

 @Override
 public void buildYear(int year) {
     car.setYear(year);
 }

 @Override
 public void buildColor(String color) {
     car.setColor(color);
 }

 @Override
 public Car getResult() {
     return car;
 }
}

//Директор
class CarDirector {
 public Car constructSportsCar(CarBuilder builder) {
     builder.buildMake("Ferrari");
     builder.buildModel("458 Spider");
     builder.buildYear(2022);
     builder.buildColor("Red");
     return builder.getResult();
 }
}


