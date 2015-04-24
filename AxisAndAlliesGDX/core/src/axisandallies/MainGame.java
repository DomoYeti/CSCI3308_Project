/** 
 * MainGame runs the application and makes calls to each game phase
 * @version 0.4
 * 
 */

package axisandallies;
import java.util.*;

public class MainGame /*extends ApplicationAdapter*/ {

   //142 Territories plus a deployment territory
   final static int MAX_TERRITORIES = 143;
   final static int WATER_TERRITORY_COUNT = 64;
   final static int MAX_RESEARCH = 7;
   final static int DEFAULT_MIN_VALUE = 0;
   final static int MAX_PLAYERS = 5;
   static Territory[] territoryList = new Territory[MAX_TERRITORIES];
   static Faction[] factionList = new Faction[MAX_PLAYERS];
   static int NUMBER_OF_PLAYERS = 0;
   
   
   private static Scanner input;
   
   public static void main(String[] args){
       //opening message
      System.out.println("\n\n\n");
      System.out.println("Welcome to Axis and Allies, the definitive wargame.\n");
      initializePlayers();
      initializeTerritories();
      //printTerrs();
      short victory = 0;
      int currentFaction = 0;
       
      while(victory == 0){
           
        if(currentFaction == 6)
               for(int i=1; i<6; i++){
                   //faction[i].victory = victory;
                i = 1;
            }
        developWeapons(currentFaction);
        //purchaseUnits()
        combatMoveAndCombat(factionList[currentFaction].getPlayerID(), currentFaction);
        //mobilizeNewUnits()
        //collectIncome()
           
        currentFaction = (currentFaction + 1) % MAX_PLAYERS;
      }
   }
   
   /**
    * Initialize the factions with starting values.
    * Initialize number of players in the game.
    * Assign players to teams.
    */
   public static void initializePlayers()
   {
      input = new Scanner(System.in); //reads input from console
      boolean done = false;
      boolean validInput = false;
      boolean validCountry = false;
      int numPlayers = 0;
      boolean takenCountries[] = new boolean[] {false, false, false, false, false};
      
      //Initialize all countries
      factionList[0] = new Faction(0, 0, 24, 24); //Russia
      factionList[1] = new Faction(1, 0, 40, 40); //Germany
      factionList[2] = new Faction(2, 0, 30, 30); //UK
      factionList[3] = new Faction(3, 0, 30, 30); //Japan
      factionList[4] = new Faction(4, 0, 42, 42); //US

      do
      {
         System.out.println("Enter number of players (2 to 5):");
         numPlayers = Integer.parseInt(input.nextLine());
         
         if(numPlayers >= 2 && numPlayers <= 5)
         {
            validInput = true;
            NUMBER_OF_PLAYERS = numPlayers;
         }
         else
         {
            System.out.println("Number of players must be between 2 and 5.");
         }
      }while(!validInput && !validCountry);

      for(int i = 1; i <= numPlayers; i++)
      {
         validCountry = false;
         validInput = false;
         System.out.println("Player " + i + ", your turn to choose!");
         
         do
         {
            playerSelectMenu(numPlayers);
            int userSelection = Integer.parseInt(input.nextLine());
            if(userSelection >= 1 && userSelection <= numPlayers)
            {
               validInput = true;
            }
            else
            {
               System.out.println("Choose a number corresponding to one of the options.");
            }
            if(takenCountries[userSelection-1] == false)
            {
               validCountry = true;
               takenCountries[userSelection-1] = true;
               assignPlayerToFaction(numPlayers, userSelection, i);
            }
            else
            {
               System.out.println("That team has already been selected! Choose another.");
            }
         }while(!validCountry || !validInput);
      }
   }
   
   /**
    * Menu output to display teams based on the number of players.
    * @param numberOfPlayers the number of players in the game.
    */
   public static void playerSelectMenu(int numberOfPlayers)
   {
      System.out.println("Enter the number to select your country:");
      switch(numberOfPlayers)
      {
         case 2:
            System.out.println("1. Russia, United Kingdom, and the United States");
            System.out.println("2. Germany, Japan");
            break;
         case 3:
            System.out.println("1. Russia, United Kingdom, and the United States");
            System.out.println("2. Germany");
            System.out.println("3. Japan");
            break;
         case 4:
            System.out.println("1. Russia, and the United States");
            System.out.println("2. Germany");
            System.out.println("3. United Kingdom");
            System.out.println("4. Japan");
            break;
         case 5:
            System.out.println("1. Russia");
            System.out.println("2. Germany");
            System.out.println("3. United Kingdom");
            System.out.println("4. Japan");
            System.out.println("5. United States");
            break;
            
         default:
            System.out.println("Something has gone wrong in country select!");
            break;
      }
   }   
   
