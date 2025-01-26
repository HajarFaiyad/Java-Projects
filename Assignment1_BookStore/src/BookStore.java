//In this project I use try and catch blocks to check if my codes are running properly or not 
// and to avoid crashing

import java.awt.event.ActionEvent;//for use of actionPerformer()
import java.awt.event.ActionListener;//for implementing actionListiner

   // we import javax.swing. ... to be able to access all the properties of that class
import javax.swing.ButtonGroup;//importing this for the ButtonGroup 
import javax.swing.JButton;//importing this for the JButton
import javax.swing.JComboBox;//importing this for the JComboBox
import javax.swing.JFrame; //importing the JFrame class to be able to extend it and use it's features
import javax.swing.JLabel;//importing this for the JLabel
import javax.swing.JOptionPane;//importing this for the JOptionPane
import javax.swing.JPanel;//importing this for the JPanel
import javax.swing.JRadioButton;//importing this for the JRadioButtons
import javax.swing.JTextField;//importing this for the JTextField

//Our class is called BookStore
//it extends the JFrame class
//and implements action listener  

public class BookStore extends JFrame implements ActionListener{

	//creating parameters
	private JLabel lblGenre, lblAmount;// initializing labels to guide the user and name the genre and amount
	private JTextField txtAmount;// initializing text field that will take the amount of books
	private JComboBox<?> comboGenre;// initializing the ComboBox that will contain the genre options
	private JRadioButton rdGold, rdSilver, rdNone;// initializing radio buttons for membership types
	private JPanel pnlRadioButtons;// initializing a panel that will contain all the radio buttons
	private ButtonGroup grpMembership;// to choose only one option for membership from radioButtons
	private JButton btnAdd, btnBuy;// initializing buttons
	
	
	//The public bookStore constructor 
	public BookStore() {
		
		//Formating all the GUI Items as instructed
		lblGenre = new JLabel("Genre: ");//initializing the lblGenre and assigning its text to "Genre:"
		lblGenre.setBounds(20, 10, 100, 40);//using setBoundsinstead of setSize and setLocation to minimize the project lines
		
		lblAmount = new JLabel("Amount: ");//initializing  the lblAmount and assigning its text to "Amount:"
		lblAmount.setBounds(200, 10, 100, 40);//setting location and size for the label amount
		
		//comboBox formating starts here
		//making a string array that contains all the options for the combo box
		String [] genre = {"Science [10p]", "History [15]", "Drama [5p]", "Romance [7p]", "Action [13p]"}; 
		
		comboGenre = new JComboBox<>(genre);//initializing the combo box and assigning its items/objects as the existing genre list
		comboGenre.setBounds(20, 60, 120, 50);//setting location and size for the combo box
		//comboBox formating ends here
		
		txtAmount = new JTextField();//initializing the txtAmount and leaving it as blank
		txtAmount.setBounds(200, 60, 100, 50);//setting location and size for the text field amount
		
		//radio buttons formating starts here
		//initializing the radio buttons
		rdGold = new JRadioButton("Golden Member");
		rdSilver = new JRadioButton("Silver Member");
		rdNone = new JRadioButton("Non-Member");
		
		
		//initializing the JPanel for the radio buttons
		pnlRadioButtons = new JPanel();
				
		
		//adding the radio buttons to the panel
		pnlRadioButtons.add(rdGold);
		pnlRadioButtons.add(rdSilver);
		pnlRadioButtons.add(rdNone);
		
		//setting the bounds for the panel radio buttons
		pnlRadioButtons.setBounds(10, 200, 400, 50);
		
		//making the radio group to choose only one option
		grpMembership = new ButtonGroup();
		grpMembership.add(rdGold);
		grpMembership.add(rdSilver);
		grpMembership.add(rdNone);
		
		// setting the default option for the membership as non-member
		rdNone.setSelected(true);
		//radio buttons formating ends here
		
		
		//initializing the buttons
		btnAdd = new JButton("Add");//initializing the btnAdd and setting its text as "Add"
		btnAdd.setBounds(400, 60, 100, 30);//setting location and size for the button Add
		
		btnBuy = new JButton("Buy");//initializing the btnBuy and setting its text as "Buy"
		btnBuy.setBounds(400, 130, 100, 30);//setting location and size for the button Buy
		
		//adding the labels to-the-GUI/to-the-frame
		add(lblGenre);
		add(lblAmount);
		//adding the combo box to-the-GUI/to-the-frame
		add(comboGenre);
		//adding the text field to-the-GUI/to-the-frame
		add(txtAmount);
		//adding the radio buttons panel to-the-GUI/to-the-frame
		add(pnlRadioButtons);
		//adding the buttons to-the-GUI/to-the-frame
		add(btnAdd);
		add(btnBuy);
		
		//register the buttons to handle action
		btnAdd.addActionListener(this);
		btnBuy.addActionListener(this);
		
		
		//Layout Type
		setLayout(null);//setting the layout as null layout for this project
		
		//Setting the GUI window frame features
		setSize(550, 350);//The window's dimensions 
		setTitle("Book Store");//setting a title for the GUI
		setVisible(true);//setting the visibility of the window as true to be able to view t when run
		setResizable(true);// setting the JFrame window as resizable as true
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setting this operation to terminate/exit the program upon closing
		
	}//end of constructor
	
