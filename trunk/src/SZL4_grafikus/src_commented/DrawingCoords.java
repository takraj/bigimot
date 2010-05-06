/**
 * Segédosztály a rajzkoordináták meghatározására.
 * 
 * @author TakRaj
 *
 */

public class DrawingCoords {

	private int map_size;
	private int my_position;

	private int drawing_width = 0;
	private int drawing_height = 0;
	
	/**
	 * Az osztály konstruktora.
	 * 
	 * @param size Mekkora a pálya négyzetesen.
	 * @param pos Ebbõl melyik pont koordinátái érdekelnek.
	 */

	public DrawingCoords(int size, int pos){
		map_size = size;
		my_position = pos + 1;
	}
	
	/**
	 * A rajzvászon állítható itt be, ez szükséges a rajzkoordináták meghatározásához,
	 * egyébként elhagyható.
	 * 
	 * @param width Milyen széles. (oszlopok)
	 * @param height Milyen magas. (sorok)
	 */

	public void SetDrawingArea(int width, int height) {
		drawing_width = width;
		drawing_height = height;
	}
	
	/**
	 * Visszaadja az X koordinátát.
	 * 
	 * @return X koordináta.
	 */

	public int GetX() {
		// my_position-t elosztom az sqrt(map_size)-al, és alsó egészrész
		// (floor)
		// visszaszorzom sqrt(map_size)-al
		// ezt a számot kivonom a my_position-ból
		int result = my_position
				- ((int) ((Math.floor(my_position / Math.sqrt(map_size))) * Math
						.sqrt(map_size)));
		return ((result == 0) ? (int)Math.sqrt(map_size) : result);
	}
	
	/**
	 * Visszaadja az Y koordinátát.
	 * 
	 * @return Y koordináta.
	 */

	public int GetY() {
		// my_position-t elosztom az sqrt(map_size)-al, és felsõ egészrész
		// (ceil)
		return (int) Math.ceil(my_position / Math.sqrt(map_size));
	}
	
	/**
	 * Vízszintesen lép i-t, pozitív=JOBB, negatív=BAL
	 * 
	 * @param i Mennyit lépjen a rácson.
	 */

	public void StepX(int i) {
		if (((GetX() + i) > 0) && (GetX() + i <= Math.sqrt(map_size)))
			my_position += i;
	}
	
	/**
	 * Függõlegesen lép i-t, pozitív=LE, negatív=FEL
	 * 
	 * @param i Mennyit lépjen a rácson.
	 */

	public void StepY(int i) {
		if (((GetY() + i) > 0) && (GetY() + i <= Math.sqrt(map_size)))
			my_position += (i * Math.sqrt(map_size));
	}
	
	/**
	 * Befoglaló téglalap kezdõpontjának X koordinátája a rajzvásznon.
	 * 
	 * @return X koordináta.
	 */

	public int GetStartX() {
		// X pozíció-1 * (rajzszélesség+1 / sqrt(map_size))
		return (int) ((GetX() - 1) * ((drawing_width + 1) / Math.sqrt(map_size)));
	}
	
	/**
	 * Befoglaló téglalap kezdõpontjának Y koordinátája a rajzváasznon.
	 * 
	 * @return Y koordináta.
	 */

	public int GetStartY() {
		// Y pozíció-1 * (rajzszélesség+1 / sqrt(map_size))
		return (int) ((GetY() - 1) * ((drawing_height + 1) / Math.sqrt(map_size)));
	}
	
	/**
	 * Befoglaló téglalap végpontjának X koordinátája a rajzvásznon.
	 * 
	 * @return X koordináta.
	 */

	public int GetEndX() {
		// X pozíció * (rajzmagasság+1 / sqrt(map_size))
		return (int) (GetX() * ((drawing_width + 1) / Math.sqrt(map_size)));
	}
	
	/**
	 * Befoglaló téglalap végpontjának Y koordinátája a rajzvásznon.
	 * 
	 * @return Y koordináta.
	 */

	public int GetEndY() {
		// Y pozíció * (rajzmagasság+1 / sqrt(map_size))
		return (int) (GetY() * ((drawing_height + 1) / Math.sqrt(map_size)));
	}
	
	/**
	 * Befoglaló téglalap középpontjának X koordinátája a rajzvásznon.
	 * 
	 * @return X koordináta.
	 */
	
	public int GetCenterX(){
		return (GetStartX() + GetEndX()) / 2;
	}
	
	/**
	 * Befoglaló téglalap középpontjának Y koordinátája a rajzvásznon.
	 * 
	 * @return Y koordináta.
	 */
	
	public int GetCenterY(){
		return (GetStartY() + GetEndY()) / 2;
	}
}
