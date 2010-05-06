import java.io.BufferedWriter;
import java.io.IOException;
/**
 * 
 * Rejtekhelyet megtestesítõ osztály. 
 */
public class Hideout extends Building {
	
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
	
	@Override
	public String WhoAmI(){
		return "Hideout";
	}
}