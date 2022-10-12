package CapstoneProject.Restaurant.Workers;
import CapstoneProject.Restaurant.Constants;
import CapstoneProject.Restaurant.Restaurant;
import CapstoneProject.Restaurant.Menu.Order;
public class Chef implements Runnable {
	public int id;
	Restaurant restaurant;
	Waiter [] waiters;
	Order chefOrder;
	boolean isOrderReady;
	Waiter waiter;
	public Chef(int id, Waiter [] waiters,Restaurant restaurant) {
		this.id=id;
		this.waiters=waiters;
		this.restaurant=restaurant;
	}
	public void cookTheOrder() {
		isOrderReady=false;
		notifyAll();
		try {
			
			chefOrder=restaurant.takenOrderQueue.poll();
			Thread.sleep(chefOrder.orderCookTime());
			restaurant.preparedOrderQueue.add(chefOrder);
			isOrderReady=true;
			System.out.println("Sipariş hazırlanıyor");
			wait();
								
		}
		catch(Exception e){
				e.printStackTrace();
		}	
	}
	
	public void run() {
		for(int i=0;i<Constants.NUM_OF_WAITERS;i++)
			if (waiters[i].isNewOrderTaken==true) {
				cookTheOrder();
			}
		
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Chef [id=" + id + "]";
	}
	
	

}