   /**
    * Assign the player to a faction
    * @param numPlayers the number of players in the game.
    * @param userChoice the team the user has selected to play.
    * @param playerNumber the player number of the current user
    */
   public static void assignPlayerToFaction(int numPlayers, int userChoice,
         int playerNumber)
   {
      switch(numPlayers)
      {
         case 2:
            switch(userChoice)
            {
               case 1:
                  factionList[0].setPlayerID(playerNumber);
                  factionList[2].setPlayerID(playerNumber);
                  factionList[4].setPlayerID(playerNumber);
                  break;
               case 2:
                  factionList[1].setPlayerID(playerNumber);
                  factionList[3].setPlayerID(playerNumber);
                  break;
            }
            break;
         case 3:
            switch(userChoice)
            {
               case 1:
                  factionList[0].setPlayerID(playerNumber);
                  factionList[2].setPlayerID(playerNumber);
                  factionList[4].setPlayerID(playerNumber);
                  break;
               case 2:
                  factionList[1].setPlayerID(playerNumber);
                  break;
               case 3:
                  factionList[3].setPlayerID(playerNumber);
                  break;
            }
            break;
         case 4:
            switch(userChoice)
            {
               case 1:
                  factionList[0].setPlayerID(playerNumber);
                  factionList[4].setPlayerID(playerNumber);
                  break;
               case 2:
                  factionList[1].setPlayerID(playerNumber);
                  break;
               case 3:
                  factionList[2].setPlayerID(playerNumber);
                  break;
               case 4:
                  factionList[3].setPlayerID(playerNumber);
                  break;
            }
            break;
         case 5:
            switch(userChoice)
            {
               case 1:
                  factionList[0].setPlayerID(playerNumber);
                  break;
               case 2:
                  factionList[1].setPlayerID(playerNumber);
                  break;
               case 3:
                  factionList[2].setPlayerID(playerNumber);
                  break;
               case 4:
                  factionList[3].setPlayerID(playerNumber);
                  break;
               case 5:
                  factionList[4].setPlayerID(playerNumber);
                  break;
            }
            break;
         default:
            System.out.println("Error assigning player to country.");
            break;
      }
   }
   
   //Helper function to determine if a faction is allied with a current faction
   public static boolean allyFaction(int currentFaction, int otherFaction){
       if(currentFaction == otherFaction) return true;
       else if(currentFaction == 0 & (otherFaction == 2 | otherFaction == 4)) return true;
       else if(currentFaction == 1 & otherFaction == 3) return true;
       else if(currentFaction == 2 & (otherFaction == 0 | otherFaction == 4)) return true;
       else if(currentFaction == 3 & otherFaction == 1) return true;
       else if(currentFaction == 4 & (otherFaction == 0 | otherFaction == 2)) return true;
       else return false;
   }
   
   /**
    * Phase 1: Select research to develop this turn
    * Require user to select option to research (or none).
    * Require user to enter the number of dice to purchase.
    * Roll for research, then complete the phase.
    * @param currentPlayer the current player whose turn it is.
    */
   public static void developWeapons(int currentPlayer)
   {
      input = new Scanner(System.in); //reads input from console
      boolean selectResearchComplete = false;
      boolean rollForResearchComplete = false;
      boolean valid = false;
      int menuPage = 1;
      int researchAttempted = 7;
      int ipcSpent = -1;
      
      do
      {
         //Validate the user entered input within range 1 to 7
         while(!valid)
         {
            selectResearchComplete = false;
            researchMenu(menuPage, currentPlayer);
            researchAttempted = Integer.parseInt(input.nextLine());
            if(researchAttempted > DEFAULT_MIN_VALUE && researchAttempted <= MAX_RESEARCH)
            {
               valid = true;
               menuPage++;
            }
            else
            {
               System.out.println("Enter a number from 1 to 7.");
            }
            //Exit all loops and complete phase if choice 7 is selected
            if(researchAttempted == 7)
            {
               selectResearchComplete = true;
               rollForResearchComplete = true;
            }
         }
         //Enter number of dice and call roll research method
         //Validation handled within roll research.
         while(!selectResearchComplete)
         {
            researchMenu(menuPage, currentPlayer);
            ipcSpent = Integer.parseInt(input.nextLine());
            if(ipcSpent == 0)
            {
               menuPage--;
               valid = false;
               selectResearchComplete = true;
            }
            else
            {
               if(factionList[currentPlayer].rollResearch(ipcSpent, researchAttempted))
               {
                  selectResearchComplete = true;
                  rollForResearchComplete = true;
               }
            }
         }
      }while(!rollForResearchComplete || !selectResearchComplete);
   }
   /**
    * Output menu options for the research phase
    * @param menuPage the page to be displayed.
    * @param currentPlayer the current player whose turn it is.
    */
   public static void researchMenu(int menuPage, int currentPlayer)
   {
      switch(menuPage)
      {
         case 1:
            System.out.println("Choose a development. Select one of the following options:");
            System.out.println("You current bank is: " + factionList[currentPlayer].getPlayerBank() + " IPCs");
            System.out.println("1. Jet fighters: fighter defense increases to 5.");
            System.out.println("2. Rockets: Antiarcraft guns can reduce enemy IPCs.");
            System.out.println("3. Super Subs: Submarine attack increases to 3.");
            System.out.println("4. Long-Range Aircraft: Fighter range increases to 6, bombers to 8.");
            System.out.println("5. Combined Bombard: Destroyers conduct bombardment during amphibious assaults");
            System.out.println("6. Heavy bombers: Bombers roll two dice on each attack");
            System.out.println("7. No research this turn.");
            break;

         case 2:
            System.out.println("Enter amount of IPCs to spend (0 to go back). Each die costs 5 IPC.");
            break;
            
         default:
            System.out.println("Error: Should not have reached here");
        
      }

   }
   
