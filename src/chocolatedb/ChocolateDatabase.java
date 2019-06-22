package chocolatedb;

/**
 * ChocolateDatabase implements chocolate database
 * @author Qëndresa, Xhemil, Erblin
 */
public class ChocolateDatabase extends Database {

    /**
     * Constructor ChocolateDatabase initializes the database
     * @param amount - database size (number of chocolates)
     */
    public ChocolateDatabase(int amount) {
        super(amount);
    }

    /**
     * insertAmount adds a specific amount of chocolates in the database
     * @param ch - array of chocolates
     * @param amount - the number of chocolates
     * @return true if the process is successful
     */
    public boolean insertAmount(Chocolate[] ch, int amount) {
        boolean success = true;

        for (int i = 0; i != amount && success; i++) {
            success = super.insert(ch[i]);
            if (success == false) {
                System.out.println("Couldn't add the product: " + ch[i].toString() + "because a product with the same id is already in the database!"); // kur produkti me key te njejt tashme gjendet ne database
                // nuk insertohet
            }
        }

        return success;
    }

    /**
     * chocolateTypeAmount return the amount of a specific chocolate type
     * @param name - chocolate name
     * @return the number of this kind of chocolate
     */
    public int chocolateTypeAmount(String name) {
        int res = 0;
        Record[] temp = super.getRecords();
        for (int i = 0; i != temp.length; i++) {
            //temp an array of Records , is casted in Chocolate (Chocolate<Record) ,
            //if there's still elements in the database...
            //if these elements have the same name as the one given in parameter
            //also if these products haven't been sold yet, which means sold() returns false ( sold()- accessor method ) 
            // add res which holds the number of this type of chocolate
            if (temp[i] instanceof Chocolate && (Chocolate) temp[i] != null && ((Chocolate) temp[i]).getName().equals(name) && ((Chocolate) temp[i]).sold() == false) {
                res++;
            }
        }

        return res;
    }

}
