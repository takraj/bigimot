import java.io.BufferedWriter;


public class Building {

	/**
	 * Az osztály felel majd az épületekért
	 *  @param keeper Az osztályért felelős Roadblock 
	 */
	public Building(RoadBlock keeper)
	{
		keeper.setBuilding(this); //itt fogja hozzárendelni magát a felelős roadblockhoz
	}
	public void getRole(Car c) {
	}
	public void save(BufferedWriter out){};
}