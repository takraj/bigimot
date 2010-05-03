import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GameForm extends Frame {

	private int map_size = 25;

	private int display_width = 800;
	private int display_height = 600;

	private Integer known_score = 0;
	private Integer known_health = 0;
	// legyen m�g egy referencia a konstruktorban kapott Game objektumra!

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

	DrawingCoords temp = new DrawingCoords(map_size, 0);

	class GameFormKeyManager extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				// todo
				temp.StepY(-1);
				Draw();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				// todo
				temp.StepY(1);
				Draw();
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				// todo
				temp.StepX(-1);
				Draw();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				// todo
				temp.StepX(1);
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

			// n�gyzet rajzol�sa

			temp.SetDrawingArea(dim.width, dim.height);

			buffer.setColor(Color.RED);
			buffer.setStroke(new BasicStroke(5.0f));
			buffer.drawRect(temp.GetStartX() + 10, temp.GetStartY() + 10, temp
					.GetEndX()
					- temp.GetStartX() - 20, temp.GetEndY() - temp.GetStartY()
					- 20);

			// ny�l
			buffer.setStroke(new BasicStroke(1.0f));
			buffer.setColor(Color.darkGray);
			/* JOBB */
			ArrowDrawer.drawArrow(buffer, temp.GetEndX() - 10, temp
					.GetCenterY(), temp.GetEndX() + 10, temp.GetCenterY(), 5f);
			/* LENT */
			ArrowDrawer.drawArrow(buffer, temp.GetCenterX(),
					temp.GetEndY() - 10, temp.GetCenterX(),
					temp.GetEndY() + 10, 5f);
			/* FENT */
			ArrowDrawer.drawArrow(buffer, temp.GetCenterX(),
					temp.GetStartY() + 10, temp.GetCenterX(),
					temp.GetStartY() - 10, 5f);
			/* BAL */
			ArrowDrawer.drawArrow(buffer, temp.GetStartX() + 10, temp
					.GetCenterY(), temp.GetStartX() - 10, temp.GetCenterY(), 5f);

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

	public GameForm(String name) { // neki legyen m�g egy Game param�tere!
		super(name);

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
