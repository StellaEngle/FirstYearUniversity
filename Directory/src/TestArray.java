//Name: Stella Englezou 
//Number:130422246
//Date:19/04/2014
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class TestArray {

	public TestArray() {

	}

	public static void main(String[] args) {
		TestArray exec = new TestArray();
		ArrayDirectory ad = new ArrayDirectory();

		// Reads and store the file to an array.
		try {
			// long startTime = System.nanoTime();

			Scanner inFile = new Scanner(
					new FileReader(
							"C:\\Users\\Stella\\Desktop\\university\\CSC 1022\\directory.txt"));
			int i = 0;

			while (inFile.hasNextLine()) {
				Entry entry = new Entry(inFile.nextLine());

				ad.directory[i] = entry;
				i++;
			}
			//long endTime = System.nanoTime();
			//long elapsedTime = 0;
			//System.out.println("Total elapsed time for the insert new method is: "+ ( elapsedTime = elapsedTime + endTime - startTime));
			inFile.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
			ex.printStackTrace();
		}
		// Sorts the array
		exec.sort(ad.directory);		
		
		// Inserts new entries
		ad.insertNew("Bruce W 0130");
		ad.insertNew("Hannibal L 0523");		
		// Delete an entry based on name
		ad.delete("Rogers S", null);
		//Delete an entry based on number
		ad.delete(null, "0623");
		ad.delete("Evans C", null);	
		// Changes the number of an entry	
		ad.changeNum("Kalatha M", "1155");
		// Search for the number of a staff and measure the time it takes to search for a staff		
		
		System.out.println(ad.lookUp("Englezou S"));		
		System.out.println(ad.lookUp("Black S"));		
		
	/*	//measures the time for best case scenario(first element of the array
		long startTime1 = System.nanoTime();
		//System.out.println(ad.lookUp("Bellamy N"));	
		//System.out.println(ad.lookUp("Kalatha M"));
		System.out.println(ad.lookUp("Stark A"));
		long endTime1 = System.nanoTime();				
		long elapsedTime1 = 0;
		System.out.println("Total elapsed time for search method is: "+ ( elapsedTime1 = elapsedTime1 + endTime1 - startTime1));	
		*/
		// Prints the array		 
	ad.printDirectory();

	}

	// Method to sort the array.
	public Entry[] sort(Entry[] sort) {

		int ret = 0;
		int k = 0;
		Entry temp;
		if (sort.length != 0) {
			while (sort[k] != null) {
				k++;
			}
			for (int i = 0; (i < sort.length) && (sort[i] != null); i++) {
				for (int j = k - 1; (j >= 0) && (j != i); j--) {
					ret = sort[i].compareTo(sort[j]);
					if (ret == 1) {
						temp = sort[i];
						sort[i] = sort[j];
						sort[j] = temp;
					}
				}
			}
		}
		return sort;
	}
}
