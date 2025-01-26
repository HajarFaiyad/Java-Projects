
class Customer{
    public String name;
    public String address;
}

class Date{
    public int day;
    public int month;
    public int year;
}

class ClockTime{
    public int hour;
    public int minute;
}

class Time{
    public Date date;
    public ClockTime clocktime;
}

class PizzaOrder{
    public Customer customer;
    public Time orderTime;
    public Time deliveryTime; 
    public String order;
    public double price;
}