// Starting the project/Assignemt
// creating the Customer class
class Customer{

    // creating and defining the fields/objects/properties for the Customer class
    private String name;
    private String address;

    // creating constructors for the ClockTime class
    // constructor 1 with inisatized constant parameters
    public Customer(){
        name = "Hajar";
        address = "Basaksehir";
    }

    // constructor 2 with varaying parameters according to the assigned value when creating the ClockTime instances
    public Customer( String name, String address){
        this.name = name;
        this.address = address;
    }

    // creating set-get method for the Customer class
    // setName() method sets assigns the value of the name to the value given in the parantheses
    // while getName() method returns the given value 
    public void setName (String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    // setAddress() method sets assigns the value of the address to the value given in the parantheses
    // while getAddress() method returns the given value 
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }

    // toString() method is a standard method for all classes
    // returns a string that textually represents the objects in the class
    public String toString(){
        return "Customer name: " + name + "Address: " + address;
    }
} // end of Customer lass

// creating the Date class
 class Date{

    // creating and defining the fields/objects/properties for the Date class
    private int day;
    private int month;
    private int year;

    // creating constructors for the ClockTime class
    // constructor 1 with varaying parameters according to the assigned value when creating the ClockTime instances
    public Date( int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // constructor 2 with inisatized constant parameters
    public Date(){
        day = 4;
        month = 2;
        year = 2020;
    }

    // creating set-get method for the Date class
    // setDay() method sets assigns the value of the day to the value given in the parantheses
    // while getDay() method returns the given value 
    public void setDay(int day){
        this.day = day;
    }
    public int getDay(){
        return day;
    }

    // setMonth() method sets assigns the value of the month to the value given in the parantheses
    // while getMonth() method returns the given value
    public void setMonth(int month){
        this.month = month;
    }
    public int getMonth(){
        return month;
    }

    // setYear() method sets assigns the value of the year to the value given in the parantheses
    // while getYear() method returns the given value
    public void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return year;
    }

    // toString() method is a standard method for all classes
    // returns a string that textually represents the objects in the class
    public String toString(){
        return "Date: " + day + "/" + month + "/" + year;
    }

} // end of Date class

// creating the ClockTime class
 class ClockTime{

    // creating and defining the fields/objects/properties for the ClockTime class
    private int hour;
    private int minute;

    // creating constructors for the ClockTime class
    // constructor 1 with varaying parameters according to the assigned value when creating the ClockTime instances
    public ClockTime(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }

    // constructor 2 with inisatized constant parameters
    public ClockTime(){
        hour = 2;
        minute = 0;
    }

    // creating set-get method for the ClockTime class
    // setHour() method sets assigns the value of the hour to the value given in the parantheses
    // while getHour() method returns the given value 
    public void setHour(int hour){
        this.hour = hour;
    }
    public int getHour (){
        return hour;
    }

    // setMinute() method sets assigns the value of the minute to the value given in the parantheses
    // while getMinute() method returns the given value 
    public void setMinute(int minute){
        this.minute = minute;
    }
    public int getMinute(){
        return minute;
    }

    // toString() method is a standard method for all classes
    // returns a string that textually represents the objects in the class
    public String toString(){
        return "ClockTime: " + hour + ":" + minute;
    }
} // end of ClockTime class

// creating the Time class
 class Time{

    // creating and defining the fields/objects/properties for the Time class
    private Date date;
    private ClockTime clocktime;

    // creating constructors for the Time class
    // constructor 1 with varaying parameteres according to the assigned value when creating the instances
    public Time(Date date, ClockTime clockT){
        this.date = date;
        clocktime = clockT;
    }

    // constructor 2 with inisatized constant parametes 
    public Time(){
        date = new Date( 6, 3, 2020);
        clocktime = new ClockTime(1, 30);
    }


    // creating set-get method for the Time class
    // setDate() method sets assigns the value of the date to the value given in the parantheses
    // while getDate() method returns the given value 
    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return date;
    }

    // setClockTime() method sets assigns the value of the clockTime to the value given in the parantheses
    // while getClockTime() method returns the given value 
    public void setClockTime(ClockTime clocktime){
        this.clocktime = clocktime;
    }
    public ClockTime getClockTime(){
        return clocktime;
    }

    // toString() method is a standard method for all classes
    // returns a string that textually represents the objects in the class
    public String toString(){
        return "Order Date & Time:" + date + " " + clocktime;
    }

} // end of Time class

// creating the PizzaOrder class
class PizzaOrder{
   
    // creating and defining the fields/objects/properties for the PizzaOrder class
    private Customer customer;
    private Time orderTime;
    private Time deliveryTime; 
    private String order;
    private double price;

    // creating constructors for the PizzaOrder class
    // constructor 1 with constant parameters
    public PizzaOrder(){
        customer = new Customer("Yomna" , "Basaksehir");
        orderTime = new Time(new Date( 20, 5, 2020),new ClockTime(4 , 00));
        deliveryTime = new Time(new Date( 20, 5, 2020),new ClockTime(4 , 45));
        order = "1 large Chicken Salami pizza";
        price = 75.9;
    }

