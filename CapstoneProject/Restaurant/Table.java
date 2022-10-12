package CapstoneProject.Restaurant;
import CapstoneProject.Restaurant.Menu.Order;

public class Table {
	int id;
	boolean isEmpty;
	Order order;
	Simulation r;
	public Table(int id,boolean isEmpty) {
		this.id=id;
		this.isEmpty=isEmpty;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
}
