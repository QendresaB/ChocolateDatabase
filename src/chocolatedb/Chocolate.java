package chocolatedb;
/**Chocolate holds informations about chocolates
 * @author Qëndresa, Xhemil, Erblin
 */
public class Chocolate implements Record {
    private String name; 
    private String distributor; 
    private String productionDate;
    private String expiryDate;
    private double price;
    private Key k;
    private boolean sold; // holds the fact if a chocolate is sold or not
    
    /** Constructor Chocolate initializes the descriptive fields of chocolate
     * @param k - chocolate key (unique identification)
     * @param name - chocolate name as a String
     * @param distributor  - distributor's name
     * @param productionDate 
     * @param expiryDate 
     * @param price - chocolate's price
     */
    public Chocolate(Key k, String name, String distributor, String productionDate, String expiryDate, double price) {
        this.k = k;
        this.name = name;
        this.distributor = distributor;
        this.expiryDate = expiryDate;
        this.productionDate = productionDate;
        this.price = price;
        this.sold = false;

    }

    /**
     * getName accessor method returns the chocolate name
     * @return name chocolate's name
     */
    public String getName() {
        return name;
    }

    /**
     * getDistributor accessor method returns the distributor name
     * @return distributor - distributor's name
     */
    public String getDistributor() {
        return distributor;
    }

    /**
     * getProductionDate accessor method returns the production date of the chocolate
     * @return productionDate - the date
     */
    public String getProductionDate() {
        return productionDate;
    }

    /**
     * getExpiryDate accessor method returns the expiry date of the chocolate
     * @return expiryDate - the expiry date
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * getKey implemented superclass's method 
     * @return Key chocolate key
     */
    @Override
    public Key getKey() {
        return k;
    }

    /**
     * price accessor method returns the chocolate price
     * @return price chocolate price
     */
    public double price() {
        return price;
    }

    /**
     * sell mutator method for chocolate sale
     * it controls if the chocolate is sold
     * @return true if it is sold
     */
    public boolean sell() {
        boolean success = false;
        if (sold == false) {
            sold = true;
            success = true;
        }
        return success;
    }

    /**
     * sold accessor method which returns if the chocolate is sold
     * @return false if it isn't , true otherwise
     */
    public boolean sold() {
        return sold;
    }
    
    /**
     * toString implemented to show some informations about the chocolate
     * @return information as String
     */
    @Override
    public String toString()
    {
        return name +", distributor : "+distributor+"\n";
    }

}

