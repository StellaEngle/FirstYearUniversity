//Stella Englezou 13042226
// Date:11/12/13

import java.util.*;

public class PizzaMenu {
	private double pizzaCost;
	private String pizzaName;
	
	
	public void margheritaPizza(){
		pizzaCost = 10.50;
		pizzaName= "Margherita Pizza";
		System.out.println("\n You have chosen: " + pizzaName);
		System.out.println(" The cost of your pizza is: £" + pizzaCost);		
	}
	
	public void vegetarianSupreme(){
		pizzaCost = 13.50;
		pizzaName= "Vegetarian Supreme Pizza";
		System.out.println("\n You have chosen: " + pizzaName);
		System.out.println(" The cost of your pizza is: £" + pizzaCost);
		
	}
	
	public void hawaiianPizza(){
		pizzaCost = 14.50;
		pizzaName= "Margherita Pizza";
		System.out.println("\n You have chosen: " + pizzaName);
		System.out.println(" The cost of your pizza is: £" + pizzaCost);
	}
	
	public void bbqPizza(){
		pizzaCost = 16.50;
		pizzaName= "BQQ Pizza";
		System.out.println("\n You have chosen: " + pizzaName);
		System.out.println(" The cost of your pizza is: £" + pizzaCost);
	}
	
	public void supremePizza(){
		pizzaCost = 17.00;
		pizzaName= "Supreme Pizza";
		System.out.println("\n You have chosen: " + pizzaName);
		System.out.println(" The cost of your pizza is: £" + pizzaCost);	
	}
	
	//In this method I print a form a form the predefined pizzas and their ingredients and if they are suitable for vegetarians or not
	//I ask the user to give the number of the  pizza he would like to order
	// I use a while loop to check if the number is one of the five choices and if it is not then I print a message to inform the user
	//and give a correct number
	//Using an if statement I check what the number is and i call the particular method that represent the pizza the user wants
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		PizzaMenu pm = new PizzaMenu();
		System.out.println(" (1) Margherita Pizza (Suitable for Vegetarians)");
		System.out.println("    Consists of: Thin Base, Tomatoes, Mozzarella and Basil.");
		System.out.println("\n (2) Vegetarian Supreme (Suitable for vegetarians)");
		System.out.println("    Consists of: Thick Base, Onions, Green Peppers, Sweetcorn, Mushrooms and Tomatoes.");
		System.out.println("\n (3) Hawaiian Pizza (Not Suitable for Vegetarians)");
		System.out.println("    Consists of: Thick Base, Ham, Pineapple and Mushrooms.");
		System.out.println("\n (4) BBQ Pizza (Not suitable for vegetarians)");
		System.out.println("    Consists of: Thin Base, BBQ sauce, Chicken, Bacon, Onions and Green Peppers.");
		System.out.println("\n (5) Supreme pizza (Not Suitable for vegeterians)");
		System.out.println("     Consists of: Thick Base, Tomatoes, Pepperoni, Mushrooms and Cicken.");
		System.out.print("\n Give the number of the pizza you would like to order:");
		n=in.nextInt();
		while((n!=1) || (n!=2) || (n!=3) || (n!=4) || (n!=5)){
			System.out.println("Incorrect number. Please give one number from 1-5.");
			n=in.nextInt();
		}
		if( n==1){
			pm.margheritaPizza();			
		}else if(n==2){
			pm.vegetarianSupreme();
			
		}else if(n==3){
			pm.hawaiianPizza();
		}else if(n==4){
			pm.bbqPizza();
		}else if(n==5){
			pm.supremePizza();
		}
		
		



		
	}

}
