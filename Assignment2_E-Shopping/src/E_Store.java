
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class E_Store extends JFrame implements ActionListener{

	private JLabel lblItems, lblAgents, lblDuration;
	private JTextField txtItems, txtAgents, txtDuration ;
	private JButton btnCreate, btnGood;
	private JPanel pnlItems;
	
	private int numOfItems, numOfAgents, duration, myAgentReservedItems, myAgentTotalReservedItems, confirmOrder , stockUpdate;
	private Items item;
	private ArrayList<Customer> listOfCustomers;
	private String nameOfItem, buyMessage;
	
	//lblItems, lblAgents, lblDuration: are just to guide the user through the GUI Text Fields
	//txtItems: for the number of items to be created
	//txtAgents: for the number of agents/customer allowed to purchase an item at the same time
	//txtDuration; for the waiting time for each agent to hold the items
	//btnCreate: to create number of items and display them on the frame
	//btnGood: an add to cart button that handles the number of items a customer holds and the remaining number of items
	//pnlItems: to facilitate the display of the created items
	
	//numberOfItems: will store the given number from the txtItems to be created
	//numberOfAgents: will store the given number from the txtAgents to be generated
	//duration: will store the given number from the txtDuration 
	//maxAgents: an arbitrary maximum number of agents/customers that can purchase the items at the same time
	//item: an Item class instance which is shared between agents/customer
	//listOfCustomers: to be able to track the number of agents/customer created
	//nameOfItem: represents the type/name of the item to be created.
	
	//default constructor for the e_store class
	public E_Store() {
		// TODO Auto-generated constructor stub
		
		init();//calling the init() function
	}
	
	//helper function that holds the frame features
	public void init() {
		
		//Frame components 
		lblItems = new JLabel("Number of items:");
		lblItems.setBounds(10, 100, 100, 25);
		
		txtItems = new JTextField();
		txtItems.setBounds(10, 135, 100, 25);
		
		lblAgents = new JLabel("Number of Agents:");
		lblAgents.setBounds(10, 170, 105, 25);

		txtAgents = new JTextField();
		txtAgents.setBounds(10, 205, 100, 25);
		
		lblDuration = new JLabel("Waiting Time:");
		lblDuration.setBounds(10, 240, 100, 25);
	
		txtDuration = new JTextField();
		txtDuration.setBounds(10, 275, 100, 25);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(10, 330, 100, 25);
		
		btnGood = new JButton("Goods");
		btnGood.setBounds(10, 365, 100, 25);
		
		//Adding Components to the frame
		add(lblItems);
		add(txtItems);
		add(lblAgents);
		add(txtAgents);
		add(lblDuration);
		add(txtDuration);
		add(btnCreate);
		add(btnGood);
		
		//adding action listeners to the buttons to be able to operate
		btnCreate.addActionListener(this);
		btnGood.addActionListener(this);
		
		//Setting the GUI frame features
		setLayout(null);
		setSize(1000, 700);//The window's dimensions 
		setTitle("E-Store");//setting a title for the GUI
		setVisible(true);//setting the visibility of the window as true to be able to view t when run
		setResizable(true);// setting the JFrame window as resizable as true
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setting this operation to terminate/exit the program upon closing
	
	}
	
	//to test the class
	public static void main(String[] args) {
		new E_Store();
	}

	
	
	
	//action performer method that operates when the buttons are clicked and is the starting point of all the other methods 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//if conditions to check which button is clicked
		//if the create button is clicked 
		if(e.getSource().equals(btnCreate)) {
			//if condition to check if the user didn't enter a required input
			if(txtAgents.getText().isEmpty() || txtItems.getText().isEmpty() || txtDuration.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please fill the text fields");
			}
			else {
				//if items were created before; the panel of items will not be empty we return
				//so if items are created we can not re create items again
				if(pnlItems != null) {
					return;
				}
					
				//assigning the entered values in the text fields to the corresponding variables
				numOfAgents = Integer.parseInt(txtAgents.getText().trim());
				numOfItems = Integer.parseInt(txtItems.getText().trim());
				duration = Integer.parseInt(txtDuration.getText().trim());
				
				
				//creating the panel that holds the new items
				pnlItems = new JPanel();
				pnlItems.setLayout(new GridLayout(6, 2, 2, 2));// vertical and horizontal gaps between the items in the layout are 2
				pnlItems.setBounds(130, 20, 845, 630);
				
				//setting the name of item as a constant for now
				nameOfItem = "Pens";
				
				//creating new item with a number of items as the parameter
				item = new Items(numOfItems, nameOfItem);
				
				//adding item buttons to the panel by using the button List from the Item class
				//as long as there are still items in the btnItemList from the Items class the loop keeps looping and buttons are added to the panel
				for(int i = 0; i < item.getBtnItemList().size(); i++ ) {
					//here i represents the index of the items in the btnItemList array
					pnlItems.add(item.getBtnItemList().get(i));
				}
				
				//adding the pnlItems to the GUI frame
				add(pnlItems);
				
				validate();
				repaint();
			}	
		}
		//if the Good button is clicked
		else if(e.getSource().equals(btnGood)) { 
			
			//if condition to check if the user didn't enter a required input
			if(txtAgents.getText().isEmpty() || txtItems.getText().isEmpty() || txtDuration.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please fill the text fields, and click the create button first");
			}
			else {
				//create a new list of agents/customers
				listOfCustomers= new ArrayList<Customer>();
				
				//setting a default value for the maximum number of agents which are able to reserve an item at the same time
				// if the numOfAgents is less than or equals to the maximum number of agents allowed
				if(numOfAgents <= 5) {
					//adding i number of agents/customers to the listOfCustomers
					//the number of agents/customers equals to the numOfAgents which is taken from the txtAgents
					for (int i = 0; i < numOfAgents; i++) {
						listOfCustomers.add(new Customer(item, duration, i));
						listOfCustomers.get(i).start();// to start the newly created thread
						
								
						//System.out.println(listOfCustomers.get(i).getName()); // for myself to check which agent/customer is active
						//System.out.println("Items reserved: " + myAgentReservedItems );// for myself to check the amount of reserved items for this agent
																//myAgentReservedItems gives zero because it is later assigned a value in the program
					}
					
					//a thread that waits until all items are reserved and then shows a message asking it the agent/customer wants to buy
					//here i made use of lambda expression to facilitate the code a bit
					Thread buyThread = new Thread(()-> { 
						while (item.isReservable()) {
							try {
								Thread.sleep(300);// the read will sleep for 300 milliseconds
							} catch (InterruptedException e2) {
								// TODO: handle exception
								System.out.println("Error in the run method of the buyThread");
							}
							comfirMessage();//calling the comfirMessage method
						}});
					buyThread.start();//starting the thread
				}
				// if the numOfAgents is more than the maximum number of agents allowed
				else{
					System.out.println("You've exceeded the maximum number of agents allowed to purshase this item");
				}
			}
			
		}
	}
	
	//helper method that operates after some time to ask the agent/user is s/he wants to buy or not
		private void comfirMessage() {
			
			for(Customer customer : listOfCustomers) {
				
				int temp;
				int myPrevious ;
				myAgentTotalReservedItems = customer.getMyAgentItems();

				temp = myAgentTotalReservedItems;

				myPrevious = 0;
				
				buyMessage= customer.getName() + " Items Booked: " + myAgentTotalReservedItems + " \n Do you want to buy these items?" ;
				confirmOrder = JOptionPane.showConfirmDialog(this, buyMessage );
				// possible valued of the comfirmOrder: 0=yes, 1=no, 2=cancel
				
				
				
				//if the agent/customer confirms the order
				if(confirmOrder == 0) {
					
					if(myPrevious == 0) {
						myAgentReservedItems = myAgentTotalReservedItems - myPrevious;

						//myPrevious = temp;
						myPrevious = myAgentReservedItems;
					}
					else {
						myAgentReservedItems = myAgentTotalReservedItems - myPrevious;
					}
					myPrevious++;
					
					stockUpdate = numOfItems - myAgentReservedItems;
					System.out.println("  >>>>>  " + customer.getName() + " reserved items " + myAgentTotalReservedItems + " in stock items" + stockUpdate);
					System.out.println("my Agent total: " + myAgentTotalReservedItems);
					System.out.println("my agent now: " + myAgentReservedItems);
					item.setNumofItems(stockUpdate);
					numOfItems = stockUpdate;
				
				}
				//if the agent/customer denies the order; if the agent/customer press no or cancel
				else {
					stockUpdate = numOfItems;
					item.setNumofItems(stockUpdate);
					System.out.println("  &&&&&  " + customer.getName() + "reserved items" + myAgentTotalReservedItems + " in stock items" + stockUpdate);
					numOfItems = stockUpdate;
				}
				
				
			}
			
			
		}
}
