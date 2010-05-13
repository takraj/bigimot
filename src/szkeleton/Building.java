
public class Building {

	/**
	 * Az osztály felel majd az épületekért
	 *  @param keeper Az osztályért felelős Roadblock 
	 */
	public Building(RoadBlock keeper)
	{
		System.out.println("Building()-Begin");
		
		keeper.setBuilding(this); //itt fogja hozzárendelni magát a felelős roadblockhoz
		
		System.out.println("Building()-End");
	}
	public int getRole() {
		throw new UnsupportedOperationException();
	}

}