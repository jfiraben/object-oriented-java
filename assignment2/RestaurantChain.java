/*
Jordan Firaben
09-24-2017
IT 206-204
Programming Assignment 2

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

public class RestaurantChain
{
   public static void main(String[] args)
   {
      //The program will continue to try to make the first restuarant until the addRestaurant method has
      //returned restaurant1.
      boolean restaurantSet = false;
      do 
      {
         try 
         {
            Restaurant restaurant1 = addRestaurant();
            restaurantSet = true;
         }
         
         catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Restaurant could not be created! " + e.getMessage());
         }
      } while (!restaurantSet);
      //The printRestaurantReport method will return a well-formatted report containing everything the user entered.
      printRestaurantReport(Restaurant.getRestaurantName(), Restaurant.getNumberOfEmployee(), Restaurant.getCustomerSeat(), Restaurant.getSaleNumber(), Restaurant.getSaleAmount(), Restaurant.getInsurance());
   }
   //The addRestaurant method will populate the restaurant1 object with several fields.
   public static Restaurant addRestaurant()
   {
      //The Restaurant class is used to create a new Restaurant named restaurant1
      Restaurant restaurant1 = new Restaurant();
      
      /*
      The program will continue to ask the user for the name of the restaurant until something has been entered.
      If something has not been entered, the user will receive an error message stating that the restaurant name
      could not be set and the restaurant must have a name.
      */
      boolean nameSet = false;
      do 
      {
         try 
         {
            restaurant1.setRestaurantName(JOptionPane.showInputDialog("Enter the name of the restaurant: "));
            nameSet = true;
         }
         catch(IllegalArgumentException e) 
         {
            JOptionPane.showMessageDialog(null, "Restaurant name could not be set. " + e.getMessage());
         }
      } while(!nameSet);
      
      /*
      The program will continue to ask the user for the amount of employees at the restaurant. If the user chooses
      the default value of 1, they can entere 0. Otherwise they need to enter a number between 1 and 50. If they do
      not enter a number, they will receive an error message. If they enter a number outside of 1 and 50, they will
      receive an error message.
      */
      boolean employeeSet = false;
      do 
      {
         try 
         {
            restaurant1.setNumberOfEmployee(Integer.parseInt(JOptionPane.showInputDialog("Enter the number of employees at the restaurant. Enter 0 if you want the default number of employees: ")));
            employeeSet = true;
         }
         catch(NumberFormatException e)
         {
            JOptionPane.showMessageDialog(null, "Number of employees could not be set. Must be entered as a number");
         }
         catch(IllegalArgumentException e) 
         {
            JOptionPane.showMessageDialog(null, "Number of employees could not be set. " + e.getMessage());
         }
      } while(!employeeSet);
      
      /*
      The program will continue to ask the user for the number of seats at the restaurant. If the user chooses
      the default value of 14, they can entere 0. Otherwise they need to enter a number between 4 and 100. If they do
      not enter a number, they will receive an error message. If they enter a number outside of 4 and 100, they will
      receive an error message.
      */
      boolean customerSeatSet = false;
      do 
      {
         try 
         {
            restaurant1.setCustomerSeat(Integer.parseInt(JOptionPane.showInputDialog("Enter the number of seats at the restaurant. Enter 0 if you want the default number of seats: ")));
            customerSeatSet = true;
         }
         catch(NumberFormatException e)
         {
            JOptionPane.showMessageDialog(null, "Number of seats could not be set. Must be entered as a number");
         }
         catch(IllegalArgumentException e) 
         {
            JOptionPane.showMessageDialog(null, "Number of seats could not be set. " + e.getMessage());
         }
      } while(!customerSeatSet);
      
      /*
      The program will ask the user if the restaurant has insurance. If the user enters anything other than
      yes or no, they will receive an error. If the user enters nothing, they will receive an error.
      */
      boolean insuranceSet = false;
      do
      {
         try
         {
            restaurant1.setInsurance(JOptionPane.showInputDialog("Does the restaurant have insurance? Enter Yes or No: "));
            insuranceSet = true;
         }
         catch(IllegalArgumentException e) 
         {
            JOptionPane.showMessageDialog(null, "Insurance could not be set. " + e.getMessage());
         }
      } while(!insuranceSet);
      
      /*
      The program will ask for the first sale amount. There must be at least one sale amount for the program
      to continue with the report. If the user enters anything outside of $0.50 and $150, the user will receive
      an error message. If the user does not enter a number, they will receive an error message.
      */
      boolean firstSaleAmountSet = false;
      do
      {
         try
         {
            restaurant1.setSaleAmount(Double.parseDouble(JOptionPane.showInputDialog("Enter sale amount: ")));
            firstSaleAmountSet = true;
         }
         catch(NumberFormatException e)
         {
            JOptionPane.showMessageDialog(null, "Error! Please enter a number.");
         }
         catch(IllegalArgumentException e)
         {
            JOptionPane.showMessageDialog(null, "Sale amount could not be set. " + e.getMessage());
         }
      } while(!firstSaleAmountSet);
      
      /*
      The user will be asked if they'd like to continue entering sales amounts. If they choose no, the program
      will continue on to the report. If they choose yes, the program will ask for the sales amount. The same
      errors will occur if the wrong information is entered, as mentioned above.
      */
      while(JOptionPane.showConfirmDialog(null,"Do you want to continue entering amount of sales?","Amount of sales",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
      {
         try
         {
            restaurant1.setSaleAmount(Double.parseDouble(JOptionPane.showInputDialog("Enter sale amount: ")));
         }
         catch(NumberFormatException e)
         {
            JOptionPane.showMessageDialog(null, "Error! Please enter a number.");
         }
         catch(IllegalArgumentException e)
         {
            JOptionPane.showMessageDialog(null, "Sale amount could not be set. " + e.getMessage());
         }
      }
      //Once the addRestaurant method is finished, it will return the restaurant1 object.
      return restaurant1;
   }
   //The printRestaurantReport method is used to print all of the pertinent information.
   public static void printRestaurantReport(String restaurantName, int numberOfEmployee, int customerSeat, int saleNumber, double saleAmount, boolean insurance) {
      //If a restaurant name has been created, the program will create a report.
      if (restaurantName != null) {
         JOptionPane.showMessageDialog(null, "Restaurant Name: " + restaurantName + "\nNumber of Employees: " + numberOfEmployee + "\nAmount of Seats: " + customerSeat + "\nTotal Number of Sales: " + saleNumber + "\nAmount of Sales: " + String.format("$%.2f", saleAmount) + "\nInsurance? " + (insurance ? "Yes" : "No"));   
      }
      else {
         JOptionPane.showMessageDialog(null, "There are no restaurants!");
      }
   }
}