package chocolatedb;
/**
 * ManagerDatabase implements the managers database
 * @author Qëndresa, Xhemil, Erblin
 */
public class ManagerDatabase extends Database {

    /**
     * Constructor ManagerDatabase initializes the database
     * @param initialSize - database's length (the number of managers)
     */
    public ManagerDatabase(int initialSize) {
        super(initialSize);
    }

    /**
     * fire fires a manager and assigns his employees to the other manager
     * @param m - the fired manager
     * @return true if the process is successful
     */
    public boolean fire(Manager m) {
        boolean success = false;

        Record[] temp = super.getRecords();

        int i = 0;
        int j = 0;
        for (; j < temp.length && i == 0; j++) // if there are still managers and their staus is inactive continue searching...
        {
            // temp  array of type Record , it's cased into Manager to use the getStatus method
            // if the manager's status is  true which means he's still working , add one to i , the for loop is done
            if (temp[j] instanceof Manager && ((Manager) temp[j]).getStatus() == true) {
            {
            	i++;
            	m.setStatus(false);
            	System.out.println("\n-------------------------------------"
                                   +"\nThis manager has been fired:\nMenaxheri: " + ((StringKey)(m).getKey()).getString() + "\nName: " 
                                   + m.getName() + "\nSurname: " + m.getSurname());
                               
            }
            }
        }
        
        SalesPeople[] Stemp = m.getEmployees();
        
        for (int k = 0; k < Stemp.length && i != 0; k++) {
            // assigns the employees of the fired manger to the first active manager found
            // the j variable holds the index of the fond manager
            ((Manager) temp[j]).addEmployee(Stemp[k]);
            // assign employees to this specific menager
            Stemp[k].setManager((Manager) temp[j]);
            
        }
        
        if(i == 0)
        	System.out.println("The manager is still working");
        else{
                System.out.println("\n"+"The employees now are assigned to :\nManager: "+((StringKey)(temp[j]).getKey()).getString() 
                                   +"\nName: " + ((Manager) temp[j]).getName() + "\nSurname: " + ((Manager) temp[j]).getSurname()
                                   +"\n-------------------------------------\n");
        }

        return success;
    }
    /**
     * totalPerformance summary of total sales based on managers
     * and their employees
     */
    public void totalPerformance()
    {
    	int totalAmount = 0;
    	double totalPrice = 0;
    	System.out.println("\n\n\n*********************************************************************************"+"\nCompany's performance: ");
    	Record[] temp = super.getRecords();
    	for(int i = 0; i < temp.length; i++)
    	{
    		if(temp[i] instanceof Manager && temp[i] != null)
    		{
    			((Manager)temp[i]).performance();
    			totalAmount += ((Manager)temp[i]).totalAmount();
    			totalPrice += ((Manager)temp[i]).totalPrice();
    		}
    	}
    	
    	System.out.println("The total number of sales in the company: " + totalAmount);
    	System.out.println("The total profit for the company : " + totalPrice + "\n*********************************************************************************\n");
    }
}

