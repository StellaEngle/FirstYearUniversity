//Name:Stella Englezou
//Number:130422246
//Date:19/04/2014
import java.util.Arrays;
import java.util.Scanner;

public class ArrayDirectory implements Directory {
	Scanner key = new Scanner(System.in);
	public Entry[] directory = new Entry[100];
	Entry en = new Entry();

	public ArrayDirectory() {
	}

	// Method to insert new staff to the array
	public void insertNew(String name) {
		Entry newEntry = new Entry(name);
		TestArray exe = new TestArray();
		Scanner look = new Scanner(name);
		String surname = look.next();
		String initial = look.next();
		String nam = surname + " " + initial;
		look.close();
		int j = 0;
		int i;
		int last = directory.length;
		// finds how many staff are in the array
		while (directory[j] != null) {
			j++;
		}
		// if statement to check if the array is full
		// and if yes then it calls the doubleArrayMethod
		if (directory[last - 1] == null) {
			doubleArray();
		}
		// adds the new staff to the array
		// directory[j]=newEntry;
		// Search if name of the staff is already in the directoy
		i = binarySearch(directory, nam, 0, j);
		// if the staff is not in the array then it adds to the array
		if (i == -1) {
			directory[j] = newEntry;
		}
		// Else if the staff is in the array does not add the staff
		else {
			directory[j] = null;
			System.out
					.println("The entry you want to input already exists in the directory.");
		}
		// calls the sort method to sort the array.
		exe.sort(directory);

	}

	// Method to double the size of the array
	private Entry[] doubleArray() {
		Entry[] temp = directory;
		directory = new Entry[temp.length * 2];
		for (int i = 0; i < temp.length; i++) {
			directory[i] = temp[i];
		}
		return directory;

	}

	// Method to delete a staff from the array, by his name(surname and initial)
	// or number
	public void delete(String name, String num) {
		int j = 0;
		int i;
		int position = -1;
		// finds how many stuff are in the array
		while (directory[j] != null) {
			j++;
		}

		for (i = 0; i < j; i++) {
			// if the name is not null and is equals to a name of a staff inside
			// the array
			// it gets the index of the array
			if (name != null && name.equals(directory[i].getName())) {
				position = i;
				break;
				// checks for the number if it belongs to a staff and if yes it
				// gets the index
			} else if (num != null && num.equals(directory[i].getNumber())) {
				position = i;
				break;
			}
		}
		// check if the position is bigger than -1, and if yes deletes the
		// element
		// else prints a message
		// for statement to move the array down by one position fro the index we
		// got,
		// and therefore deleting the staff we want
		if (position > -1) {
			for (int k = position; k < directory.length ; k++) {
				directory[position] = directory[position + 1];
				
			}
			directory[position + 1] = null;
		} else {
			System.out.println("The staff you want to delete does not exist.");
		}
	}

	// Method to change the number of staff, given his name(surname and initial)
	public void changeNum(String surname, String newNumber) {
		int j = 0;
		int position = -1;
		// finds how many stuff are in the array
		while (directory[j] != null) {
			j++;
		}
		
		for (int i = 0; i < j; i++) {
			// if statement to find the index of the staff we want to change the
			// number
			if (surname != null && surname.equals(directory[i].getName())) {
				position = i;
				directory[position].num = newNumber;
				break;
			}
			
		}

	}

	// Method to return the number of staff by his/her name(surname and initial)
	public String lookUp(String surname) {
		Scanner look = new Scanner(surname);
		look.close();
		int j = 0;
		String value = "";
		while (directory[j] != null) {
			j++;
		}
		// calls the binarySearch method to find the index of the staff
		int i = binarySearch(directory, surname, 0, j);
		// if the index is -1 the staff was not found else it returns his/her
		// number
		if (i == -1) {
			System.out.println("The staff is not in the directory");
		} else {
			System.out.print("Number of the person you are searching is: ");
			value = directory[i].getNumber();
		}

		return value;
	}

	// Method to look for staff given his/her name(Surname and Initial)
	public int binarySearch(Entry[] directory, String name, int start, int end) {
		int mid = (start + end) / 2;
		Scanner look = new Scanner(name);
		look.close();
		int result = name.compareTo(directory[mid].getName());
		while (start <= end) {
			if (result > 0) {
				return binarySearch(directory, name, mid + 1, end);
			} else if (result < 0) {
				return binarySearch(directory, name, start, mid - 1);
			} else if (result == 0) {
				return mid;
			}

		}
		return -1;

	}

	// Method to print all the elements of the array
	public void printDirectory() {
		System.out.println("_____________________________________________");
		System.out.println();
		System.out.println("            Directory                   ");
		System.out.println();
		System.out.println(" Surname " + "             " + "Initial" + "     "
				+ "Tel. Extension");
		System.out.println("________________________________________________");

		for (int i = 0; i < directory.length; i++) {
			if (directory[i] != null) {

				System.out.printf("\n %-20s %5s %12s",
						directory[i].getSurname(), directory[i].getInitial(),
						directory[i].getNumber());
				System.out.printf("\n");
				System.out
						.println("________________________________________________");
				// System.out.println(directory[i].getSurname()+ "\t\t"+
				// directory[i].getInitial()+ "\t\t"+directory[i].getNumber());

			}
		}

	}

}
