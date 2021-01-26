/*
Jordan Firaben
09-24-2017
IT 206-204
Programming Assignment 4

The following program is used to to create a keep track of restaurant information(for now just one restaurant)
for student run restaurants in the Norther Virginia area. The program will take a name for the restaurant. The
name must be entered or else the program will not continue to the other information. The program will then allow
the user to enter the number of employees and the number of seats at the restaurant. If the user chooses to use
the default value of 1 employee and/or 14 seats, they can enter 0 in the respective dialog boxes.The program will
then ask if the user has insurance or not. They can choose to enter either "yes" or "no".  Once the user
has entered the name, number of employees, seats, and insurance, they will be asked to enter the amount of sales. 
User can enter any number between $0.50 and $150. The user will be asked if they'd like to continue entering amount
of sales after each sale is entered. Once the user is finished entering the amount of sales, they will be presented
with a well-formatted report containing the name of the restaurant, number of employees, number of seats, total
amount of sales, and the total number of sales.

The required input is the name of the restaurant, number of employees(default 1), number of seats (default 14),
and amount of sales(can enter as many sales as wanted). The expected output is name of the restaurant, number
of employees, number of seats, number of sales, total amount of sales, and if the restaurant has insurance.
*/
import javax.swing.JOptionPane;

public class WarehouseSystem2
{
   public static void main(String[] args)
   {
      //The program will continue to try to make the first restuarant until the addRestaurant method has
      //returned restaurant1.
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
            
            }
            if (menuChoice.equals("Display All Warehouses"))
            {
               showWarehouse(warehouse);
            }
            if (menuChoice.equals("Exit System"))
            {
               warehouseSet = true;
            }
         }
         
         catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Warehouse could not be created! " + e.getMessage());
         }
      } while (!warehouseSet);
      //The printRestaurantReport method will return a well-formatted report containing everything the user entered.
      //printRestaurantReport(Restaurant.getRestaurantName(), Restaurant.getNumberOfEmployee(), Restaurant.getCustomerSeat(), Restaurant.getSaleNumber(), Restaurant.getSaleAmount(), Restaurant.getInsurance());
   }
   public static String getMenuChoice()
   {
      String[] choice = {"Add Warehouse","Delete Warehouse","Mark Preferred/Not Preferred","Display All Warehouses","Exit System"};
      String warehouseChoice = JOptionPane.showInputDialog(null,"Please choose from the selections below:\n","Warehouse System",JOptionPane.QUESTION_MESSAGE,null, choice, "Add Warehouse").toString();
      return warehouseChoice;
   }
   public static void addWarehouse(Warehouse[] warehouse)
   {
      int position = Warehouse.getNumWarehouse();
      if (position < warehouse.length) 
      {
         Warehouse oneWarehouse = new Warehouse();
         
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
         
         /*
         The program will continue to ask the user for the amount of employees at the restaurant. If the user chooses
         the default value of 1, they can entere 0. Otherwise they need to enter a number between 1 and 50. If they do
         not enter a number, they will receive an error message. If they enter a number outside of 1 and 50, they will
         receive an error message.
         */
         boolean idSet = false;
         do 
         {
            oneWarehouse.setWarehouseID();
            idSet = true;
         } while(!idSet);
         
         /*
         The program will continue to ask the user for the number of seats at the restaurant. If the user chooses
         the default value of 14, they can entere 0. Otherwise they need to enter a number between 4 and 100. If they do
         not enter a number, they will receive an error message. If they enter a number outside of 4 and 100, they will
         receive an error message.
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
         The program will ask the user if the restaurant has insurance. If the user enters anything other than
         yes or no, they will receive an error. If the user enters nothing, they will receive an error.
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
         The program will ask for the first sale amount. There must be at least one sale amount for the program
         to continue with the report. If the user enters anything outside of $0.50 and $150, the user will receive
         an error message. If the user does not enter a number, they will receive an error message.
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
         JOptionPane.showMessageDialog(null, "The system is full. No more warehouses could be added.");
      }
   }
   public static void deleteWarehouse(Warehouse[] warehouse)
   {
      String warehouseList = "";
      int numWarehouse = Warehouse.getNumWarehouse();
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
   public static void showWarehouse(Warehouse[] warehouse)
   {
      String warehouseList = "Warehouse (ID, Name, State, Number of Products, Prefered?) \n";
      int numWarehouse = Warehouse.getNumWarehouse();
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
   public static void markPreferred(Warehouse[] warehouse)
   {
      int numWarehouse = Warehouse.getNumWarehouse();
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
}