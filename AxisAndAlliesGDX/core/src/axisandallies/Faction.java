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
   private static final int DEFAULT_FACTION = -1;
   private static final int DEFAULT_PLAYERID = -1;
   private int faction, playerID, playerBank, income;
   private Random rand = new Random();
   private boolean[] research = new boolean[MAX_RESEARCH];
   private boolean isDefeated = false;
   
   public Faction()
   {
      setFaction(Faction.DEFAULT_FACTION);
      setFaction(Faction.DEFAULT_PLAYERID);      
   }
   
   public Faction(int faction, int playerID)
   {
      if(!setFaction(faction))
         setFaction(Faction.DEFAULT_FACTION);
      if(!setPlayerID(playerID))
         setFaction(Faction.DEFAULT_PLAYERID);
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
   
   //sets the bank of the faction to newBank
   public boolean setPlayerBank(int newBank)
   {
      if(newBank >= Faction.MIN_BANK)
      {
         this.playerBank = newBank;
         return true;
      }
      else
         return false;
   }
   
   //sets the faction single turn income to newIncome
   public boolean setIncome(int newIncome)
   {
      if(newIncome >= Faction.MIN_INCOME && newIncome <= Faction.MAX_INCOME)
      {
         this.income = newIncome;
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
   
   //sets a factions defeat status to true
   public boolean setIsDefeated(boolean isDefeated)
   {
      this.isDefeated = true;
      return true;
   }
   
        //Functions
	public boolean rollResearch(int amtWager, int researchAttempted)
	{
		int numDie;
		int roll;

		if(amtWager % 5 != 0 || amtWager < 5)
		{
			System.out.println("Each die costs 5 IPCs. Must spend a multiple of 5 for research.");
			return false;
		}
		else
		{
			numDie = amtWager % 5;
			for(int i = 0; i < numDie; i++)
			{
				roll = rand.nextInt(MAX_RESEARCH);
				if(roll == researchAttempted){
					setResearch(researchAttempted);
					System.out.println("Research complete!");
				}
				
			}
			return true;
		}
	}
        
}
