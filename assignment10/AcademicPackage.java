public class AcademicPackage extends GuestInfo
{
   private static final double ACADEMIC_RATE = 206;
   private static final double PRINT_FEE = 50;
   private boolean lecturePrint;
   private double printFee;
   
   public AcademicPackage()
   {
      super();
   }
   
   public boolean getLecturePrint()
   {
      return this.lecturePrint;
   }
   public double getPrintFee()
   {
      return this.printFee;
   }
   
   public void setLecturePrint(boolean lecturePrint)
   {
      if(lecturePrint = true)
      {
         printFee = PRINT_FEE;
      }
      else
      {
         printFee = 0;
      }
      this.lecturePrint = lecturePrint;
   }
   
   public double calculateRate()
   {
      double academicRate = super.getFlatRate() + ACADEMIC_RATE + this.getPrintFee();
      
      if(super.getSmoker())
      {
         return academicRate + (academicRate * super.getSmokerFee()) + super.calculateRate();
      }
      else
      {
         return academicRate + super.calculateRate();
      }
   }
   public String toString()
   {
      return "Academic Package Amount Due: " + this.calculateRate();
   }
}