package CapstoneProject.Restaurant.Menu;
public class Order {
	int customerID;
	Menu[]menus;
	public Order(int customerID,Menu[]menus) {
		this.customerID=customerID;
		this.menus=menus;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public Menu[] getMenus() {
		return menus;
	}
	public void setMenus(Menu[] menus) {
		this.menus = menus;
	}
	public int orderCookTime() {
		int cookTime=0;
		for(int i=0;i<menus.length;i++) {
			cookTime=menus[i].getCookingTime();
		}
		return cookTime;
	}	
}
