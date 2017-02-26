//Name: Stella Englezou
//Student No:130422246
//Date: 7/11/13

public class MarkCalculator {

	// I created a static method that computes and returns the module marks for
	// each Course
	public static int[] computeMarks(int[] first, int[] second) {
		int k;
		int[] moduleMarks = new int[6];
		// This is the coursework weighting for each module, is stored on array
		// of constants
		int[] courseworkWeight = { 50, 40, 100, 20, 20, 35 };
		System.out
				.println("       Coursework Marks    Exam Marks    Module Marks");
		// I used a for loop and if statement to check if the Coursework and
		// Exam Marks are equal or greater
		// than 35, and if it's true then It computes the module marks,
		// otherwise to make the module marks
		// equal to 34
		for (k = 0; k <= 5; k++) {
			if (((first[k] >= 35) && (second[k] >= 35))) {
				moduleMarks[k] = (int) ((first[k] * courseworkWeight[k]) + (second[k] * (100 - courseworkWeight[k]))) / 100;
			} else {
				moduleMarks[k] = 34;

			}
			// here i used a second if statement inside my for loop to check if
			// the module marks are equal or greater
			// than 34, and the Coursework or exam marks are less than 35, then make
			// to compute the module mark
			
			if ((((first[k] < 35) || (second[k] < 35)) && (moduleMarks[k] >= 34))) {
				moduleMarks[k] =  (int) ((first[k] * courseworkWeight[k]) + (second[k] * (100 - courseworkWeight[k]))) / 100;
			}
			else {
				moduleMarks[k] = (int) ((first[k] * courseworkWeight[k]) + (second[k] * (100 - courseworkWeight[k]))) / 100;

			}
			System.out.print("CSC 102" + (k + 1));
			System.out.print("      " + first[k] + "             " + second[k]
					+ "            " + moduleMarks[k]);
			// i used an if statement to check the module mark and print out if
			// it is a pass, a Compensatable Fail or Fail
			
			if (moduleMarks[k] >= 40)
				System.out.println("         Pass");
			else if ((moduleMarks[k] <= 40) && (moduleMarks[k] >= 35))
				System.out.println("        Compensatable Fail");
			else
				System.out.println("       Fail");

		}
		// it returns the computed Module marks
		return moduleMarks;
	}

	// A method to compute the Stage Result
	public static void computeResult(int[] moduleMarks) {
		int i;
		int[] aver = new int[6];
		int counterPass = 0;
		int counterCompFail = 0;
		int counterFail = 0;
		//With this for loop the average for each module is computed
		//and with the If..else statement I count how many module are Pass, Compensatable Fail, and Fail
		for (i = 0; i <= 5; i++) {
			aver[i] = (moduleMarks[i] / 2);
			if (moduleMarks[i] >= 40)
				counterPass = counterPass + 1;
			else if ((moduleMarks[i] <= 40) && (moduleMarks[i] >= 35))
				counterCompFail = counterCompFail + 1;
			else
				counterFail = counterFail + 1;
		}
		//Using the results from the If..else statement, I use another If..else statement to determinate
		//if the Student Passed, Passed by Compensation or Failed
		if (counterPass == 6)
			System.out.println("Stage Result:" + "   Pass");
		else if ((counterFail == 0) && (counterCompFail <= 2))
			System.out.println("Stage Result:" +"    Pass By Compensation");
		else
			System.out.println("Stage Result:" +"   Fail");

	}

}
