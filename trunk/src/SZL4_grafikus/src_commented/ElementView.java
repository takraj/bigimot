import java.awt.Graphics2D;

/**
 * Interf�sz a k�l�nf�le elemek n�zeteihez.
 * 
 * @author TakRaj
 *
 */

public interface ElementView {
	
	/**
	 * Interf�sz a k�l�nb�z� elemek kirajzol�s�hoz
	 * 
	 * @param g	Graphics2D
	 * @param map_size	T�rk�p m�rete
	 */

	public void Draw(Graphics2D g, int map_size, int where);
}
