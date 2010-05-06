
/**
 * A Bank osztálya.
 * 
 * @author TakRaj
 *
 */

public class Bank extends Building {

	/**
	 * Az objektum konstruktora. Megadható, hogy hova rakja a Bankot.
	 * 
	 * @param keeper Az a RoadBlock amire a Bank kerüljön.
	 */
	
	public Bank(RoadBlock keeper) {
		super(keeper);
	}

	/**
	 * ?????
	 */
	
	public void getRole(Car c) {
		c.AtBuilding(this);
	}
	
	/**
	 * Ezzel a függvénnyel lekérdezhetjük, hogy az adott objektumpéldány
	 * mit reprezentál.
	 * 
	 * @return Az objektumpéldány azonosítója.
	 */
	
	@Override
	public String WhoAmI(){
		return "Bank";
	}

}