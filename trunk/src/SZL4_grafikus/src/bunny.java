
public class bunny extends Car {
	public bunny() {
		super();
		speed = 0;
		timetomove = 0;
	}
	public bunny(RoadBlock keeper) {
		super(keeper);
		speed = 0;
		timetomove = 0;
	}
	public bunny(RoadBlock keeper, int s) {
		super(keeper, s);
	}

	public void pass(Robber r) {
		r.immortal();
		}
	/**
	 * Mikor egy civil gyorsabb mint a rendõr (megelõzni nem tudja) akkor hívódik meg
	 * @param c Az adott civil jármûre mutató referencia
	 */

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
		if (speed < 1) return;
		time--;
		if (time==0)
		{
			time=speed;
			if(timetomove==0)
			{
				RoadBlock destination;
				RoadBlock[] destlist=rb.getNeighbour(); 
				int temp;
				temp=0;
				destination=null;
				while((destination==null)&&(temp<=3))
				{
					destination=destlist[temp];
					temp++;
				}
				if ((temp>3)&&(destination==null)) return;
		
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
			else timetomove=0;
		}
	}
	
	@Override
	public String WhoAmI(){
		return "Bunny";
	}

}

