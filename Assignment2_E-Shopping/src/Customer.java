import java.util.Random;

//a class for the customers/agents that will purchase items
//Customers/Agents represents Threads; whenever mentioned in this project they refer to threads
public class Customer extends Thread{

	private Items item;
	private int duration, myAgentItems;
	private Random randNum;
	
	//item: a variable of the item class that represents the items created
	//duration: maximum waiting time for an agents/customer to reserve an item
	//myAgentItems: acts as a counter for the items that the agents/customer reserves
	//randNum: a random number for the waiting time; it will be between 0 and duration
	
	//constructor for the customer class that
	public Customer(Items item, int duration, int i) {
		// TODO Auto-generated constructor stub
		this.item = item;
		this.duration = duration;
		randNum = new Random();
		myAgentItems = 0;// Initializing the value of the items that the agent holds as 0 
		setName("Customer " + (i + 1));//setting the agents/customer's name 
	}
	
	//a must to have method from the thread class that operates the threads
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		//as long as there are items available for reservation it will continue
		while(item.isReservable()) {
			//if items are reservable; remember: reserveItem() is a boolean method thus it gives a true or false value
			if(item.reserveItem()) {
				try {
					myAgentItems++;//increase the number of items that the agent holds 
					
					System.out.println(getName() + " My items " + myAgentItems);//for myself to check if the items reserved increase
					
					sleep(randNum.nextInt(duration));// the current agents/customer will sleep(be inactive) for a random amount of time between 0 and the given duration
					
				} catch (InterruptedException e) {
					// TODO: handle exception
					System.out.println("Error in the Customer's run method");
				}
			}
		}
	}

	
	public void setMyAgentItems(int myAgentItems) {
		this.myAgentItems = myAgentItems;
	}

	//a method to get the index/value/number of the current agents/customer
	public int getMyAgentItems() {
		return myAgentItems;
	}

	
	
}
