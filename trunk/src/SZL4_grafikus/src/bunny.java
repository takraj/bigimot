
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
	 * Mikor egy civil gyorsabb mint a rend�r (megel�zni nem tudja) akkor h�v�dik meg
	 * @param c Az adott civil j�rm�re mutat� referencia
	 */

	/**
	 * Mikor a rabl� el�zni pr�b�lja a rend�rt akkor h�v�dik meg, a j�t�k elveszt�s�hez
	 * vezet.
	 * @param r Referencia a rabl�ra  
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
	
	@Override
	public String WhoAmI(){
		return "Bunny";
	}

}

