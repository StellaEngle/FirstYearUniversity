import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaChoice{
	public   List<String> toppings = new ArrayList<String>();
	public  List<Double> prices= new ArrayList<Double>();
	
	public   String baseType;
	public   String topping;
	public  double costTop;
			
	public   double baseCost;
	public   String baseMsg="";
	public   double toppingsCost;
	public   String toppingsMsg="";	
	public   double totalCost;
	public   String vegetOption="";
	public  boolean vegeterian=true;
	
	//This method asks the user to input the base and the toppings he wants for his pizza.
	public  void orderMsg() {
		@SuppressWarnings("resource")
		Scanner s1 = new Scanner(System.in);
		System.out.println("Choose the base you would like: Thin/Thick");
		baseType = s1.next().toLowerCase();
		//If the value of baseType is not equal to thin or thick, it asks the user to choose again between thin and thick
		while(!((baseType.equals("thin")) || (baseType.equals("thick")))){
			System.out.println("Wrong Pizza Base. Please choose [Thin or Thick]");
			baseType = s1.next().toLowerCase();
			
		}
		
		System.out.println("Choose toppings: Ham, Mushroom, Onions, Chicken, Pepperoni ");
		System.out.println("Choose one topping you want and press enter to choose another one");
		System.out.println("Enter the word \"finish\"  to complete your order ");
		topping = s1.next().toLowerCase();
		
		while (!topping.equals("finish")) {
			toppings.add(topping);
			
			topping = s1.next().toLowerCase();
		}
	}
	//this method prints the pizza's base
	public  void createBasePizza(){
		System.out.println("Your customized pizza consists of:");
		System.out.println(baseMsg +  " base");
			
	}
	//this method calculates and prints the total cost of the pizza
	public  void calculateCost(){
		totalCost=baseCost+toppingsCost;
		System.out.println("\n");
		System.out.println("Your pizza costs: £"+totalCost);
	}
	//This method checks the toppings. If one of the toppings is ham, chicken or pepperoni
	//then prints out that the pizza is not suitable for vegeterians else, the pizza is suitabe for vegeterians
	public  void vegeterianMsg(){
		for (int i=0;i<toppings.size();i++){
		if(toppings.contains("ham") || toppings.contains("chicken")|| toppings.contains("chickens") || toppings.contains("pepperoni")){
			vegeterian=false;
		}
		else{
			vegeterian=true;
				
			}
		}
		if (vegeterian==false){
			System.out.println(vegetOption="Not suitable for vegeterians");

		}else{
			System.out.println(vegetOption="Suitable for vegeterians");
		}
			
	}
//this is the main method of the PizzaChoice Class and calls different methods from the Pizza Class and itself
//It prints out the toppings, and the price of each topping
	public static void main(String[] args) {
		Pizza pi = new Pizza();
		PizzaChoice pc = new PizzaChoice();
		pc.orderMsg();
		pc.baseCost=pi.basecost(pc.baseType);
		pc.baseMsg=pi.Basemsg(pc.baseType);
		pc.toppingsCost=pi.toppingsCost(pc.toppings);
		pc.toppingsMsg=pi.getToppingsMsg();
		pc.createBasePizza();
		System.out.print("Toppings: " + pc.toppingsMsg );
		System.out.print("\n");
		System.out.print("Prices of each topping respectavely in pounds: " + pi.toppingMsgCost(pc.toppings , pc.prices));		     	
		pc.calculateCost();
		pc.vegeterianMsg();
	}

}