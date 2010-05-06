/**
 * A nyuszit reprezent�l� oszt�ly.
 * 
 * @author TakRaj
 *
 */

public class bunny extends Car {
	
	/**
	 * Az oszt�ly default konstruktora.
	 */
	public bunny() {
		super();
		speed = 0;
		timetomove = 0;
	}
	
	/**
	 * Az oszt�ly konstruktora, param�terk�nt megadva, hogy hova ker�lj�n.
	 * 
	 * @param keeper Melyik RoadBlock-ra ker�lj�n.
	 */
	public bunny(RoadBlock keeper) {
		super(keeper);
		speed = 0;
		timetomove = 0;
	}
	
	/**
	 * Az oszt�ly konstruktora, param�terk�nt megadva, hogy hova ker�lj�n, milyen sebess�ggel.
	 * 
	 * @param keeper Melyik RoadBlock-ra ker�lj�n.
	 * @param s Default sebess�g.
	 */
	public bunny(RoadBlock keeper, int s) {
		super(keeper, s);
	}
	
	/**
	 * El�t�skor h�v�dik meg.
	 * 
	 * @param r Ki �t�tte el.
	 */

	public void pass(Robber r) {
		r.immortal();
		}

	/**
	 * El�z�skor h�v�dik meg.
	 * 
	 * @param r Ki el�zte meg.
	 */
	public void move(Robber r) {
		r.pass(this);
	}

	/**
	 * A l�ptet� f�ggv�ny, sz�ks�ges fel�ldefini�lni a Car.step()-et mivel this-t adunk �t. 
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
		
				Car elozendo = destination.getCar(); //megtudja milyen aut� van (ha van) a c�l RoadBlockon
				if (elozendo==null) //ha nincs aut� halad tov�bb
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
	 * Visszaadja az objektump�ld�ny azonos�t� stringj�t.
	 * 
	 * @return Azonos�t� string.
	 */
	
	@Override
	public String WhoAmI(){
		return "Bunny";
	}

}

