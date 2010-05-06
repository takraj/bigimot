
/**
 * Ez az osztály reprezentálja az egyszerû épületeket.
 * A program jelenlegi verziója ezt nem használja direkt módon.
 * 
 * @author TakRaj
 *
 */

public class Building {
	
	private ElementView view;

	/**
	 * Az osztály konstruktora.
	 * 
	 *  @param keeper Az osztályért felelõs RoadBlock (ezen van az épület)
	 */
	public Building(RoadBlock keeper)
	{
		keeper.setBuilding(this); //itt fogja hozzárendelni magát a felelõs roadblockhoz
	}
	
	/**
	 * ?????
	 */
	public void getRole(Car c) {
	}
	
	/**
	 * Nézet beállítása.
	 * 
	 * @param v A megjelenítésért felelõs objektum.
	 */
	
	public void SetView(ElementView v){
		view = v;
	}
	
	/**
	 * Megadja, hogy mi az aktuálisan beállított nézet erre az objektumpéldányra.
	 * 
	 * @return Az aktuális nézet.
	 */
	
	public ElementView GetView(){
		return view;
	}
	
	/**
	 * Megadja, hogy az aktuális objektumpéldány hogyan azonosítja magát.
	 * 
	 * @return Azonosító string.
	 */
	
	public String WhoAmI(){
		return "Building";
	}
}