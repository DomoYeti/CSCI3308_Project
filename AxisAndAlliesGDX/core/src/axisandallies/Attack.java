/*
 * This is the Attack subclass
 * The class is a helper class to track the attack data generated during combat moves
 * All set functions are tuples of the form (attacker,defender)
 */
package axisandallies;
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
    
    /**
     * Constructor for the Attack class.
     * Format: attacking territory, defending territory,
     * number of the following units: attacking infantry, defending infantry,
     * attacking artillery, defending artillery, attacking tanks,
     * defending tanks, attacking fighters, defending fighters,
     * attacking bombers, defending fighters, attacking battleships,
     * defending battleships, attacking carriers, defending carriers,
     * attacking transports, defending transports, attacking submarines,
     * defending submarines, attacking destroyers, defending destroyers.
     */
    public Attack(Territory attacker, Territory defender, int aInfantry,
            int dInfantry, int aArtillery, int dArtillery, int aTank, int dTank,
            int aFighter, int dFighter, int aBomber, int dBomber,
            int aBattleship, int dBattleship, int aAircraftCarrier,
            int dAircraftCarrier, int aTransport, int dTransport,
            int aSubmarine, int dSubmarine, int aDestroyer, int dDestroyer,
            boolean antiaircraftGun)
    {
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
    }
    
    //Accessors
    public int getInfantry(String type)
    {
        if(type == "attacker") return this.aInfantry;
        else if (type == "a") return this.aInfantry;
        else if(type == "defender") return this.dInfantry;
        else if(type == "d") return this.dInfantry;
        else return -1;
    }
    public int getArtillery(String type)
    {
        if(type == "attacker") return this.aArtillery;
        else if (type == "a") return this.aArtillery;
        else if(type == "defender") return this.dArtillery;
        else if(type == "d") return this.dArtillery;
        else return -1;
    }
    public int getTank(String type)
    {
        if(type == "attacker") return this.aTank;
        else if (type == "a") return this.aTank;
        else if(type == "defender") return this.dTank;
        else if(type == "d") return this.dTank;
        else return -1;
    }
    public int getFighter(String type)
    {
        if(type == "attacker") return this.aFighter;
        else if (type == "a") return this.aFighter;
        else if(type == "defender") return this.dFighter;
        else if(type == "d") return this.dFighter;
        else return -1;
    }
    public int getBomber(String type)
    {
        if(type == "attacker") return this.aBomber;
        else if (type == "a") return this.aBomber;
        else if(type == "defender") return this.dBomber;
        else if(type == "d") return this.dBomber;
        else return -1;
    }
    public int getBattleship(String type)
    {
        if(type == "attacker") return this.aBattleship;
        else if (type == "a") return this.aBattleship;
        else if(type == "defender") return this.dBattleship;
        else if(type == "d") return this.dBattleship;
        else return -1;
    }
    public int getAircraftCarrier(String type)
    {
        if(type == "attacker") return this.aAircraftCarrier;
        else if (type == "a") return this.aAircraftCarrier;
        else if(type == "defender") return this.dAircraftCarrier;
        else if(type == "d") return this.dAircraftCarrier;
        else return -1;
    }
    public int getTransport(String type)
    {
        if(type == "attacker") return this.aTransport;
        else if (type == "a") return this.aTransport;
        else if(type == "defender") return this.dTransport;
        else if(type == "d") return this.dTransport;
        else return -1;
    }
    public int getSubmarine(String type)
    {
        if(type == "attacker") return this.aSubmarine;
        else if (type == "a") return this.aSubmarine;
        else if(type == "defender") return this.dSubmarine;
        else if(type == "d") return this.dSubmarine;
        else return -1;
    }
    public int getDestroyer(String type)
    {
        if(type == "attacker") return this.aDestroyer;
        else if (type == "a") return this.aDestroyer;
        else if(type == "defender") return this.dDestroyer;
        else if(type == "d") return this.dDestroyer;
        else return -1;
    }
    
    
    //Mutators
    public void setAttacker(Territory wokka)
   {
      this.attacker = wokka;
   }
    public void setDefender(Territory flokka)
   {
      this.defender = flokka;
   }
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
