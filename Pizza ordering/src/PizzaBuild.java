import java.util.*;

public class PizzaBuild {
	public List<String> toppings = new ArrayList<String>();
	public String baseType;
	public String topping;

	public double baseCost;
	public String baseMsg = "";
	public double toppingsCost;
	public String toppingsMsg = "";
	public double totalCost;
	public String vegetOption = "";
	public boolean vegeterian = true;
	
	//This method asks the user to input the base and the toppings he wants for his pizza.
		public void orderMsg() {
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
	//this method calculates and prints the total cost of the pizza
	public void calculateCost() {
		totalCost = baseCost + toppingsCost;
		System.out.println("\n");
		System.out.println("Your pizza costs: £" + totalCost);
	}
	
	//This method checks the toppings. If one of the toppings is ham, chicken or pepperoni
		//then prints out that the pizza is not suitable for vegeterians else, the pizza is suitabe for vegeterians
	public void vegeterianMsg() {
		for (int i = 0; i < toppings.size(); i++) {
			if (toppings.contains("ham") || toppings.contains("chicken")
					|| toppings.contains("chickens") || toppings.contains("pepperoni")) {
				vegeterian = false;
			} else {
				vegeterian = true;

			}
		}
		if (vegeterian == false) {
			System.out.println(vegetOption = "Not suitable for vegeterians");

		} else {
			System.out.println(vegetOption = "Suitable for vegeterians");
		}

	}
	//this is the main method of the PizzaBuild Class and calls different methods from the Pizza Class and itself
	public static void main(String[] args) {
		Pizza pi = new Pizza();
		PizzaBuild pb = new PizzaBuild();
		pb.orderMsg();
		pb.baseCost = pi.basecost(pb.baseType);
		pb.baseMsg = pi.Basemsg(pb.baseType);
		pb.toppingsCost = pi.toppingsCost(pb.toppings);
		pb.toppingsMsg = pi.getToppingsMsg();
		pb.calculateCost();
		pb.vegeterianMsg();
	}

}