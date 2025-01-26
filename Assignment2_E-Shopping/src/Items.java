import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

public class Items {

	private int numofItems;//for the number of items in stock
	private String itemName;//for the name/type of the item. I.e: pens, paper, dress, etc.
	private ArrayList<JButton> btnItemList;
	private JButton btnNewItem;//for the buttons which are to be added to the btnItemList
	private int index;// to be able to follow which item are we selecting now
	private boolean reserved;
	
	//constructor for the Item class that takes an integer that represents the number of items to be created
	public Items(int stock, String itemName) {
		// TODO Auto-generated constructor stub
		numofItems = stock;
		this.itemName = itemName;
		btnItemList = new ArrayList<JButton>(stock);
		index =0;// initial index of the first item in the list
		createItems();// calling the function that creates the items
	}
	
	//a public method that created Items when the btnCreate is clicked
	public void createItems() {
		
		//a loop that created i number of items
		for(int i = 0; i < numofItems; i++) {
			btnNewItem = new JButton("Item " + i);//new button with name item and it's number in the list
			btnNewItem.setBackground(Color.CYAN);// setting the color of an available item to cyan
			btnNewItem.setText(itemName);//setting the name of the new item created
			btnItemList.add(btnNewItem);// adding the new buttons to the list of buttons
		}
		
		if(btnItemList.size() > 0) {
			reserved = true; // now there are items that can be reserved so items are reservable 
		}
	}
	
	//a public method for reserving Items 
	public synchronized boolean reserveItem() {
		//customer is able to reserve items as long as there are still unreserved items in the list
		//the reservation process occurs in the order of the array
		if (index < btnItemList.size()) {
			btnItemList.get(index).setText("Reserved Item");
			btnItemList.get(index).setBackground(Color.LIGHT_GRAY);
			index++;
			return true;// return false after the reserving is successfully finished
		}
		else {
			reserved = false;//items can not be reserved anymore because they are all reserved already
			return false;//return false after the reserving is successfully finished
		}
	}

	//a public method to be able to access the array of items from other classes
	public ArrayList<JButton> getBtnItemList() {
		return btnItemList;
	}

	//a getter method to be able to check the reservation status from other classes
	public boolean isReservable() {
		return reserved;
	}

	//a setter method to be ale to update the stock/number of items available after an agent/customer buys an item
	public void setNumofItems(int numofItems) {
		this.numofItems = numofItems;
	}
	

	
	

	
	
}
