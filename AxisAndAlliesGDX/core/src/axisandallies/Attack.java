/*
 * This is the Attack subclass
 * The class is a helper class to track the attack data generated during combat moves
 * All set functions are tuples of the form (attacker,defender)
 */
package axisandallies;
import static axisandallies.Territory.MAX_FACTION;
import java.util.*;

/**
 *
 * @author FlintTD
 */
public class Attack {
    private Territory attacker;
    private Territory defender;
    private int aInfantry;
    private int dInfantry;
    private int aArtillery;
    private int dArtillery;
    private int aTank;
    private int dTank;
    private int aFighter;
    private int dFighter;
    private int aBomber;
    private int dBomber;
    private int aBattleship;
    private int dBattleship;
    private int aAircraftCarrier;
    private int dAircraftCarrier;
    private int aTransport;
    private int dTransport;
    private int aSubmarine;
    private int dSubmarine;
    private int aDestroyer;
    private int dDestroyer;
    
    public Attack(){
        setInfantry(0,0);
        setArtillery(0,0);
        setTank(0,0);
        setFighter(0,0);
        setBomber(0,0);
	setBattleship(0,0);
	setAircraftCarrier(0,0);
	setTransport(0,0);
	setSubmarine(0,0);
	setDestroyer(0,0);
    }
    
    public Attack(Territory attacker, Territory defender, int aInfantry,
            int dInfantry, int aArtillery, int dArtillery, int aTank, int dTank,
            int aFighter, int dFighter, int aBomber, int dBomber,
            int aBattleship, int dBattleship, int aAircraftCarrier,
            int dAircraftCarrier, int aTransport, int dTransport,
            int aSubmarine, int dSubmarine, int aDestroyer, int dDestroyer,
            boolean antiaircraftGun)
    {
	if(!setFaction(faction))
		System.out.println("Invalid faction");
	if(!setInstance(instance))
		System.out.println("Invalid instance");
	if(!setIsLand(landTerritory))
		System.out.println("Invalid type");
	setInfantry(aInfantry, dInfantry);
	setArtillery(aArtillery, dArtillery);
	setTank(aTank, dTank);
	setFighter(aFighter, dFighter);
	setBomber(aBomber, dBomber);
	setBattleship(aBattleship, dBattleship);
	setAircraftCarrier(aAircraftCarrier, dAircraftCarrier);
	setTransport(aTransport, dTransport);
	setSubmarine(aSubmarine, dSubmarine);
	setDestroyer(aDestroyer, dDestroyer);
	setAntiAircraft(antiaircraftGun);
    }
    
    //Accessors
    public int getInfantry()
    {
        return this.aInfantry;
    }
    public int getArtillery()
    {
        return this.artillery;
    }
    public int getTank()
    {
        return this.tank;
    }
    public int getFight()
    {
        return this.fighter;
    }
    public int getBomber()
    {
        return this.bomber;
    }
    public int getBattleship()
    {
        return this.battleship;
    }
    public int getAircraftCarrier()
    {
        return this.aircraftCarrier;
    }
    public int getTransport()
    {
        return this.transport;
    }
    public int getSubmarine()
    {
        return this.submarine;
    }
    public int getDestroyer()
    {
        return this.destroyer;
    }
    
    //Mutators
   public void setInfantry(int attackers, int defenders)
   {
      aInfantry = attackers;
      dInfantry = defenders;
         
   }
   public void setArtillery(int attackers, int defenders)
   {
      aArtillery = attackers;
      dArtillery = defenders;
   }
   public void setTank(int attackers, int defenders)
   {
      aTank = attackers;
      dTank = defenders;
   }
   public void setFighter(int attackers, int defenders)
   {
      aFighter = attackers;
      dFighter = defenders;
   }
   public void setBomber(int attackers, int defenders)
   {
      aBomber = attackers;
      dBomber = defenders;
   }
   public void setBattleship(int attackers, int defenders)
   {
      aBattleship = attackers;
      dBattleship = defenders;
   }
   public void setAircraftCarrier(int attackers, int defenders)
   {
      aAircraftCarrier = attackers;
      dAircraftCarrier = defenders;
   }  
   public void setTransport(int attackers, int defenders)
   {
      aTransport = attackers;
      dTransport = defenders;
   }
   public void setSubmarine(int attackers, int defenders)
   {
      aSubmarine = attackers;
      dSubmarine = defenders;
   }
   public void setDestroyer(int attackers, int defenders)
   {
      aDestroyer = attackers;
      dDestroyer = defenders;
   }
   
   
   //Helper Functions
    
}
