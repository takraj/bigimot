import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Robber extends Car {

	/**
	 * konstruktor
	 */
	private int irany;
	private int immortality;

	public Robber() {
		super();
	}
	public Robber(RoadBlock keeper) {
		super(keeper);
	}
	public Robber(RoadBlock keeper, int s) {
		super(keeper, s);
	}
	
	public void setirany(int i){if ((i<0)||(i>3)) irany=0; else irany=i; }

	/**
	 * Ha rendõrt akart elõzni a játék vége
	 */
	public void pass(Police p) {
		if (immortality==0) return;
	}	
	public void pass(bunny b) {
			immortal();
	}
	
	public void save(BufferedWriter out){
		try {
			out.write(" robber speed="+speed);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Ha civilt elõz a civil megsemmisül, õ tovább halad
	 */
	
	public void pass(Car c) {
		c.rb.setCar(this);
		rb.setCar(null);
		rb=c.rb;
		//c.destroy();
	}


	/**
	 * Ha civil akarja elõzni
	 */
	public void move(Car c) {
		c.pass(this);
	}
	/**
	 * Ha rendõr elkapja
	 */
	public void move(Police p) {
		p.pass(this,immortality);
	}
	/**
	 * A haladásért felelõs függvény a Car.step() felüldefiniálása
	 */
	public void step()
	{
		time--;
		if (time==0)
		{
			time=speed;
			RoadBlock destination;
			RoadBlock[] destlist=rb.getNeighbour(); 
			destination=destlist[irany];
			if (destination==null)
			{
				destlist=rb.getPrev();
				destination=destlist[irany];
				if (destination==null) return;
			}
			// 	elkéri a lehetséges célállomások címét a RoadBlocktól, és a destinationban tárolja 
	
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
		
		
			Building tempb=destination.getBuilding();
			if (tempb!=null) tempb.getRole(this);
		}
	}
		
	public void AtBuilding(Hideout h)
	{
		System.out.println("Nyertél - Game Over");
		System.exit(0);
	}
	public void immortal() {immortality=10;}
}