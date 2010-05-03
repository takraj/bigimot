import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GameForm extends Frame {

	private int map_size;

	private int display_width = 800;
	private int display_height = 600;

	private Integer known_score = 0;
	private Integer known_health = 0;

	City city_reference; // referencia a v�rosra

	private Panel menuPanel = new Panel();
	private Panel statusPanel = new Panel();
	private Field displayPanel = new Field();

	private Button newGameBtn = new Button("New Game");
	private Button loadGameBtn = new Button("Load Game");
	private Button saveGameBtn = new Button("Save Game");

	private Label scoreLabel = new Label(known_score.toString());
	private Label healthLabel = new Label(known_health.toString());

	class GameFormWindowCloser extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	class GameFormKeyManager extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				// todo
				city_reference.step();
				UpdateViews();
				Draw();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				// todo
				Draw();
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				// todo
				Draw();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				// todo
				Draw();
			}
			// System.out.printf("X=%d, Y=%d\n",temp.GetX(),temp.GetY());
		}
	}

	class Field extends Canvas {
		public void paint(Graphics gc) {

			// 01 - H�TT�R BUFFER ELK�SZ�T�SE

			Dimension dim = this.getSize();
			Image image = createImage(dim.width, dim.height);
			Graphics2D buffer = (Graphics2D) image.getGraphics();
			buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

			// 02 - ST�TUSZ FRISS�T�SE

			if (known_score != 0) {
				SetScore(0);
			}
			if (known_health != 0) {
				SetHealth(0);
			}

			// 03 - K�PERNY� T�RL�SE

			buffer.clearRect(0, 0, dim.width, dim.height);

			// 04 - �J GRAFIKA ELK�SZ�T�SE

			for (int i = 0; i<city_reference.GetSize(); i++){
				RoadBlock rb = city_reference.GetRBAt(i);
				if (rb != null){
					ElementView v = rb.GetView();
					if (v != null) v.Draw(buffer, map_size, i);
				}
			}

			// keret rajzol�sa

			buffer.setStroke(new BasicStroke(5.0f));
			buffer.setColor(Color.BLUE);
			buffer.drawRect(0, 0, dim.width - 1, dim.height - 1);

			// 05 - KIRAJZOL�S

			gc.drawImage(image, 0, 0, this);
		}

		public void update(Graphics g) {
			paint(g);
		}
	}

	public void SetViews(){
		for (int i = 0; i<city_reference.GetSize(); i++){
			RoadBlock rb = city_reference.GetRBAt(i);
			if (rb != null){
				rb.SetView(new GRoadBlock(rb, display_height, display_width));
				
				Building b = rb.getBuilding();
				if (b != null){
					if (b.WhoAmI().compareToIgnoreCase("Building") == 0)
						b.SetView(new GBuilding(b, display_height, display_width));
					if (b.WhoAmI().compareToIgnoreCase("Bank") == 0)
						b.SetView(new GBank(b, display_height, display_width));
					if (b.WhoAmI().compareToIgnoreCase("Hideout") == 0)
						b.SetView(new GHideout(b, display_height, display_width));
				}
				
				ITraffic t = rb.getTraffic();
				if (t != null){
					if (t.WhoAmI().compareToIgnoreCase("TrafficTable") == 0)
						t.SetView(new GTrafficTable(t, display_height, display_width));
					if (t.WhoAmI().compareToIgnoreCase("TrafficSign") == 0)
						t.SetView(new GTrafficSign(t, display_height, display_width));
				}
				
				Car c = rb.getCar();
				if (c != null){
					if (c.WhoAmI().compareToIgnoreCase("Car") == 0)
						c.SetView(new GCar(c, display_height, display_width));
					if (c.WhoAmI().compareToIgnoreCase("Robber") == 0)
						c.SetView(new GRobber(c, display_height, display_width));
					if (c.WhoAmI().compareToIgnoreCase("Police") == 0)
						c.SetView(new GPolice(c, display_height, display_width));
				}
			}
		}
	}
	
	public void UpdateViews(){
		for (int i = 0; i<city_reference.GetSize(); i++){
			RoadBlock rb = city_reference.GetRBAt(i);
			if (rb != null){
				Car c = rb.getCar();
				if (c != null){
					if (c.WhoAmI().compareToIgnoreCase("Car") == 0)
						c.SetView(new GCar(c, display_height, display_width));
					if (c.WhoAmI().compareToIgnoreCase("Robber") == 0)
						c.SetView(new GRobber(c, display_height, display_width));
					if (c.WhoAmI().compareToIgnoreCase("Police") == 0)
						c.SetView(new GPolice(c, display_height, display_width));
				}
			}
		}
	}
	
	public GameForm(String name, City c) {
		super(name);

		// refer�l�s a v�rosra

		city_reference = c;
		map_size = city_reference.GetSize();
		SetViews();

		// layout be�ll�t�sa

		setLayout(new BorderLayout());
		Button controlBtn = new Button("Control");

		displayPanel.setSize(display_width, display_height);

		add("North", menuPanel);
		add("South", statusPanel);
		add("Center", displayPanel);

		menuPanel.add(controlBtn);
		menuPanel.add(newGameBtn);
		menuPanel.add(loadGameBtn);
		menuPanel.add(saveGameBtn);

		statusPanel.add(new Label("Actual Score:"));
		statusPanel.add(scoreLabel);
		statusPanel.add(new Label("Health:"));
		statusPanel.add(healthLabel);

		addWindowListener(new GameFormWindowCloser());
		controlBtn.addKeyListener(new GameFormKeyManager());
		// todo: men�gombok esem�nyei

		// megjelen�t�s

		pack();
		setResizable(false);
		Draw();
		setVisible(true);
	}

	public void Draw() {
		displayPanel.repaint();
	}

	public void SetScore(Integer new_score) {
		scoreLabel.setText(new_score.toString());
	}

	public void SetHealth(Integer new_health) {
		healthLabel.setText(new_health.toString());
	}

}
