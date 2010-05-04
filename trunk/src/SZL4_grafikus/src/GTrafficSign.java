import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class GTrafficSign implements ElementView {
	
	ITraffic host = null;
	int height = 0;
	int width = 0;
	
	public GTrafficSign(ITraffic h, int canvas_h, int canvas_w){
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
	
		// Forgalomir�ny�t� kirajzol�sa
	
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(5.0f));
		g.drawOval(my_area.GetCenterX() - 15, my_area.GetCenterY() - 15, 30, 30);
		
		if (host.getstate() == 1){
			g.setColor(Color.RED);
		} else{
			g.setColor(Color.GREEN);
		}
		g.setStroke(new BasicStroke(1.0f));
		g.fillOval(my_area.GetCenterX() - 15, my_area.GetCenterY() - 15, 30, 30);
	}
}