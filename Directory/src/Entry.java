//Name:Stella Englezou
//Number:130422246
//Date:19/04/2014
import java.util.Scanner;


//A class to get the surname, initial, number and name(surname and initial) of each staff
public class Entry implements Comparable<Entry> {	

	public String surname;
	public String initial;
	public String num;
	public String name;
	
	public Entry() {
	}

	public Entry(String fdata) {
		Scanner data = new Scanner(fdata);
		this.surname = data.next();
		this.initial =  data.next();
		this.num =  data.next();
		this.name=getSurname()+" " +getInitial();
		
		data.close();
	}
	
	public String getSurname(){
		return surname;
	}
	public String getInitial(){
		return initial;
	}
	
	public String getNumber(){
		return num;
	}
	public String getName(){
		return name;
	}
	

	
	public String toString(){
		return surname + " " + initial + " "+ num ;

	}

	//A compareTo method to return an integer for the sort method inside the TestArray class
	public int compareTo(Entry other) {
		if (this.getSurname().toLowerCase().compareTo(other.getSurname().toLowerCase())>0){
			return 1;
		} else if (this.getSurname().toLowerCase().compareTo(other.getSurname().toLowerCase())<0){
			return -1;
		} else{ 
			if (this.getInitial().toLowerCase().compareTo(other.getInitial().toLowerCase())>0){
				return 1;
			} else if (this.getInitial().toLowerCase().compareTo(other.getInitial().toLowerCase())==0){
				return 0;
			} else {
				return -1;
			}
		}
		
		
		
	}

	
	
}
