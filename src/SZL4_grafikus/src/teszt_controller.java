
public class teszt_controller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameForm gf = new GameForm("TESZT");
		
		gf.pack();
		gf.setResizable(false);
		gf.Draw();
		gf.setVisible(true);
		gf.Draw();
	}

}
