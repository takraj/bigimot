
public class RoadBlock {

	private Car car;
	private ITraffic traffic;
	private Building building;
	private RoadBlock[] road;
	private RoadBlock[] prev;
	private ElementView view;
	//private int traf;
	public int used;
	
	public void SetView(ElementView v){
		// ha zombi, akkor ne legyen neki megjelen�t�se
		
		if (((road[0] != null) || (road[1] != null) || (road[2] != null) || (road[3] != null))
				|| ((prev[0] != null) || (prev[1] != null) || (prev[2] != null) || (prev[3] != null)))
			view = v;
	}
	
	public ElementView GetView(){
		return view;
	}
	
	/**
	 * RoadBlock konstruktora
	 */
	public RoadBlock()
	{
		//traf=0;
		road=new RoadBlock[4];
		prev=new RoadBlock[4];
		for(int i=0; i<4; i++) road[i]=prev[i]=null;
		building=null;
		traffic=null;
		car=null;
		used=0;
	}

	/**
	 * Szomsz�dok felv�tele
	 * @param i szomsz�dok sz�ma
	 */
	
	public void setPrev(RoadBlock rb, int i){
		prev[i]=rb;
	}

	public void setNeighbour(RoadBlock rb, int i) {
		road[i]=rb;
	}
	
	public RoadBlock GetNeighbour(int i){
		return road[i];
	}

	/**
	 * Az �tszakaszhoz tartoz� �p�let hozz�rendel�se
	 * @param b Az �p�letre mutat� referencia
	 */
	public void setTraffic(ITraffic t){
		traffic=t;
		
	}

	
	public void setBuilding(Building b) {
		building=b;
	}

	/**
	 * Az �tszakaszhoz tartoz� aut� hozz�rendel�se
	 * @param c Az aut�ra mutat� referencia
	 */
	public void setCar(Car c) {
			car=c;
		}

	/**
	 * A lehets�ge kimenetek (�tszakaszok) meghat�roz�sa
	 */

	public RoadBlock[] getPrev() {
		return prev;
	}	
	
	public RoadBlock[] getNeighbour() {
		return road;
	}
	/**
	 * Az �tszakaszhoz tartoz� �p�letek meghat�roz�sa, a hideout eset�n a j�t�k v�ge
	 */
	public Building getBuilding() {
		return building;
	}

	/**
	 * Az �tszakasz foglalts�g�nak vizsg�lata
	 */

	public Car getCar() {
		return car;

	}
	
	/**
	 * Az �tszakaszhoz tartoz� k�zleked�si jelz�sek lek�r�se
	 */

	public ITraffic getTraffic() {
		return traffic;
	}
	
	@Override
	public String toString(){
		String result = "";
		
		if (car != null){
			result += String.format("\ncar car[%d]", car.getIndex());
		}
		
		return result;
	}

}