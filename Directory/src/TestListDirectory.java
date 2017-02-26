//Name:Stella Englezou
//Number:130422246
//Date:19/04/2014
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class TestListDirectory {
	public TestListDirectory(){
		
	}
	
	public static void main(String[] args) {		
		ListDirectory ad= new ListDirectory();	
		
		//Reads and adds the file to a linkedList
	try {	
		//long startTime = System.nanoTime();
		Scanner inFile = new Scanner(
				new FileReader(
						"C:\\Users\\Stella\\Desktop\\university\\CSC 1022\\directory.txt"));	
		while (inFile.hasNextLine()) {					
			ad.insertNew(inFile.nextLine());	
		}
		//long endTime = System.nanoTime();
		//long elapsedTime = 0;
		//System.out.println("Total elapsed time for the insert new method is: "+ ( elapsedTime = elapsedTime + endTime - startTime));		
		inFile.close();
	} catch (FileNotFoundException ex) {
		System.out.println("File not found");
		ex.printStackTrace();
	}
	
	//System.out.println(ad.size);
	//Search for the number of a staff given his name(Surname and Initial)
	System.out.println( ad.lookUp("Englezou S"));
	
	System.out.println( ad.lookUp("Hannibal L"));
	
	//Add a new staff to the LinkedList
	ad.insertNew("Lee B 0253");
	//Search for the number of the new staff given his name(Surname and Initial)
	System.out.println("Number of the person you are searching is: "  + ad.lookUp("Lee B"));
	//Change the number of a staff given his name
	ad.changeNum("Englezou S", "1111");
	ad.changeNum("Stark A", "6963");
	//Delete a staff by his name(Surname and Initial) 	
	ad.delete("Hannibal L", null);
	ad.delete("Englezou S", null);
	//Delete a stuff by his number
	ad.delete(null, "0223");
	ad.delete("Black S", null);
	System.out.println(ad.lookUp("Evans C"));	
	
	//Search for the number of the new staff given his name(Surname and Initial)
	//long startTime1 = System.nanoTime();
	//Measures the time for the best, average, worst case scenario
	System.out.println(ad.lookUp("Ppalli S"));
	System.out.println(ad.lookUp("Stark A"));
	System.out.println(ad.lookUp("Graham W"));
	//long endTime1 = System.nanoTime();
	//long elapsedTime1 = 0;
	//System.out.println("Total elapsed time for search method is: "+ ( elapsedTime1 = elapsedTime1 + endTime1 - startTime1));
	//Prints the LinkedList
	ad.printDirectory();
	
	
	}

}
