package chocolatedb;
/**
 * Sales hold informations about sales
 * @author Qëndresa, Xhemil, Erblin
 */
public class Sales { 
    
    private Chocolate ch;
    private String chocolateName;
    private ChocolateDatabase db;
    private Key k ;
    private String date;
    private int amount;
    private Key[] keys;
    private SalesPeople salesPeople;
    private boolean s;
    
    /**
     * Constructor Sales initializes the fields
     * @param k - the sales Key
     * @param ch - the chocolate for sale
     * @param date - sold date
     * @param amount - the amount of sold chocolate
     * @param db - chocolate database
     * @param salesPeople - the person who sales the chocolate
     */
    public Sales(Key k,String chName,String date,int amount,ChocolateDatabase db, SalesPeople salesPeople)
    {
     this.k=k;
     this.amount=amount;
     this.date=date;
     this.chocolateName=chName;
     this.db=db;
     this.salesPeople=salesPeople;

     Record[] temp = db.getRecords();
     
     for(int i = 0; i < temp.length; i++)
     {
    	 if(temp[i] instanceof Chocolate && (Chocolate) temp[i] != null && ((Chocolate) temp[i]).getName().equals(chocolateName))
    		 ch = (Chocolate)temp[i];
     }
     
     if(ch == null)
    	 s = false;
     
     else
    	 s = true;
     
    }
    
    /**
     * sell for the chocolate sale
     * @return true if the whole amount of chocolate is sold , the process is successful
     */
    public boolean sell()
    {
        boolean success=false;
        if(amount<=db.chocolateTypeAmount(ch.getName()) && s == true)
        {
            int j=0;
            keys= new Key[amount];
            Record [] temp= db.getRecords();
                for(int i=0; i!=temp.length && j!=amount;i++)
                {
                    //temp varg i Records , behet cast ne Chocolate (Chocolate<Record) ,
                    //nese keto elemente kane emrin e njejte me emrin e cokolades se dhene
                    //si dhe nese keto produkte nuk jane shitur ende qe dmth sold() kthen false ( sold() si accessor method ) 
                    //kryej shitjen ... sell metoda (mutator method) e bene true fushen qe tregon se cokolada eshte shitur
                    if(temp[i] instanceof Chocolate && ((Chocolate)temp[i]).getName().equals(ch.getName())&&((Chocolate)temp[i]).sold()==false)
                    {
                        ((Chocolate)temp[i]).sell();
                        keys[j++]=((Chocolate)temp[i]).getKey();
                    } 
                    // nese eshte shit e gjithe sasia e cokoladave , procesi eshte i suksesshem
                    if(j==amount-1)
                    {
                        success=true;
                    }
                }
        }
        return success;  
    }
    
    @Override
    public String toString()
    {
    	return "Type: " + ch.getName() + ", Date: " + date + ", Amount: " + amount + ", Price : "+this.getTotalPrice();
    }
    
     /**
     * getAmount accessor method which returns the number of sales
     * @return amount the number of sales
     */
    public int getAmount()
    {
        return amount;
    }
    
    /**
     * getDate accessor method which returns the date of sales
     * @return the sale date
     **/
    public String getDate()
    {
        return date;
    }
   
    /**
     * getTotalPrice returns the total price of all sold products
     * @return double the total price
     */
    public double getTotalPrice()
    {
        return amount*ch.price();
    }
    
     public Key getKey()
    {
        return k;
    }
}

