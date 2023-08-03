package homework_15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		 List<Product> products = new ArrayList<>();
	     products.add(new Product("Book", 300));
	     products.add(new Product("Pen", 150));
	     products.add(new Product("Book", 970));
	     products.add(new Product("Food", 400));

	     List<Product> list = products.stream()
	    		 .filter(product -> product.getType().equals("Book"))
	    		 .collect(Collectors.toList());
	     System.out.println("Filtered products:");
	     list.forEach(product -> System.out.println("Type: " + product.getType() + ", Price: " + product.getPrice()));
	}

}

class Product {
	private String type;
	private double price;
	
	public String getType() {
		return type;
	}
	public double getPrice() {
		return price;
	}
	
	public Product(String type, double price) {
        this.type = type;
        this.price = price;
	}
	
}