
import java.util.Random;

/**
 * Civil aut�t reprezent�l� oszt�ly.
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
	 * Be�ll�tja, hogy merre menjen az aut�.
	 * Csak rabl�n�l haszn�latos.
	 * 
	 * @param i Ir�ny: 0=FEL, 3=LE, 2=JOBB, 1=BAL
	 */
	public void setirany(int i){};
	
	
	/**
	 * Be�ll�tja az aktu�lis objektump�ld�ny index�t.
	 * 
	 * @param i Index.
	 */
	public void setIndex(int i){
		my_index = i;
	}
	
	/**
	 * Az oszt�ly default konstruktora.
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
	 * A Car oszt�ly konstruktora
	 * 
	 * @param keeper Az oszt�ly�rt felel�s RoadBlock
	 */
	public Car(RoadBlock keeper)
	{
		timetomove=0;
		rb=keeper;
		keeper.setCar(this); //itt rendeli hozz� mag�t a felel�s roadblockhoz
		speed=irand.nextInt(10)+1;
		time=speed;
		health = 100;
	}
	
	/**
	 * Az oszt�ly konstruktora.
	 * 
	 * @param keeper Az a RoadBlock amin az objektum tal�lhat�.
	 * @param s Kezdeti sebess�g.
	 */
	public Car(RoadBlock keeper, int s)
	{
		timetomove=0;
		rb=keeper;
		keeper.setCar(this); //itt rendeli hozz� mag�t a felel�s roadblockhoz
		speed=s;
		time=speed;
		health = 100;
	}
	
	
	/**
	 * Ez a f�ggv�ny felel�s az�rt hogy az �tk�zni/el�zni k�sz�l� kocsi tiszt�ban legyen
	 * azzal milyen kocsit el�z
	 * 
	 * @param c Aki meg akarta el�zni.
	 */
	public void move(Car c) {
		c.pass(this); // Azonos�tja mag�t a megel�zend� kocsi
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
	 * L�ptet� f�ggv�ny.
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
	 * Ha egy aut� el�tt van m�s aut� itt kezeli le
	 * 
	 * @param c Akit el�tne.
	 */
	public void pass(Car c) {
	}

	/**
	 * Visszat�r azzal az �tdarabk�val amin �ll.
	 * 
	 * @return RoadBlock amin �ll.
	 */
	
	public RoadBlock getKeeper(){
		return rb;
	}
	
	/**
	 * Az aut� megsemmis�l�se (ha rabl� el�zi)  
	 * 
	 */
	
	public void destroy() {
		rb.setCar(null);
		this.rb=null;
		game.GetCity().DeleteCar(this);
	}
	
	/**
	 * Ezzel �ll�that� be a megjelen�t� n�zet.
	 * 
	 * @param v K�v�nt n�zet.
	 */
	
	public void SetView(ElementView v){
		view = v;
	}
	
	/**
	 * Visszaadja az aktu�lisan be�ll�tott n�zetet.
	 * 
	 * @return N�zet.
	 */
	
	public ElementView GetView(){
		return view;
	}
	
	/**
	 * Visszaadja az azonos�t� stringet.
	 * 
	 * @return Azonos�t� string.
	 */
	
	public String WhoAmI(){
		return "Car";
	}
	
	/**
	 * Be�ll�tja, hogy �pp melyik RoadBlockon legyen az aut�.
	 * 
	 * @param r K�v�nt RoadBlock.
	 */
	
	public void SetRB(RoadBlock r){
		rb = r;
	}
	
	/**
	 * Be�ll�tja az aut� sebess�g�t.
	 * 
	 * @param s Sebess�g 0-10 k�z�tt. Poz. eg�sz sz�m. 0=�LL, 1=MAX, 10=MIN
	 */
	
	public void SetSpeed(int s){
		time = speed = s;
	}
	
	/**
	 * Be�ll�tja, hogy mennyi id� eltelt�vel l�phet �jra.
	 * 
	 * @param ttm Id�. Pozit�v eg�sz.
	 */
	
	public void SetTimeToMove(int ttm){
		timetomove = ttm;
	}
	
	/**
	 * Be�ll�tja az aut� �let�t.
	 * 
	 * @param hp �let. 0-100 Poz. eg�sz.
	 */
	
	public void SetHealth(int hp){
		health = hp;
	}
	
	/**
	 * A ki�rat�s�rt felel�s f�ggv�ny.
	 * 
	 * @return Egy string az oszt�ly �llapotaival.
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
	 * Visszaadja az objektump�ld�ny index�t.
	 * 
	 * @return Index.
	 */
	
	public int getIndex(){
		return my_index;
	}

}