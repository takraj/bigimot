import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 * �p�letek megjelen�t�s��rt felel�s oszt�ly
 */
public class GBuilding implements ElementView {
	
	Building host = null;
	int height = 0;
	int width = 0;
	
	public GBuilding(Building h, int canvas_h, int canvas_w){
		host = h;
		height = canvas_h;
		width = canvas_w;
	}
	/**
	 * Rajzol� met�dus fel�ldefini�l�sa
	 * 
	 * @param g Ahova rajzolni kell.
	 * @param map_size A berajzolhat� p�lya m�rete.
	 * @param where Hova rajzoljunk.
	 */
	@Override
	public void Draw(Graphics2D g, int map_size, int where) {
		// TODO Auto-generated method stub
	
		// Befoglal� t�glalap meghat�roz�sa
	
		DrawingCoords my_area = new DrawingCoords(map_size, where);
		my_area.SetDrawingArea(width, height);
	
		// �p�let kirajzol�sa
		
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(5.0f));
		g.drawRect(my_area.GetStartX() + 10, my_area.GetStartY() + 10, 30, 30);
	
		g.setColor(Color.CYAN);
		g.setStroke(new BasicStroke(1.0f));
		g.fillRect(my_area.GetStartX() + 10, my_area.GetStartY() + 10, 30, 30);
	}
}
