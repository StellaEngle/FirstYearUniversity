//Name: Stella Englezou
//Student No:130422246
//Date: 7/11/13


public class StudentChart {
	//this the array where i will store the module marks from the computeMarks method
	//to use for the creation of my Bar chart
	int[] marks1 = new int[6];
	
	//This is my constructor with one parameter 
	public StudentChart(int[] moduleMarks1) {
		marks1 = moduleMarks1;

	}
	
	//This is the draw method. It draws thin Bars based of the values in the array
	public void draw() {
		// widthSize defines the width of each bar
		int widthSize = 20;
		//I created the x and y bars, as the x-axis and y-axis of the bar
		Bar x = new Bar();
		Bar y = new Bar();
		//I change their size and made them visible
		x.changeSize(200, 1);
		x.moveVertical(100);
		x.makeVisible();
		y.changeSize(1, 100);
		y.makeVisible();
		//I created 6 other bars, each one for the 6 Module Marks
		Bar b1 = new Bar();
		Bar b2 = new Bar();
		Bar b3 = new Bar();
		Bar b4 = new Bar();
		Bar b5 = new Bar();
		Bar b6 = new Bar();
		
		// Below I changed their sizes, I moved them Vertical and Horizontal and made them visible
		//And using an if..else statement to changed the colour of each bar, based on the Module Marks
		//if the Module Marks are equal or greater than 70 then the bar should be coloured magenta
		//else if the Module Marks are equal or greater than 40 and less than 70 , the bar should be coloured Green
		//else if the module marks are equal or greater than 35 and less than 40, the bar should be coloured Yellow
		//otherwise it should be coloured Red

		b1.changeSize(widthSize, marks1[0]);
		b1.moveHorizontal(20);
		b1.moveVertical(100 - marks1[0]);
		if (marks1[0] >= 70)
			b1.changeColour(Colour.MAGENTA);
		else if ((marks1[0] >= 40) && (marks1[0] < 70))
			b1.changeColour(Colour.GREEN);
		else if ((marks1[0] < 40) && (marks1[0] >= 35))
			b1.changeColour(Colour.YELLOW);
		else
			b1.changeColour(Colour.RED);
		b1.makeVisible();

		b2.changeSize(widthSize, marks1[1]);
		b2.moveHorizontal(60);
		b2.moveVertical(100 - marks1[1]);
		if (marks1[1] >= 70)
			b2.changeColour(Colour.MAGENTA);
		else if ((marks1[1] >= 40) && marks1[1] < 70)
			b2.changeColour(Colour.GREEN);
		else if ((marks1[1] < 40) && (marks1[1] >= 35))
			b2.changeColour(Colour.YELLOW);
		else
			b2.changeColour(Colour.RED);
		b2.makeVisible();

		b3.changeSize(widthSize, marks1[2]);
		b3.moveHorizontal(90);
		b3.moveVertical(100 - marks1[2]);

		if (marks1[2] >= 70)
			b3.changeColour(Colour.MAGENTA);
		else if ((marks1[2] >= 40) && marks1[2] < 70)
			b3.changeColour(Colour.GREEN);
		else if ((marks1[1] < 40) && (marks1[1] >= 35))
			b3.changeColour(Colour.YELLOW);
		else
			b3.changeColour(Colour.RED);
		b3.makeVisible();

		b4.changeSize(widthSize, marks1[3]);
		b4.moveHorizontal(120);
		b4.moveVertical(100 - marks1[3]);
		if (marks1[3] >= 70)
			b4.changeColour(Colour.MAGENTA);
		else if ((marks1[3] >= 40) && marks1[3] < 70)
			b4.changeColour(Colour.GREEN);
		else if ((marks1[3] < 40) && (marks1[3] >= 35))
			b4.changeColour(Colour.YELLOW);
		else
			b4.changeColour(Colour.RED);
		b4.makeVisible();

		b5.changeSize(widthSize, marks1[4]);
		b5.moveHorizontal(150);
		b5.moveVertical(100 - marks1[4]);
		if (marks1[4] >= 70)
			b5.changeColour(Colour.MAGENTA);
		else if ((marks1[4] >= 40) && marks1[4] < 70)
			b5.changeColour(Colour.GREEN);
		else if ((marks1[4] < 40) && (marks1[4] >= 35))
			b5.changeColour(Colour.YELLOW);
		else
			b5.changeColour(Colour.RED);
		b5.makeVisible();

		b6.changeSize(widthSize, marks1[5]);
		b6.moveHorizontal(180);
		b6.moveVertical(100 - marks1[5]);
		if (marks1[5] >= 70)
			b6.changeColour(Colour.MAGENTA);
		else if ((marks1[5] >= 40) && marks1[5] < 70)
			b6.changeColour(Colour.GREEN);
		else if ((marks1[5] < 40) && (marks1[5] >= 35))
			b6.changeColour(Colour.YELLOW);
		else
			b6.changeColour(Colour.RED);
		b6.makeVisible();

	}
	
	//This method neatly prints a table of the module marks corresponding to my chart
	public void printSummary() {
		System.out.println();
		System.out.println("      Module Marks based on the Chart");
		int k;
		for (k = 0; k <= 5; k++) {
			System.out.print("CSC 102" + (k + 1));
			System.out.println("  " + marks1[k]);

		}

	}
}
