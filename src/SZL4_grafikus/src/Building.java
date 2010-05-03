import java.io.BufferedWriter;


public class Building {

	/**
	 * Az osztály felel majd az épületekért
	 *  @param keeper Az osztályért felelõs Roadblock 
	 */
	public Building(RoadBlock keeper)
	{
		keeper.setBuilding(this); //itt fogja hozzárendelni magát a felelõs roadblockhoz
	}
	public void getRole(Car c) {
	}
	public void save(BufferedWriter out){};
}