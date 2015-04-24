/*
 * This is the Faction sub class
 * The class tracks the income, research, saved bank, and whether or not the faction has been defeated
 * Available factions: 0 - Russia, 1 - Germany, 2 - UK, 3 - Japan, 4 - US
 */
package axisandallies;
import java.util.*;

public class Faction{
   private static final int MAX_RESEARCH = 6;
   private static final int MAX_FACTION = 4; //Factions 0-4
   private static final int MIN_FACTION = 0;
   private static final int MIN_BANK = 0;
   private static final int MIN_INCOME = 0;
   private static final int MAX_INCOME = 63;
   private int faction, playerID;
   private int playerBank = 0;
   private int income = 0;
   private Random rand = new Random();
   private boolean[] research = new boolean[] {false, false, false,
      false, false, false};
   
   public Faction()
   {
      setFaction(0);
      setPlayerID(0);
      increasePlayerBank(0);
      increaseIncome(0);
   }
   /**
    * Constructor for the faction class
    * @param faction which faction is this instance of the class
    * @param playerID the playerID playing this class
    * @param bank the number of IPCs the player has
    * @param income the current income of the player
    */
   public Faction(int faction, int playerID, int bank, int income)
   {
      setFaction(faction);
      setPlayerID(playerID);
      increasePlayerBank(bank);
      increaseIncome(income);
   }
   
   
   //gets the faction ID
   public int getFaction()
   {
      return this.faction;
   }
   
   //retrieves the ID for the player controlling the faction
   public int getPlayerID()
   {
      return this.playerID;
   }
   
   //retrieves the faction's saved bank
   public int getPlayerBank()
   {
      return this.playerBank;
   }
   
   //retrieves the single turn income of a faction
   public int getIncome()
   {
      return this.income;
   }
   
   //returns an array of boolean values pertaining to which research the faction has done
   public boolean[] getResearch()
   {
      return this.research;
   }
   
   //sets the faction being played to newFaction
   public boolean setFaction(int newFaction)
   {
      if(newFaction >= Faction.MIN_FACTION && newFaction <= Faction.MAX_FACTION)
      {
         this.faction = newFaction;
         return true;
      }
      else
         return false;
   }
   
   //sets the unique player ID for the faction to newPlayerID
   public boolean setPlayerID(int newPlayerID)
   {
      if(newPlayerID > 0)
      {
         this.playerID = newPlayerID;
         return true;
      }
      else
         return false;
   }
   
   public boolean increasePlayerBank(int amount)
   {
      if(amount >= Faction.MIN_BANK)
      {
         this.playerBank += amount;
         return true;
      }
      else
         return false;
   }
   
   public boolean decreasePlayerBank(int amount)
   {
      int tempBank = this.income - amount;
      
      if(tempBank >= Faction.MIN_BANK)
      {
         this.playerBank -= amount;
         return true;
      }
      else
         return false;
   }
   
   //sets the faction single turn income to newIncome
   public boolean increaseIncome(int newIncome)
   {
      int tempIncome = this.income + newIncome;
      
      if(tempIncome <= Faction.MAX_INCOME)
      {
         this.income += newIncome;
         return true;
      }
      else
         return false;
   }
   
   public boolean decreaseIncome(int newIncome)
   {
      int tempIncome = this.income - newIncome;
      
      if(tempIncome >= Faction.MIN_INCOME)
      {
         this.income -= newIncome;
         return true;
      }
      else
         return false;
   }
   
   //sets the faction's research array to researchPos
   public boolean setResearch(int researchPos)
   {
      if(researchPos >= 0 && researchPos < Faction.MAX_RESEARCH)
      {
         this.research[researchPos] = true;
         return true;
      }
      else
         return false;
   }
   
   /**
    * Rolling for research for a specific faction.
    * Research is performed by rolling dice for the indicated number of the
    * research (i.e. Fighter jets succeeds on a roll of a 1).
    * Dice is purchased in increments of 5 IPC each.
    * @param amtWager the amount of IPC spent on dice
    * @param researchAttempted the index number of the research being attempted
    * @return boolean to indicate whether the method completed correctly
    */
	public boolean rollResearch(int amtWager, int researchAttempted)
	{
		int numDie;
		int roll;
		boolean researchSuccess = false;

		if(amtWager % 5 != 0)
		{
		   System.out.println("Each die costs 5 IPCs. Must spend a multiple of 5 for research.");
		   return false;
	   }
		else if(amtWager < 5)
		{
			System.out.println("Each die costs 5 IPCs. Must spend a multiple of 5 for research.");
			return false;
		}
		else
		{
			numDie = amtWager / 5;
			if(!decreasePlayerBank(amtWager))
			{
			   System.out.println("Insufficient funds, select new amount");
			   return false;
			}
			
			System.out.println("Rolling for research!");
			System.out.println("...");
			for(int i = 0; i < numDie; i++)
			{
				roll = rand.nextInt(MAX_RESEARCH) + 1;
				System.out.print("" + roll + "\t");
				//If any roll is the number being attempted, then research succeeds
				if(roll == researchAttempted)
				{
					setResearch(researchAttempted);
					researchSuccess = true;
				}
			}
			if(researchSuccess)
			{
			   System.out.println("\nResearch succesfully completed!");
			}
			else
			{
			   System.out.println("\nResearch failed.");
			}
			
			return true;
		}
	}
        
}
