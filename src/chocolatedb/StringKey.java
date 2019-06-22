package chocolatedb;
/**
 * StringKey models a String key
 * @author Qëndresa, Xhemil, Erblin
 */

public class StringKey implements Key
{ private String s;

  public StringKey(String j)
  { s = j; }

  public String getString()
  { return s; }

  public boolean equals(Key another_key)
{ boolean answer;
  // asks if another_key run-time type is IntegerKey:
  if ( another_key instanceof IntegerKey ) 
       { String m = ((StringKey)another_key).getString(); 
         answer = (s.equals(m)); 
       }
  else // another_key  isn't an  IntegerKey, don't compare:
       { answer = false; }
  return answer;
}
}