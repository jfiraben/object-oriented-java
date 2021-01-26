public class EmergencyContact extends GuestInfo
{
   private String emName;
   private String emPhone;
   private String emEmail;
   
   //Constructor Methods
   public EmergencyContact()
   {
      super();
   }
   public EmergencyContact(String emName, String emPhone, String emEmail)
   {
      if(emName == null | !CheckEmName(emName))
      {
         throw new IllegalArgumentException("Must enter an emergency contact name.");
      }
      if(emPhone == null | !CheckEmPhone(emPhone))
      {
         throw new IllegalArgumentException("Must enter an emergency contact phone number.");
      }
      if(emEmail == null | !CheckEmEmail(emEmail))
      {
         throw new IllegalArgumentException("Must enter an emergency contact email address.");
      }
      this.emName = emName;
      this.emPhone = emPhone;
      this.emEmail = emEmail;
   }
   public EmergencyContact(EmergencyContact emContact)
   {
      this.emName = emContact.getEmName();
      this.emPhone = emContact.getEmPhone();
      this.emEmail = emContact.getEmEmail();
   }
   
   //Accessor Methods
   public String getEmName()
   {
      return this.emName;
   }
   public String getEmPhone()
   {
      return this.emPhone;
   }
   public String getEmEmail()
   {
      return this.emEmail;
   }
      
   //Mutator Methods
   public void setEmName(String emName)
   {
      if(emName == null)
      {
         throw new IllegalArgumentException("Must enter emergency contact name.");
      }
      if(!CheckEmName(emName))
      {
         throw new IllegalArgumentException("Name can only contain letters, dashes, and apostrophes");
      }
      this.emName = emName;
   }
   public void setEmPhone(String emPhone)
   {
      if(emPhone == null)
      {
         throw new IllegalArgumentException("Must enter emergency contact phone.");
      }
      if(!CheckEmPhone(emPhone))
      {
         throw new IllegalArgumentException("Emergency contact phone must be entered as (xxx) xxx-xxxx where each x must be a digit, such as (571) 123-3456]");
      }
      this.emPhone = emPhone;
   }
   public void setEmEmail(String emEmail)
   {
      if(emEmail == null)
      {
         throw new IllegalArgumentException("Must enter emergency contact email.");
      }
      if(!CheckEmEmail(emEmail))
      {
         throw new IllegalArgumentException("Emergency contact email must be entered as containing only one @ sign and only one period – where the @ sign appears prior to the period and there exists at least one letter or digit: before the @ sign, in between the @ sign and the period, and after the period, such as bsit@gmu.edu");
      }
      this.emEmail= emEmail;
   }
      
   //Special methods to check if info is entered correctly
   public boolean CheckEmName(String emName)
   {
      if(emName.length() < 3)
      {
         throw new IllegalArgumentException("Name must be at least 2 characters");
      }
      //Runs through name and checks for illegal characters
      for(int x = 0; x < emName.length(); x++)
      {
         char ch = emName.charAt(x);
         
         if('a'<=ch && ch<='z') continue;
         if('A'<=ch && ch<='Z') continue;
         if(ch=='\'') continue;
         if(ch=='-') continue;
         
         return false;
      }
      return true;
   }
   public boolean CheckEmPhone(String emPhone)
   {
      if(emPhone.length() < 14 | emPhone.length() > 14)
      {
         throw new IllegalArgumentException("Phone number must be 14 characters entered as (xxx) xxx-xxxx");
      }
      //Runs through name and checks for illegal characters
      for(int x = 0; x < emPhone.length(); x++)
      {
         char ch = emPhone.charAt(x);
         
         if(x == 0)
         {
             if (!String.valueOf(ch).equals("("))
             {
               return false;
             }
         }
         if(x == 4)
         {
            if(!String.valueOf(ch).equals(")"))
            {
               return false;
            }
         }
         if(x == 5)
         {
            if(!String.valueOf(ch).equals(" "))
            {
               return false;
            }
         }
         if(x == 9)
         {
            if(!String.valueOf(ch).equals("-"))
            {
               return false;
            }
         }
      }
      try  
      {  
         for(int x = 0; x < emPhone.length(); x++)
         {
            char ch = emPhone.charAt(x);
            
            if(x == 1 || x == 2 || x == 3 || x == 6 || x == 7 || x == 8 || x == 10 || x == 11 || x == 12 || x == 13)
            {
               double digit = Double.parseDouble(String.valueOf(ch));
            } 
         } 
      }  
      catch(NumberFormatException e)  
      {  
         return false;  
      }
      return true;
   }
   public boolean CheckEmEmail(String emEmail)
   {
      int atIndex = 0;
      int periodIndex = 0;
      int atCount = 0;
      int periodCount = 0;
      //Used to find where the @ and . are in the email
      //If there are more than 1 @ or . sign, will throw error
      for(int x = 0; x < emEmail.length(); x++)
      {
         char ch = emEmail.charAt(x);
         if(ch=='@')
         {
            atIndex = x;
            atCount++;
         }
         if(ch=='.')
         {
            periodIndex = x;
            periodCount++;
         }
         if(periodCount > 1 || atCount > 1)
         {
            return false;
         }
      }
      //If the . is before the @ sign, will throw error
      if(periodIndex < atIndex)
      {
         return false;
      }
      //Assigns values for each part of email
      String beforeAt = emEmail.substring(0,atIndex);
      String afterAt = emEmail.substring(atIndex + 1,periodIndex);
      String afterPeriod = emEmail.substring(periodIndex + 1);
      //If any part is less than 1, will throw error
      if(beforeAt.length() < 1 || afterAt.length() < 1 || afterPeriod.length() < 1)
      {
         return false;
      }
      return true;
   }
   
   public String toString()
   {
      return this.getEmName() + this.getEmPhone() + this.getEmEmail();
   }
}