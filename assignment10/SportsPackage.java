public class SportsPackage extends GuestInfo
{
   private static final double MIN_HOURS = 1;
   private static final double MAX_HOURS = 10;
   private static final double FACILITY_FEE = 75;
   private static final double HOURLY_FEE = 5;
   private int numHours;
   
   private Equipment equipment;
   
   public SportsPackage()
   {
      super();
   }
   public SportsPackage(int numHours, String equipmentType, String[] equipmentList)
   {
      this.numHours = numHours;
      this.equipment = new Equipment(equipmentType, equipmentList);
   }
   
   public int getNumHours()
   {
      return this.numHours;
   }
   public Equipment getEquipment()
   {
      return this.equipment;
   }
   public int getNumEquipment()
   {
      return equipment.getNumEquipment();
   }
   public double getMaxEquipment()
   {
      return equipment.getMaxEquipment();
   }
   public String[] getEquipmentList()
   {
      return equipment.getEquipmentList();
   }
   
   
   public void setEquipment(Equipment equipment)
   {
      this.equipment = equipment;
   }
   public void setEquipmentType(String equipmentType)
   {
      equipment.setEquipmentType(equipmentType);
   }
   public void setNumHours(int numHours)
   {
      if(numHours < MIN_HOURS | numHours > MAX_HOURS)
      {
         throw new IllegalArgumentException("The number of hours must be greater than " + MIN_HOURS + " and less than " + MAX_HOURS);
      }
      this.numHours += numHours;
   }
   
   public double calculateRate()
   {
      double sportsRate = super.getFlatRate() + FACILITY_FEE + (this.numHours * HOURLY_FEE) + (equipment.getNumEquipment() * equipment.getEquipmentFee());
      
      if(super.getSmoker())
      {
         return sportsRate + (sportsRate * super.getSmokerFee()) + super.calculateRate();
      }
      else
      {
         return sportsRate + super.calculateRate();
      }
   }
   public String toString()
   {
      return "Sports Package Amount Due: " + this.calculateRate();
   }
}