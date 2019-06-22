package chocolatedb;

/**
 * Manager it holds informations about managers
 * @author Qëndresa, Xhemil, Erblin
 */
public class Manager implements Record{
    
    private Key k;
    private String name;
    private String surname;
    private SalesPeople [] salesPeople;
    private int count;
    private boolean active;
    
    /**
     * Constructor Manager initializes the fields
     * @param k - the manger's unique key
     * @param name - manager's name
     * @param surname - manager's surname
     */
    public Manager(Key k , String name , String surname)
    {
        this.k=k;
        this.name=name;
        this.surname=surname;
        //this.db=db;
        count = 0;
        active = true;
        salesPeople = new SalesPeople[10];
    }
    
    /**
     * addEmployee  assigns a manager for the employee
     * @param s - employee 
     * @return true if it's successful
     */
    public boolean addEmployee(SalesPeople s)
    {
    	boolean success = false;
    	
    	if(count < salesPeople.length)
    	{
    		salesPeople[count] = s;
    		count++;
    		success = true;
    	}
    	
    	else
    	{
    		SalesPeople[] temp = new SalesPeople[salesPeople.length * 2];
    		
    		for (int i = 0; i < salesPeople.length; i++)
    		{
    			temp[i] = salesPeople[i];
    		}
    		
    		salesPeople = temp;
    		salesPeople[count] = s;
    		count++;
    		success = true;
    		
    	}
    	
    	return success;
    }
    
    /**
     * getEmployees returns the manager's employees
     * @return temp employee's array
     */
    public SalesPeople[] getEmployees()
    {
    	SalesPeople[] temp = new SalesPeople[count];
    	
    	for(int i = 0; i < count; i++)
    	{
    		temp[i] = salesPeople[i];
    	}
    	
    	return temp;
    }
    
    /**
     * getStatus accessor method returns the manager's status
     * @return active - if active (true)
     **/
    
    public boolean getStatus()
    {
 	   return active;
    }
    
    /**
     * setStatus mutator method it changes the field value for the manager
     * @param s manager's status
     */
    public void setStatus(boolean s)
    {
 	   active = s;
    }
    
    /**
     * noOfEmployees accessor method which returns the number of employees for the manager
     * @return count employees number
     */
    public int noOfEmployees()
    {
    	return count;
    }
    
    /**
     * getName accessor method returns manager's name
     * @return name the name
     */
     public String getName()
    {
        return name;
    }
    
    /**
     * getSurname accessor method it returns manager's surname
     * @return surname 
     */
    public String getSurname()
    {
        return surname;
    }
   
    @Override
     public Key getKey()
    {
        return k;
    } 
     
    /**
     * performance method returns the manager's performance
     * the products sold from manager's employees
     * and the total price of the overall sold items
     */
    public void performance()
    {
        String str = "\n======================================================================="
                     +"\nManager: "+name +", "+surname +", The number of employees, "+count;
        System.out.println(str);
        for(int i =0 ;i!=count ;i++)
        {
            salesPeople[i].performance();   
        }
        
        System.out.println("\nThe total number of products sold by manager's employees: " + this.totalAmount());
        System.out.println("The total amount earned from the sold products: " + this.totalPrice() 
                           +"\n=======================================================================\n");
        
    }
    /**
     * totalAmount returns the total number of sold items from all the employees 
     * @return total - the total number as an integer
     */
    public int totalAmount()
    {
    	int total = 0;
    	
    	for(int i = 0; i < count; i++)
    		total += salesPeople[i].totalAmount();
    	
    	return total;
    }
    
    /**
     * totalPrice the total price of sold items from all the employees 
     */
    public double totalPrice()
    {
    	double total = 0;
    	
    	for(int i = 0; i < count; i++)
    		total += salesPeople[i].totalPrice();
    	
    	return total;
    }
     
     
}

