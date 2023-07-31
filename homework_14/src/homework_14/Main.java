package homework_14;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		 CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

	        orderBoard.add("Alen");
	        orderBoard.add("Yoda");
	        orderBoard.add("Obi-van");
	        orderBoard.add("John Snow");

	        System.out.println("Current queue:");
	        orderBoard.draw();

	        Order nextOrder = orderBoard.deliver();
	        System.out.println("Next order to deliver:");
	        if (nextOrder != null) {
	            System.out.println(nextOrder.getNumber() + " | " + nextOrder.getName());
	        } else {
	            System.out.println("No orders in the queue.");
	        }

	        int orderNumberToDeliver = 3;
	        Order specificOrder = orderBoard.deliverByNumber(orderNumberToDeliver);
	        System.out.println("\nDelivering order with number " + orderNumberToDeliver + ":");
	        if (specificOrder != null) {
	            System.out.println(specificOrder.getNumber() + " | " + specificOrder.getName());
	        } else {
	            System.out.println("Order with number " + orderNumberToDeliver + " not found.");
	        }

	        System.out.println("\nUpdated queue:");
	        orderBoard.draw();

	}

}

class Order {
    private int number;
    private String name;

    public Order(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}

class CoffeeOrderBoard {
    private List<Order> orders;
    private int nextOrderNumber;

    public CoffeeOrderBoard() {
        orders = new ArrayList<>();
        nextOrderNumber = 1;
    }

    public void add(String name) {
        Order newOrder = new Order(nextOrderNumber, name);
        orders.add(newOrder);
        nextOrderNumber++;
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            return null;
        }
        Order nextOrder = orders.get(0);
        orders.remove(0);
        return nextOrder;
    }

    public Order deliverByNumber(int orderNumber) {
        Order foundOrder = null;
        for (Order order : orders) {
            if (order.getNumber() == orderNumber) {
                foundOrder = order;
                orders.remove(order);
                break;
            }
        }
        return foundOrder;
    }

    public void draw() {
        System.out.println("=============\nNum | Name");
        for (Order order : orders) {
            System.out.println(order.getNumber() + " | " + order.getName());
        }
    }
}


