package ed;

public class CashDispenser 
{
   private final static int INITIAL_COUNT = 10000;
   private int count; 
   public CashDispenser() {
      count = INITIAL_COUNT; 
   } 

   public void dispenseCash(int amount)
   {
      int bill = amount / 50000;
      count -= bill;
   }
   public boolean ktSoDuATM(int amount) {
      int bill= amount / 50000; 

      if (count >= bill )
         return true;
      else
         return false; 
   }
}

