//Name: Stella Englezou
//Student No:130422246
//Date: 7/11/13
import java.util.Scanner;


public class Summary {
	
	
	public static void main(String[] args) {
		studentSummary();
		


	}

	public static void studentSummary() {
	      //With the use of a scanner I input the Coursework Marks and Exam Marks
			@SuppressWarnings("resource")
			Scanner key = new Scanner(System.in);
			//I created two arrays to store the Marks
			int[] coursework = new int[6];
			int[] examMarks = new int[6];
			int i;
			//I use a For Loop to ask for the Coursework and Exam Marks
			for (i = 0; i <= 5; i++) {
				System.out.println("Give Coursework Mark for CSC 102" + (i + 1)
						+ " and press Enter");
				coursework[i] = key.nextInt();
				//Checks if the value is less than 0 or greater than 100 and if it's true
				//It asks the user to give the value again
				if((coursework[i]<0) ||(coursework[i]>100)){
					System.out.println("Only integer values from 0 to 100. Give again:");
					coursework[i] = key.nextInt();
				}
				System.out.println("Give Exam Mark for CSC 102" + (i + 1)
						+ " and press Enter");
				examMarks[i] = key.nextInt();
				//Checks if the value is less than 0 or greater than 100 and if it's true
				//It asks the user to give the value again
				if ((examMarks[i]<0)|| (examMarks[i]>100)){
					System.out.println("Only integer values from 0 to 100. Give again:");
					examMarks[i]=key.nextInt();
				}

			}
			//Here I called the methods from each class
			int[] j = MarkCalculator.computeMarks(coursework, examMarks);
			
			MarkCalculator.computeResult(j);
			StudentChart object1 = new StudentChart(j);
			StudentChart object2 = new StudentChart(j);
			object1.draw();
			object2.printSummary();
	}

}
