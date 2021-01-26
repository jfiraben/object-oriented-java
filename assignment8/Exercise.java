public abstract class Exercise
{
   private static final int MAX_MINS = 175;
   private static final int MIN_MINS = 0;
   private static final int MAX_INTENSITY = 4;
   private static final int MIN_INTENSITY = 1;
   private String day;
   private String dayOfWeek[] = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
   private String dayTracker[];
   private int numMinutes;
   private int intensityLevel;
   private static int numExercise;
   private int numDays = 0;
   
   public Exercise(String day, int numMinutes, int intensityLevel)
   {
      if(day == null | !CheckDay(day))
      {
         throw new IllegalArgumentException("Must enter day of the week. Make sure it is spelled correctly.");
      }
      if(!CheckNumMinutes(numMinutes))
      {
         throw new IllegalArgumentException("Must enter number of minutes for session. Must be more than " + MIN_MINS + " and less than " + MAX_MINS);
      }
      if(!CheckIntensityLevel(intensityLevel))
      {
         throw new IllegalArgumentException("Intensity level must be between " + MIN_INTENSITY + " and " + MAX_INTENSITY);
      }
      this.day = day;
      this.numMinutes = numMinutes;
      this.intensityLevel = intensityLevel;
      ++numExercise;
   }
   
   public String getDay()
   {
      return this.day;
   }
   public int getNumMinutes()
   {
      return this.numMinutes;
   }
   public int getIntensityLevel()
   {
      return this.intensityLevel;
   }
   public static int getNumExercise()
   {
      return numExercise;
   }
   
   public void setDay(String day)
   {
      if(day == null | !CheckDay(day))
      {
         throw new IllegalArgumentException("Must enter day of the week. Make sure it is spelled correctly.");
      }
      this.day = day;
   }
   public void setNumMinutes(int numMinutes)
   {
      if(!CheckNumMinutes(numMinutes))
      {
         throw new IllegalArgumentException("Must enter number of minutes for session. Must be more than " + MIN_MINS + " and less than " + MAX_MINS);
      }
      this.numMinutes = numMinutes;
   }
   public void setIntensityLevel(int intensityLevel)
   {
      if(!CheckIntensityLevel(intensityLevel))
      {
         throw new IllegalArgumentException("Intensity level must be between " + MIN_INTENSITY + " and " + MAX_INTENSITY);
      }
      this.intensityLevel = intensityLevel;
   }
   
   public boolean CheckDay(String day)
   {
      //Runs through name and checks for illegal characters
      for(int x = 0; x < dayOfWeek.length; x++)
      {
         if(day.equalsIgnoreCase(dayOfWeek[x]))
         {
            return true;
         }
      }
      return false;
   }
   public boolean CheckNumMinutes(int numMinutes)
   {
      //Runs through name and checks for illegal characters
      if(numMinutes < MIN_MINS || numMinutes > MAX_MINS)
      {
         return false;
      }
      return true;
   }
   public boolean CheckIntensityLevel(int intensityLevel)
   {
      //Runs through name and checks for illegal characters
      if(intensityLevel < MIN_INTENSITY || intensityLevel > MAX_INTENSITY)
      {
         return false;
      }
      return true;
   }
   public abstract double calculateCalories();
   //Special toString class to assign values of Intern class to String
   public String toString()
   {
      return "Day of the week: " + this.getDay() + "\nNumber of Minutes: " + this.getNumMinutes() + "\nIntensity Level: " + this.getIntensityLevel();
   }
}