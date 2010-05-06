
import java.util.Random;

/**
 * Civil autót reprezentáló osztály.
 * 
 * @author TakRaj
 *
 */

public class Car {

	private ElementView view;
	private int my_index = 0;
	
	protected int time;
	protected int speed = 10;
	protected int timetomove;
	protected int health;
	protected RoadBlock rb;
	Random irand = new Random();
	
	/**
	 * Beállítja, hogy merre menjen az autó.
	 * Csak rablónál használatos.
	 * 
	 * @param i Irány: 0=FEL, 3=LE, 2=JOBB, 1=BAL
	 */
	public void setirany(int i){};
	
	
	/**
	 * Beállítja az aktuális objektumpéldány indexét.
	 * 
	 * @param i Index.
	 */
	public void setIndex(int i){
		my_index = i;
	}
	
	/**
	 * Az osztály default konstruktora.
	 */
	
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
	 * 
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
	
	/**
	 * Az osztály konstruktora.
	 * 
	 * @param keeper Az a RoadBlock amin az objektum található.
	 * @param s Kezdeti sebesség.
	 */
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
	 * @param c Aki meg akarta elõzni.
	 */
	public void move(Car c) {
		c.pass(this); // Azonosítja magát a megelõzendõ kocsi
	}
	
	/**
	 * ??
	 */
	public void settimetomove(TrafficSign t){
		timetomove=t.getstate();
	}
	
	/**
	 * ??
	 */
	
	public void settimetomove(TrafficTable t){
		timetomove=1;
	}
	
	/**
	 * Léptetõ függvény.
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
		
				Car elozendo = destination.getCar(); //megtudja milyen autó van (ha van) a cél RoadBlockon
				if (elozendo==null) //ha nincs autó halad tovább
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
			else timetomove=0;
		}
	}
	
	/**
	 * ???
	 */
	public void AtBuilding(Bank b){}
	
	/**
	 * ???
	 */
	public void AtBuilding(Hideout h){}

	/**
	 * Ha egy autó elõtt van más autó itt kezeli le
	 * 
	 * @param c Akit elütne.
	 */
	public void pass(Car c) {
	}

	/**
	 * Visszatér azzal az útdarabkával amin áll.
	 * 
	 * @return RoadBlock amin áll.
	 */
	
	public RoadBlock getKeeper(){
		return rb;
	}
	
	/**
	 * Az autó megsemmisülése (ha rabló elõzi)  
	 * 
	 */
	
	public void destroy() {
		rb.setCar(null);
		this.rb=null;
		game.GetCity().DeleteCar(this);
	}
	
	/**
	 * Ezzel állítható be a megjelenítõ nézet.
	 * 
	 * @param v Kívánt nézet.
	 */
	
	public void SetView(ElementView v){
		view = v;
	}
	
	/**
	 * Visszaadja az aktuálisan beállított nézetet.
	 * 
	 * @return Nézet.
	 */
	
	public ElementView GetView(){
		return view;
	}
	
	/**
	 * Visszaadja az azonosító stringet.
	 * 
	 * @return Azonosító string.
	 */
	
	public String WhoAmI(){
		return "Car";
	}
	
	/**
	 * Beállítja, hogy épp melyik RoadBlockon legyen az autó.
	 * 
	 * @param r Kívánt RoadBlock.
	 */
	
	public void SetRB(RoadBlock r){
		rb = r;
	}
	
	/**
	 * Beállítja az autó sebességét.
	 * 
	 * @param s Sebesség 0-10 között. Poz. egész szám. 0=ÁLL, 1=MAX, 10=MIN
	 */
	
	public void SetSpeed(int s){
		time = speed = s;
	}
	
	/**
	 * Beállítja, hogy mennyi idõ elteltével léphet újra.
	 * 
	 * @param ttm Idõ. Pozitív egész.
	 */
	
	public void SetTimeToMove(int ttm){
		timetomove = ttm;
	}
	
	/**
	 * Beállítja az autó életét.
	 * 
	 * @param hp Élet. 0-100 Poz. egész.
	 */
	
	public void SetHealth(int hp){
		health = hp;
	}
	
	/**
	 * A kiíratásért felelõs függvény.
	 * 
	 * @return Egy string az osztály állapotaival.
	 */
	
	@Override
	public String toString(){
		String result = "";
		
		result += String.format("\nspeed %d", speed);
		result += String.format("\nhealth %d", health);
		result += String.format("\ntimetomove %d", timetomove);
		
		return result;
	}
	
	/**
	 * Visszaadja az objektumpéldány indexét.
	 * 
	 * @return Index.
	 */
	
	public int getIndex(){
		return my_index;
	}

}