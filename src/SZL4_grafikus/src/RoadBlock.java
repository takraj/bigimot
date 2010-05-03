import java.io.*;

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
	 * Szomszédok felvétele
	 * @param i szomszédok száma
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
	 * Az útszakaszhoz tartozó épület hozzárendelése
	 * @param b Az épületre mutató referencia
	 */
	public void setTraffic(ITraffic t){
		traffic=t;
		
	}

	
	public void setBuilding(Building b) {
		building=b;
	}

	/**
	 * Az útszakaszhoz tartozó autó hozzárendelése
	 * @param c Az autóra mutató referencia
	 */
	public void setCar(Car c) {
			car=c;
		}

	/**
	 * A lehetsége kimenetek (útszakaszok) meghatározása
	 */

	public RoadBlock[] getPrev() {
		return prev;
	}	
	
	public RoadBlock[] getNeighbour() {
		return road;
	}
	/**
	 * Az útszakaszhoz tartozó épületek meghatározása, a hideout esetén a játék vége
	 */
	public Building getBuilding() {
		return building;
	}

	/**
	 * Az útszakasz foglaltságának vizsgálata
	 */

	public Car getCar() {
		return car;

	}
	
	/**
	 * Az útszakaszhoz tartozó közlekedési jelzések lekérése
	 */

	public ITraffic getTraffic() {
		return traffic;
	}

	public void save(BufferedWriter out){
			try {
				if(traffic!=null){
					out.write("Traffic ");
					traffic.save(out);
					out.newLine();
				}
				if(building!=null){
					out.write("Building ");
					building.save(out);					
					out.newLine();
				}
				if(car!=null){
					out.write("Car ");
					car.save(out);
					out.newLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}