package CapstoneProject.Restaurant.Workers;
import CapstoneProject.Restaurant.Constants;
import CapstoneProject.Restaurant.Customer;
import CapstoneProject.Restaurant.Restaurant;
import CapstoneProject.Restaurant.Menu.Order;

public class Waiter implements Runnable {
	public int id;
	Restaurant restaurant;
	Customer []customers;
	Customer customer;
	Order order;
	Chef []chefs;
	boolean isNewOrderTaken;
	public boolean isOrderServicable;
	
	public Waiter(int id,Customer []customers,Chef []chefs,Restaurant restaurant) {
		this.id=id;
		this.customers=customers;		
		this.chefs=chefs;
		this.restaurant=restaurant;
	}
		public int getId() {
		return id;
	}		
	@Override
	public String toString() {
		return "Waiter [id=" + id + "]";
	}
	@Override
	public void run () {
		
		while (true) {
			try {
				int i=0;
				while(i<Constants.NUM_OF_CUSTOMERS) {
					if(customers[i].isWaiterAvailable==true) {	
						takeOrder();
						i++;
					}
				}int j=0;
				while(j<Constants.NUM_OF_CHEFS) {
					if(chefs[i].isOrderReady==true) {
						serviceTheOrder();
						
					}
				}
			}
			catch (Exception e) {
                e.printStackTrace();
            }
		}		
	}
	public void  takeOrder() throws InterruptedException {
		
		Thread.sleep(1000);
		isNewOrderTaken=false;
		synchronized (this) {
			notifyAll();
			try {
				Thread.sleep(100);
				isNewOrderTaken=true;
				System.out.println("Sipariş alındı");
				wait();
			}
			catch(Exception e){
					e.printStackTrace();
			}
		}				
	}
	public void serviceTheOrder() throws InterruptedException {
		notifyAll();
		isOrderServicable=false;
		synchronized (this) {
			try {
				isOrderServicable=true;
				wait();
			}
			catch( InterruptedException e) {
				
			}
		}						
	}
}

