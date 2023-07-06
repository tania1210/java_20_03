package homework_20;

interface Figure {
	double calculateArea(double [] dimensions);
}

//площа прямокутника
class Rectangle implements Figure{
	
	@Override
	public double calculateArea(double [] dimensions) {
		// dimensions[0] - довжина, dimensions[1] - ширина
		return dimensions[0] * dimensions[1];
	}

}

//площа трикутника
class Triangle implements Figure {
    @Override
    public double calculateArea(double[] dimensions) {
    	// dimensions[0] - основа, dimensions[1] - висота
        return 0.5 * dimensions[0] * dimensions[1];
    }
}

//Клас контексту, що використовує стратегію для обчислення площі фігури
class ShapeAreaCalculator {
 private Figure strategy;

 public ShapeAreaCalculator(Figure strategy) {
     this.strategy = strategy;
 }

 public void setStrategy(Figure strategy) {
     this.strategy = strategy;
 }

 public double calculateArea(double[] dimensions) {
     return strategy.calculateArea(dimensions);
 }
}
