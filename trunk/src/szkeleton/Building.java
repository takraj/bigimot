
public class Building {

	/**
	 * Az oszt�ly felel majd az �p�letek�rt
	 *  @param keeper Az oszt�ly�rt felel�s Roadblock 
	 */
	public Building(RoadBlock keeper)
	{
		System.out.println("Building()-Begin");
		
		keeper.setBuilding(this); //itt fogja hozz�rendelni mag�t a felel�s roadblockhoz
		
		System.out.println("Building()-End");
	}
	public int getRole() {
		throw new UnsupportedOperationException();
	}

}