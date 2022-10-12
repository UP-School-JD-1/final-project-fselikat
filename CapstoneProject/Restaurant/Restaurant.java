package CapstoneProject.Restaurant;
import java.util.LinkedList;
import java.util.Queue;
import CapstoneProject.Restaurant.Menu.Order;
public class Restaurant {
	public Queue<Order> takenOrderQueue= new LinkedList<>();
    public Queue<Customer> waitingQueue= new LinkedList<>();
    public Queue<Order> preparedOrderQueue=new LinkedList<>();
}
