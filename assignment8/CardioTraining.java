public class CardioTraining extends Exercise
{
   private static final double CALORIE_MULTIPLIER = 8;
   private String equipmentType;
   
   public CardioTraining(String day, int numMinutes, int intensityLevel)
   {
      super(day,numMinutes,intensityLevel);
   }
   
   public String getEquipmentType()
   {
      return this.equipmentType;
   }
   
   public void setEquipmentType(String equipmentType)
   {
      if(equipmentType == null)
      {
         throw new IllegalArgumentException("You must enter an equipment type");
      }
      this.equipmentType = equipmentType;
   }
   
   public double calculateCalories()
   {
      return super.getNumMinutes() * CALORIE_MULTIPLIER;
   }
   public String toString()
   {
      return "Cardiovascular Training: \n" + super.toString() + "\nEquipment Type: " + this.equipmentType + "\nCalories Burned: " + this.calculateCalories();
   }
}