package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Order;

public class OrderRepository {
	private List<Order> orders;
	
	public OrderRepository() {
		orders = new ArrayList();
	}
	
	public Order getOrderById(int id) {
		return orders.get(id);
	}
	
	public List<Order> getAllOrders() {
		return orders;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}
}