   /**
    * Phase 3: Move units from friendly territories into hostile territories
    * Require user to select territories and declare units to invade them.
    * Require user to enter the friendly and enemy territory names.
    * Move units into territories and end the phase.
    * @param currentPlayer the current player whose turn it is.
    * @param currentFaction is the faction of the player.
    */
   public static void combatMoveAndCombat(int currentPlayer, int currentFaction){
       input = new Scanner(System.in); //reads input from users
       //Combat Move phase
       boolean concluded = false;
       while(concluded == false){
           //prepare a new attack
           boolean done = false;
           String attackerName = null;
           String defenderName = null;
           String attackingUnit = null;
           Territory attackingTerritory = null;
           Territory defendingTerritory = null;
           
           String curFac = null;
           if(currentFaction == 0){
               curFac = "Russia";
           }
           else if(currentFaction == 1){
               curFac = "Germany";
           }
           else if(currentFaction == 2){
               curFac = "UK";
           }
           else if(currentFaction == 3){
               curFac = "Japan";
           }
           else if(currentFaction == 4){
               curFac = "US";
           }
           String out = String.format("Player %d You are currently %s.\n", currentPlayer, curFac);
           System.out.print(out);
           //read user input for selecting attacking territory, SOLID
           while(done == false){
               System.out.print("Enter the territory you would like to mobilize from: ");
               attackerName = input.next( );
               //check is territory
               attackingTerritory = getTerritoryFromName(attackerName);
               if(attackingTerritory.getName().equals(attackerName)){
                   //check is owned
                   if(currentFaction == attackingTerritory.getFaction()){
                       //print message and done
                       String selection = String.format("You have selected %s.\n", attackerName);
                       System.out.print(selection);
                       done = true;
                   }
                   else System.out.print("You do not control that territory!\n");
               }
               else System.out.print("That is not a known territory.\n");
           }
           done = false;
           
           //read user input for selecting attacking unit type-group
           while(done == false){
               if(attackingTerritory.getIsLand()){
                   //land territory
                   int infantry = attackingTerritory.getInfantry(currentFaction);
                   int artillery = attackingTerritory.getArtillery(currentFaction);
                   int tank = attackingTerritory.getTanks(currentFaction);
                   int fighter = attackingTerritory.getFighters(currentFaction);
                   int bomber = attackingTerritory.getBombers(currentFaction);
                   
                   String roster = String.format("You have %d Infantry, %d Artillery, %d Tanks, %d Fighters, and %d Bombers.\n", infantry, artillery, tank, fighter, bomber);
                   System.out.print(roster);
               }
               else{
                   //sea territory
                   int battleship = attackingTerritory.getBattleships(currentFaction);
                   int carrier = attackingTerritory.getAircraftCarriers(currentFaction);
                   int transport = attackingTerritory.getTransports(currentFaction);
                   int submarine = attackingTerritory.getSubmarines(currentFaction);
                   int destroyer = attackingTerritory.getDestroyers(currentFaction);
                   
                   String roster = String.format("You have %d Battleships, %d Aircraft Carriers, %d Transports, %d Submarines, and %d Destroyers.\n", battleship, carrier, transport, submarine, destroyer);
                   System.out.print(roster);
               }
           
               System.out.print("Enter the unit type you would like to mobilize: ");
               attackingUnit = input.next( );
               //check is unit
               if(attackingUnit.equals("Infantry")){
                   System.out.print("Enter the number of units you would like to mobilize: ");
                   String unitStrength = input.next( );
               }
               else if(attackingUnit.equals("Artillery")){
                   
               }
               else if(attackingUnit.equals("Tank")){
                   
               }
               else if(attackingUnit.equals("Fighter")){
                   
               }
               else if(attackingUnit.equals("Bomber")){
                   
               }
               else if(attackingUnit.equals("Battleship")){
                   
               }
               else if(attackingUnit.equals("Carrier")){
                   
               }
               else if(attackingUnit.equals("Transport")){
                   
               }
               else if(attackingUnit.equals("Submarine")){
                   
               }
               else if(attackingUnit.equals("Destroyer")){
                   
               }
               else{
                   System.out.print("That is not a valid unit type.\n");
               }
           }
           
           //read user input for selecting territory to attack, todo
           while(done == false){
               System.out.print("Enter the territory you would like to attack: ");
               defenderName = input.next( );
               //check is territory
               defendingTerritory = getTerritoryFromName(defenderName);
               if(defendingTerritory == null){
                   System.out.print("That is not a known territory.\n");
                   return;
               }
               //check is enemy
               if(allyFaction(currentFaction, defendingTerritory.getFaction())){
                   System.out.print("That is an allied territory!\n");
                   return;
               }
           }
           done = false;
           //cleanup and packaging of Attack
       }
       
       //Combat Resolution phase
       //moves through all territories checking for invaders
       for(int i = 1; i < 143; i++){
           if((territoryList[i].getFaction() % 2) == 0){
               if((territoryList[i].getInfantry(1) > 0) | (territoryList[i].getInfantry(3) > 0)){
                   resolveCombat(territoryList[i]);
               }
           }
           else{
               if((territoryList[i].getInfantry(0) > 0) | (territoryList[i].getInfantry(2) > 0) | (territoryList[i].getInfantry(4) > 0)){
                   resolveCombat(territoryList[i]);
               }
           }
       }
   }
   
   
    /**
    * A helper function to facilitate a single combat move for any single-type
    * group of units
    * Note that many units have more than one combat move per turn, this is not
    * accounted for here
    * @param currentFaction is the faction moving their units
    * @param units are the unit type moving
    * @param numberOfUnits is the number of units moving
    * //@param unitMoves is the number of territories a unit can move (fungible)
    * @param attackingTerritory is the territory the units are coming from
    * @param defendingTerritory is the territory the units are going to
    */
   public static void combatMove(int currentFaction, Unit units, int numberOfUnits, Territory attackingTerritory, Territory defendingTerritory){
       //if(unitMoves == 0) return;
       String unitType = units.getType();
       if(unitType.equals("Infantry")){
           //add units to invaded territory
           if(defendingTerritory.setInfantry(currentFaction, numberOfUnits)){
               int remaining = attackingTerritory.getInfantry(currentFaction) - numberOfUnits;
               //removes units from staging territory
               if(attackingTerritory.setInfantry(currentFaction, remaining)){
                   return;
               }
           }
       }
       else if(unitType.equals("Artillery")){
           //add units to invaded territory
           if(defendingTerritory.setArtillery(currentFaction, numberOfUnits)){
               int remaining = attackingTerritory.getArtillery(currentFaction) - numberOfUnits;
               //removes units from staging territory
               if(attackingTerritory.setArtillery(currentFaction, remaining)){
                   return;
               }
           }
       }
       else if(unitType.equals("Tank")){
           //add units to invaded territory
           if(defendingTerritory.setTanks(currentFaction, numberOfUnits)){
               int remaining = attackingTerritory.getTanks(currentFaction) - numberOfUnits;
               //removes units from staging territory
               if(attackingTerritory.setTanks(currentFaction, remaining)){
                   return;
               }
           }
       }
       else if(unitType.equals("Fighter")){
           //add units to invaded territory
           if(defendingTerritory.setFighters(currentFaction, numberOfUnits)){
               int remaining = attackingTerritory.getFighters(currentFaction) - numberOfUnits;
               //removes units from staging territory
               if(attackingTerritory.setFighters(currentFaction, remaining)){
                   return;
               }
           }
       }
       else if(unitType.equals("Bomber")){
           //add units to invaded territory
           if(defendingTerritory.setBombers(currentFaction, numberOfUnits)){
               int remaining = attackingTerritory.getBombers(currentFaction) - numberOfUnits;
               //removes units from staging territory
               if(attackingTerritory.setBombers(currentFaction, remaining)){
                   return;
               }
           }
       }
       else if(unitType.equals("Battleship")){
           //add units to invaded territory
           if(defendingTerritory.setBattleships(currentFaction, numberOfUnits)){
               int remaining = attackingTerritory.getBattleships(currentFaction) - numberOfUnits;
               //removes units from staging territory
               if(attackingTerritory.setBattleships(currentFaction, remaining)){
                   return;
               }
           }
       }
       else if(unitType.equals("Carrier")){
           if(defendingTerritory.setAircraftCarriers(currentFaction, numberOfUnits)){
               int remaining = attackingTerritory.getAircraftCarriers(currentFaction) - numberOfUnits;
               //removes units from staging territory
               if(attackingTerritory.setAircraftCarriers(currentFaction, remaining)){
                   return;
               }
           }
       }
       else if(unitType.equals("Transport")){
           if(defendingTerritory.setTransports(currentFaction, numberOfUnits)){
               int remaining = attackingTerritory.getTransports(currentFaction) - numberOfUnits;
               //removes units from staging territory
               if(attackingTerritory.setTransports(currentFaction, remaining)){
                   return;
               }
           }
       }
       else if(unitType.equals("Submarine")){
           if(defendingTerritory.setSubmarines(currentFaction, numberOfUnits)){
               int remaining = attackingTerritory.getSubmarines(currentFaction) - numberOfUnits;
               //removes units from staging territory
               if(attackingTerritory.setSubmarines(currentFaction, remaining)){
                   return;
               }
           }
       }
       else if(unitType.equals("Destroyer")){
           if(defendingTerritory.setDestroyers(currentFaction, numberOfUnits)){
               int remaining = attackingTerritory.getDestroyers(currentFaction) - numberOfUnits;
               //removes units from staging territory
               if(attackingTerritory.setDestroyers(currentFaction, remaining)){
                   return;
               }
           }
       }
   }
   
   
   /**
    * Helper function to resolve combats for units in hostile territories
    * @param territory is the territory that needs resolution
    */
   public static void resolveCombat(Territory territory){
       //country booleans only true if enemies to territory controller
       boolean Russia = false, Germany = false, UK = false, Japan = false, US = false;
       boolean enemies[] = new boolean[5];
       boolean allies[] = new boolean[5];
       int owner = territory.getFaction();
       //determine enemies
       if(owner % 2 == 0){
           Germany = territory.getIsFactionUnits(1);
           Japan = territory.getIsFactionUnits(3);
       }
       else{
           Russia = territory.getIsFactionUnits(0);
           UK = territory.getIsFactionUnits(2);
           US = territory.getIsFactionUnits(4);
       }
       enemies[0] = Russia;
       enemies[1] = Germany;
       enemies[2] = UK;
       enemies[3] = Japan;
       enemies[4] = US;
       allies[0] = !Russia;
       allies[1] = !Germany;
       allies[2] = !UK;
       allies[3] = !Japan;
       allies[4] = !US;
       //roll for combat
       boolean concluded = false;
       while(concluded == false){
            //roll for Opening Fire
            int airCasualty = 0;
            if(territory.getAntiAircraft()){
                if(Russia) airCasualty = airCasualty + flacked(territory, 0);
                if(Germany) airCasualty = airCasualty + flacked(territory, 1);
                if(UK) airCasualty = airCasualty + flacked(territory, 2);
                if(Japan) airCasualty = airCasualty + flacked(territory, 3);
                if(US) airCasualty = airCasualty + flacked(territory, 4);
            }
            String out = String.format("There were %d casualties from Opening Fire from Anti-Aircraft batteries.\n", airCasualty);
            System.out.print(out);
            //Naval Bombardment todo
            //Submarines todo
            //roll for Attackers
            int[][] attackers = new int[5][8];
            for(int i = 0; i < 5; i++){
                if(enemies[i]){
                    attackers[i][0] = attackers[i][0] + territory.getInfantry(i);
                    attackers[i][1] = attackers[i][1] + territory.getArtillery(i);
                    attackers[i][2] = attackers[i][2] + territory.getTanks(i);
                    attackers[i][3] = attackers[i][3] + territory.getFighters(i);
                    attackers[i][4] = attackers[i][4] + territory.getBombers(i);
                    attackers[i][5] = attackers[i][5] + territory.getBattleships(i);
                    attackers[i][6] = attackers[i][6] + territory.getAircraftCarriers(i);
                    attackers[i][7] = attackers[i][7] + territory.getDestroyers(i);
                }
            }
            int defenderCasualties = attackCasualties(attackers, enemies);
            //roll for Defenders
            int[][] defenders = new int[5][9];
            for(int i = 0; i < 5; i++){
                if(!enemies[i]){
                    defenders[i][0] = defenders[i][0] + territory.getInfantry(i);
                    defenders[i][1] = defenders[i][1] + territory.getArtillery(i);
                    defenders[i][2] = defenders[i][2] + territory.getTanks(i);
                    defenders[i][3] = defenders[i][3] + territory.getFighters(i);
                    defenders[i][4] = defenders[i][4] + territory.getBombers(i);
                    defenders[i][5] = defenders[i][5] + territory.getBattleships(i);
                    defenders[i][6] = defenders[i][6] + territory.getAircraftCarriers(i);
                    defenders[i][6] = defenders[i][7] + territory.getTransports(i);
                    defenders[i][7] = defenders[i][8] + territory.getDestroyers(i);
                }
            }
            int attackerCasualties = defenceCasualties(defenders, allies);
            //Press Attack or Retreat
       }
   }
   
   
   /**
    * Helper function to resolve anti-aircraft opening fire
    * @param territory is the territory that does the flacking
    * @param faction is the faction being flacked
    * Citation: http://introcs.cs.princeton.edu/java/13flow/RollDie.java.html
    */
   public static int flacked(Territory territory, int faction){
       int planes = territory.getBombers(faction) + territory.getFighters(faction);
       int casualty = 0;
       for(int i = 0; i < planes; i++){
           if(((int) (Math.random() * 6) + 1) < 2){
               casualty++;
           }
       }
       return casualty;
   }
   
   
   /**
    * Helper function to resolve attack-caused casualties
    * @param roster are all of the units, [faction][type]
    * @param attackers
    * Note: todo: add the capacity to understand which units have been upgraded in any faction
    */
    public static int attackCasualties(int[][] roster, boolean[] attackers){
        int infantryAttack = 1;
        int artilleryAttack = 2;
        int tankAttack = 3;
        int fighterAttack = 3;
        int bomberAttack = 4;
        int battleshipAttack = 4;
        int carrierAttack = 1;
        int destroyerAttack = 3;
        int casualties = 0;
        //check each faction
        for(int j = 0; j < 4; j++){
            //If you are attacking, be counted
            if(attackers[j]){
                //Infantry
                for(int i = 0; i < roster[j][0]; i++){
                    if(((int) (Math.random() * 6) + 1) < infantryAttack){
                        casualties++;
                    }
                }
                //Artillery
                    for(int i = 0; i < roster[j][1]; i++){
                    if(((int) (Math.random() * 6) + 1) < artilleryAttack){
                        casualties++;
                    }
                }
               //Tanks
                for(int i = 0; i < roster[j][2]; i++){
                    if(((int) (Math.random() * 6) + 1) < tankAttack){
                        casualties++;
                    }
                }
                //Fighters
                for(int i = 0; i < roster[j][3]; i++){
                    if(((int) (Math.random() * 6) + 1) < fighterAttack){
                        casualties++;
                    }
                }
                //Bombers
                for(int i = 0; i < roster[j][4]; i++){
                    if(((int) (Math.random() * 6) + 1) < bomberAttack){
                        casualties++;
                    }
                }
                //Battleship
                for(int i = 0; i < roster[j][5]; i++){
                    if(((int) (Math.random() * 6) + 1) < battleshipAttack){
                        casualties++;
                    }
                }
                //Carrier
                for(int i = 0; i < roster[j][6]; i++){
                    if(((int) (Math.random() * 6) + 1) < carrierAttack){
                        casualties++;
                    }
                }
                //Destroyer
                for(int i = 0; i < roster[j][7]; i++){
                    if(((int) (Math.random() * 6) + 1) < destroyerAttack){
                        casualties++;
                    }
                }
            }
            //end of counting loop
        }
        String out = String.format("Attackers deal %d casualties to Defenders!\n", casualties);
        System.out.print(out);
        return casualties;
    }
   
    
   /**
    * Helper function to resolve defense-caused casualties
    * @param roster are all of the units, [faction][type]
    * @param defenders
    * Note: todo: add the capacity to understand which units have been upgraded in any faction
    */
    public static int defenceCasualties(int[][] roster, boolean[] defenders){
        int infantryDefence = 2;
        int artilleryDefence = 2;
        int tankDefence = 3;
        int fighterDefence = 4;
        int bomberDefence = 1;
        int battleshipDefence = 4;
        int carrierDefence = 3;
        int transportDefence = 1;
        int destroyerDefence = 3;
        int casualties = 0;
        //check each faction
        for(int j = 0; j < 4; j++){
            //If you are defending, be counted
            if(defenders[j]){
                //Infantry
                for(int i = 0; i < roster[j][0]; i++){
                    if(((int) (Math.random() * 6) + 1) < infantryDefence){
                        casualties++;
                    }
                }
                //Artillery
                    for(int i = 0; i < roster[j][1]; i++){
                    if(((int) (Math.random() * 6) + 1) < artilleryDefence){
                        casualties++;
                    }
                }
               //Tanks
                for(int i = 0; i < roster[j][2]; i++){
                    if(((int) (Math.random() * 6) + 1) < tankDefence){
                        casualties++;
                    }
                }
                //Fighters
                for(int i = 0; i < roster[j][3]; i++){
                    if(((int) (Math.random() * 6) + 1) < fighterDefence){
                        casualties++;
                    }
                }
                //Bombers
                for(int i = 0; i < roster[j][4]; i++){
                    if(((int) (Math.random() * 6) + 1) < bomberDefence){
                        casualties++;
                    }
                }
                //Battleship
                for(int i = 0; i < roster[j][5]; i++){
                    if(((int) (Math.random() * 6) + 1) < battleshipDefence){
                        casualties++;
                    }
                }
                //Carrier
                for(int i = 0; i < roster[j][6]; i++){
                    if(((int) (Math.random() * 6) + 1) < carrierDefence){
                        casualties++;
                    }
                }
                //Transport
                for(int i = 0; i < roster[j][7]; i++){
                    if(((int) (Math.random() * 6) + 1) < transportDefence){
                        casualties++;
                    }
                }
                //Destroyer
                for(int i = 0; i < roster[j][8]; i++){
                    if(((int) (Math.random() * 6) + 1) < destroyerDefence){
                        casualties++;
                    }
                }
            }
            //end of counting loop
        }
        String out = String.format("Defenders deal %d casualties to Attackers!\n", casualties);
        System.out.print(out);
        return casualties;
    }
    
   
   /**
    * Initialize all territories to their default values and owners
    * Initialization according to 2004 Revised Edition Ruleset
    */
   public static void initializeTerritories()
   {
      int i;
      //Deployment territory
      territoryList[0] = new Territory("Deployment Zone", 0, 0, false, false, 
            false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      //Water territories
      for(i = 1; i <= WATER_TERRITORY_COUNT; i++){
         String initName = "" + i;
         territoryList[i] = new Territory(initName, 0, 0, false, false, 
               false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      }
      
      //Land Territories
      //Format: Name, faction, value, land, neutral, capital, victory,
      //infantry, artillery, tank, fighter, bomber, battleship, 
      //aircraft carrier, transport, submarine, destroyer, AA Gun, indust compl
      territoryList[65] = new Territory("Eastern Canada", 2, 3, true, false, 
            false, false, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[66] = new Territory("Eastern United States", 4, 12, true, 
            false, true, true, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, true, true);
      territoryList[67] = new Territory("Panama", 4, 1, true, false, false, 
            false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[68] = new Territory("Venezuela", 0, 0, true, true, false, 
            false,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[69] = new Territory("Peru", 0, 0, true, true, false, false,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[70] = new Territory("Brazil", 4, 3, true, false, false, 
            false,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[71] = new Territory("Argentina", 0, 0, true, true, false, 
            false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[72] = new Territory("Greenland", 4, 0, true, false, false, 
            false,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[73] = new Territory("West Indies", 4, 1, true, false, 
            false, false,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[74] = new Territory("Eire", 0, 0, true, true, false, false,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[75] = new Territory("United Kingdom", 2, 8, true, false, 
            true, true, 2, 1, 1, 2, 1, 1, 0, 1, 0, 0, true, true);
      territoryList[76] = new Territory("Norway", 1, 3, true, false, false, 
            false, 3, 0, 2, 1, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[77] = new Territory("Sweden", 0, 0, true, true, false, 
            false,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[78] = new Territory("Spain", 0, 0, true, true, false, 
            false,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[79] = new Territory("Gibraltar", 2, 0, true, false, false, 
            false,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[80] = new Territory("Western Europe", 1, 6, true, false, 
            false, true, 2, 0, 2, 1, 0, 0, 0, 0, 0, 0, true, false);
      territoryList[81] = new Territory("Switzerland", 0, 0, true, true, 
            false, false,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[82] = new Territory("Germany", 1, 10, true, false, 
            true, true, 3, 0, 2, 1, 1, 0, 0, 0, 0, 0, true, true);
      territoryList[83] = new Territory("Southern Europe", 1, 6, true, false, 
            false, true, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, true, true);
      territoryList[84] = new Territory("Eastern Europe", 1, 3, true, false, 
            false, false, 2, 0, 1, 1, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[85] = new Territory("Balkans", 1, 3, true, false, 
            false, false, 2, 0, 1, 1, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[86] = new Territory("Belorussia", 1, 2, true, false, 
            false, false, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[87] = new Territory("Ukraine S.S.R.", 1, 3, true, false, 
            false, false, 3, 1, 1, 1, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[88] = new Territory("West Russia", 1, 2, true, false, 
            false, false, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[89] = new Territory("Algeria", 1, 1, true, false, 
            false, false, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[90] = new Territory("Libya", 1, 1, true, false, 
            false, false, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[91] = new Territory("Sahara", 0, 0, true, true, 
            false, false,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[92] = new Territory("Anglo-Egypt", 2, 2, true, false, 
            false, false, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[93] = new Territory("Rio De Oro", 0, 0, true, true, 
            false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[94] = new Territory("French West Africa", 2, 1, true, false, 
            false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[95] = new Territory("French Equitorial Africa", 2, 1, true, 
            false, false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[96] = new Territory("Italian East Africa", 2, 1, true, 
            false, false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[97] = new Territory("Belgian Congo", 2, 1, true, false, 
            false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[98] = new Territory("Rhodesia", 2, 1, true, false, 
            false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[99] = new Territory("Angola", 2, 1, true, false,
            false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[100] = new Territory("Union of South Africa", 2, 2, true, 
            false, false, false, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[101] = new Territory("Mozambique", 0, 0, true, true, 
            false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[102] = new Territory("French Madagascar", 2, 1, true, false,
            false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[103] = new Territory("Turkey", 0, 0, true, true, 
            false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[104] = new Territory("Saudi Arabia", 0, 0, true, true,
            false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[105] = new Territory("Trans-Jordan", 2, 1, true, false, 
            false, false, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[106] = new Territory("Persia", 2, 1, true, false, 
            false, false, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[107] = new Territory("India", 2, 3, true, false, 
            false, true, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, true, false);
      territoryList[108] = new Territory("Afghanistan", 0, 0, true, true, 
            false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[109] = new Territory("Himalaya", 0, 0, true, true, 
            false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[110] = new Territory("Karelia S.S.R.", 0, 2, true, false, 
            false, true, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[111] = new Territory("Archangel", 0, 2, true, false, 
            false, false, 3, 0, 1, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[112] = new Territory("Russia", 0, 8, true, false, 
            true, true, 3, 1, 2, 1, 0, 0, 0, 0, 0, 0, true, true);
      territoryList[113] = new Territory("Caucasus",0, 4, true, false, 
            false, false, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, true, true);
      territoryList[114] = new Territory("Kazakh S.S.R.", 0, 2, true, false, 
            false, false, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[115] = new Territory("Novosibirsk", 0, 2, true, false, 
            false, false, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[116] = new Territory("Evenki National Okrug", 0, 1, true, 
            false, false, false, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[117] = new Territory("Sinkiang", 4, 2, true, false, 
            false, false, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[118] = new Territory("China", 4, 2, true, false, 
            false, false, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[119] = new Territory("Yakut S.S.R.", 0, 1, true, false, 
            false, false, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[120] = new Territory("Soviet Far East", 0, 1, true, false,
            false, false, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[121] = new Territory("Buryatia S.S.R.", 0, 1, true, false, 
            false, false, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[122] = new Territory("Manchuria", 3, 3, true, false, 
            false, false, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[123] = new Territory("Kwangtung", 3, 3, true, false, 
            false, true, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[124] = new Territory("French Indochina", 3, 3, true, 
            false, false, false, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[125] = new Territory("Japan", 3, 8, true, false, 
            true, true, 4, 1, 1, 1, 1, 0, 0, 0, 0, 0, true, true);
      territoryList[126] = new Territory("Philippine Islands", 3, 3, true, 
            false, false, true, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[127] = new Territory("Okinawa", 3, 1, true, false, 
            false, false, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[128] = new Territory("Wake Island", 3, 0, true, false, 
            false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[129] = new Territory("East Indies", 3, 4, true, false, 
            false, false, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[130] = new Territory("Borneo", 3, 4, true, false, 
            false, false, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[131] = new Territory("New Guinea", 3, 1, true, false, 
            false, false, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[132] = new Territory("Caroline Island", 3, 0, true, false, 
            false, false, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[133] = new Territory("Solomon Islands", 3, 0, true, false, 
            false, false, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[134] = new Territory("Australia", 2, 2, true, false, 
            false, false, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[135] = new Territory("New Zealand", 2, 1, true, false, 
            false, false, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[136] = new Territory("Hawaiian Islands", 4, 1, true, false, 
            false, false, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[137] = new Territory("Midway Island", 4, 0, true, false, 
            false, false, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[138] = new Territory("Alaska", 4, 2, true, false, 
            false, false, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[139] = new Territory("Western Canada", 2, 1, true, false, 
            false, false, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[140] = new Territory("Western United States", 4, 10, true, 
            false, false, true, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, true, true);
      territoryList[141] = new Territory("Central United States", 4, 6, true, 
            false, false, false, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);
      territoryList[142] = new Territory("Mexico", 4, 2, true, false, 
            false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false);

      //Init sea territories
      //Format: Battleship, aircraft carrier, transport, submarine, destroyer
      //Soviet Union
      territoryList[4].updateSeaUnits(0, 0, 0, 0, 1, 0);
      
      //Germany
      territoryList[5].updateSeaUnits(1, 0, 0, 1, 2, 1);
      territoryList[8].updateSeaUnits(1, 0, 0, 0, 1, 0);
      territoryList[14].updateSeaUnits(1, 1, 0, 1, 0, 0);
      
      //United Kingdom
      territoryList[2].updateSeaUnits(2, 1, 0, 1, 0, 0);
      territoryList[1].updateSeaUnits(2, 0, 0, 1, 0, 0);
      territoryList[40].updateSeaUnits(2, 0, 0, 1, 1, 0);
      territoryList[35].updateSeaUnits(2, 0, 1, 1, 0, 1);
      territoryList[15].updateSeaUnits(2, 0, 0, 0, 0, 1);
      territoryList[13].updateSeaUnits(2, 1, 0, 0, 0, 0);
      
      //Japan
      territoryList[60].updateSeaUnits(3, 1, 0, 1, 0, 0);
      territoryList[59].updateSeaUnits(3, 0, 0, 1, 0, 0);
      territoryList[37].updateSeaUnits(3, 1, 1, 0, 0, 0);
      territoryList[50].updateSeaUnits(3, 0, 1, 0, 0, 1);
      territoryList[45].updateSeaUnits(3, 0, 0, 0, 1, 0);
      
      //United States
      territoryList[55].updateSeaUnits(4, 1, 0, 1, 0, 0);
      territoryList[10].updateSeaUnits(4, 0, 0, 2, 0, 1);
      territoryList[20].updateSeaUnits(4, 0, 0, 0, 0, 1);
      territoryList[52].updateSeaUnits(4, 0, 1, 0, 1, 0);
   }      
   /**
    * Helper function to print all territory names
    */
   public static void printTerrs()
   {
      for(int i = 0; i < MAX_TERRITORIES; i++)
      {
        System.out.println("" + territoryList[i].getName());
      }
   }
   
   public static Territory getTerritoryFromName(String inputString)
   {
      for(int j = 0; j < MAX_TERRITORIES; j++)
      {
        String name = territoryList[j].getName();
        if(name.equals(inputString)) return territoryList[j];
      }
      System.out.print("Territory name lookup failed.\n");
      return null;
   }

}
