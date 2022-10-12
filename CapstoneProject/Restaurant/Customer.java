package CapstoneProject.Restaurant;
import java.util.Arrays;
import java.util.Random;
import CapstoneProject.Restaurant.Menu.*;
import CapstoneProject.Restaurant.Workers.Waiter;
//import CapstoneProject.Restaurant.Workers.*;
public class Customer implements Runnable {
	int id;
	Restaurant restaurant;
	Waiter []waiters;
	Table tables[];	
	Order order;
	Menu [] menus;
	MenuList ml= new MenuList();
	public boolean isWaiterAvailable;
	public Customer[] waitingQueue=new Customer[Constants.NUM_OF_CUSTOMERS];
	public Customer(int id,Table tables[], Menu [] menus,Waiter []waiters,Restaurant restaurant) {
		this.id=id;
		this.tables=tables;
		this.menus=menus;
		this.waiters=waiters;
		this.restaurant=restaurant;
		}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		public Table[] getTables() {
		return tables;
	}
		
	public Menu[] getMenus() {
			return menus;
		}
		public void setMenus(Menu[] menus) {
			this.menus = menus;
		}
	public void setTables(Table[] tables) {
		this.tables = tables;
	}
	@Override
	public void run() {
		while(true) {			
			try {	
				findAnEmptyTable();	
				
				
			}
			catch (InterruptedException e) {
                e.printStackTrace();
            }		
		}
	}
	public Menu[] randomOrder() {		
		int a =new Random().nextInt(3)+1;
		Menu [] orders=new Menu[a];
		if (a==1) {	
			int randomIndex = new Random().nextInt(ml.menuList.length-1);
			orders[0]=ml.menuList[randomIndex];
			return orders;
		}
		else if(a==2) {
			int randomIndex1 = new Random().nextInt(ml.menuList.length-1);
			orders[0]=ml.menuList[randomIndex1];
			int randomIndex2 = new Random().nextInt(ml.foodList.length-1);
			orders[1]=ml.foodList[randomIndex2];
			return orders;
		}
		else {
			int randomIndex = new Random().nextInt(ml.drinkList.length-1);
			orders[0]=ml.drinkList[randomIndex];
			int randomIndex1 = new Random().nextInt(ml.foodList.length-1);
			orders[1]=ml.foodList[randomIndex1];
			int randomIndex2 = new Random().nextInt(ml.foodList.length-1);
			orders[2]=ml.foodList[randomIndex2];
			return orders;
		}	
	}
	public void  findAnEmptyTable()throws InterruptedException {	
		for (int i=0;i<Constants.NUM_OF_TABLES;i++) {
			synchronized(this) {
				notifyAll();			
				if(tables[i].isEmpty==true) {
					System.out.println("Customer"+id+" "+(i+1)+" nolu masaya oturdu");
					tables[i].isEmpty=false;	
					menus=randomOrder();
					order=new Order(id,menus);
					restaurant.takenOrderQueue.add(order);	
					isWaiterAvailable=true;
					for(int j=0;i<Constants.NUM_OF_WAITERS;i++) {
						if(waiters[j].isOrderServicable==true) {
							Thread.sleep(eatingTime());
							pay();
							tables[i].isEmpty=false;
							
						}
					}
				}
				else if(tables[i].isEmpty==false) {
					if(i==Constants.NUM_OF_TABLES-1) {
						System.out.println("Bütün masalar dolu Costumer"+id+" ayakta kaldı");
						waitOrLeft();
						wait();
					}
				}
			}
		}
	}			
	@Override
	public String toString() {
		return "Customer [id=" + id + ", menus=" + Arrays.toString(menus) + "]";
	}
	public boolean waitOrLeft() {
		int a =new Random().nextInt(1, 3);
		if (a==1) {
			System.out.println("Müşteri ayrıldı");
			return false;
		}
		else {
			System.out.println("Müşteri beklemeyi seçti ve ve bekleme sırasına girdi");
			restaurant.waitingQueue.add(this);	
			return true;		
		}
	}
	public int eatingTime() {
		int eatingTime=0;
		for(int i=0;i<menus.length;i++) {
			eatingTime=menus[i].getConsumptionTime();
		}
		return eatingTime;
	}
	public double pay() {
		double prices=0;
		for(int i=0;i<menus.length;i++) {
			prices=menus[i].getPrice();
		}
		return prices;
	}
}