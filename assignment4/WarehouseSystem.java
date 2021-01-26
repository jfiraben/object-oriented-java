/*
Jordan Firaben
10-08-2017
IT 206-204
Programming Assignment 4

The following program is used to to create a keep track of warehouses that supply the GMU food
Industries restaurants. The program allows the user to do several tasks including: Add a warehouse,
Delete a warehouse, Display all warehouses, Mark a warehouse as preferred or not preferred, and 
exit the program at any time and display the warehouses in the system.

If the user has not entered anything in the system and tries to delete a warehouse, mark a warehouse
as preferred or not preferred, or display the warehouses, they will receive an error that says there
are currently no warehouses in the system. The program will display errors when an incorrect item is
entered anywhere. Once the user is done with the program, they can choose to exit the system and
either receive a notice saying there are currently no warehouses in the system, or they will receive
a printout with all of the warehouses in the system.
*/
import javax.swing.JOptionPane;

public class WarehouseSystem
{
   public static void main(String[] args)
   {
      //The program will continue perform any of the given tasks until the user
      //has chosen "Exit system".
      
      //The maximum number of warehouses is 24
      final int MAX_WAREHOUSE = 24;
      int warehouseNumber = 1;
      Warehouse[] warehouse = new Warehouse[MAX_WAREHOUSE];
      
      boolean warehouseSet = false;
      do 
      {
         try 
         {
            String menuChoice = getMenuChoice();
            if (menuChoice.equals("Add Warehouse"))
            {
               addWarehouse(warehouse);
               warehouseNumber++;
            }
            if (menuChoice.equals("Delete Warehouse"))
            {
               deleteWarehouse(warehouse);
               warehouseNumber--;
            }
            if (menuChoice.equals("Mark Preferred/Not Preferred"))
            {
               //markPreferred(warehouse);
            }
            if (menuChoice.equals("Display All Warehouses"))
            {
               showWarehouse(warehouse);
            }
            if (menuChoice.equals("Exit System"))
            {
               showWarehouse(warehouse);
               warehouseSet = true;
            }
         }
         
         catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Warehouse could not be created! " + e.getMessage());
         }
      } while (!warehouseSet);
   }
   //This method is used to display the menu for the user to choose from and return
   //whatever choice the user has chosen
   public static String getMenuChoice()
   {
      String[] choice = {"Add Warehouse","Delete Warehouse","Mark Preferred/Not Preferred","Display All Warehouses","Exit System"};
      String warehouseChoice = JOptionPane.showInputDialog(null,"Please choose from the selections below:\n","Warehouse System",JOptionPane.QUESTION_MESSAGE,null, choice, "Add Warehouse").toString();
      return warehouseChoice;
   }
   //This method is to add a warehouse to the warehouse array
   public static void addWarehouse(Warehouse[] warehouse)
   {
      int position = Warehouse.getNumWarehouse();
      if (position < warehouse.length) 
      {
         //A warehouse is created
         Warehouse oneWarehouse = new Warehouse();
         /*
         The program will continue to ask the user for the name of the Warehouse. If the user enters
         anything incorrectly, they will receive an error stating what they have done wrong.
         */
         boolean nameSet = false;
         do 
         {
            try 
            {
               oneWarehouse.setWarehouseName(JOptionPane.showInputDialog("Enter the name of the Warehouse: "));
               nameSet = true;
            }
            catch(IllegalArgumentException e) 
            {
               JOptionPane.showMessageDialog(null, "Warehouse name could not be set. " + e.getMessage());
            }
         } while(!nameSet);
         
         //The program sets the first ID and the subsequent IDs
         boolean idSet = false;
         do 
         {
            oneWarehouse.setWarehouseID();
            idSet = true;
         } while(!idSet);
         
         /*
         The program will continue to ask the user for the state location of the Warehouse. If the user enters
         anything incorrectly, they will receive an error stating what they have done wrong.
         */
         boolean stateSet = false;
         do 
         {
            try 
            {
               oneWarehouse.setWarehouseState(JOptionPane.showInputDialog("Enter the state your warehouse is located. Must be capitalized and two characters"));
               stateSet = true;
            }
            catch(IllegalArgumentException e) 
            {
               JOptionPane.showMessageDialog(null, "Warehouse State could not be set. " + e.getMessage());
            }
         } while(!stateSet);
         
         /*
         The program will continue to ask the user for the preferred or not preffered of the Warehouse. If the user enters
         anything incorrectly, they will receive an error stating what they have done wrong.
         */
         boolean preferredSet = false;
         do
         {
            try
            {
               oneWarehouse.setPreferredWarehouse(JOptionPane.showInputDialog("Is this a preferred warehouse? Enter Yes or No: "));
               preferredSet = true;
            }
            catch(IllegalArgumentException e) 
            {
               JOptionPane.showMessageDialog(null, "Preferred warehouse could not be set. " + e.getMessage());
            }
         } while(!preferredSet);
         
         /*
         The program will continue to ask the user for the number of products for the Warehouse. 
         If the user enters anything incorrectly, they will receive an error stating what they 
         have done wrong.
         */
         boolean numProductsSet = false;
         do
         {
            try
            {
               oneWarehouse.setNumProducts(Integer.parseInt(JOptionPane.showInputDialog("Enter number of products supplied to the company")));
               numProductsSet = true;
            }
            catch(NumberFormatException e)
            {
               JOptionPane.showMessageDialog(null, "Error! Please enter a number");
            }
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, "Number of products could not be set. " + e.getMessage());
            }
         } while(!numProductsSet);
         warehouse[position] = oneWarehouse;
      }
      else 
      {
         //If the user tries to add more warehouses after the system is full, they will
         //receive an error
         JOptionPane.showMessageDialog(null, "The system is full. No more warehouses could be added.");
      }
   }
   /*
   The program will ask the user which of the warehouses they would like to delete from
   a list. The user must enter the name of the warehouse. They program will then delete
   that warehouse from the system. If there are no warehouses, the program will inform
   the user that there are currently no warehouses in the system.
   */
   public static void deleteWarehouse(Warehouse[] warehouse)
   {
      String warehouseList = "";
      int numWarehouse = Warehouse.getNumWarehouse();
      //A new array must be created to ensure it has the proper size to
      //search through the array
      Warehouse[] newWarehouse = new Warehouse[numWarehouse];
      boolean nameFound = false;
      
      if (numWarehouse > 0)
      {
         for (int x = 0; x < Warehouse.getNumWarehouse(); x++)
         {
            newWarehouse[x] = warehouse[x];
         }
         for (int x = 0; x < newWarehouse.length; x++) 
         {
            warehouseList += newWarehouse[x].toString() + "\n";
         }
         
         String warehouseName = JOptionPane.showInputDialog("Please enter the warehouse name from the list below that you want to delete: \n\n"+ warehouseList);
         
         for (int x = 0; x < newWarehouse.length - 1; x++)
         {
            if (newWarehouse[x].toStringName().equals(warehouseName))
            {
               warehouse[x] = warehouse[x+1];
               --numWarehouse;
            }
            else
            {
               JOptionPane.showMessageDialog(null,"You have entered an incorrect Warehouse name. Please try again.");
            }
         }
      }
      else
      {
         JOptionPane.showMessageDialog(null,"There are currently no warehouses in the system");
      }      
   }
   /*
   The program will display the warehouses that are currently in the system. If there are no warehouses,
   the program will inform the user that there are currently no warehouses in the system.
   */
   public static void showWarehouse(Warehouse[] warehouse)
   {
      String warehouseList = "Warehouse (ID, Name, State, Number of Products, Prefered?) \n";
      int numWarehouse = Warehouse.getNumWarehouse();
      //A new array must be created to ensure it has the proper size to
      //search through the array
      Warehouse[] newWarehouse = new Warehouse[numWarehouse];
      if (numWarehouse > 0)
      {
         for (int x = 0; x < Warehouse.getNumWarehouse(); x++)
         {
            newWarehouse[x] = warehouse[x];
         }
         for (int x = 0; x < newWarehouse.length; x++) 
         {
            warehouseList += newWarehouse[x].toString() + "\n";
         }
         JOptionPane.showMessageDialog(null,warehouseList);
      }
      else
      {
         JOptionPane.showMessageDialog(null,"There are currently no warehouses in the system");
      }
   }
   /*
   The program will ask the user which warehouse they would like to mark as preferred from a list.
   The user will enter a name, and the program will mark that warehouse as preferred.If there are 
   no warehouses,the program will inform the user that there are currently no warehouses in the system.
   */
   // public static void markPreferred(Warehouse[] warehouse)
