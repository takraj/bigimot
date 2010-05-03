import java.io.BufferedWriter;


public class Building {
	
	private ElementView view;

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
	
	public void SetView(ElementView v){
		view = v;
	}
	
	public ElementView GetView(){
		return view;
	}
	
	public String WhoAmI(){
		return "Building";
	}
}