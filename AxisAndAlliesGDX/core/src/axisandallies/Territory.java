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
		setBattleship(0,0);
		setAircraftCarrier(0,0);
		setTransport(0,0);
		setSubmarine(0,0);
		setDestroyer(0,0);
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
		setTank(faction, tank);
		setFighter(faction, fighter);
		setBomber(faction, bomber);
		setBattleship(faction, battleship);
		setAircraftCarrier(faction, aircraftCarrier);
		setTransport(faction, transport);
		setSubmarine(faction, submarine);
		setDestroyer(faction, destroyer);
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
   public int[] getBattleship()
   {
      return this.battleship;
   }
   public int[] getAircraftCarrier()
   {
      return this.aircraftCarrier;
   }
   public int[] getTransport()
   {
      return this.transport;
   }
   public int[] getSubmarine()
   {
      return this.submarine;
   }
   public int[] getDestroyer()
   {
      return this.destroyer;
   }
	public boolean getIsLand()
	{
		return this.isLand;
	}
	public boolean getIsNeutral()
	{
		return this.isNeutral;
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
   public boolean setTank(int factionPos, int count)
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
   public boolean setFighter(int factionPos, int count)
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
   public boolean setBomber(int factionPos, int count)
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
   public boolean setBattleship(int factionPos, int count)
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
   public boolean setAircraftCarrier(int factionPos, int count)
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
   public boolean setTransport(int factionPos, int count)
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
   public boolean setSubmarine(int factionPos, int count)
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
   public boolean setDestroyer(int factionPos, int count)
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
      if(!setTank(factionPos, tankCount)){ success = false; }
      if(!setFighter(factionPos, fighterCount)){ success = false; }
      if(!setBomber(factionPos, bomberCount)){ success = false; }
      
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
      
      if(!setBattleship(factionPos, battleshipCount)){ success = false; }
      if(!setAircraftCarrier(factionPos, aircraftCarrierCount)){ success = false; }
      if(!setTransport(factionPos, transportCount)){ success = false; }
      if(!setSubmarine(factionPos, submarineCount)){ success = false; }
      if(!setDestroyer(factionPos, destroyerCount)){ success = false; }
      
      return success;
   }
}
