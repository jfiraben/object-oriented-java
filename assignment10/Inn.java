/*
Jordan Firaben
12-09-2017
IT 206-204
Programming Assignment 10


*/


import javax.swing.JOptionPane;
public class Inn
{
   public static void main(String[] args)
   {
      //The maximum number of days allowed in the array
      final int MAX_GUEST = 555;
      //Exercise array created to hold all of the ResistanceTraining and CardioTraining
      //objects
      GuestInfo guests[] = new GuestInfo[MAX_GUEST];
      //Created an Exercise object used to populate the exercises array
      GuestInfo oneGuest;
      //boolean used to check if the exercises have been set
      boolean guestSet = false;
      
      //DoWhile loop used to populate the Exercise array with ResistanceTraining
      //and CardioTraining objects
      do
      {
         try
         {
            //Uses getNewExercise class to populate oneExercise with the proper object
            oneGuest = getNewGuest();
            //Depending on if it's Resistance Training or Cardio Training, it will use
            //the populateExercise class to populate oneExercise with the right info
            populateGuest(oneGuest);
            //Adds the oneExercise object to the exercises array
            guests[GuestInfo.getNumGuest() - 1] = oneGuest;
            //Allows the user to enter as many exercise sessions as they want (up to 4)
	         //Will only allow one exercise session per day.
            if(JOptionPane.showConfirmDialog(null,"You have entered " + GuestInfo.getNumGuest() + " guest(s)! Would you like to enter another guest?", "Create Guest",JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
            {
               guestSet = true;
            }
            //Once the max number of exercise sessions is reached, show user this message
            if(GuestInfo.getNumGuest() >= MAX_GUEST)
            {
               JOptionPane.showMessageDialog(null,"You have reached the maximum number of guests");
               guestSet = true;
            }
         }
         //Exception for improper information entered
         catch (IllegalArgumentException e)
         {
            JOptionPane.showMessageDialog(null,e.getMessage());
         }
      }while(!guestSet);
      //Print method to print information about all the exercise sessions
      printGuestReport(guests, GuestInfo.getNumGuest());
   }  
   //Asks user if the exercise session they want to describe is Cardio or Resistance Training
   public static GuestInfo getNewGuest()
   {
      //Exercise object created
      GuestInfo guest;
      //Allows user to choose if it is Resistance or Cardio Training
      Object[] options = {"Sports Package", "Academic Package", "Theatre Package"};
      //Assigns the choice above to the exerciseType variable
      int packageType = JOptionPane.showOptionDialog(null,"Please choose what type of package:", "Create Package", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
           
      //Creates either a CardioTraining or ResistanceTraining object based on the choice above
      switch (packageType)
      {
         case 0:
            guest = new SportsPackage();
            break;
         case 1:
            guest = new AcademicPackage();
            break;
         case 2:
            guest = new TheatrePackage();
            break;
         default:
            guest = null;
            break;
      }
      return guest;
   }
   //Used to populate each of the CardioTraining or ResistanceTraining objects based on prior choices
   public static void populateGuest(GuestInfo guest)
   {
      //If the user chose CardioTraining, they will need to enter the day, number of
      //minutes, intensity level, and equipment type
      if(guest instanceof SportsPackage)
      {
         //Empty string to hold the day entered by the user
         String guestName = "";
         //boolean to validate if the proper info has been entered
         boolean guestNameSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               guestName = answerString("Enter the guest name: ");
               //Once it is certain something has been entered, the day will be set for the
               //CardioTraining object using proper validation
               ((SportsPackage)guest).setGuestName(guestName);
               //The day is set once all validations have been passed
               guestNameSet = true;
               
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!guestNameSet);
         EmergencyContact emContact = new EmergencyContact();
         
         //Empty string to hold the day entered by the user
         String emName = "";
         //boolean to validate if the proper info has been entered
         boolean emNameSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               emName = answerString("Enter the emergency contact name: ");
               //Once it is certain something has been entered, the day will be set for the
               //CardioTraining object using proper validation
               emContact.setEmName(emName);
               //The day is set once all validations have been passed
               emNameSet = true;
               
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!emNameSet);
         
         //Empty string to hold the day entered by the user
         String emPhone = "";
         //boolean to validate if the proper info has been entered
         boolean emPhoneSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               emPhone = answerString("Enter the emergency contact phone number: ");
               //Once it is certain something has been entered, the day will be set for the
               //CardioTraining object using proper validation
               emContact.setEmPhone(emPhone);
               //The day is set once all validations have been passed
               emPhoneSet = true;
               
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!emPhoneSet);
         
         //Empty string to hold the day entered by the user
         String emEmail = "";
         //boolean to validate if the proper info has been entered
         boolean emEmailSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               emEmail = answerString("Enter the emergency contact email: ");
               //Once it is certain something has been entered, the day will be set for the
               //CardioTraining object using proper validation
               emContact.setEmEmail(emEmail);
               //The day is set once all validations have been passed
               emEmailSet = true;
               
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!emEmailSet);
         
         //Empty int to hold the number of minutes
         int numDays = 0;
         //Empty string to check for entered information using the answerString method
         String numDaysCheck = "";
         //boolean to validate if the proper info has been entered
         boolean numDaysSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               numDaysCheck = answerString("Enter the number of days you wish to stay at the GMU Innovation Inn: ");
               //Converts the numMinutesCheck string to an int
               numDays = Integer.parseInt(numDaysCheck);
               //Once it is certain something has been entered, the numMinutes will be set for the
               //CardioTraining object using proper validation
               ((SportsPackage)guest).setNumDays(numDays);
               //The numMinutes is set once all validations have been passed
               numDaysSet = true;
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!numDaysSet);
         Object[] options = {"Smoker", "Non-Smoker"};
         //Assigns the choice above to the exerciseType variable
         int smoker = JOptionPane.showOptionDialog(null,"Please choose if the guest is a smoker or non-smoker:", "Smoker?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
              
         //Creates either a CardioTraining or ResistanceTraining object based on the choice above
         switch (smoker)
         {
            case 0:
               ((SportsPackage)guest).setSmoker(true);
               break;
            case 1:
               ((SportsPackage)guest).setSmoker(false);
               break;
            default:
               guest = null;
               break;
         }
         boolean exerciseSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
		         //If the user has entered the maximum number of resistance exercises they will
               //receive an error and the program will move on
               if(((SportsPackage)guest).getNumEquipment() >= ((SportsPackage)guest).getMaxEquipment())
               {
                  exerciseSet = true;
               }
               String[] equipmentList = ((SportsPackage)guest).getEquipmentList();
               Object selection = JOptionPane.showInputDialog(null, "What type of equipment would you like to use for your workout?","Workout Equipment", JOptionPane.DEFAULT_OPTION, null, equipmentList, "0");
               if (selection != null)
               {
                  String equipmentSelection = selection.toString();
                  ((SportsPackage)guest).setEquipmentType(equipmentSelection);
               }
               else
               {
                  throw new IllegalArgumentException("Must select an equipment type");
               }
               double numHours = 0;
               String numHoursCheck = "";
               //boolean to validate if the proper info has been entered
               boolean numHoursSet = false;
               //DoWhile loop will keep asking the user to enter information until the
               //proper information has been entered
               do
               {
                  try
                  {
                     //answerString method used to ensure something is entered
                     numHoursCheck = answerString("How many hours for the equipment?");
                     //Converts the numMinutesCheck string to an int
                     numHours = Double.parseDouble(numHoursCheck);
                     //Once it is certain something has been entered, the numMinutes will be set for the
                     //CardioTraining object using proper validation
                     ((SportsPackage)guest).setNumHours((int)numHours);
                     //The numMinutes is set once all validations have been passed
                     numHoursSet = true;
                  }
                  //Determines if improper info has been entered. Will warn user.
                  catch(IllegalArgumentException e)
                  {
                     JOptionPane.showMessageDialog(null, e.getMessage());
                  }
               }while(!numHoursSet);
               if(JOptionPane.showConfirmDialog(null,"Would you like to enter another type of equipment?", "Equipment Rental",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
               {
                  //Will keep boolean at false to ask user again if they’d like to enter an exercise
                  exerciseSet = false;
               }
               //Will end the DoWhile loop if the user enters no for the previous question
               else
               {
                  exerciseSet = true;
               }
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!exerciseSet);
      }
      //If the user chose ResistanceTraining, they will need to enter the day, number of
      //minutes, intensity level, and type of exercise
      if(guest instanceof AcademicPackage)
      {
         //Empty string to hold the day entered by the user
         String guestName = "";
         //boolean to validate if the proper info has been entered
         boolean guestNameSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               guestName = answerString("Enter the guest name: ");
               //Once it is certain something has been entered, the day will be set for the
               //CardioTraining object using proper validation
               ((AcademicPackage)guest).setGuestName(guestName);
               //The day is set once all validations have been passed
               guestNameSet = true;
               
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!guestNameSet);
         
         EmergencyContact emContact = new EmergencyContact();
         //Empty string to hold the day entered by the user
         String emName = "";
         //boolean to validate if the proper info has been entered
         boolean emNameSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               emName = answerString("Enter the emergency contact name: ");
               //Once it is certain something has been entered, the day will be set for the
               //CardioTraining object using proper validation
               emContact.setEmName(emName);
               //The day is set once all validations have been passed
               emNameSet = true;
               
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!emNameSet);
         
