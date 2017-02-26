import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TestHash {

	public static void main(String[] args) {
		HashDirectory haDi = new HashDirectory();
		// Reads and stores the directory
		try {
			// long startTime = System.nanoTime();
			Scanner inFile = new Scanner(
					new FileReader(
							"C:\\Users\\Stella\\Desktop\\university\\CSC 1022\\directory.txt"));

			while (inFile.hasNextLine()) {
				haDi.insertNew(inFile.nextLine());
			}
			//long endTime = System.nanoTime();
			//long elapsedTime = 0;
			//System.out.println("Total elapsed time for the insert new method is: "+ ( elapsedTime = elapsedTime + endTime - startTime));
			inFile.close();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
			ex.printStackTrace();
		}

		// Insert new entry to the HashMap
		haDi.insertNew("Evans L 0235");
		
		// Delete a staff based on his/her name(Surname and Initial)
		//haDi.delete("Graham W", null);
		// Delete a staff based on his/her number
		haDi.delete(null, "0723");
		// Search for the number of a staff based on his/her name(Surname and
		// Initial)
		
		System.out.println( haDi.lookUp("Englezou S"));
		
		System.out.println(haDi.lookUp("Black S"));
		// Change the number of a staff based on his/her name(Surname and
		// Initial)
		haDi.changeNum("Kalatha M", "5656");
		haDi.changeNum("Luthor L", "8586");
		
		//long startTime1 = System.nanoTime();
		//Measures the time for the best, average, worst case scenario
		System.out.println(haDi.lookUp("Bellamy M"));
		System.out.println(haDi.lookUp("Hannibal L"));
		System.out.println(haDi.lookUp("Stark A"));
		//long endTime1 = System.nanoTime();
		//long elapsedTime1 = 0;
		//System.out.println("Total elapsed time for search method is: "+ ( elapsedTime1 = elapsedTime1 + endTime1 - startTime1));
		// Puts the Hash Map to a tree map		
		haDi.sortMap.putAll(haDi.map);
		haDi.printDirectory();
		
	}

}
