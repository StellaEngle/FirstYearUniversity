//Stella Englezou 130422246
//Date: 11/12/13

import java.util.ArrayList;
import java.util.List;

public class Pizza {
	PizzaBase pBase = new PizzaBase();
	PizzaToppings top = new PizzaToppings();

	public double baseCost;
	public String baseType;
	public String baseMsg = "";
	public double toppingsCost;
	public String toppingsMsg = "";	
	//private boolean vegetcheck ;
// A List where the toppings the user chooses will be saved in
	public List<String> toppings = new ArrayList<String>();
//A list where the prices of the toppings the user have chosen are saved in	
	public List<Double> prices= new ArrayList <Double>();
	
//This method calls the cost of each base from the PizzaBase class, depending on the user's choice
	public double basecost(String baseType) {
		if ((baseType.equals("thin"))) {
			baseCost = pBase.getcThin();
		} else if ((baseType.equals("thick"))) {
			baseCost = pBase.getcThick();
		}
		return baseCost;
	}
//This method calls the name of each base from the PizzaBase Class
	public String Basemsg(String baseType) {
		if ((baseType.equals("thin"))) {
			baseMsg = pBase.getbThin();
		} else if ((baseType.equals("thick"))) {
			baseMsg = pBase.getbThin();
		}
		return baseMsg;
	}

	//public String thickMsg() {
		//return pBase.getbThick();
	//}

	//public String thinMsg() {
		//return pBase.getbThin();
	//}

	//This methods adds together the price of each topping the user have chosen together
	public double toppingsCost(List<String> toppings) {
		for (int i = 0; i < toppings.size(); i++) {
			if (((toppings.get(i).equals("ham")))) {
				toppingsCost = toppingsCost + top.getHam();
				toppingsMsg = toppingsMsg + "Ham" + ", ";
				//vegetcheck=top.vegetHam();
			}
			if (((toppings.get(i).equals("mushroom ")) || (toppings.get(i)
					.equals("mushrooms")))) {
				toppingsCost = toppingsCost + top.getMushroom();
				toppingsMsg = toppingsMsg + "Mushroom" + " ";
				//vegetcheck=top.vegetMushroom();
			}
			if ((toppings.get(i).equals("onion"))
					|| (toppings.get(i).equals("onions"))) {
				toppingsCost = toppingsCost + top.getOnions();
				toppingsMsg = toppingsMsg + "Onion" + " ";
				// vegetcheck=top.vegetOnions();
			}
			if ((toppings.get(i).equals("chicken"))
					|| (toppings.get(i).equals("chickens"))) {
				toppingsCost = toppingsCost + top.getChicken();
				toppingsMsg = toppingsMsg + "Chicken" + " ";
				//vegetcheck=top.vegetChicken();
			}
			if(toppings.get(i).equals("pepperoni")){
				toppingsCost = toppingsCost + top.getPepperoni();
				toppingsMsg = toppingsMsg + "Pepperoni" + "";
				
			}
		}
		return toppingsCost;
	}
	//this method returns the name of each topping
	public String getToppingsMsg() {
		return toppingsMsg;
	}
//this method add the price of each topping to the list prices which i will later call in the PizzaChoice
	// to print each topping price
	public List<Double> toppingMsgCost(List<String> toppings, List<Double> prices){
			for (int i = 0; i < toppings.size(); i++) {
				if (((toppings.get(i).equals("ham")))) {
					prices.add(i,top.getHam());	
					
			}
				if (((toppings.get(i).equals("mushroom")) || (toppings.get(i)
						.equals("mushrooms")))) {
					prices.add(i,top.getMushroom());
					
				}
				if ((toppings.get(i).equals("onion"))
						|| (toppings.get(i).equals("onions"))) {
					prices.add(i,top.getOnions());
					
				}
				if (toppings.get(i).equals("chicken") || (toppings.get(i).equals("chickens"))){
					prices.add(i,top.getChicken());
				}
				if(toppings.get(i).equals("pepperoni")){
					prices.add(i,top.getPepperoni());
				}
				
		}
			return prices;
		
	}	

	//public void getVegetCheck(boolean vegetcheck){
		//this.vegetcheck=vegetcheck;
		
	//}
	//public boolean setVegetCheck(){
	//	return vegetcheck;
	//}
	

	
}