/*
 * This is the Territory class
 * The class maintains all of the territories and their information, as well as 
 * providing a map for units to exist within.
 * Unit counts are set up as arrays, with a slot for each faction
 * Available factions: 0 - Russia, 1 - Germany, 2 - UK, 3 - Japan, 4 - US
 */

package axisandallies;

public class Territory{

	public static final int MAX_FACTION = 5;
	public static final int MIN_VALUE = 0;
	private int faction, value;
	private String name;
	private boolean isCapital, isVictory, hasIndustrialComplex, 
	   hasAntiAircraft, isLand, isNeutral;
	private int[] infantry = new int[MAX_FACTION];
	private int[] artillery = new int[MAX_FACTION];
	private int[] tank = new int[MAX_FACTION];
	private int[] fighter = new int[MAX_FACTION];
	private int[] bomber = new int[MAX_FACTION];
	private int[] battleship = new int[MAX_FACTION];
	private int[] aircraftCarrier = new int[MAX_FACTION];
	private int[] transport = new int[MAX_FACTION];
	private int[] submarine = new int[MAX_FACTION];
	private int[] destroyer = new int[MAX_FACTION];
	
   private int connectionsNumber = 0;
   private String[] connections;

	public Territory(){
		setName("");
		setFaction(0);
		setValue(0);
		setIsLand(false);
		setIsNeutral(false);
		setCapital(false);
		setVictory(false);
		setBattleships(0,0);
		setAircraftCarriers(0,0);
		setTransports(0,0);
		setSubmarines(0,0);
		setDestroyers(0,0);
	}
	/**
	 * Territory constructor.
	 * Format: Name, faction, territory value, land or sea, neutral or playable,
	 * has a capital city, has a victory city, number of the following units:
	 * infantry, artillery, tank, fighter, bomber, battleship, aircraft carrier,
	 * transport, submarine, destroyer, has an anti aircraft gun,
	 * has an industrial complex
	 */
	public Territory(String name, int faction, int value, boolean landTerritory, 
	      boolean isNeutral, boolean isCapital, boolean isVictory,
	      int infantry, int artillery, int tank, int fighter, int bomber,
	      int battleship, int aircraftCarrier, int transport, int submarine, 
	      int destroyer, boolean antiaircraftGun, boolean industrialComplex)
	{
		if(!setName(name))
			System.out.println("Could not set territory name");
		if(!setFaction(faction))
			System.out.println("Invalid faction");
		if(!setValue(value))
			System.out.println("Invalid value");
		if(!setIsLand(landTerritory))
			System.out.println("Invalid type");
		if(!setIsNeutral(isNeutral))
			System.out.println("Set neutral error");
		if(!setCapital(isCapital))
			System.out.println("Set capital error");
		if(!setVictory(isVictory))
			System.out.println("Set victory error");
		setInfantry(faction, infantry);
		setArtillery(faction, artillery);
		setTanks(faction, tank);
		setFighters(faction, fighter);
		setBombers(faction, bomber);
		setBattleships(faction, battleship);
		setAircraftCarriers(faction, aircraftCarrier);
		setTransports(faction, transport);
		setSubmarines(faction, submarine);
		setDestroyers(faction, destroyer);
		setAntiAircraft(antiaircraftGun);
		setIndustrialComplex(industrialComplex);
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
   public boolean getIndustrialComplex()
   {
      return this.hasIndustrialComplex;
   }
   public boolean getAntiAircraft()
   {
      return this.hasAntiAircraft;
   }
   //get<units> functions require the faction number
   public int getInfantry(int faction)
   {
      return this.infantry[faction];
   }
   public int getArtillery(int faction)
   {
      return this.artillery[faction];
   }
   public int getTanks(int faction)
   {
      return this.tank[faction];
   }
   public int getFighters(int faction)
   {
      return this.fighter[faction];
   }
   public int getBombers(int faction)
   {
      return this.bomber[faction];
   }
   public int getBattleships(int faction)
   {
      return this.battleship[faction];
   }
   public int getAircraftCarriers(int faction)
   {
      return this.aircraftCarrier[faction];
   }
   public int getTransports(int faction)
   {
      return this.transport[faction];
   }
   public int getSubmarines(int faction)
   {
      return this.submarine[faction];
   }
   public int getDestroyers(int faction)
   {
      return this.destroyer[faction];
   }
	public boolean getIsLand()
	{
		return this.isLand;
	}
	public boolean getIsNeutral()
	{
		return this.isNeutral;
	}
   public boolean getIsFactionUnits(int faction){
       if(this.infantry[faction] > 0) return true;
       else if(this.artillery[faction] > 0) return true;
       else if(this.tank[faction] > 0) return true;
       else if(this.fighter[faction] > 0) return true;
       else if(this.bomber[faction] > 0) return true;
       else if(this.battleship[faction] > 0) return true;
       else if(this.aircraftCarrier[faction] > 0) return true;
       else if(this.transport[faction] > 0) return true;
       else if(this.submarine[faction] > 0) return true;
       else if(this.destroyer[faction] > 0) return true;
       else return false;
   }
   public int getConnectionsNumber()
   {
      return this.connectionsNumber;
   }
   public String[] getConnections()
   {
      return this.connections;
   }
   public boolean getIsConnected(String territory)
   {
      int i = this.getConnectionsNumber();
      for(int j = 0; j<i; j++)
      {
         if(territory.equals(this.connections[j]))
         {
             return true;
         }
      }
      return false;
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
   public boolean setIndustrialComplex(boolean IC)
   {
      //Cannot build IC on sea territory
      if(this.getIsLand())
      {
         //Cannot build an IC if one exists
         if(this.hasIndustrialComplex == true)
         {
            return false;
         }
         else
         {
            this.hasIndustrialComplex = IC;
            return true;
         }
      }
      else
      {
         return false;
      }
   }
   public boolean setAntiAircraft(boolean AA)
   {
      if(this.getIsLand())
      {
         //Cannot build AntiAircraft if one exists
         if(this.hasAntiAircraft == true)
         {
            return false;
         }
         else
         {
            this.hasAntiAircraft = AA;
            return true;
         }
      }
      else
      {
         return false;
      }
   }
   public boolean setInfantry(int factionPos, int count)
   {
      if(this.setLandUnitParamterTest(factionPos, count))
      {
         this.infantry[factionPos] = count;
         return true;
      }
      else
      {
         return false;
      }
         
   }
   public boolean setArtillery(int factionPos, int count)
   {
      if(this.setLandUnitParamterTest(factionPos, count))
      {
         this.artillery[factionPos] = count;
         return true;
      }
      else
      {
         return false;
      }
   }
   public boolean setTanks(int factionPos, int count)
   {
      if(this.setLandUnitParamterTest(factionPos, count))
      {
         this.tank[factionPos] = count;
         return true;
      }
      else
      {
         return false;
      }
   }
   public boolean setFighters(int factionPos, int count)
   {
      if(this.setLandUnitParamterTest(factionPos, count))
      {
         this.fighter[factionPos] = count;
         return true;
      }
      else
      {
         return false;
      }
   }
   public boolean setBombers(int factionPos, int count)
   {
      if(this.setLandUnitParamterTest(factionPos, count))
      {
         this.bomber[factionPos] = count;
         return true;
      }
      else
      {
         return false;
      }
   }
   public boolean setBattleships(int factionPos, int count)
   {
      if(this.setSeaUnitParameterTest(factionPos, count))
      {
         this.battleship[factionPos] = count;
         return true;
      }
      else
      {
         return false;
      }
   }
   public boolean setAircraftCarriers(int factionPos, int count)
   {
      if(this.setSeaUnitParameterTest(factionPos, count))
      {
         this.aircraftCarrier[factionPos] = count;
         return true;
      }
      else
      {
         return false;
      }
   }  
   public boolean setTransports(int factionPos, int count)
   {
      if(this.setSeaUnitParameterTest(factionPos, count))
      {
         this.transport[factionPos] = count;
         return true;
      }
      else
      {
         return false;
      }
   }
   public boolean setSubmarines(int factionPos, int count)
   {
      if(this.setSeaUnitParameterTest(factionPos, count))
      {
         this.submarine[factionPos] = count;
         return true;
      }
      else
      {
         return false;
      }
   }
   public boolean setDestroyers(int factionPos, int count)
   {
      if(this.setSeaUnitParameterTest(factionPos, count))
      {
         this.destroyer[factionPos] = count;
         return true;
      }
      else
      {
         return false;
      }
   }
	public boolean setIsLand(boolean isLand)
	{
		this.isLand = isLand;
		return true;
	}
	public boolean setIsNeutral(boolean isNeutral)
	{
		this.isNeutral = isNeutral;
		return true;
	}
	
	/**
	 * List of the number of connecting territories to the current territory
	 * @param territory the name of the territory to set connections
	 * @return boolean to indicate that the connections were set correctly
	 */
   public boolean setNewConnection(String territory)
   {
      if(this.getIsConnected(territory)) return false;
      String[] oldList = this.connections;
      int i = this.connectionsNumber;
      String[] newList = new String[i];
      for(int j = 0; j<i; j++)
      {
         newList[j] = oldList[j];
      }
      newList[i] = territory;
      this.connections = newList;
      this.connectionsNumber = i + 1;
      return true;
   }
        
   /**
    * Helper function to test valid parameters for updating the number of
    * land units in a territory
    * @param factionPos the faction that owns the units to be updated
    * @param count the number of units remaining in the territory
    * @return boolean whether the update was successful or not
    */
	public boolean setLandUnitParamterTest(int factionPos, int count)
	{
	   if(this.getIsLand())
      {
         if(factionPos >= Territory.MIN_VALUE && factionPos <= Territory.MAX_FACTION
               && count >= Territory.MIN_VALUE)
         {
            return true;
         }
         else
            return false;
      }
      else
      {
         return false;
      }
	}
	
   /**
    * Helper function to test valid parameters for updating the number of
    * sea units in a territory
    * @param factionPos the faction that owns the units to be updated
    * @param count the number of units remaining in the territory
    * @return boolean whether the update was successful or not
    */
   public boolean setSeaUnitParameterTest(int factionPos, int count)
   {
      if(!this.getIsLand())
      {
         if(factionPos >= Territory.MIN_VALUE && factionPos <= Territory.MAX_FACTION
               && count >= Territory.MIN_VALUE)
         {
            return true;
         }
         else
            return false;
      }
      else
      {
         return false;
      }
   }
   /**
    * Update land units of all types in a single territory
    * @param factionPos the faction owner of the units to be updated
    * @param infantryCount the number of infantry remaining
    * @param artilleryCount the number of artillery remaining
    * @param tankCount the number of tanks remaining
    * @param fighterCount the number of fighters remaining
    * @param bomberCount the number of bombers remaining
    * @return boolean to indicate whether update was successful or not
    */
   public boolean updateLandUnits(int factionPos, int infantryCount, 
         int artilleryCount, int tankCount, int fighterCount, int bomberCount)
   {
      boolean success = true;
      
      if(!setInfantry(factionPos, infantryCount)){ success = false; }
      if(!setArtillery(factionPos, artilleryCount)){ success = false; }
      if(!setTanks(factionPos, tankCount)){ success = false; }
      if(!setFighters(factionPos, fighterCount)){ success = false; }
      if(!setBombers(factionPos, bomberCount)){ success = false; }
      
      return success;
   }
   /**
    * Update sea units of all types in a single territory
    * @param factionPos the faction owner of the units to be updated
    * @param battleshipCount the number of battleships remaining
    * @param aircraftCarrierCount the number of aircraft carriers remaining
    * @param transportCount the number of transports remaining
    * @param submarineCount the number of submarines remaining
    * @param destroyerCount the number of destroyers remaining
    * @return boolean to indicate whether update was successful or not
    */
   public boolean updateSeaUnits(int factionPos, int battleshipCount,
         int aircraftCarrierCount, int transportCount, 
         int submarineCount, int destroyerCount)
   {
      boolean success = true;
      
      if(!setBattleships(factionPos, battleshipCount)){ success = false; }
      if(!setAircraftCarriers(factionPos, aircraftCarrierCount)){ success = false; }
      if(!setTransports(factionPos, transportCount)){ success = false; }
      if(!setSubmarines(factionPos, submarineCount)){ success = false; }
      if(!setDestroyers(factionPos, destroyerCount)){ success = false; }
      
      return success;
   }
}
