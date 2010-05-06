
/**
 * Ez az oszt�ly reprezent�lja az egyszer� �p�leteket.
 * A program jelenlegi verzi�ja ezt nem haszn�lja direkt m�don.
 * 
 * @author TakRaj
 *
 */

public class Building {
	
	private ElementView view;

	/**
	 * Az oszt�ly konstruktora.
	 * 
	 *  @param keeper Az oszt�ly�rt felel�s RoadBlock (ezen van az �p�let)
	 */
	public Building(RoadBlock keeper)
	{
		keeper.setBuilding(this); //itt fogja hozz�rendelni mag�t a felel�s roadblockhoz
	}
	
	/**
	 * ?????
	 */
	public void getRole(Car c) {
	}
	
	/**
	 * N�zet be�ll�t�sa.
	 * 
	 * @param v A megjelen�t�s�rt felel�s objektum.
	 */
	
	public void SetView(ElementView v){
		view = v;
	}
	
	/**
	 * Megadja, hogy mi az aktu�lisan be�ll�tott n�zet erre az objektump�ld�nyra.
	 * 
	 * @return Az aktu�lis n�zet.
	 */
	
	public ElementView GetView(){
		return view;
	}
	
	/**
	 * Megadja, hogy az aktu�lis objektump�ld�ny hogyan azonos�tja mag�t.
	 * 
	 * @return Azonos�t� string.
	 */
	
	public String WhoAmI(){
		return "Building";
	}
}