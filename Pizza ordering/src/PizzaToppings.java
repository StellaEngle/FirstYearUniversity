//Stella Englezou 130422246
//Date: 11/12/13

//This class consists of five toppings and their prices and also if they are vegetarian or not.
//I will call methods from this class to other classes.

public class PizzaToppings {
	private  double ham=0.50;
	private  double mushroom=0.40;
	private  double chicken=1.50;
	private  double onions=0.30;	
	private double  pepperoni=0.80;
	
	public void setPepperoni(double pepperoni){
		this.pepperoni=pepperoni;
		}
	public double getPepperoni(){
		return pepperoni;
	}
	
	public void setHam(double ham){
		this.ham=ham;
	}
	public double getHam(){
		return ham;
	}
	
	public void setMushroom(double mushroom){
		this.mushroom=mushroom;
	}
	public double getMushroom(){
		return mushroom;
	}
	
	public void setOnion(double onions){
		this.onions=onions;
		
	}	
	public double getOnions(){
		return onions;
	}
	
	public void setChicken(double chicken){
		this.chicken=chicken;
		
	}
	public double getChicken(){
		return chicken;
	}
	
	public boolean vegetHam(){
		return false;
	}
	public boolean vegetMushroom(){
		return true;
	}
	public boolean vegetOnions(){
		return true;
	}
	public boolean vegetChicken(){
		return false;
	}
	public boolean vegetPepperoni(){
		return false;
	}
 }
