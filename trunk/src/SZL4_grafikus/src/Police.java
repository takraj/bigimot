import java.io.BufferedWriter;
import java.io.IOException;

public class Police extends Car {

	/**
	 * Konstruktor
	 *  @param keeper A rendõrért felelõs RoadBlock
	 */
	public Police() {
		super();
	}
	public Police(RoadBlock keeper) {
		super(keeper);
	}
	public Police(RoadBlock keeper, int s) {
		super(keeper, s);
	}
	
	public void save(BufferedWriter out){
		try {
			out.write(" police speed="+speed);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Mikor a rablót elkapja a rendõr akkor hívódik meg, a játék elvesztéséhez
	 * vezet.
	 * @param r Referencia a rablóra  
	 */
	public void pass(Robber r, int i) {
		if (i==0) return;
		}
	/**
	 * Mikor egy civil gyorsabb mint a rendõr (megelõzni nem tudja) akkor hívódik meg
	 * @param c Az adott civil jármûre mutató referencia
	 */

	public void move(Car c) {
		c.pass(this);
	}
	/**
	 * Mikor a rabló elõzni próbálja a rendõrt akkor hívódik meg, a játék elvesztéséhez
	 * vezet.
	 * @param r Referencia a rablóra  
	 */
	public void move(Robber r) {
		r.pass(this);
	}

	/**
	 * A léptetõ függvény, szükséges felüldefiniálni a Car.step()-et mivel this-t adunk át. 
	 */

	public void step()
	{
		time--;
		if (time==0)
		{
			time=speed;
			if(timetomove==0)
			{
				RoadBlock destination;
				RoadBlock[] destlist=rb.getNeighbour();
				destination=null;

				while (destination==null)
				{
					if ((destlist[0] != null) || (destlist[1] != null) || (destlist[2] != null) || (destlist[3] != null)){
						int[] temp = Randomizer.CreatePermutation(4);
						for (int f = 0; f<=3; f++){
							if (destlist[temp[f]] != null){
								destination = destlist[temp[f]];
								break;
							}
						}
					}
					else return;
				}
		
				Car elozendo = destination.getCar(); //megtudja milyen autó van (ha van) a cél RoadBlockon
				if (elozendo==null) //ha nincs autó halad tovább
					{
						rb.setCar(null);
						destination.setCar(this);
						rb=destination;
					}
				else
					{
						elozendo.move(this);
					}
			
		
				ITraffic temptraf=destination.getTraffic(); 
				if (temptraf!=null) temptraf.whattodo(this);
				Building tempb=destination.getBuilding();
				if (tempb!=null) tempb.getRole(this);
			}
			else timetomove--;
		}
	}
	
	@Override
	public String WhoAmI(){
		return "Police";
	}

}