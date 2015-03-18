/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package axisandallies;

public class SeaTerritory extends Territory{
	private static final int MAX_FACTION = 4;
	private static final int MIN_FACTION = 0;
	private static final int MIN_VALUE = 0;
	
	//Counting variables to store number of units in territory
	//Index in array is associated to faction (Russia = 0, Germany = 1, etc)
	private int[] transport = new int[MAX_FACTION];
	private int[] submarine = new int[MAX_FACTION];
	private int[] destroyer = new int[MAX_FACTION];
	private int[] carrier = new int[MAX_FACTION];
	private int[] battleship = new int[MAX_FACTION];

	public SeaTerritory()
	{
		//TODO: UPDATE CONSTRUCTOR
	}

	//Accessors
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
	public int[] getCarrier()
	{
		return this.carrier;
	}
	public int[] getBattleship()
	{
		return this.battleship;
	}

	//Mutators
	public boolean setTransport(int factionIndex, int count)
	{
		if(factionIndex >= SeaTerritory.MIN_VALUE && factionIndex <= SeaTerritory.MAX_FACTION && count >= SeaTerritory.MIN_VALUE)
		{
			this.transport[factionIndex] = count;
			return true;
		}
		else
			return false;
	}
	public boolean setSubmarine(int factionIndex, int count)
	{
		if(factionIndex >= SeaTerritory.MIN_VALUE && factionIndex <= SeaTerritory.MAX_FACTION && count >= SeaTerritory.MIN_VALUE)
		{
			this.submarine[factionIndex] = count;
			return true;
		}
		else
			return false;
	}
	public boolean setDestroyer(int factionIndex, int count)
	{
		if(factionIndex >= SeaTerritory.MIN_VALUE && factionIndex <= SeaTerritory.MAX_FACTION && count >= SeaTerritory.MIN_VALUE)
		{
			this.destroyer[factionIndex] = count;
			return true;
		}
		else
			return false;
	}
	public boolean setCarrier(int factionIndex, int count)
	{
		if(factionIndex >= SeaTerritory.MIN_VALUE && factionIndex <= SeaTerritory.MAX_FACTION && count >= SeaTerritory.MIN_VALUE)
		{
			this.carrier[factionIndex] = count;
			return true;
		}
		else
			return false;
	}
	public boolean setBattleship(int factionIndex, int count)
	{
		if(factionIndex >= SeaTerritory.MIN_VALUE && factionIndex <= SeaTerritory.MAX_FACTION && count >= SeaTerritory.MIN_VALUE)
		{
			this.battleship[factionIndex] = count;
			return true;
		}
		else
			return false;
	}
}
