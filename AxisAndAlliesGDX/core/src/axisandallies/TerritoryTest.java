package axisandallies;

import org.junit.Test;
import org.junit.Assert.*;

public class TerritoryTest{

	@test
	public void testName(){
		Territory testTerritory = new Territory();

		boolean result = testTerritory.setName("New Name");
		assertEquals(true, result);
	}
	
	public void testFaction(){
		Territory testTer = new Territory();

		assertEquals("Faction -1 should be false", false, testTer.setFaction(-1));
		assertEquals("Faction 3 should be true", true, testTer.setFaction(3));
		assertEquals("Faction 5 should be false", false, testTer.setFaction(5));
	}

	public void testIC(){
		Territory testTer = new Territory();
		
		assertEquals("Return true if adding IC when none exists", true, testTer.setFaction(true));
		assertEquals("Return false if adding IC when one currently exists", false, testTer.setFaction(true));
	}

	public void testInfantry(){
		Territory testTer = new Territory();

		assertEquals("Return false if faction less than 0", false, testTer.setInfantry(-1, 10));
		assertEquals("Return false if number of units less than 0", false, testTer.setInfantry(0, -1));
	}
}

