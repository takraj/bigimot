/**
 * A nyuszit reprezentáló osztály.
 * 
 * @author TakRaj
 *
 */

public class bunny extends Car {
	
	/**
	 * Az osztály default konstruktora.
	 */
	public bunny() {
		super();
		speed = 0;
		timetomove = 0;
	}
	
	/**
	 * Az osztály konstruktora, paraméterként megadva, hogy hova kerüljön.
	 * 
	 * @param keeper Melyik RoadBlock-ra kerüljön.
	 */
	public bunny(RoadBlock keeper) {
		super(keeper);
		speed = 0;
		timetomove = 0;
	}
	
	/**
	 * Az osztály konstruktora, paraméterként megadva, hogy hova kerüljön, milyen sebességgel.
	 * 
	 * @param keeper Melyik RoadBlock-ra kerüljön.
	 * @param s Default sebesség.
	 */
	public bunny(RoadBlock keeper, int s) {
		super(keeper, s);
	}
	
	/**
	 * Elütéskor hívódik meg.
	 * 
	 * @param r Ki ütötte el.
	 */

	public void pass(Robber r) {
		r.immortal();
		}

	/**
	 * Elõzéskor hívódik meg.
	 * 
	 * @param r Ki elõzte meg.
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
	
	/**
	 * Visszaadja az objektumpéldány azonosító stringjét.
	 * 
	 * @return Azonosító string.
	 */
	
	@Override
	public String WhoAmI(){
		return "Bunny";
	}

}

