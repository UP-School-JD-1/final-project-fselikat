package CapstoneProject.Restaurant.Menu;
public class MenuList {
	Food food1=new Food("Ton Balıklı Sandviç",2000,1000,4.50);
	Food food2=new Food("Mantı",2500,1000,5.50);
	Food food3=new Food("Tost",3000,1000,6.00);
	Food food4=new Food("Hamburger",900,1000,4.50);
	Food food5=new Food("Patates Kızartması",2000,1400,4.50);
	Food food6=new Food("Salata",1000,1500,4.50);
	Food food7=new Food("Profiterol",2000,750,10.00);
	Food food8=new Food("Kabak Tatlısı",2500,1000,14.90);
	Food food9=new Food("Tiramisu",1900,1995,25.50);
	Drink drink1 =new Drink("Çay",750,900,1.00);
	Drink drink2 =new Drink("Türk Kahvesi",1500,1000,3.00);
	Drink drink3 =new Drink("Salep",1000,700,3.50);
	Drink drink4 =new Drink("Bubble Tea",200,500,2.00);
	Drink drink5 =new Drink("Gazoz",100,500,2.50);
	Drink drink6 =new Drink("Kola",100,500,2.50);
	public Menu[] menuList = new Menu[] {food1,food2,food3,food4,food5,food6,food7,food8,food9,
			drink1,drink2,drink3,drink4,drink5,drink6};
	public Food[] foodList= new Food[] {food1,food2,food3,food4,food5,food6,food7,food8,food9};
	public Drink [] drinkList = new Drink[] {drink1,drink2,drink3,drink4,drink5,drink6};	
}
