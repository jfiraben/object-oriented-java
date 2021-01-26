public class ResistanceTraining extends Exercise
{
   private static final int MAX_RESISTANCE = 9;
   private static final double CALORIE_MULTIPLIER = 112;
   private String exercise;
   private String exerciseList="";
   private int numResistance;
   
   public ResistanceTraining(String day, int numMinutes, int intensityLevel)
   {
      super(day,numMinutes,intensityLevel);
   }
   
   public String getExercise()
   {
      return this.exercise;
   }
   
   public void setExercise(String exercise)
   {
      if(numResistance >= MAX_RESISTANCE)
      {
         throw new IllegalArgumentException("You have reaced the maximum number of exercises at " + MAX_RESISTANCE);
      }
      if(exercise == null | exercise == "")
      {
         throw new IllegalArgumentException("You must enter a exercise");
      }
      ++numResistance;
      this.exercise = exercise;
      this.exerciseList += exercise + ", ";
   }
   
   public double calculateCalories()
   {
      return this.numResistance * CALORIE_MULTIPLIER;
   }
   public String toString()
   {
      String exerciseList = this.exerciseList;
      exerciseList = exerciseList.replaceAll(", $", "");
      this.exerciseList = exerciseList;
      return "Resistance Training: \n" + super.toString() + "\nExercise List: " + this.exerciseList + "\nNumber of Exercises: " + this.numResistance + "\nCalories Burned: " + this.calculateCalories();
   }
}