//    {
//       String warehouseList = "Warehouse (ID, Name, State, Number of Products, Prefered?) \n";
//       int numWarehouse = Warehouse.getNumWarehouse();
//       //A new array must be created to ensure it has the proper size to
//       //search through the array
//       Warehouse[] newWarehouse = new Warehouse[numWarehouse];
//       
//       if (numWarehouse > 0)
//       {
//          for (int x = 0; x < Warehouse.getNumWarehouse(); x++)
//          {
//             newWarehouse[x] = warehouse[x];
//          }
//          for (int x = 0; x < newWarehouse.length; x++) 
//          {
//             warehouseList += newWarehouse[x].toString() + "\n";
//          }
//          
//          String warehouseName = JOptionPane.showInputDialog("Please enter the warehouse name from the list below that you want to mark as preferred or not preferred: \n\n"+ warehouseList);
//          
//          for (int x = 0; x < newWarehouse.length - 1; x++)
//          {
//             if (newWarehouse[x].toStringName().equals(warehouseName))
//             {
//                warehouse[x] = Warehouse.setPreferredWarehouse(JOptionPane.showInputDialog("Is this a preferred warehouse? Enter Yes or No: "));
//             }
//             else
//             {
//                JOptionPane.showMessageDialog(null,"You have entered an incorrect Warehouse name. Please try again.");
//             }
//          }
//       }
//       else
//       {
//          JOptionPane.showMessageDialog(null,"There are currently no warehouses in the system");
//       } 
//    }
}