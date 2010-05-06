/**
 * Seg�doszt�ly a rajzkoordin�t�k meghat�roz�s�ra.
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
	 * Az oszt�ly konstruktora.
	 * 
	 * @param size Mekkora a p�lya n�gyzetesen.
	 * @param pos Ebb�l melyik pont koordin�t�i �rdekelnek.
	 */

	public DrawingCoords(int size, int pos){
		map_size = size;
		my_position = pos + 1;
	}
	
	/**
	 * A rajzv�szon �ll�that� itt be, ez sz�ks�ges a rajzkoordin�t�k meghat�roz�s�hoz,
	 * egy�bk�nt elhagyhat�.
	 * 
	 * @param width Milyen sz�les. (oszlopok)
	 * @param height Milyen magas. (sorok)
	 */

	public void SetDrawingArea(int width, int height) {
		drawing_width = width;
		drawing_height = height;
	}
	
	/**
	 * Visszaadja az X koordin�t�t.
	 * 
	 * @return X koordin�ta.
	 */

	public int GetX() {
		// my_position-t elosztom az sqrt(map_size)-al, �s als� eg�szr�sz
		// (floor)
		// visszaszorzom sqrt(map_size)-al
		// ezt a sz�mot kivonom a my_position-b�l
		int result = my_position
				- ((int) ((Math.floor(my_position / Math.sqrt(map_size))) * Math
						.sqrt(map_size)));
		return ((result == 0) ? (int)Math.sqrt(map_size) : result);
	}
	
	/**
	 * Visszaadja az Y koordin�t�t.
	 * 
	 * @return Y koordin�ta.
	 */

	public int GetY() {
		// my_position-t elosztom az sqrt(map_size)-al, �s fels� eg�szr�sz
		// (ceil)
		return (int) Math.ceil(my_position / Math.sqrt(map_size));
	}
	
	/**
	 * V�zszintesen l�p i-t, pozit�v=JOBB, negat�v=BAL
	 * 
	 * @param i Mennyit l�pjen a r�cson.
	 */

	public void StepX(int i) {
		if (((GetX() + i) > 0) && (GetX() + i <= Math.sqrt(map_size)))
			my_position += i;
	}
	
	/**
	 * F�gg�legesen l�p i-t, pozit�v=LE, negat�v=FEL
	 * 
	 * @param i Mennyit l�pjen a r�cson.
	 */

	public void StepY(int i) {
		if (((GetY() + i) > 0) && (GetY() + i <= Math.sqrt(map_size)))
			my_position += (i * Math.sqrt(map_size));
	}
	
	/**
	 * Befoglal� t�glalap kezd�pontj�nak X koordin�t�ja a rajzv�sznon.
	 * 
	 * @return X koordin�ta.
	 */

	public int GetStartX() {
		// X poz�ci�-1 * (rajzsz�less�g+1 / sqrt(map_size))
		return (int) ((GetX() - 1) * ((drawing_width + 1) / Math.sqrt(map_size)));
	}
	
	/**
	 * Befoglal� t�glalap kezd�pontj�nak Y koordin�t�ja a rajzv�asznon.
	 * 
	 * @return Y koordin�ta.
	 */

	public int GetStartY() {
		// Y poz�ci�-1 * (rajzsz�less�g+1 / sqrt(map_size))
		return (int) ((GetY() - 1) * ((drawing_height + 1) / Math.sqrt(map_size)));
	}
	
	/**
	 * Befoglal� t�glalap v�gpontj�nak X koordin�t�ja a rajzv�sznon.
	 * 
	 * @return X koordin�ta.
	 */

	public int GetEndX() {
		// X poz�ci� * (rajzmagass�g+1 / sqrt(map_size))
		return (int) (GetX() * ((drawing_width + 1) / Math.sqrt(map_size)));
	}
	
	/**
	 * Befoglal� t�glalap v�gpontj�nak Y koordin�t�ja a rajzv�sznon.
	 * 
	 * @return Y koordin�ta.
	 */

	public int GetEndY() {
		// Y poz�ci� * (rajzmagass�g+1 / sqrt(map_size))
		return (int) (GetY() * ((drawing_height + 1) / Math.sqrt(map_size)));
	}
	
	/**
	 * Befoglal� t�glalap k�z�ppontj�nak X koordin�t�ja a rajzv�sznon.
	 * 
	 * @return X koordin�ta.
	 */
	
	public int GetCenterX(){
		return (GetStartX() + GetEndX()) / 2;
	}
	
	/**
	 * Befoglal� t�glalap k�z�ppontj�nak Y koordin�t�ja a rajzv�sznon.
	 * 
	 * @return Y koordin�ta.
	 */
	
	public int GetCenterY(){
		return (GetStartY() + GetEndY()) / 2;
	}
}
