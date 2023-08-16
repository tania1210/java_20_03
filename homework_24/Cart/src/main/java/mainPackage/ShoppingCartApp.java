package mainPackage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class ShoppingCartApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add product to cart");
            System.out.println("2. Remove product from cart");
            System.out.println("3. Show cart contents");
            System.out.println("4. Show all price");
            System.out.println("5. Exit");
            System.out.print("Choose an option: \n");
            int choice = scanner.nextInt();

            Cart cart = context.getBean(Cart.class);
            ProductRepository productRepository = context.getBean(ProductRepository.class);

            switch (choice) {
                case 1:
                    System.out.print("\nEnter product ID to add: ");
                    int productIdToAdd = scanner.nextInt();
                    Product productToAdd = productRepository.getProductById(productIdToAdd);
                    if (productToAdd != null) {
                        cart.addProduct(productToAdd);
                        System.out.println("Product added to cart.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID to remove: ");
                    int productIdToRemove = scanner.nextInt();
                    Product productToRemove = productRepository.getProductById(productIdToRemove);
                    if (productToRemove != null) {
                        cart.deleteProduct(productToRemove);
                        System.out.println("Product removed from cart.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    System.out.println("Cart items:");
                    for (Product cartItem : cart.getItems()) {
                        System.out.println(cartItem.getName() + " - $" + cartItem.getPrice());
                    }
                    break;

                case 4:
                	System.out.println("All price:");
                	List<Product> allprice = productRepository.getAllProducts();
                	for(Product item: allprice) {
                		System.out.println(item.getId() + ". " + item.getName() + " -$" + item.getPrice());
                	}
                    break;
                    
                case 5:
                	 System.out.println("Exiting...");
                     scanner.close();
                     System.exit(0);
            }
        }
    }
}



//package mainPackage;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class ShoppingCartApp {
//    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        // Отримання екземпляру Cart з контексту додатка
//        Cart cart = context.getBean(Cart.class);
//
//        // Додавання товару до кошика
//        ProductRepository productRepository = context.getBean(ProductRepository.class);
//        Product productToAdd = productRepository.getProductById(1);
//        cart.addProduct(productToAdd);
//
//        // Виведення товарів у кошику
//        System.out.println("Cart items:");
//        for (Product cartItem : cart.getItems()) {
//            System.out.println(cartItem.getName() + " - $" + cartItem.getPrice());
//        }
//    }
//}


