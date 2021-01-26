public class GuestInfo
{
   private static final int MAX_GUEST = 555;
   private static final int MAX_STAY = 50;
   private static final int MIN_STAY = 0;
   private static final double FLAT_RATE = 45;
   private static int guestNum = 100000;
   private String guestID = "G" + guestNum;
   private String guestName;
   private int numDays;
   private boolean smoker;
   private static final double SMOKER_FEE = .10;
   private String emName;
   private String emPhone;
   private String emEmail;
   private static int numGuest;
   
   private EmergencyContact emContact;
   
   //Constructor Methods
   public GuestInfo()
   {
      ++numGuest;
   }
   public GuestInfo(String guestName, EmergencyContact emContact, int numDays, boolean smoker)
   {
      if(guestName == null | !CheckGuestName(guestName))
      {
         throw new IllegalArgumentException("Must enter guest name.");
      }
      if(emContact == null | emContact.equals(""))
      {
         throw new IllegalArgumentException("Must enter emergency contact.");
      }
      if(!CheckNumDays(numDays))
      {
         throw new IllegalArgumentException("Must enter the number of days guest will be staying.");
      }
      this.guestName = guestName;
      this.emContact = emContact;
      this.numDays = numDays;
      this.smoker = smoker;
      ++numGuest;
   }
   public GuestInfo(GuestInfo g)
   {
      this.guestName = g.getGuestName();
      this.emContact = g.getEmContact();
      this.numDays = g.getNumDays();
      this.smoker = g.getSmoker();
   }
   
   //Accessor Methods
   public String getGuestName()
   {
      return this.guestName;
   }
   public EmergencyContact getEmContact()
   {
      return this.emContact;
   }
   public int getNumDays()
   {
      return this.numDays;
   }
   public boolean getSmoker()
   {
      return this.smoker;
   }
   public static int getNumGuest()
   {
      return numGuest;
   }
   public String getGuestID()
   {
      return this.guestID;
   }
   public double getFlatRate()
   {
      return FLAT_RATE;
   }
   public double getSmokerFee()
   {
      return SMOKER_FEE;
   }
      
   //Mutator Methods
   public void setGuestName(String guestName)
   {
      if(guestName == null)
      {
         throw new IllegalArgumentException("Must enter guest name.");
      }
      if(!CheckGuestName(guestName))
      {
         throw new IllegalArgumentException("Name can only contain letters, dashes, and apostrophes");
      }
      this.guestName = guestName;
   }
   public void setEmName(String emName)
   {
      emContact.setEmName(emName);
   }
   public void setEmPhone(String emPhone)
   {
      emContact.setEmPhone(emPhone);
   }
   public void setEmEmail(String emEmail)
   {
      emContact.setEmEmail(emEmail);
   }
   public void setNumDays(int numDays)
   {
      if(!CheckNumDays(numDays))
      {
         throw new IllegalArgumentException("The number of days must be more than " + MIN_STAY + " and less than " + MAX_STAY);
      }
      this.numDays = numDays;
   }
   public void setSmoker(boolean smoker)
   {
      this.smoker = smoker;
   }
   
   //Special methods to check if info is entered correctly
   public boolean CheckGuestName(String guestName)
   {
      if(guestName.length() < 3)
      {
         throw new IllegalArgumentException("Name must be at least 2 characters");
      }
      //Runs through name and checks for illegal characters
      for(int x = 0; x < guestName.length(); x++)
      {
         char ch = guestName.charAt(x);
         
         if('a'<=ch && ch<='z') continue;
         if('A'<=ch && ch<='Z') continue;
         if(ch=='\'') continue;
         if(ch=='-') continue;
         
         return false;
      }
      return true;
   }
   public boolean CheckNumDays(int numDays)
   {
      if(numDays <= MIN_STAY || numDays >= MAX_STAY)
      {
         throw new IllegalArgumentException("The number of days must be greater than " + MIN_STAY + " and less than " + MAX_STAY);
      }
      return true;
   }
   
   public double calculateRate()
   {
      return FLAT_RATE;
   }
   
   public String toString()
   {
      return this.getGuestName() + emContact.toString() + this.getNumDays() + this.getSmoker();
   }
}