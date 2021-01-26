public class Equipment
{
   private static final double MIN_EQUIPMENT = 0;
   private static final double MAX_EQUIPMENT = 9;
   private static final double EQUIPMENT_FEE = 10;
   private static String equipmentType;
   private static String[] equipmentList = {"Elliptical","Treadmill","Indoor Cycling","Climber","Shoulder Press","Seated Row","Bicep/Tricep Curl","Power Rack","Bench Press"};
   private int numEquipment;
   
   public Equipment()
   {
      super();
   }
   public Equipment(String equipmentType, String[] equipmentList)
   {
      if(numEquipment > MAX_EQUIPMENT)
      {
         throw new IllegalArgumentException("You have reached the maximum number of equipment allowed to use: " + MAX_EQUIPMENT);
      }
      this.equipmentType = equipmentType;
   }
   
   public String[] getEquipmentList()
   {
      return this.equipmentList;
   }
   public String getEquipmentType()
   {
      return this.equipmentType;
   }
   public int getNumEquipment()
   {
      return this.numEquipment;
   }
   public double getEquipmentFee()
   {
      return EQUIPMENT_FEE;
   }
   public double getMaxEquipment()
   {
      return MAX_EQUIPMENT;
   }
   
   
   public void setEquipmentType(String equipmentType)
   {
      if(numEquipment > MAX_EQUIPMENT)
      {
         throw new IllegalArgumentException("You have reached the maximum number of equipment allowed to use: " + MAX_EQUIPMENT);
      }
      this.equipmentType = equipmentType;
      ++numEquipment;
   }
}