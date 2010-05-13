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
	 * Ha rend�rt akart el�zni a j�t�k v�ge
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
	 * Ha civilt el�z a civil megsemmis�l, � tov�bb halad
	 */
	
	public void pass(Car c) {
		c.rb.setCar(this);
		rb.setCar(null);
		rb=c.rb;
		//c.destroy();
	}


	/**
	 * Ha civil akarja el�zni
	 */
	public void move(Car c) {
		c.pass(this);
	}
	/**
	 * Ha rend�r elkapja
	 */
	public void move(Police p) {
		p.pass(this,immortality);
	}
	/**
	 * A halad�s�rt felel�s f�ggv�ny a Car.step() fel�ldefini�l�sa
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
			// 	elk�ri a lehets�ges c�l�llom�sok c�m�t a RoadBlockt�l, �s a destinationban t�rolja 
	
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
		
		
			Building tempb=destination.getBuilding();
			if (tempb!=null) tempb.getRole(this);
		}
	}
		
	public void AtBuilding(Hideout h)
	{
		System.out.println("Nyert�l - Game Over");
		System.exit(0);
	}
	public void immortal() {immortality=10;}
}