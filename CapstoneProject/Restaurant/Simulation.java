package CapstoneProject.Restaurant;
import CapstoneProject.Restaurant.Workers.Chef;
import CapstoneProject.Restaurant.Workers.Waiter;
import CapstoneProject.Restaurant.Menu.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Simulation {	
	public Simulation(){		
	}
	public static void main(String[] args) {		
		Waiter[] waiters= null;
		Chef[] chefs= null;
		Customer[] customers = null;
		Table[] tables  = null;
		//Order[] orders = null;
		Menu[] menus=null;
		Restaurant restaurant=new Restaurant();
		
        ExecutorService executorCustomer = Executors.newFixedThreadPool(Constants.NUM_OF_CUSTOMERS);
        ExecutorService executorWaiter = Executors.newFixedThreadPool(Constants.NUM_OF_WAITERS);
        ExecutorService executorChef= Executors.newFixedThreadPool(Constants.NUM_OF_CHEFS);
        try {
        	//orders= new Order [Constants.NUM_OF_CUSTOMERS];
            tables = new Table[Constants.NUM_OF_TABLES];
            customers = new Customer[Constants.NUM_OF_CUSTOMERS];
            waiters= new Waiter[Constants.NUM_OF_WAITERS];
            chefs= new Chef[Constants.NUM_OF_CHEFS];
            // initialize tables
            for (int i = 0; i < Constants.NUM_OF_TABLES; ++i) {
                tables[i] = new Table(i + 1,true);
            }
            // initialize customers
            for (int i = 0; i < Constants.NUM_OF_CUSTOMERS; ++i) {
            	customers[i] = new Customer(i + 1, tables,menus,waiters,restaurant);
            	executorCustomer.execute(customers[i]);
            	Thread.sleep(100);
            }
            // initialize waiters
            for (int i = 0; i < Constants.NUM_OF_WAITERS; ++i) {
            	waiters[i] = new Waiter(i + 1,customers,chefs,restaurant);
                executorWaiter.execute(waiters[i]);
                Thread.sleep(100);
            }
            // initialize chefs
            for (int i = 0; i < Constants.NUM_OF_CHEFS; ++i) {
            	chefs[i] = new Chef(i + 1,waiters,restaurant);
                executorChef.execute(chefs [i]);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorCustomer.shutdown();
            executorWaiter.shutdown();
            executorChef.shutdown();
        }
	}
}
