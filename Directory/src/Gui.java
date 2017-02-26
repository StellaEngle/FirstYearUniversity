//Name: Stella Englezou
//Student Number: 130422246
//Date: 19/04/2014
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextField txtAdd;
	private JTextField textDeleteName;
	private JTextField textChangeName;
	private JTextField textNewNumber;
	private JTextField textDeleteNum;
	private JTextField textDeleteNumber;

	
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTest1 frame = new GuiTest1();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
				}
		});
		
	}

	//Constructor of the class creates the graphical user interface
	public Gui() {
		final HashDirectory haDi= new HashDirectory();
		setTitle("Directory");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Button to import the file
		JButton btnImport = new JButton("Import File");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Scanner inFile = new Scanner(
							new FileReader(
									"C:\\Users\\Stella\\Desktop\\university\\CSC 1022\\directory.txt"));					

					while (inFile.hasNextLine()) {
						
						haDi.insertNew(inFile.nextLine());
					}
					
				
					
					inFile.close();
				} catch (FileNotFoundException ex) {
					System.out.println("File not found");
					ex.printStackTrace();
			}
				haDi.sortMap.putAll(haDi.map);
				}
		});
		
		
		btnImport.setBounds(60, 43, 129, 23);
		contentPane.add(btnImport);
		
		//Text field to enter the number of staff given his/her name(surname and initial)
		//and use it for the search button
		txtSearch = new JTextField();
		txtSearch.setText("");
		txtSearch.setBounds(159, 149, 154, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		//Text field to enter the information about a new staff
		//and use it for the add button
		txtAdd = new JTextField();
		txtAdd.setText("");		
		txtAdd.setBounds(159, 95, 186, 20);
		contentPane.add(txtAdd);
		txtAdd.setColumns(10);
		
		//Text field to enter the name(surname and initial) of a staff
		//and use it for the delete button
		textDeleteName = new JTextField();
		textDeleteName.setText("");
		textDeleteName.setToolTipText("Insert name");
		textDeleteName.setBounds(159, 199, 107, 20);
		contentPane.add(textDeleteName);
		textDeleteName.setColumns(10);	
		
		//Text field to enter the number of a staff
		//and use it for the delete button
		textDeleteNumber = new JTextField();
		textDeleteNumber.setText("");
		textDeleteNumber.setToolTipText("Insert number");
		textDeleteNumber.setBounds(287, 199, 102, 20);
		contentPane.add(textDeleteNumber);
		textDeleteNumber.setColumns(10);
		
		//Text field to enter the name(surname and initial) of a staff
		//and use it for the change button
		textChangeName = new JTextField();
		textChangeName.setText("");
		textChangeName.setBounds(199, 249, 134, 20);
		contentPane.add(textChangeName);
		textChangeName.setColumns(10);
		
		//Text field to enter a new number of a staff
		//and use it for the change button
		textNewNumber = new JTextField();
		textNewNumber.setText("");
		textNewNumber.setBounds(343, 249, 122, 20);
		contentPane.add(textNewNumber);
		textNewNumber.setColumns(10);
		
		//A text area where the number of a particular staff would be printed
		final JTextArea textSearch = new JTextArea();
		textSearch.setEditable(false);
		textSearch.setBounds(332, 146, 174, 23);
		contentPane.add(textSearch);
		
		//Search button. Calls the lookup method of the HashDirectory
		//when you click on it.
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name =txtSearch.getText();
				if(!name.equals("")){
				String num=haDi.lookUp(name);
				//Sets the text in textSearch with the value that the lookup method returns
				textSearch.setText(num);
				}
				
			}
		});
		btnSearch.setBounds(60, 148, 89, 23);
		contentPane.add(btnSearch);
		
		//A text area where the directory would be printed
		//It has a scroll pane in case the user needs to scroll down 
		//to see all the staff
		final JTextArea textPrint = new JTextArea();
		textPrint.setEditable(false);
		textPrint.setTabSize(15);
		JScrollPane scroll = new JScrollPane ( textPrint );
		scroll.setSize(174, 118);
		scroll.setLocation(159, 304);
	    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );	    
	    contentPane.add(scroll);
		textPrint.setWrapStyleWord(true);
		textPrint.setLineWrap(true);
		textPrint.setBounds(159, 294, 303, 127);
		
		
		//Add button. Calls the insertNew method inside the HashDirectory Class,
		//when you click on it. It add a new staff to the directory.
		JButton btnAdd = new JButton("Add ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txtAdd.getText();
				//checks if the text field has a value
				if(!name.equals("")){
				haDi.insertNew(name);
				}
				/*Clears the text field after adding the entry*/
				txtAdd.setText("");
			}
		});
		btnAdd.setBounds(60, 94, 89, 23);
		contentPane.add(btnAdd);
		
		//A label to guide the user
		JLabel lblNewLabel = new JLabel("Enter name.");
		lblNewLabel.setBounds(159, 136, 89, 14);
		contentPane.add(lblNewLabel);		
		
		//A label to guide the user
		JLabel lblNewLabel_1 = new JLabel("Enter the name and number.");
		lblNewLabel_1.setBounds(159, 77, 200, 17);
		contentPane.add(lblNewLabel_1);
		
		//Delete Button. It calls the delete method inside the HashDirectory class,
		//when you click on it. It delete the information about a staff, given his/her name or number
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			String name= textDeleteName.getText();
			String number= textDeleteNumber.getText();	
			//checks if the text fields have a value
				if(!name.equals("")){
				haDi.delete(name, null);
				}
				else if(!number.equals("")){
					haDi.delete(null, number);
				}
				/*Clears the text fields after deleting the entry*/
				textDeleteName.setText("");
				textDeleteNumber.setText("");
			}
	
		});
		btnDelete.setBounds(60, 198, 89, 23);
		contentPane.add(btnDelete);
		
		//A label to guide the user
		JLabel lblGiveTheName = new JLabel("Enter name.");
		lblGiveTheName.setBounds(159, 180, 73, 23);
		contentPane.add(lblGiveTheName);
		
		
		//A label
		JLabel lblDirectory = new JLabel("Directory");
		lblDirectory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDirectory.setBounds(205, 11, 154, 14);
		contentPane.add(lblDirectory);
		
		//The change button.
		JButton btnChangeNumber = new JButton("Change number");		
		btnChangeNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name= textChangeName.getText();
				String newNumber= textNewNumber.getText();
				if(!name.equals("") && !newNumber.equals("")){
					haDi.changeNum(name, newNumber);
				}
				/*Clears the text fields after it changed the number*/
				textChangeName.setText("");
				textNewNumber.setText("");
			}
		});
		btnChangeNumber.setBounds(60, 246, 129, 23);
		contentPane.add(btnChangeNumber);
		
		
		//A label to guide the user
		JLabel lblGiveTheName_1 = new JLabel("Give the name.");
		lblGiveTheName_1.setBounds(199, 229, 83, 20);
		contentPane.add(lblGiveTheName_1);
		//A label to guide the user
		JLabel lblNewLabel_2 = new JLabel("Give the new number.");
		lblNewLabel_2.setBounds(343, 229, 122, 20);
		contentPane.add(lblNewLabel_2);
		
		//Print button. It prints the directory when you click on it
		JButton printButton = new JButton("Print All");
		printButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				//String text=textPrint.getText();				
					textPrint.setText("");					
					haDi.sortMap.putAll(haDi.map);						
				textPrint.setText("  " + haDi.sortMap.entrySet().toString()+ "  ");	
					
				
				}
				
		});		
		printButton.setBounds(60, 295, 89, 23);
		contentPane.add(printButton);
		
		//A label to guide the user
		JLabel lblTheNumberIs = new JLabel("The number is:");
		lblTheNumberIs.setBounds(332, 134, 108, 10);
		contentPane.add(lblTheNumberIs);		
		
		//A label to guide the user
		JLabel lblEnterNumber = new JLabel("Enter number.");
		lblEnterNumber.setBounds(287, 182, 86, 20);
		contentPane.add(lblEnterNumber);
		
		//Clear button. Clears the textPrint 
		JButton btnClear = new JButton("Clear");
		btnClear.setToolTipText("");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPrint.setText("");
			}
		});
		btnClear.setBounds(60, 319, 89, 23);
		contentPane.add(btnClear);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
