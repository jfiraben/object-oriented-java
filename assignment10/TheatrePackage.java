public class TheatrePackage extends GuestInfo
{
   private static final double THEATRE_RATE = 150;
   private static final double ADD_SHOW_RATE = 25;
   private static final double PREMIUM_RATE = 100;
   private static final int MAX_ADD_SHOW = 2;
   private boolean addShow;
   private boolean premiumShow;
   private int numAddShows;
   private double premiumRate;
   
   public TheatrePackage()
   {
      super();
   }
   
   public boolean getAddShow()
   {
      return this.addShow;
   }
   public boolean getPremiumShow()
   {
      return this.premiumShow;
   }
   public int getNumAddShows()
   {
      return this.numAddShows;
   }
   public double getPremiumRate()
   {
      return this.premiumRate;
   }
   
   public void setAddShow(boolean addShow)
   {
      if(numAddShows >= MAX_ADD_SHOW)
      {
         throw new IllegalArgumentException("You have reached the maximum number of shows allowed");
      }
      if(addShow = true)
      {
         numAddShows++;
      }
      this.addShow = addShow;
   }
   public void setPremiumShow(boolean premiumShow)
   {
      if(premiumShow = true)
      {
         this.premiumRate = PREMIUM_RATE;
      }
      else
      {
         this.premiumRate = 0;
      }
      this.premiumShow = premiumShow;
   }
   
   public double calculateRate()
   {
      double theatreRate =  super.getFlatRate() + THEATRE_RATE + (this.getNumAddShows() * ADD_SHOW_RATE) + this.getPremiumRate();
      
      if(super.getSmoker())
      {
         return theatreRate + (theatreRate * super.getSmokerFee()) + super.calculateRate();
      }
      else
      {
         return theatreRate + super.calculateRate();
      }
   }
   public String toString()
   {
      return "Theatre Package Amount Due: " + this.calculateRate();
   }
}