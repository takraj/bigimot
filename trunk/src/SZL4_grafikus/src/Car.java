
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

public class Car {

	private ElementView view;
	private int my_index = 0;
	
	protected int time;
	protected int speed;
	protected int timetomove;
	protected int health;
	protected RoadBlock rb;
	Random irand = new Random();
	public void setirany(int i){};
	
	public void setIndex(int i){
		my_index = i;
	}
	
	public Car()
	{
		timetomove=0;
		rb = null;
		speed = irand.nextInt(10)+1;
		health = 100;
		time = speed;
	}
	
	/**
	 * A Car osztály konstruktora
	 * @param keeper Az osztályért felelõs RoadBlock
	 */
	public Car(RoadBlock keeper)
	{
		timetomove=0;
		rb=keeper;
		keeper.setCar(this); //itt rendeli hozzá magát a felelõs roadblockhoz
		speed=irand.nextInt(10)+1;
		time=speed;
		health = 100;
	}
	public Car(RoadBlock keeper, int s)
	{
		timetomove=0;
		rb=keeper;
		keeper.setCar(this); //itt rendeli hozzá magát a felelõs roadblockhoz
		speed=s;
		time=speed;
		health = 100;
	}
	
	
	/**
	 * Ez a függvény felelõs azért hogy az ütközni/elõzni készülõ kocsi tisztában legyen
	 * azzal milyen kocsit elõz
	 *  
	 */
	public void move(Car c) {
		c.pass(this); // Azonosítja magát a megelõzendõ kocsi
	}

	public void save(BufferedWriter out){
		try {
			out.write(" car speed="+speed);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * A léptetésért felelõs függvény
	 *  
	 */
	public void settimetomove(TrafficSign t){timetomove=t.getstate();}
	public void settimetomove(TrafficTable t){timetomove=1;}
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
	
	public void AtBuilding(Bank b){}
	public void AtBuilding(Hideout h){}

	/**
	 * Ha egy autó elõtt van más autó itt kezeli le
	 *  
	 */
	public void pass(Car c) {
	}

	
	/**
	 * Az autó megsemmisülése (ha rabló elõzi)  
	 * 
	 */

	public RoadBlock getKeeper(){
		return rb;
	}
	
	public void destroy() {
		rb.setCar(null);
		this.rb=null;
	}
	
	public void SetView(ElementView v){
		view = v;
	}
	
	public ElementView GetView(){
		return view;
	}
	
	public String WhoAmI(){
		return "Car";
	}
	
	public void SetRB(RoadBlock r){
		rb = r;
	}
	
	public void SetSpeed(int s){
		time = speed = s;
	}
	
	public void SetTimeToMove(int ttm){
		timetomove = ttm;
	}
	
	public void SetHealth(int hp){
		health = hp;
	}
	
	@Override
	public String toString(){
		String result = "";
		
		result += String.format("\nspeed %d", speed);
		result += String.format("\nhealth %d", health);
		result += String.format("\ntimetomove %d", timetomove);
		
		return result;
	}
	
	public int getIndex(){
		return my_index;
	}

}