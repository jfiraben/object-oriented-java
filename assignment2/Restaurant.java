public class Restaurant
{
   //The private variable have all been created. They will be used throughout Restaurant
   
   private static String restaurantName;
   private static int numberOfEmployee;
   private static double saleAmount;
   private static int saleNumber;
   private static boolean insurance;
   private static int customerSeat;
   
   //Several minimum and maximums have been hard-coded.
   private static final double MIN_SALE_AMOUNT = 0.50;
   private static final double MAX_SALE_AMOUNT = 150.00;
   private static final int MIN_NUMBER_EMPLOYEE = 1;
   private static final int MAX_NUMBER_EMPLOYEE = 50;
   private static final int MIN_CUSTOMER_SEAT = 4;
   private static final int MAX_CUSTOMER_SEAT = 100;
   
   //Several constructors including a default constructor for the number of employees
   //and number of seats.
   public Restaurant(String restaurantName) 
   {
      this.restaurantName = restaurantName;
   }
   public Restaurant()
   {
      this.numberOfEmployee = 1;
      this.customerSeat = 14;
   }
   public Restaurant(int numberOfEmployee, int customerSeat)
   {
      this.numberOfEmployee = numberOfEmployee;
      this.customerSeat = customerSeat;
   }
   
   //Several accessor methods to return the correct instance variables
   public static String getRestaurantName()
   {
      return restaurantName;
   }
   public static int getNumberOfEmployee()
   {
      return numberOfEmployee;
   }
   public static double getSaleAmount()
   {
      return saleAmount;
   }
   public static int getSaleNumber()
   {
      return saleNumber;
   }
   public static boolean getInsurance()
   {
      return insurance;
   }
   public static int getCustomerSeat()
   {
      return customerSeat;
   }
   //Several mutator methods to set the instance variables.
   public void setRestaurantName(String restaurantName)
   {
      //If the user does not enter anything, they will receive an error.
      if (restaurantName == null || restaurantName.equals("")) {
         throw new IllegalArgumentException("Restaurant must have a name");
      }
      this.restaurantName = restaurantName;
   }
   public void setNumberOfEmployee(int numberOfEmployee)
   {
      //If the user enters 0, they will make the number of employees the default
      //value of 1.
      if(numberOfEmployee == 0)
      {
         numberOfEmployee = 1;
      }
      //If the user enters anything too high or low, they will receive an error.
      else if(numberOfEmployee < MIN_NUMBER_EMPLOYEE || numberOfEmployee > MAX_NUMBER_EMPLOYEE)
      {
         throw new IllegalArgumentException("The number of employees must be between " + MIN_NUMBER_EMPLOYEE + " and " + MAX_NUMBER_EMPLOYEE);
      }
      this.numberOfEmployee = numberOfEmployee;
   }
   public void setSaleAmount(double saleAmount)
   {
      //If the user enters anything too high or low, they will receive an error.
      if(saleAmount < MIN_SALE_AMOUNT || saleAmount > MAX_SALE_AMOUNT)
      {
         throw new IllegalArgumentException("The sale amount must be between " + String.format("$%.2f", MIN_SALE_AMOUNT) + " and " + String.format("$%.2f", MAX_SALE_AMOUNT));
      }
      this.saleAmount += saleAmount;
      //Used to keep track of the amount of sales made.
      ++saleNumber;
   }
   public void setInsurance(String insuranceAnswer)
   {
      if(insuranceAnswer.equalsIgnoreCase("yes"))
      {
         this.insurance = true;
      }
      else if (insuranceAnswer.equalsIgnoreCase("no"))
      {
         this.insurance = false;
      }
      //If the user enters anything other than yes or no, they will receive an error.
      else
      {
         throw new IllegalArgumentException("Please enter either 'yes' or 'no'");
      }
   }
   public void setCustomerSeat(int customerSeat)
   {
      //If the user chooses the default value, they will set the amount of seats
      //to 14.
      if(customerSeat == 0)
      {
         customerSeat = 14;
      }
      //If the user enters anything too high or low, they will receive an error.
      else if(customerSeat < MIN_CUSTOMER_SEAT || customerSeat > MAX_CUSTOMER_SEAT)
      {
         throw new IllegalArgumentException("The number of seats must be between " + MIN_CUSTOMER_SEAT + " and " + MAX_CUSTOMER_SEAT);
      }
      this.customerSeat = customerSeat;
   }
   //Special purpose method to return a string representation of the object.
   public String toString()
   {
      return this.getRestaurantName() + "   " + this.getNumberOfEmployee() + "   " + this.getCustomerSeat() + "   " + this.saleNumber + "   " + this.getSaleAmount() + "   " + this.getInsurance();
   }
}