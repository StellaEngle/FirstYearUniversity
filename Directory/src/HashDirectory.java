//Name:Stella Englezou
//Number:130422246
//Date:19/04/2014
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class HashDirectory implements Directory {
	public HashDirectory() {

	}

	// The HashMap to store the directory
	public HashMap<Character, ArrayList<Entry>> map = new HashMap<Character, ArrayList<Entry>>();
	// An arraylist to store the staff
	public ArrayList<Entry> names = new ArrayList<Entry>();
	public TreeMap<Character, ArrayList<Entry>> sortMap = new TreeMap<Character, ArrayList<Entry>>();
	int size = 0;

	// A method to add a new staff
	public void insertNew(String name) {
		Entry entry = new Entry(name);
		// Finds the first character of the string
		char key = name.charAt(0);
		// An if statement to check if the first character is in the Map
		// if true it finds the ArrayList of the letter and add the staff
		// else creates a new ArrayList and add the information about the stuff
		// and then
		// puts the new key and ArrayList to the Map
		if (map.containsKey(key)) {
			map.get(key).add(entry);

		} else {
			names = new ArrayList<Entry>();
			names.add(entry);
			map.put(key, names);
		}
		size++;
	}

	// Method to delete a staff given his/her name(Surname and Initial) or
	// his/her number
	public void delete(String name, String num) {
		// Checks if there is a value
		if (name != null) {
			// Gets the first character of the string name
			char key = name.charAt(0);
			// checks if the map contains the key
			if (map.containsKey(key)) {
				// Saves all the elements in an ArrayList of the particular key
				ArrayList<Entry> result = map.get(key);
				// Goes through the ArrayList and if the name is equal with the
				// name of a staff, it deletes it
				for (int i = 0; i < result.size(); i++) {
					if (result.get(i).getName().equals(name)) {
						result.remove(i);
					}

				}// if the ArrayList is empty then it deletes the key as well
				if (result.isEmpty()) {
					map.remove(key);
				}
			}

		}
		// Checks if there is a value
		else if (num != null) {
			// for all the key of the map saves their values in a new ArrayList
			for (Character key : map.keySet()) {
				ArrayList<Entry> result1 = map.get(key);
				// Goes through the ArrayList and if it finds the numb is equal
				// with the
				// the number of a staff, it deletes the staff
				for (int i = 0; i < result1.size(); i++) {
					if (result1.get(i).getNumber().equals(num)) {
						result1.remove(i);

					}
				}
				// if the ArrayList is empty then it deletes the key as well
				if (result1.isEmpty()) {
					map.remove(key);
					break;
				}
			}
		}
	}

	// A method to search the number of a staff given his/her name(surname and
	// initial)
	public String lookUp(String surname) {
		String num = "The staff is not in the directory";
		// Checks if there is a value
		if (surname != null) {
			// Gets the first character of the string
			char key = surname.charAt(0);
			// checks if the map contains the key
			if (map.containsKey(key)) {
				// Saves all the elements in an ArrayList of the particular key
				ArrayList<Entry> result = map.get(key);
				// Goes through the ArrayList and if the name is equal with the
				// name of a staff
				// it gets the number of the staff
				for (int i = 0; i < result.size(); i++) {
					if (result.get(i).getName().equals(surname)) {
						System.out.print("The number of the staff is: ");
						num = result.get(i).getNumber();
					}
				}
			}

		}
		return num;
	}

	// A method to change the number of a staff, given his/her
	// name(surname/initial)
	public void changeNum(String surname, String newNumber) {
		// Checks if there is a value
		if (surname != null) {
			// Gets the first character of the string
			char key = surname.charAt(0);
			if (map.containsKey(key)) {
				// Saves all the elements in an ArrayList of the particular key
				ArrayList<Entry> result = map.get(key);
				for (int i = 0; i < result.size(); i++) {
					if (result.get(i).getName().equals(surname)) {
						result.get(i).num = newNumber;
					}
				}
			}
		}

	}

	// Method to print the directory
	public void printDirectory() {
		System.out.println("_____________________________________________");
		System.out.println();
		System.out.println("            Directory                   ");
		System.out.println();
		System.out.println("Letter");
		System.out.println("-------");
		for (Character name : sortMap.keySet()) {
			System.out.println(" " + name + "   " + sortMap.get(name));
			System.out.println();

		}
	}

}
