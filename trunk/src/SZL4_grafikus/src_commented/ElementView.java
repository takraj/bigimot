import java.awt.Graphics2D;

/**
 * Interfész a különféle elemek nézeteihez.
 * 
 * @author TakRaj
 *
 */

public interface ElementView {
	
	/**
	 * Interfész a különbözõ elemek kirajzolásához
	 * 
	 * @param g	Graphics2D
	 * @param map_size	Térkép mérete
	 */

	public void Draw(Graphics2D g, int map_size, int where);
}
