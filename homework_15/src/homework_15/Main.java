package homework_15;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) {
		 List<Product> products = new ArrayList<>();
	     products.add(new Product("Book", 20, false, LocalDate.of(2023, 8, 06), 1));
	     products.add(new Product("Pen", 150, true, LocalDate.of(2023, 3, 21), 2));
	     products.add(new Product("Book", 70, true, LocalDate.of(2023, 5, 11), 3));
	     products.add(new Product("Food", 400, true, LocalDate.of(2022, 10, 10), 4));
	     products.add(new Product("Book", 490, false, LocalDate.of(2022, 9, 17), 5));
	     products.add(new Product("Book", 140, false, LocalDate.of(2022, 1, 28), 6));
	     products.add(new Product("Book", 600, true, LocalDate.of(2022, 5, 05), 7));
	     products.add(new Product("Food", 410, false, LocalDate.of(2022, 10, 12), 8));
	     
	     
	     System.out.println("Task 1.2:");
	     List<Product> p1 = Product.getAllBookProducts(products);	     
	     p1.forEach(product -> System.out.println("Type: " + product.getType() + ", Price: " + product.getPrice()));
	    
	     System.out.println("\nTask 2.2:");
	     List<Product> p2 = Product.getDiscountedBookProducts(products);
	     p2.forEach(product -> System.out.println("Type: " + product.getType() + ", Price: " + product.getPrice()));
	     
	     System.out.println("\nTask 3.2:");
	     try {
	    	 Product cheapestBookProduct = Product.getCheapestBookProduct(products);
	    	 System.out.println("Type: " + cheapestBookProduct.getType() + ", Price: " + cheapestBookProduct.getPrice());
	     } catch (NoSuchElementException e) {
	    	 System.out.println(e.getMessage());
	     }
   
	     System.out.println("\nTask 4.2:");
	     List<Product> threeLatestAddedProducts = Product.getThreeLatestAddedProducts(products);
	     for(int i = 0; i < threeLatestAddedProducts.size(); i++) {
	    	 System.out.println("Result: " + threeLatestAddedProducts.get(i).getType() +" "
	    			 + threeLatestAddedProducts.get(i).getPrice());
	    	 
	     }
	     
	     System.out.println("\nTask 5.2:");
	     double totalPrice = Product.calculateTotalPrice(products);
	     System.out.println("Result: " + totalPrice);
	     
	     System.out.println("\nTask 6.2:");
	     Map<String, List<Product>> groupedProductsByType = Product.groupProductsByType(products);
	     System.out.println("Result " + groupedProductsByType);
	          
	}

}

class Product {
	private String type;
	private double price;
	private boolean discountApplicable;
	private LocalDate createDate;
	private int id;
	
	public String getType() {
		return type;
	}
	public double getPrice() {
		return price;
	}
	
	public boolean getDiscountApplicable() {
		return discountApplicable;
	}
	
	public LocalDate getCreateDate() {
		return createDate;
	}
	
	public int getId() {
		return id;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Product(String type, double price, boolean discountApplicable, LocalDate createDate, int id) {
        this.type = type;
        this.price = price;
        this.discountApplicable = discountApplicable;
        this.createDate = createDate;
        this.id = id;
	}
	
	// Завдання 1.2
	public static List<Product> getAllBookProducts(List<Product> products) {
		 return products.stream()
				 .filter(product -> product.getType().equals("Book"))
				 .filter(product -> product.getPrice() > 250)
	    		 .collect(Collectors.toList());
	}
	 
	// Завдання 2.2
	public static List<Product> getDiscountedBookProducts(List<Product> products) {
		return products.stream()
				.filter(p -> p.getType().equals("Book"))
	        	.peek(p -> p.doDiscount())
	            .collect(Collectors.toList());
	}
	 
	private double doDiscount() {
		if(discountApplicable == false) {
			return price;
		}else {
			setPrice(price * 0.9);
			return price;
		}
	}
	 
	// Завдання 3.2
	public static Product getCheapestBookProduct(List<Product> products) {
		return products.stream()
				.filter(product -> product.getType().equals("Book"))
				.min(Comparator.comparingDouble(Product::getPrice))
				.orElseThrow(() -> new NoSuchElementException("Продукт [категорія: Book] не знайдено"));
	}

	// Завдання 4.2	 
	public static List<Product> getThreeLatestAddedProducts(List<Product> products) {
		return products.stream()
				.filter(p -> p.getCreateDate() != null)
				.sorted(Comparator.comparing(Product::getCreateDate))
				.limit(3)
				.collect(Collectors.toList());
	}
	    
	// Завдання 5.2	
	public static double calculateTotalPrice(List<Product> products) {		 
		return products.stream()
				.filter(p -> p.getType().equals("Book"))
				.filter(p -> p.getCreateDate().getYear() == LocalDate.now().getYear())
				.filter(p -> p.getPrice() <= 75)
				.mapToDouble(Product::getPrice)
				.sum();
	}
	 
	// Завдання 6.2
	public static Map<String, List<Product>> groupProductsByType(List<Product> products) {
		return products.stream()
				.collect(Collectors.groupingBy(Product::getType));
	}
	 
		 
}
