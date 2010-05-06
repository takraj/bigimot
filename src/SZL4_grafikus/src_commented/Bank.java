
/**
 * A Bank oszt�lya.
 * 
 * @author TakRaj
 *
 */

public class Bank extends Building {

	/**
	 * Az objektum konstruktora. Megadhat�, hogy hova rakja a Bankot.
	 * 
	 * @param keeper Az a RoadBlock amire a Bank ker�lj�n.
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
	 * Ezzel a f�ggv�nnyel lek�rdezhetj�k, hogy az adott objektump�ld�ny
	 * mit reprezent�l.
	 * 
	 * @return Az objektump�ld�ny azonos�t�ja.
	 */
	
	@Override
	public String WhoAmI(){
		return "Bank";
	}

}