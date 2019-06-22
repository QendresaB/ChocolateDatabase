package chocolatedb;
/**
 * IntegerKey models an integer key
 * @author Qëndresa, Xhemil, Erblin
 */
public class IntegerKey implements Key {

    private int k;  // the integer key

    /**
     * Constructor IntegerKey constructs the key
     * @param i - the integer that uniquely defines the key
     */
    public IntegerKey(int i) {
        k = i;
    }

    /**
     * getInt returns the integer value k ( as a key )
     */
    public int getInt() {
        return k;
    }

   /**
     * equals compares this Key with another for equality
     * @param another_key - the other key
     * @return true, if they're the same ; return false, otherwise
     */
    public boolean equals(Key another_key) {
        boolean answer;
        // pyet nese   another_key's  run-time data tipi eshte IntegerKey:
        if (another_key instanceof IntegerKey) {
            int m = ((IntegerKey) another_key).getInt();
            answer = (k == m);
        } else // another_key  isn't an IntegerKey, do not compare:
        {
            answer = false;
        }
        return answer;
    }
}
