import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class GRoadBlock implements ElementView {

	RoadBlock host = null;
	int height = 0;
	int width = 0;
	
	public GRoadBlock(RoadBlock h, int canvas_h, int canvas_w){
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
		
		// �t kirajzol�sa
		
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(5.0f));
		g.drawRect(my_area.GetStartX() + 10, my_area.GetStartY() + 10, my_area
				.GetEndX()
				- my_area.GetStartX() - 20, my_area.GetEndY() - my_area.GetStartY()
				- 20);
		g.setStroke(new BasicStroke(1.0f));
		
		// Ir�ny�t�s kirajzol�sa
		
		g.setStroke(new BasicStroke(1.0f));
		g.setColor(Color.darkGray);
		
		if (host.GetNeighbour(2) != null){
			/* JOBB */
			ArrowDrawer.drawArrow(g, my_area.GetEndX() - 10, my_area
				.GetCenterY(), my_area.GetEndX() + 10, my_area.GetCenterY(), 5f);
		
		}
		if (host.GetNeighbour(3) != null){
			/* LENT */
			ArrowDrawer.drawArrow(g, my_area.GetCenterX(),
				my_area.GetEndY() - 10, my_area.GetCenterX(),
				my_area.GetEndY() + 10, 5f);
		}
		if (host.GetNeighbour(0) != null){
			/* FENT */
			ArrowDrawer.drawArrow(g, my_area.GetCenterX(),
				my_area.GetStartY() + 10, my_area.GetCenterX(),
				my_area.GetStartY() - 10, 5f);
		}
		if (host.GetNeighbour(1) != null){
			/* BAL */
			ArrowDrawer.drawArrow(g, my_area.GetStartX() + 10, my_area
				.GetCenterY(), my_area.GetStartX() - 10, my_area.GetCenterY(), 5f);
		}
		
		// aut�/nyuszi kirajzol�sa
		
		Car c = host.getCar();
		if (c != null){
			ElementView v = c.GetView();
			if (v != null) v.Draw(g, map_size, where);
		}
		
		// �p�let kirajzol�sa
		
		Building b = host.getBuilding();
		if (b != null){
			ElementView v = b.GetView();
			if (v != null) v.Draw(g, map_size, where);
		}
		
		// forgalomir�ny�t�s kirajzol�sa
		
		ITraffic t = host.getTraffic();
		if (t != null){
			ElementView v = t.GetView();
			if (v != null) v.Draw(g, map_size, where);
		}
		
	}

}
