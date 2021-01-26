public class Warehouse
{
   //The private variable have all been created. They will be used throughout Restaurant
   private String warehouseName;
   private int warehouseID = 10000;
   private String warehouseState;
   private int numProducts;
   private boolean preferredWarehouse;
   private static int numWarehouse;
   
   //Several minimum and maximums have been hard-coded.
   private static final int MIN_ID = 10000;
   private static final int ADD_ID = 1000;
   private static final int MAX_WAREHOUSE = 24;
   //Several constructors
   public Warehouse()
   {
      this.warehouseName = warehouseName;
      this.warehouseID+=ADD_ID;
      this.warehouseState = warehouseState;
      this.numProducts = numProducts;
      this.preferredWarehouse = preferredWarehouse;
      ++numWarehouse;
   }
   public Warehouse(boolean preferredWarehouse)
   {
      this.preferredWarehouse = preferredWarehouse;
   }
   
   //Several accessor methods to return the correct instance variables
   public static int getNumWarehouse()
   {
      return numWarehouse;
   }
   public String getWarehouseName()
   {
      return this.warehouseName;
   }
   public int getWarehouseID()
   {
      return warehouseID;
   }
   public String getWarehouseState()
   {
      return this.warehouseState;
   }
   public int getNumProducts()
   {
      return this.numProducts;
   }
   public boolean getPreferredWarehouse()
   {
      return this.preferredWarehouse;
   }
   //Several mutator methods to set the instance variables.
   public void setWarehouseName(String warehouseName)
   {
      char firstLetter = warehouseName.charAt(0);
      //If the user does not enter anything, they will receive an error.
      if (warehouseName == null || warehouseName.equals("")) 
      {
         throw new IllegalArgumentException("Warehouse must have a name");
      }
      else if (Character.isLowerCase(firstLetter))
      {
         throw new IllegalArgumentException("Warehouse name must begin with a capital letter");
      }
      else if (warehouseName.length() < 5)
      {
         throw new IllegalArgumentException("Warehouse name must be at least 5 characters long");
      }
      this.warehouseName = warehouseName;
   }
   // public void setWarehouseID()
//    {
//       if (numWarehouse == 1)
//       {
//          this.warehouseID = MIN_ID;
//       }
//       else
//       {
//          this.warehouseID += ADD_ID;
//       }
//    }
   public void setWarehouseState(String warehouseState)
   {
      char firstLetter = warehouseState.charAt(0);
      char secondLetter = warehouseState.charAt(1);
      
      if (warehouseState == null)
      {
         throw new IllegalArgumentException("Warehouse State must be entered");
      }
      else if (warehouseState.length() > 2 || warehouseState.length() == 0)
      {
         throw new IllegalArgumentException("Warehouse State must be more than 0 and less than 3 characters long");
      }
      else if (Character.isLowerCase(firstLetter) || Character.isLowerCase(secondLetter))
      {
         throw new IllegalArgumentException("Warehouse State must be capital letters");
      }
      this.warehouseState = warehouseState;
   }
   public void setPreferredWarehouse(String preferredWarehouseAnswer)
   {
      if(preferredWarehouseAnswer.equalsIgnoreCase("yes"))
      {
         this.preferredWarehouse = true;
      }
      else if (preferredWarehouseAnswer.equalsIgnoreCase("no"))
      {
         this.preferredWarehouse = false;
      }
      //If the user enters anything other than yes or no, they will receive an error.
      else
      {
         throw new IllegalArgumentException("Please enter either 'yes' or 'no'");
      }
   }
   public void setNumProducts(int numProducts)
   {
      if (numProducts < 0 || numProducts > 1000000)
      {
         throw new IllegalArgumentException("The number of products must be greater than 0 and less than 1,000,000");
      }
      this.numProducts = numProducts;
   }
   //Special purpose method to return a string representation of the object.
   public String toString()
   {
      return this.getWarehouseID() + "   " + this.getWarehouseName() + "   " + this.getWarehouseState() + "   " + this.getNumProducts() + "   " + (this.getPreferredWarehouse() ? "Yes" : "No");
   }
   public String toStringNameState()
   {
      return this.getWarehouseName() + "   " + this.getWarehouseState();
   }
   public String toStringName()
   {
      return this.getWarehouseName();
   }
}