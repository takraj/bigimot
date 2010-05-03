import java.io.BufferedWriter;
import java.io.IOException;

public class Hideout extends Building {

	/**
	 * Az osztály jelenleg nem példányosul meg
	 *  
	 */
	public Hideout(RoadBlock keeper) {
		super(keeper);
	}

	public void getRole(Car c) {
		c.AtBuilding(this);
	}

	public void save(BufferedWriter out){
		try {
			out.write("hideout");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}