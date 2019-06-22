package chocolatedb;

/**
 * SalesPeople holds informations about salespeople
 * @author Qëndresa, Xhemil, Erblin
 */
public class SalesPeople {

    private Manager manager;
    private Key k;
    private Sales[] sales;
    private int countOfSales;
    private ChocolateDatabase db;
    private String name;
    private String surname;
    boolean active; // it holds the fact if this employee is active or not

    /**
     * Constructor SalesPeople initializes the fields
     * @param name - employee's name
     * @param surname - employee's surname
     * @param manager - employee's manager
     * @param db - chocolate database
     */
    public SalesPeople(String name, String surname, Manager manager, ChocolateDatabase db) {
        this.manager = manager;
        this.db = db;
        sales = new Sales[10];
        this.name = name;
        this.surname = surname;
        // get the manager Key , cast into StringKey < Key to invoke the getString method
        // and the number of employees for the manager
        // create the employee key from these two
        // assign the employee recently created to the manager
        k = new StringKey(((StringKey) (manager).getKey()).getString() + manager.noOfEmployees());
        manager.addEmployee(this);
        active = true;
    }

    /**
     * sell sells chocolates with a specific amount
     * @param ch - the chocolate for sale
     * @param amount - the chocolate's amount
     * @param date - the date when it's sold
     * @return true if the specific amount of chocolates is sold
     */
    public boolean sell(String ch, int amount, String date) {
        boolean success = false;
        Key key = new StringKey(((StringKey) k).getString() + countOfSales); // key for sales , created by:
                                                                             // the key of employee and its sales
        Sales s = new Sales(key, ch, date, amount, db, this);

        if (s.sell()) {

            if (countOfSales < sales.length) {
                sales[countOfSales] = s;
                countOfSales++;
            } else {
                Sales[] temp = new Sales[sales.length * 2];
                for (int i = 0; i != sales.length; i++) {
                    temp[i] = sales[i];
                }

                sales = temp;
                sales[countOfSales] = s;
                countOfSales++;
            }
            success = true;
        }

        if (success) {
            System.out.println("\n-----------------------------------------------"+"\nThe amount sold: " + amount + " ,the chocolate type " + ch + "\nDate: " + date + "\nFrom " + name + " " + surname + "\n-----------------------------------------------"+"\n");
        } else {
            System.out.println("\n-------------------------------------------------------------------------"
                                 +"\nThe sale was not completed because there's not enough products." 
                                 +"\n-------------------------------------------------------------------------\n");
        }

        return success;

    }

    /**
     * getStatus returns the employee status if he/she is working or not
     * @return active
     */
    public boolean getStatus() {
        return active;
    }

    /**
     * performance shows the manager's and employee's performance
     */
    public void performance() {
        int total = 0;
        double price = 0;
        String status = "";

        if (active) {
            status = "Active";
        } else {
            status = "Nonactive";
        }

        System.out.println("\n-----------------------------------------------------------------------"+"\nInformation about the employee: " + name + ", " + surname + "\nStatus: " + status);

        for (int i = 0; i < countOfSales; i++) {
            System.out.println(sales[i].toString());
        }
        System.out.println("The total amount of products sold: " + this.totalAmount() + "\nThe total income: " + this.totalPrice());
        System.out.print("-----------------------------------------------------------------------");
    }

    /**
     * fire mutator method when the employee is fired, he/she is considered as nonactive
     * (active=false)
     */
    public void fire() {
        if (active == false) {
            System.out.println("\n-------------------------------------"
                               +"\nThe employee is already fired\nEmployee: " + ((StringKey) (this).getKey()).getString()
                               +"\nName: " + this.getName() + "\nSurname: " + this.getSurname()
                               +"\n-------------------------------------");
        } else {
            active = false;
            System.out.println("\n-------------------------------------"
                               +"\nThe employee has been fired\nEmployee: " + ((StringKey) (this).getKey()).getString() 
                               +"\nName: " + this.getName() + "\nSurname: " + this.getSurname()
                               +"\n-------------------------------------");
        }
    }

    /**
     * totalAmount returns the total amount of products sold by employees
     * @return total as an integer
     */
    public int totalAmount() {
        int total = 0;
        for (int i = 0; i < countOfSales; i++) {
            total += sales[i].getAmount();
        }

        return total;
    }

    /**
     * totalPrice the total price of all sales for the emoloyee
     * @return total as double
     */
    public double totalPrice() {
        double total = 0;
        for (int i = 0; i < countOfSales; i++) {
            total += sales[i].getTotalPrice();
        }

        return total;
    }

    /**
     * setManager mutator method changes the manger for the employee
     * @param m the manger assigned to the employee
     */
    public void setManager(Manager m) {
        manager = m;
    }

    /**
     * getName accessor method which returns the name of the employee
     * @return the employee's name
     */
    public String getName() {
        return name;
    }

    /**
     * getSurname accessor method which returns the employee's surname
     * @return employee's surname
     */
    public String getSurname() {
        return surname;
    }

    public Key getKey() {
        return k;
    }

}
