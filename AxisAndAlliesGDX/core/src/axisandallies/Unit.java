/*
 * This is the Unit class
 * The class is a helper class to track the battle stats of units from all factions
 */
package axisandallies;

public class Unit{

   private static final int MAX_FACTION = 4;
   private static final int MIN_FACTION = 0;
   private static final int MIN_VALUE = 0;
   private static final int MAX_TYPE = 3;
   
   //Type refers to land/air/water unit
   private int faction, cost, attack, defense, move;
   private String type;
   
   public Unit()
   {
      //TODO: UPDATE UNIT CONSTRUCTORS
   }
   
   //Accessors
   public int getFaction()
   {
      return this.faction;
   }
   public int getCost()
   {
      return this.cost;
   }
   public int getAttack()
   {
      return this.attack;
   }
   public int getDefense()
   {
      return this.defense;
   }
   public int getMove()
   {
      return this.move;
   }
   public String getType()
   {
      return this.type;
   }
   
   //Mutators
   public boolean setFaction(int newFaction)
   {
      if(newFaction >= Unit.MIN_FACTION && newFaction <= Unit.MAX_FACTION)
      {
         this.faction = newFaction;
         return true;
      }
      else
         return false;
   }
   public boolean setCost(int newCost)
   {
      if(newCost >= Unit.MIN_VALUE)
      {
         this.cost = newCost;
         return true;
      }
      else
         return false;
   }
   public boolean setAttack(int newAttack)
   {
      if(newAttack >= Unit.MIN_VALUE)
      {
         this.attack = newAttack;
         return true;
      }
      else
         return false;
   }
   public boolean setDefense(int newDefense)
   {
      if(newDefense >= Unit.MIN_VALUE)
      {
         this.defense = newDefense;
         return true;
      }
      else
         return false;
   }
   public boolean setMove(int newMove)
   {
      if(newMove > Unit.MIN_VALUE)
      {
         this.move = newMove;
         return true;
      }
      else
         return false;
   }
   public boolean setType(String newType)
   {
      if(newType == "Infantry" || newType == "Artillery" || newType == "Tank"
            || newType == "Fighter" || newType == "Bomber"
            || newType == "Battleship" || newType == "Carrier"
            || newType == "Transport" || newType == "Submarine"
            || newType == "Destroyer" || newType == "AA")
      {
         this.type = newType;
         return true;
      }
      else
         return false;
   }
   
   //TODO
   //Special unit rules:
   //Battleship HP, submarine +attack, strategic bombing, artillery, plane movement

}
