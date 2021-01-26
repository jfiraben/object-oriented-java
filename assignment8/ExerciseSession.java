import javax.swing.JOptionPane;
public class ExerciseSession
{
   public static void main(String[] args)
   {
      final int MAX_NUM_DAYS = 4;
      //Intern array created to hold all of the RegularIntern and ResearchIntern
      //objects
      Exercise exercises[] = new Exercise[MAX_NUM_DAYS];
      Exercise oneExercise; 
      boolean exerciseSet = false;
      int numDays = 1;
      
      //DoWhile loop used to populate the interns array with RegularIntern
      //and ResearchIntern objects
      do
      {
         try
         {
            //Uses getNewIntern class to populate oneIntern with the proper object
            oneExercise = getNewExercise(numDays);
            //Depending on if it's a RegularIntern or Research Intern, it will use
            //the populateIntern class to populate oneIntern with the right info
            populateExercise(oneExercise);
            //Adds the oneIntern object to the interns array
            exercises[Exercise.getNumExercise() - 1] = oneExercise;
            //Allows the user to enter as many interns as they want (up to 12)
            if(JOptionPane.showConfirmDialog(null,"Would you like to enter another exercise?", "Create Exercise",JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
            {
               exerciseSet = true;
            }
            //Once the max number of interns is reached, show user this message
            if(Exercise.getNumExercise() >= MAX_NUM_DAYS)
            {
               JOptionPane.showMessageDialog(null,"You have reached the maximum number of exercises");
               exerciseSet = true;
            }
         }
         //Exception for improper information entered
         catch (IllegalArgumentException e)
         {
            JOptionPane.showMessageDialog(null,"Exercise could not be created\n" + e.getMessage());
         }
      }while(!exerciseSet);
      //Print method to print information about all the interns
      printExerciseReport(exercises, Exercise.getNumExercise());
   }  
   //Asks user for the name, school, and email of the intern. Will determine
   //what type of intern it is with user input
   public static Exercise getNewExercise(int numDays)
   {
      //Intern object created
      Exercise exercise;
      //Allows user to choose if it is a regular or research intern
      Object[] options = {"Cardiovascular Training", "Resistance Training"};
      String[] dayChecker = {"","","",""};
      //Assigns the choice above to the internType variable
      int exerciseType = JOptionPane.showOptionDialog(null,"It's winter break and we need to get in shape.\nPlease choose what type of Exercise:", "Create Exercise", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
      //Asks user for the name, school, and email of the intern
      String dayOfWeek = "";
      String dayOfWeekError = "";
      boolean dayOfWeekSet = false;
      do
      {
         try
         {
            dayOfWeek = answerString("Enter the day of the week: ");
            dayOfWeek = checkDays(dayOfWeek,dayChecker,numDays);
            dayOfWeekSet = true;
            
         }
         //Determines if improper info has been entered. Will warn user.
         catch(IllegalArgumentException e)
         {
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
      }while(!dayOfWeekSet);
      
      int numMinutes = 0;
      String numMinutesCheck = "";
      boolean numMinutesSet = false;
      do
      {
         try
         {
            numMinutesCheck = answerString("Enter the number of minutes for exercise: ");
            numMinutes = Integer.parseInt(numMinutesCheck);
            numMinutesSet = true;
         }
         //Determines if improper info has been entered. Will warn user.
         catch(IllegalArgumentException e)
         {
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
      }while(!numMinutesSet);
      
      int intensityLevel = 0;
      String intensityLevelCheck = "";
      boolean intensityLevelSet = false;
      do
      {
         try
         {
            intensityLevelCheck = answerString("Enter the intensity level of the exercise: ");
            intensityLevel = Integer.parseInt(intensityLevelCheck);
            intensityLevelSet = true;
         }
         //Determines if improper info has been entered. Will warn user.
         catch(IllegalArgumentException e)
         {
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
      }while(!intensityLevelSet);
      
      //Uses the internType variable to assign name, school, and email
      //to either the regular or research intern object
      switch (exerciseType)
      {
         case 0:
            exercise = new CardioTraining(dayOfWeek, numMinutes, intensityLevel);
            break;
         case 1:
            exercise = new ResistanceTraining(dayOfWeek, numMinutes, intensityLevel);
            break;
         default:
            exercise = null;
            break;
      }
      return exercise;
   }
   //After the name, school, and email have been entered, the rest of the data
   //must be entered about the interns
   public static void populateExercise(Exercise exercise)
   {
      //The regular intern will have a department name and hours wanted
      if(exercise instanceof CardioTraining)
      {
         //Asks for department names until user is finished or it has reached the
         //max number of departments
         boolean equipmentTypeSet = false;
         do
         {
            try
            {
               ((CardioTraining)exercise).setEquipmentType(answerString("Enter the equipment type:"));
               equipmentTypeSet = true;
            }
            //Will warn user if improper info has been entered
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null,e.getMessage());
            }
         }while(!equipmentTypeSet);
      }
      //The research intern will have the department names, hours wanted, number of
      //years experience, and research areas intern has knowledge with
      if(exercise instanceof ResistanceTraining)
      {
         //Same as above
         boolean exerciseSet = false;
         do
         {
            try
            {
               ((ResistanceTraining)exercise).setExercise(answerString("Enter the exercise name: "));
               if(JOptionPane.showConfirmDialog(null,"Would you like to enter a type of exercise?", "Exercise Name",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
               {
                  exerciseSet = false;
               }
               else
               {
                  exerciseSet = true;
               }
            }
            catch(IllegalArgumentException e)
            {
               JOptionPane.showMessageDialog(null, e.getMessage());
            }
         }while(!exerciseSet);
      }
   }
   public static String checkDays(String day, String[] dayChecker, int numDays)
   {
      dayChecker[numDays] = day;
      boolean daySet = false;
      do
      {
         for(int x = 0; x < dayChecker.length; x++)
         {
            if(day.equalsIgnoreCase(dayChecker[x]))
            {
               JOptionPane.showMessageDialog(null,"You have already entered that day");
            }
            else
            {
               ++numDays;
               daySet = true;
            }
         }
      }while(!daySet);
      String dayCheck = "";
      for(int x = 0; x < dayChecker.length; x++)
      {
         dayCheck = dayChecker[x] + ",";
      }
      JOptionPane.showMessageDialog(null,dayCheck);
      return day;
      
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
   //Used to print all information about all interns entered. Will print the
   //total amount of pay for all interns at the end of the report
   public static void printExerciseReport(Exercise[] exercises, int numExercise)
   {
      if(numExercise > 0)
      {
         String report = "<html><b><u>EXERCISE SESSIONS</u></b></html>\n";
         double totalCalories = 0;
         
         for(int x = 0; x < numExercise; x++)
         {
            totalCalories += exercises[x].calculateCalories();
            report += x + 1 + ") " + exercises[x].toString() + "\n\n";
         }
         report += "\n\nTotal calories burned: " + totalCalories;
         JOptionPane.showMessageDialog(null,report);
      }
      //User will be informed if no interns have been entered
      else
      {
         JOptionPane.showMessageDialog(null,"There are no exercises!");
      }
   }
}