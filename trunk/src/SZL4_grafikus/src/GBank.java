import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class GBank implements ElementView {
	
	Building host = null;
	int height = 0;
	int width = 0;
	
	public GBank(Building h, int canvas_h, int canvas_w){
		host = h;
		height = canvas_h;
		width = canvas_w;
	}
	
	@Override
	public void Draw(Graphics2D g, int map_size, int where) {
		// TODO Auto-generated method stub
	
		// Befoglaló téglalap meghatározása
	
		DrawingCoords my_area = new DrawingCoords(map_size, where);
		my_area.SetDrawingArea(width, height);
	
		// Épület kirajzolása
		
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(5.0f));
		g.drawRect(my_area.GetStartX() + 10, my_area.GetStartY() + 10, 30, 30);
	
		g.setColor(Color.MAGENTA);
		g.setStroke(new BasicStroke(1.0f));
		g.fillRect(my_area.GetStartX() + 10, my_area.GetStartY() + 10, 30, 30);
	}
}