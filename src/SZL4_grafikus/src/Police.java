
public class Police extends Car {

	/**
	 * Konstruktor
	 *  @param keeper A rend�r�rt felel�s RoadBlock
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
	
	/**
	 * Mikor a rabl�t elkapja a rend�r akkor h�v�dik meg, a j�t�k elveszt�s�hez
	 * vezet.
	 * @param r Referencia a rabl�ra  
	 */
	public void pass(Robber r, int i) {
		if (i==0) {
			game.PrintMessage("Elkapott a rend�r.");
			r.destroy();
		}
	}
	/**
	 * Mikor egy civil gyorsabb mint a rend�r (megel�zni nem tudja) akkor h�v�dik meg
	 * @param c Az adott civil j�rm�re mutat� referencia
	 */

	public void move(Car c) {
		c.pass(this);
	}
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
		
		if ((rb.GetNeighbour(0) == null) && (rb.GetNeighbour(1) == null) && (rb.GetNeighbour(2) == null) && (rb.GetNeighbour(3) == null)){
			destroy();
			return;
		}
		
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
		
				Car elozendo = destination.getCar(); //megtudja milyen aut� van (ha van) a c�l RoadBlockon
				if (elozendo==null) //ha nincs aut� halad tov�bb
					{
						rb.setCar(null);
						destination.setCar(this);
						rb=destination;
					}
				else
					{
						if (elozendo != null){
							elozendo.move(this);
						}
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