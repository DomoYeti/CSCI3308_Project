/** 
 * MainGame runs the application and makes calls to each game phase
 * @version 0.3
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
       
      initializePlayers();
      initializeTerritories();
      //printTerrs();
      short victory = 0;
      int currentPlayer = 0;
       
      while(victory == 0){
           
        if(currentPlayer == 6)
               for(int i=1; i<6; i++){
                   //faction[i].victory = victory;
                i = 1;
            }
        developWeapons(currentPlayer);
        //purchaseUnits()
        //combat()
        //move()
        //mobilizeNewUnits()
        //collectIncome()
           
        currentPlayer = (currentPlayer + 1) % MAX_PLAYERS;
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
   
   public static void combatMoveAndCombat(int currentPlayer, int currentFaction){
       Attack[] attackList = new Attack[MAX_TERRITORIES];
       int numberOfAttacks = 0;
       //Combat Move phase
       boolean concluded = false;
       while(concluded == false){
           //prepare a new attack
           Attack currentAttack = null;
           boolean done = false;
           String attackerName;
           String defenderName;
           Territory attackingTerritory = null;
           Territory defendingTerritory = null;
           
           //read user input for selecting attacking territory
           while(done == false){
               System.out.print("Enter the territory you would like to mobilize from: ");
               attackerName = input.next( );
               //check is territory
               attackingTerritory = getTerritoryFromName(attackerName);
               if(attackingTerritory == null){
                   System.out.print("That is not a known territory.\n");
                   return;
               }
               //check is owned
               if(currentFaction != attackingTerritory.getFaction()){
                   System.out.print("You do not control that territory!\n");
                   return;
               }
           }
           done = false;
           currentAttack.setAttacker(attackingTerritory);
           
           //read user input for selecting territory to attack
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
           currentAttack.setDefender(defendingTerritory);
           
           //read user input for selecting units to attack
           while(done == false){
               
               System.out.print("Enter the territory you would like to attack: ");
           }
           
           //cleanup and packaging of Attack
           attackList[numberOfAttacks] = currentAttack;
           numberOfAttacks++;
       }
       
       //Combat Resolution phase
       

       
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
   
   public static Territory getTerritoryFromName(String nameString)
   {
      for(int i = 0; i < MAX_TERRITORIES; i++)
      {
        if(territoryList[i].getName() == nameString) return territoryList[i];
      }
      return null;
   }

}
