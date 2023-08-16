package mainPackage;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1, "Apples", 32.80));
        products.add(new Product(2, "Potatoes", 14.50));
        products.add(new Product(3, "Carrots", 22.90));
        products.add(new Product(4, "Plums", 46.80));
        products.add(new Product(5, "Onions", 10.00));
        products.add(new Product(6, "Blueberries", 86.90));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
