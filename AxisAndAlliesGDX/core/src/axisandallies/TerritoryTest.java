package axisandallies;

import static org.junit.Assert.*;

import org.junit.Test;

public class TerritoryTest
{
   
   @Test
   public void testName(){
      Territory testTerritory = new Territory();

      boolean result = testTerritory.setName("New Name");
      assertEquals(true, result);
   }
   @Test
   public void testFaction(){
      Territory testTer = new Territory();

      assertEquals("Faction -1 should be false", false, testTer.setFaction(-1));
      assertEquals("Faction 3 should be true", true, testTer.setFaction(3));
      assertEquals("Faction 5 should be false", false, testTer.setFaction(5));
   }
   @Test
   public void testIC(){
      Territory testTer = new Territory("", 0, 0, true, false, false, false,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      
      assertEquals("Return true if adding IC when none exists", true, testTer.setIndustrialComplex(true));
      assertEquals("Return false if adding IC when one currently exists", false, testTer.setIndustrialComplex(true));
   }
   @Test
   public void testInfantry(){
      Territory testTer = new Territory();

      assertEquals("Return false if faction less than 0", false, testTer.setInfantry(-1, 10));
      assertEquals("Return false if number of units less than 0", false, testTer.setInfantry(0, -1));
   }

   
}
