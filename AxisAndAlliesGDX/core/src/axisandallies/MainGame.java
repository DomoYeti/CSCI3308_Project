package axisandallies;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends ApplicationAdapter {

	//158 Territories plus a deployment territory
	final static int MAX_TERRITORIES = 160;
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
		//territoryList[0] = new Territory(
		//Water territories
		for(i = 1; i <= WATER_TERRITORY_COUNT; i++){
			String initName = "" + i;
			territoryList[i] = new Territory(initName, 0, 0, false, false, false, false);
		}
		//Land Territories
		territoryList[i++] = new Territory("Eastern Canada", 2, 3, true, false, false, false);
		territoryList[i++] = new Territory("Eastern United States", 4, 12, true, false, true, true);
		territoryList[i++] = new Territory("Panama", 4, 1, true, false, false, false);
		territoryList[i++] = new Territory("Venezuela", 0, 0, true, true, false, false);
		territoryList[i++] = new Territory("Peru", 0, 0, true, true, false, false);
		territoryList[i++] = new Territory("Brazil", 4, 3, true, false, false, false);
		territoryList[i++] = new Territory("Argentina", 0, 0, true, true, false, false);
		territoryList[i++] = new Territory("Greenland", 4, 0, true, false, false, false);
		territoryList[i++] = new Territory("West Indies", 4, 1, true, false, false, false);
		territoryList[i++] = new Territory("Eire", 0, 0, true, true, false, false);
		territoryList[i++] = new Territory("United Kingdom", 2, 8, true, false, true, true);
		territoryList[i++] = new Territory("Norway", 1, 3, true, false, false, false);
		territoryList[i++] = new Territory("Sweden", 0, 0, true, true, false, false);
		territoryList[i++] = new Territory("Spain", 0, 0, true, true, false, false);
		territoryList[i++] = new Territory("Gibraltar", 2, 0, true, false, false, false);
		territoryList[i++] = new Territory("Western Europe", 1, 6, true, false, false, true);
		territoryList[i++] = new Territory("Switzerland", 0, 0, true, true, false, false);
		territoryList[i++] = new Territory("Germany", 1, 10, true, false, true, true);
		territoryList[i++] = new Territory("Southern Europe", 1, 6, true, false, false, true);
		territoryList[i++] = new Territory("Eastern Europe", 1, 3, true, false, false, false);
		territoryList[i++] = new Territory("Balkans", 1, 3, true, false, false, false);
		territoryList[i++] = new Territory("Belorussia", 1, 2, true, false, false, false);
		territoryList[i++] = new Territory("Ukraine S.S.R.", 1, 3, true, false, false, false);
		territoryList[i++] = new Territory("West Russia", 1, 2, true, false, false, false);
		territoryList[i++] = new Territory("Algeria", 1, 1, true, false, false, false);
		territoryList[i++] = new Territory("Libya", 1, 1, true, false, false, false);
		territoryList[i++] = new Territory("Sahara", 0, 0, true, true, false, false);
		territoryList[i++] = new Territory("Anglo-Sahara", 2, 2, true, false, false, false);
		territoryList[i++] = new Territory("Rio De Oro", 0, 0, true, true, false, false);
		territoryList[i++] = new Territory("French West Africa", 2, 1, true, false, false, false);
		territoryList[i++] = new Territory("French Equitorial Africa", 2, 1, true, false, false, false);
		territoryList[i++] = new Territory("Italian East Africa", 2, 1, true, false, false, false);
		territoryList[i++] = new Territory("Belgian Congo", 2, 1, true, false, false, false);
		territoryList[i++] = new Territory("Rhodesia", 2, 1, true, false, false, false);
		territoryList[i++] = new Territory("Angola", 2, 1, true, false, false, false);
		territoryList[i++] = new Territory("Union of South Africa", 2, 2, true, false, false, false);
		territoryList[i++] = new Territory("Mozambique", 0, 0, true, true, false, false);
		territoryList[i++] = new Territory("French Madagascar", 2, 1, true, false, false, false);
		territoryList[i++] = new Territory("Turkey", 0, 0, true, true, false, false);
		territoryList[i++] = new Territory("Saudi Arabia", 0, 0, true, true, false, false);
		territoryList[i++] = new Territory("Trans-Jordan", 2, 1, true, false, false, false);
		territoryList[i++] = new Territory("India", 2, 3, true, false, false, true);
		territoryList[i++] = new Territory("Afghanistan", 0, 0, true, true, false, false);
		territoryList[i++] = new Territory("Himalaya", 0, 0, true, true, false, false);
		territoryList[i++] = new Territory("Karelia S.S.R.", 0, 2, true, false, false, true);
		territoryList[i++] = new Territory("Archangel", 0, 2, true, false, false, false);
		territoryList[i++] = new Territory("Russia", 0, 8, true, false, true, true);
		territoryList[i++] = new Territory("Caucasus",0, 4, true, false, false, false);
		territoryList[i++] = new Territory("Kazakh S.S.R.", 0, 2, true, false, false, false);
		territoryList[i++] = new Territory("Novosibirsk", 0, 2, true, false, false, false);
		territoryList[i++] = new Territory("Evenki National Okrug", 0, 1, true, false, false, false);
		territoryList[i++] = new Territory("Sinkiang", 4, 2, true, false, false, false);
		territoryList[i++] = new Territory("China", 4, 2, true, false, false, false);
		territoryList[i++] = new Territory("Yakut S.S.R.", 0, 1, true, false, false, false);
		territoryList[i++] = new Territory("Soviet Far East", 0, 1, true, false, false, false);
		territoryList[i++] = new Territory("Buryatia S.S.R.", 0, 1, true, false, false, false);
		territoryList[i++] = new Territory("Manchuria", 3, 3, true, false, false, false);
		territoryList[i++] = new Territory("Kwangtung", 3, 3, true, false, false, true);
		territoryList[i++] = new Territory("French Indochina", 3, 3, true, false, false, false);
		territoryList[i++] = new Territory("Japan", 3, 8, true, false, true, true);
		territoryList[i++] = new Territory("Philippine Islands", 3, 3, true, false, false, true);
		territoryList[i++] = new Territory("Okinawa", 3, 1, true, false, false, false);
		territoryList[i++] = new Territory("Wake Island", 3, 0, true, false, false, false);
		territoryList[i++] = new Territory("East Indies", 3, 4, true, false, false, false);
		territoryList[i++] = new Territory("Borneo", 3, 4, true, false, false, false);
		territoryList[i++] = new Territory("New Guinea", 3, 1, true, false, false, false);
		territoryList[i++] = new Territory("Caroline Island", 3, 0, true, false, false, false);
		territoryList[i++] = new Territory("Solomon Islands", 3, 0, true, false, false, false);
		territoryList[i++] = new Territory("Australia", 2, 2, true, false, false, false);
		territoryList[i++] = new Territory("New Zealand", 2, 1, true, false, false, false);
		territoryList[i++] = new Territory("Hawaiian Islands", 4, 1, true, false, false, false);
		territoryList[i++] = new Territory("Midway Island", 4, 0, true, false, false, false);
		territoryList[i++] = new Territory("Alaska", 4, 2, true, false, false, false);
		territoryList[i++] = new Territory("Western Canada", 2, 1, true, false, false, false);
		territoryList[i++] = new Territory("Western United States", 4, 10, true, false, false, true);
		territoryList[i++] = new Territory("Central United States", 4, 6, true, false, false, false);
		territoryList[i++] = new Territory("Mexico", 4, 2, true, false, false, false);
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
