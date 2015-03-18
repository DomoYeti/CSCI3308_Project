/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package axisandallies;

public class LandTerritory extends Territory{
   private static final int MAX_FACTION = 4;
   private static final int MIN_VALUE = 0;
   private int faction, value;
   private String name;
   private boolean isCapital, isVictory, hasIC, hasAA;
   private int[] infantry = new int[MAX_FACTION];
   private int[] artillery = new int[MAX_FACTION];
   private int[] tank = new int[MAX_FACTION];
   private int[] fighter = new int[MAX_FACTION];
   private int[] bomber = new int[MAX_FACTION];
   
   //TODO: Constructors
   public Territory()
   {
      
   }
   
   //Accessors
   public int getFaction()
   {
      return this.faction;
   }
   public int getValue()
   {
      return this.value;
   }
   public String getName()
   {
      return this.name;
   }
   public boolean getCapital()
   {
      return this.isCapital;
   }
   public boolean getVictory()
   {
      return this.isVictory;
   }
   public boolean getIC()
   {
      return this.hasIC;
   }
   public boolean getAA()
   {
      return this.hasAA;
   }
   public int[] getInfantry()
   {
      return this.infantry;
   }
   public int[] getArtillery()
   {
      return this.artillery;
   }
   public int[] getTank()
   {
      return this.tank;
   }
   public int[] getFight()
   {
      return this.fighter;
   }
   public int[] getBomber()
   {
      return this.bomber;
   }
   
   
   //Mutators
   public boolean setFaction(int newFaction)
   {
      if(newFaction >= Territory.MIN_VALUE && newFaction <= Territory.MAX_FACTION)
      {
         this.faction = newFaction;
         return true;
      }
      else
         return false;
   }
   public boolean setValue(int newVal)
   {
      if(newVal >= Territory.MIN_VALUE)
      {
         this.value = newVal;
         return true;
      }
      else
         return false;
   }
   public boolean setName(String name)
   {
      this.name = name;
      return true;
   }
   public boolean setCapital(boolean cap)
   {
      this.isCapital = cap;
      return true;
   }
   public boolean setVictory(boolean vic)
   {
      this.isVictory = vic;
      return true;
   }
   public boolean setIC(boolean IC)
   {
      //Cannot build an IC if one exists
      if(this.hasIC == true)
      {
         return false;
      }
      else
      {
         this.hasIC = true;
         return true;
      }
   }
   public boolean setAA(boolean AA)
   {
      if(this.hasAA == true)
      {
         return false;
      }
      else
      {
         this.hasAA = true;
         return true;
      }
   }
   public boolean setInfantry(int factionPos, int count)
   {
      if(factionPos >= Territory.MIN_VALUE && factionPos <= Territory.MAX_FACTION
            && count >= Territory.MIN_VALUE)
      {
         this.infantry[factionPos] = count;
         return true;
      }
      else
         return false;
   }
   public boolean setArtillery(int factionPos, int count)
   {
      if(factionPos >= Territory.MIN_VALUE && factionPos <= Territory.MAX_FACTION
            && count >= Territory.MIN_VALUE)
      {
         this.artillery[factionPos] = count;
         return true;
      }
      else
         return false;
   }
   public boolean setTank(int factionPos, int count)
   {
      if(factionPos >= Territory.MIN_VALUE && factionPos <= Territory.MAX_FACTION
            && count >= Territory.MIN_VALUE)
      {
         this.tank[factionPos] = count;
         return true;
      }
      else
         return false;
   }
   public boolean setFighter(int factionPos, int count)
   {
      if(factionPos >= Territory.MIN_VALUE && factionPos <= Territory.MAX_FACTION
            && count >= Territory.MIN_VALUE)
      {
         this.fighter[factionPos] = count;
         return true;
      }
      else
         return false;
   }
   public boolean setBomber(int factionPos, int count)
   {
      if(factionPos >= Territory.MIN_VALUE && factionPos <= Territory.MAX_FACTION
            && count >= Territory.MIN_VALUE)
      {
         this.bomber[factionPos] = count;
         return true;
      }
      else
         return false;
   }
}