    // constructor 2 with varying parrameteres according to the assigned values when creating the instances 
    public PizzaOrder(Customer cust, Time ot, Time dt, String ord, double p){
        customer = cust;
        orderTime = ot;
        deliveryTime = dt;
        order = ord;
        price = p;
    }

    // creating set-get method for the PizzaOrder class
    // setCustomer() method sets assigns the value of the custumer to the value given in the parantheses
    // while getCustmer() method returns the given value 
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public Customer getcustomer(){
        return customer;
    }

    // setOrderTime() method sets assigns the value of the ordertime to the value given in the parantheses
    // while getOrderTime() method returns the given value 
    public void setOrderTime(Time orderTime){
        this.orderTime = orderTime;
    }
    public Time getOrderTime(){
        return orderTime;
    }

    // setDeliveryTime() method sets assigns the value of the deliveryTime to the value given in the parantheses
    // while getDeliveryTime() method returns the given value 
    public void setDeliveryTime(Time  deliveryTime){
        this.deliveryTime = deliveryTime;
    }
    public Time getDeliveryTime(){
        return deliveryTime;

    }

    // setOrder() method sets assigns the value of the order to the value given in the parantheses
    // while getOrder() method returns the given value 
    public void setOrder(String order){
        this.order = order;
    }
    public String getOrder(){
        return order;
    }

    // setPrice() method sets assigns the value of the price to the value given in the parantheses
    // while getPrice() method returns the given value 
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }

    // toString() method is a standard method for all classes
    // returns a string that textually represents the objects in the class
    public String toString(){
        return "PizzaOrder informtion:" + customer + " " + orderTime + " " + deliveryTime + " " + order + " " + price;
    }

    // LateOrNot() method is created o check if the PizzaOrder delivery is a late delivery or not
    // Prints out the deliver time statements "Late Delivery" or "On-time Delivery"
    // does Not return any value
    // if condition is used to determine the case of late delivery 
    // if the difference between the delivery time's hour and the order time's hour eqaulas to 1 and the difference between the order time's 
    //     minutes and the delivery time's minutes subtarcted from 60 are greater than 60, then it is a late delivery
    //     if this is not the case, if the order time's hour subtracted from the delivery time's hour is greater than 1, then it is a late delivery
    //     else if these are not the cases, then it is on-time delivery
    public void LateOrNot(){
        if (deliveryTime.getClockTime().getHour() - orderTime.getClockTime().getHour() == 1 && 60 - orderTime.getClockTime().getMinute()+ deliveryTime.getClockTime().getMinute() > 60){
            System.out.println("Late delivery");
        }
        else if (deliveryTime.getClockTime().getHour() - orderTime.getClockTime().getHour() > 1){
            System.out.println("Late delivery ");
        }
        else{
            System.out.println("On-time delivery");
        }
    } // end of LateOrNot() method

    
} // end of PizzaOrder class

// creating a test class to test the LateOrNot method
class OrderTest{

    // main method for the Ordertest class
    public static void main(String [] args){

        // creating and inisalizing new instances and variables to use in PizzaOrder instances

        Customer customer1 = new Customer("Mariam","Fatih");
        Customer customer2 = new Customer("Joudi" , "Kayasehir");
        Time orderTime1 = new Time(new Date(5, 2, 2020), new ClockTime(1, 55));
        Time deliveryTime1 = new Time(new Date(8, 4, 2020), new ClockTime(2, 30));
        Date date1 = new Date(12, 3, 2020);
        ClockTime clockTime1 = new ClockTime();//(2,0)
        Date date2 = new Date(12, 3, 2020);
        ClockTime clockTime2 = new ClockTime(3, 15);
        Time ordertime2 = new Time(date1 , clockTime1);
        Time deliveryTime2 = new Time(date2, clockTime2);
        String order = "1 medium Pepperoni pizza";
        int price = 45;

        // creating PizzaOrder instances using different ways

        PizzaOrder order1 = new PizzaOrder();
        PizzaOrder order2 = new PizzaOrder( new Customer("Dalia","Eyup"), new Time(new Date(22,4,2020),new ClockTime(9, 20)), new Time(new Date(22,4,2020), new ClockTime(10, 30)), "2 medium meat lovers", 99.5);
        PizzaOrder order3 = new PizzaOrder(new Customer(), new Time(), deliveryTime1, "1 large BBQ & 2 small Chicken Salamai pizza" , 100.0);
        PizzaOrder order4 = new PizzaOrder(customer1, orderTime1, deliveryTime1, order, price);
        PizzaOrder order5 = new PizzaOrder(customer2, ordertime2, deliveryTime2, "1 large Vegetables pizza", 50.0);

        // calling the LateOrNot() method to test the time statements of the PizzaOrder instances 
        order1.LateOrNot();// on-time delivery
        order2.LateOrNot();// Late delivery
        order3.LateOrNot();// on-time delivery
        order4.LateOrNot();// on-time delivery
        order5.LateOrNot();// Late delivery



    } // end of main function/method
} // end of OrderTest class