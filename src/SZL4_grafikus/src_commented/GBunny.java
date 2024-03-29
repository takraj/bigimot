import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Nyulat rajzol� oszt�ly 
 * 
 */
public class GBunny implements ElementView {
	
	Car host = null;
	int height = 0;
	int width = 0;
	/**
	 * GBunny oszt�ly konstruktora
	 * 
	 */
	public GBunny(Car h, int canvas_h, int canvas_w){
		host = h;
		height = canvas_h;
		width = canvas_w;
	}
	
	@Override
	public void Draw(Graphics2D g, int map_size, int where) {
		// TODO Auto-generated method stub
	
		// Befoglal� t�glalap meghat�roz�sa
	
		DrawingCoords my_area = new DrawingCoords(map_size, where);
		my_area.SetDrawingArea(width, height);
	
		// Nyuszi kirajzol�sa
	
		g.setColor(Color.PINK);
		g.setStroke(new BasicStroke(1.0f));
		g.fillRect(my_area.GetStartX() + 30, my_area.GetStartY() + 30, my_area
				.GetEndX()
				- my_area.GetStartX() - 60, my_area.GetEndY() - my_area.GetStartY()
				- 60);
	}
}