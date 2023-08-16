package mainPackage;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private List<Product> items = new ArrayList();

    public void addProduct(Product product) {
        items.add(product);
    }

    public void deleteProduct(Product product) {
        items.remove(product);
    }

    public List<Product> getItems() {
        return items;
    }
}