         //Empty string to hold the day entered by the user
         String emPhone = "";
         //boolean to validate if the proper info has been entered
         boolean emPhoneSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               emPhone = answerString("Enter the emergency contact phone number: ");
               //Once it is certain something has been entered, the day will be set for the
               //CardioTraining object using proper validation
               emContact.setEmPhone(emPhone);
               //The day is set once all validations have been passed
               emPhoneSet = true;
               
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!emPhoneSet);
         
         //Empty string to hold the day entered by the user
         String emEmail = "";
         //boolean to validate if the proper info has been entered
         boolean emEmailSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               emEmail = answerString("Enter the emergency contact email: ");
               //Once it is certain something has been entered, the day will be set for the
               //CardioTraining object using proper validation
               emContact.setEmEmail(emEmail);
               //The day is set once all validations have been passed
               emEmailSet = true;
               
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!emEmailSet);
         
         //Empty int to hold the number of minutes
         int numDays = 0;
         //Empty string to check for entered information using the answerString method
         String numDaysCheck = "";
         //boolean to validate if the proper info has been entered
         boolean numDaysSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               numDaysCheck = answerString("Enter the number of days you wish to stay at the GMU Innovation Inn: ");
               //Converts the numMinutesCheck string to an int
               numDays = Integer.parseInt(numDaysCheck);
               //Once it is certain something has been entered, the numMinutes will be set for the
               //CardioTraining object using proper validation
               ((AcademicPackage)guest).setNumDays(numDays);
               //The numMinutes is set once all validations have been passed
               numDaysSet = true;
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!numDaysSet);
         Object[] options = {"Smoker", "Non-Smoker"};
         //Assigns the choice above to the exerciseType variable
         int smoker = JOptionPane.showOptionDialog(null,"Please choose if the guest is a smoker or non-smoker:", "Smoker?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
              
         //Creates either a CardioTraining or ResistanceTraining object based on the choice above
         switch (smoker)
         {
            case 0:
               ((AcademicPackage)guest).setSmoker(true);
               break;
            case 1:
               ((AcademicPackage)guest).setSmoker(false);
               break;
            default:
               guest = null;
               break;
         }
         Object[] printOptions = {"Yes", "No"};
         //Assigns the choice above to the exerciseType variable
         int print = JOptionPane.showOptionDialog(null,"Would you like to have lecture materials printed for $50 extra?", "Lecture Materials", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, printOptions, printOptions[0]);
              
         //Creates either a CardioTraining or ResistanceTraining object based on the choice above
         switch (print)
         {
            case 0:
               ((AcademicPackage)guest).setLecturePrint(true);
               break;
            case 1:
               ((AcademicPackage)guest).setLecturePrint(false);
               break;
            default:
               guest = null;
               break;
         }
      }
      if(guest instanceof TheatrePackage)
      {
         //Empty string to hold the day entered by the user
         String guestName = "";
         //boolean to validate if the proper info has been entered
         boolean guestNameSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               guestName = answerString("Enter the guest name: ");
               //Once it is certain something has been entered, the day will be set for the
               //CardioTraining object using proper validation
               ((TheatrePackage)guest).setGuestName(guestName);
               //The day is set once all validations have been passed
               guestNameSet = true;
               
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!guestNameSet);
         
         EmergencyContact emContact = new EmergencyContact();
         //Empty string to hold the day entered by the user
         String emName = "";
         //boolean to validate if the proper info has been entered
         boolean emNameSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               emName = answerString("Enter the emergency contact name: ");
               //Once it is certain something has been entered, the day will be set for the
               //CardioTraining object using proper validation
               emContact.setEmName(emName);
               //The day is set once all validations have been passed
               emNameSet = true;
               
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!emNameSet);
         
         //Empty string to hold the day entered by the user
         String emPhone = "";
         //boolean to validate if the proper info has been entered
         boolean emPhoneSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               emPhone = answerString("Enter the emergency contact phone number: ");
               //Once it is certain something has been entered, the day will be set for the
               //CardioTraining object using proper validation
               emContact.setEmPhone(emPhone);
               //The day is set once all validations have been passed
               emPhoneSet = true;
               
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!emPhoneSet);
         
         //Empty string to hold the day entered by the user
         String emEmail = "";
         //boolean to validate if the proper info has been entered
         boolean emEmailSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               emEmail = answerString("Enter the emergency contact email: ");
               //Once it is certain something has been entered, the day will be set for the
               //CardioTraining object using proper validation
               emContact.setEmEmail(emEmail);
               //The day is set once all validations have been passed
               emEmailSet = true;
               
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!emEmailSet);
         
         //Empty int to hold the number of minutes
         int numDays = 0;
         //Empty string to check for entered information using the answerString method
         String numDaysCheck = "";
         //boolean to validate if the proper info has been entered
         boolean numDaysSet = false;
         //DoWhile loop will keep asking the user to enter information until the
         //proper information has been entered
         do
         {
            try
            {
               //answerString method used to ensure something is entered
               numDaysCheck = answerString("Enter the number of days you wish to stay at the GMU Innovation Inn: ");
               //Converts the numMinutesCheck string to an int
               numDays = Integer.parseInt(numDaysCheck);
               //Once it is certain something has been entered, the numMinutes will be set for the
               //CardioTraining object using proper validation
               ((TheatrePackage)guest).setNumDays(numDays);
               //The numMinutes is set once all validations have been passed
               numDaysSet = true;
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!numDaysSet);
         Object[] options = {"Smoker", "Non-Smoker"};
         //Assigns the choice above to the exerciseType variable
         int smoker = JOptionPane.showOptionDialog(null,"Please choose if the guest is a smoker or non-smoker:", "Smoker?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
              
         //Creates either a CardioTraining or ResistanceTraining object based on the choice above
         switch (smoker)
         {
            case 0:
               ((TheatrePackage)guest).setSmoker(true);
               break;
            case 1:
               ((TheatrePackage)guest).setSmoker(false);
               break;
            default:
               guest = null;
               break;
         }
         boolean showSet = false;
         do
         {
            try
            {
		         Object[] showOptions = {"Yes", "No"};
               //Assigns the choice above to the exerciseType variable
               int show = JOptionPane.showOptionDialog(null,"Would you like to add a show for $25 extra?", "Lecture Materials", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, showOptions, showOptions[0]);
                    
               //Creates either a CardioTraining or ResistanceTraining object based on the choice above
               switch (show)
               {
                  case 0:
                     ((TheatrePackage)guest).setAddShow(true);
                     break;
                  case 1:
                     showSet = true;
                     break;
                  default:
                     guest = null;
                     break;
               }
            }
            //Determines if improper info has been entered. Will warn user.
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!showSet);
         Object[] premiumOptions = {"Yes", "No"};
         //Assigns the choice above to the exerciseType variable
         int premium = JOptionPane.showOptionDialog(null,"Would you like to have premium seating for $100 extra?", "Premium Seating", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, premiumOptions, premiumOptions[0]);
               
         //Creates either a CardioTraining or ResistanceTraining object based on the choice above
         switch (premium)
         {
            case 0:
               ((TheatrePackage)guest).setPremiumShow(true);
               break;
            case 1:
               ((TheatrePackage)guest).setPremiumShow(false);
               break;
            default:
               guest = null;
               break;
         }
      }
   }
   //If user does not enter anything, user will be warned and asked
   //to enter info again
   public static String answerString(String prompt)
   {
      String answerString = "";
      do
      {
         answerString = JOptionPane.showInputDialog(prompt);
         if(answerString.trim().equals(""))
         {
            JOptionPane.showMessageDialog(null,"Please enter a value");
         }
      }while(answerString.trim().equals(""));
      return answerString;
   }
   //Method used to calculate the total number of calories burned from all exercises during the week
   public static double getTotalRate(GuestInfo[] guests, int numGuest)
   {
      double totalRate = 0;
      //For loop to run through and get all the calories burned per day
      for(int x = 0; x < numGuest; x++)
      {
         totalRate += guests[x].calculateRate();
      }
      return totalRate;
   }
   //Used to print all information about all exercises entered. Will print the
   //total amount of calories burned for the week at the end of the report
   public static void printGuestReport(GuestInfo[] guests, int numGuest)
   {
      if(numGuest > 0)
      {
         String report = "<html><b><u>GMU Innovation Inn Guests</u></b></html>\n";
         double totalRate = getTotalRate(guests, numGuest);
         
         for(int x = 0; x < numGuest; x++)
         {
            report += x + 1 + ") " + guests[x].toString() + "\n\n";
         }
         report += "\n\nTotal fees for all guests: " + totalRate;
         JOptionPane.showMessageDialog(null,report);
      }
      //User will be informed if no exercises have been entered
      else
      {
         JOptionPane.showMessageDialog(null,"There are no exercises!");
      }
   }
}