	//Variables that help us calculate the order's price
	double TotalPayment ;// totalPayment for all books/all order
	                     // totalPayment adds to the price with each click of the add button
	
	double TotalPaymentFinal;// for the final totalPayment
	                         // saves/holds/stores the final total price of the order
	                         // mainly used to avoid confusion
	
	double TotalPaymentDiscount;// for the final totalPayment of the basket
	                            // calculates the discount(if chosen) on the whole order/basket
	
	// Helper method for the add button:-
	//    a method called basket that keeps track of the basket's total price without discount
	public void basket() {
	
		//total prices of individual genres
		int sciencePrice = 0;// for romance
		int historyPrice = 0;// for history
		int dramaPrice = 0;// for drama
		int romancePrice = 0;// for romance
		int actionPrice = 0;// for action
		
		int bookAmount = 0;// bookAmount for the item amount initially is zero
		
		try {
			bookAmount = Integer.parseInt(txtAmount.getText().trim());//to check if the input is integer

		//condition to check if the txtAmount is empty
		// if it is empty then a warning message will pop up
		//if it is not empty it will go to the else part and execute the code within it
		if(txtAmount.getText().isEmpty()) {
			//if empty a message dialog will pop up 
			JOptionPane.showMessageDialog(this, "Please enter an amount", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		else {
			try {
				bookAmount = Integer.parseInt(txtAmount.getText().trim());//to get the number of books we need to convert the txtfield's input to integer
			
			
				//conditions for each genre selected and to calculate the amount of each genre separately
				// for selected genre is science books
				if(comboGenre.getSelectedItem().toString().contentEquals("Science [10p]")) {
					sciencePrice = 10 * bookAmount;//multiply the price/item with the total amount of item
				}
				// for selected genre is history books
				if(comboGenre.getSelectedItem().toString().contentEquals("History [15]")) {
					historyPrice = 15 * bookAmount;//multiply the price/item with the total amount of item
				}
				// for selected genre is drama books
				if(comboGenre.getSelectedItem().toString().contentEquals("Drama [5p]")) {
					dramaPrice = 5 * bookAmount;//multiply the price/item with the total amount of item
				}
				// for selected genre is romance books
				if(comboGenre.getSelectedItem().toString().contentEquals("Romance [7p]")) {
					romancePrice = 7 * bookAmount;//multiply the price/item with the total amount of item
				}
				// for selected genre is action books
				if(comboGenre.getSelectedItem().toString().contentEquals("Action [13p]")) {
					actionPrice = 13 * bookAmount;//multiply the price/item with the total amount of item
				}
				
				//making the total payment = to the sum of all the the book added 
				TotalPayment = TotalPayment + sciencePrice + historyPrice + dramaPrice + romancePrice + actionPrice;
				TotalPaymentFinal = TotalPayment;//for later use
			
				//System.out.println("Total payment without discount: " + TotalPaymentFinal);// for myself; used to check if it calculates correctly
	
				}//end of try
				catch (NumberFormatException e) {
					// TODO: handle exception
					System.err.println("Error in the basket ");// for myself to check if there is an error
				}//end of catch
			}// end of else for the if that checks that the amount is not null	
		}//end of try
		catch (NumberFormatException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Input Integer data", "Number format", JOptionPane.ERROR_MESSAGE);
		}
		}//end of basket method 
	
	// Helper method for the buy button:- 
	//   a method called bsketDiscount that calculates the discount on the whole basket 
	public void basketDiscount() {
		
		try {
			// condition to apply the membership discount
			//for golden member
			if(rdGold.isSelected()) {
				TotalPaymentDiscount = TotalPaymentFinal * 0.85;//15% discount
			}
			//for silver member
			else if (rdSilver.isSelected()) {
				TotalPaymentDiscount = TotalPaymentFinal * 0.90;//10% discount
			}
			//for non member
			else {
				TotalPaymentDiscount = TotalPaymentFinal;//no discount
			}
			
			//System.out.println("Total payment with discount: " + TotalPaymentDiscount);// for myself; used to check if it calculates correctly
			}//end of try
			catch (NumberFormatException e) {
				// TODO: handle exception
				System.err.println("Error in the basketDiscount");// for myself to check if there is an error
			}//end of catch
	}//end of basketDiscount method
	
	// initializing variables that will hold the mount for each genre of book with initial amount 0
			int sciAmount = 0;// for science books
			int hisAmount = 0;// for history books
			int draAmount = 0;// for drama books
			int romAmount = 0;// for romance books
			int actAmount = 0;// for action books
	
	
	// Helper method for the Add button:- 
	//	 a method called baskeItems that keeps track of the basket's items and amounts
	public void basketItems() {
		//In this method I intentionally wrote a code that updates the amount of a genre more than once
		//Example: if the user entered the amount of science books as 2
        //         then is s/he rewrote another amount for science, let's say 3,
		//         then the final amount of the science books will be 5.
		
		
		//if the txtAmount field is not empty this method will execute its content/code
		// and if it is empty then it will not do anything
		try{
			int Amount = Integer.parseInt(txtAmount.getText().trim());//to check if the input is integer
		if(!txtAmount.getText().isEmpty()) {
			try {
				// integer Amount that takes the amount of books the user entered
				 Amount = Integer.parseInt(txtAmount.getText().trim());//to get the number of books we need to convert the txtfield's input to integer

				//condition for each genre selected that counts the amounts of items entered 
				if(comboGenre.getSelectedItem().toString().contentEquals("Science [10p]")) {
					sciAmount = sciAmount + Amount;
				}
				// for history books
				if(comboGenre.getSelectedItem().toString().contentEquals("History [15]")) {
					hisAmount = hisAmount + Amount;
				}
				// for drama books
				if(comboGenre.getSelectedItem().toString().contentEquals("Drama [5p]")) {
					draAmount = draAmount + Amount;
				}
				// for romance books
				if(comboGenre.getSelectedItem().toString().contentEquals("Romance [7p]")) {
					romAmount = romAmount + Amount;
				}
				// for action books
				if(comboGenre.getSelectedItem().toString().contentEquals("Action [13p]")) {
					actAmount = actAmount + Amount;
				}
				
				//System.out.println(...) is for myself to check if they are correct
				//System.out.println("Sci.: " + sciAmount + "  His.: " + hisAmount + "  Dra.: " + draAmount + "  Rom.: "+ romAmount + "  Act.: " + actAmount);
			}//end of try
			catch (NumberFormatException e) {
				// TODO: handle exception
				System.err.println("Error at the basketItems method");// for myself to check if there is an error
			}
		}// end of if condition
		}//end of try
		catch (NumberFormatException e) {
			// TODO: handle exception
			//System.err.println("input is not integer");// for myself
		}
	}//end of basketItems method
	
	
	// Helper Method for the Buy button:-
	//    a method called newFrame that creates a new frame containing the order's info
	public void newFrame() {
		JFrame orderInfo = new JFrame("Order Information");//making a new frame with title "Order information"
		
		orderInfo.setLayout(null);//layout of the new JFrame
		
		orderInfo.setSize(400, 400);//size of frame
		orderInfo.setResizable(true);//the frame is resizable
		orderInfo.setVisible(true);// the frame is visible
		orderInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//when close is pressed the project is terminated
		
		JLabel lblorderInformation = new JLabel();// creating a label that will hold the order's information
		
		
		lblorderInformation.setBounds(25, 0, 350, 350);//setting the bounds of the label
		
		//here I use HTML code to achieve LineBreaks in the JLabel
		//I use <html></html> to surround my whole text in the label
		// and <br/> to break the line and start in a new line
		lblorderInformation.setText("<html>Your order information:- <br/><br/>" 
																+ " Science: " + sciAmount + " Books. " +  " ---Price per item: 10p   --> " + 10*sciAmount + "p total <br/>" 
																+ " History:    " + hisAmount + " Books. " + " ---Price per item: 15p   --> " + 15*hisAmount + "p total <br/>" 
																+ " Drama:      " + draAmount + " Books. " + "  ---Price per item: 5p    --> " + 5*draAmount + "p total <br/>" 
																+ " Romance:     " + romAmount + " Books. " + "  ---Price per item: 7p   --> " + 7*romAmount + "p total <br/>" 
																+ " Action:     " + actAmount + " Books. " + "  ---Price per item: 13p   --> " + 13*actAmount + "p total <br/><br/>" 
																+ "Order's price without dicount: " + TotalPaymentFinal + "p" + "<br/>" 
																+ "Order's price after dicount: " + TotalPaymentDiscount + "p" + "<br/><br/>"
																+ "Your bill:  " + TotalPaymentDiscount + "p" + "</html>");
		
		
		orderInfo.add(lblorderInformation);//adding the label to the frame
		
	}//end of newFrame method
	
	//The actionPreformed method for the action listener 
	//this method checks which button is clicked thus which helper method is going to execute
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(btnAdd)) {//when the button Add is clicked
			basket();//execute/run the basket function/method
			basketItems();//execute/run the basketItems function/method
		}
		else if (e.getSource().equals(btnBuy)) {//when the button Buy is clicked
			basketDiscount();//execute/run the basketDiscount function/method
			newFrame();//execute/run the newFrame function/method
		}
		
	}//end of actionPreformed method
	
	// The Main Method To Run/Execute The Project
	public static void main(String[] args) {
		new BookStore();//calling the class
	}//end of main method

}// end of BookStore1 class

