import java.io.BufferedWriter;


public class Building {

	/**
	 * Az oszt�ly felel majd az �p�letek�rt
	 *  @param keeper Az oszt�ly�rt felel�s Roadblock 
	 */
	public Building(RoadBlock keeper)
	{
		keeper.setBuilding(this); //itt fogja hozz�rendelni mag�t a felel�s roadblockhoz
	}
	public void getRole(Car c) {
	}
	public void save(BufferedWriter out){};
}