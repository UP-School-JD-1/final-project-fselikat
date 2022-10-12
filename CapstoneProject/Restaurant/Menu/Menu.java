package CapstoneProject.Restaurant.Menu;
public class  Menu {	
	String name;
	int cookingTime;
	int consumptionTime;
	double price;
	Menu(String name,int cookingTime, int consumptionTime, double price){
		this.name=name;
		this.cookingTime=cookingTime;
		this.consumptionTime=consumptionTime;
		this.price=price;
	}	
	public int getConsumptionTime() {
		return consumptionTime;
	}
	public void setConsumptionTime(int consumptionTime) {
		this.consumptionTime = consumptionTime;
	}
	public String getName() {
		return name;
	}
	public int getCookingTime() {
		return cookingTime;
	}
	@Override
	public String toString() {
		return "Menu [name=" + name + ", cookingTime=" + cookingTime + ", consumptionTime=" + consumptionTime
				+ ", price=" + price + "]";
	}
	public double getPrice() {
		return price;
	}		
}