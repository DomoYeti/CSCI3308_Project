package axisandallies;

public class Faction
{
   private static final int MAX_RESEARCH = 6;
   private static final int MAX_FACTION = 4; //Factions 0-4
   private static final int MIN_FACTION = 0;
   private static final int MIN_BANK = 0;
   private static final int MIN_INCOME = 0;
   private static final int MAX_INCOME = 63;
   private static final int DEFAULT_FACTION = -1;
   private static final int DEFAULT_PLAYERID = -1;
   private int faction, playerID, playerBank, income;
   private boolean[] research = new boolean[MAX_RESEARCH];
   
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
   
   
   //Accessors
   public int getFaction()
   {
      return this.faction;
   }
   public int getPlayerID()
   {
      return this.playerID;
   }
   public int getPlayerBank()
   {
      return this.playerBank;
   }
   public int getIncome()
   {
      return this.income;
   }
   public boolean[] getResearch()
   {
      return this.research;
   }
   
   //Mutators
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
}
