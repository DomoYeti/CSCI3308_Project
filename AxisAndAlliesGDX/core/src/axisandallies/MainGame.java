package axisandallies;

//import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame /*extends ApplicationAdapter*/ {

   //158 Territories plus a deployment territory
   final static int MAX_TERRITORIES = 144;
   final static int WATER_TERRITORY_COUNT = 64;
   //PlayerIDs
   //Need to be updated
   int playerID1 = 1, playerID2 = 2, playerID3 = 3, playerID4 = 4, playerID5 = 5;
   Territory[] territoryList = new Territory[MAX_TERRITORIES];

   //List of initial territories and their default values
   //Board set up initialization
   public void initialize(){
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
   }
      

   /*
   ***** Original main files *****
   SpriteBatch batch;
   Texture img;
   
   @Override
   public void create () {
      batch = new SpriteBatch();
      img = new Texture("badlogic.jpg");
   }
   @Override
   public void render () {
      Gdx.gl.glClearColor(1, 0, 0, 1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      batch.begin();
      batch.draw(img, 0, 0);
      batch.end();
   }*/
}
