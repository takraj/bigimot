import java.io.IOException;

public class Car {

	private int speed;
	private int timetomove;
	protected RoadBlock rb;

	public Car(){}
	
	/**
	 * A Car osztály konstruktora
	 * @param keeper Az osztályért felelõs RoadBlock
	 */
	public Car(RoadBlock keeper)
	{
		System.out.println("Car()-Begin");

		rb=keeper;
		keeper.setCar(this); //itt rendeli hozzá magát a felelõs roadblockhoz

		System.out.println("Car()-End");
	}
	
	
	/**
	 * Ez a függvény felelõs azért hogy az ütközni/elõzni készülõ kocsi tisztában legyen
	 * azzal milyen kocsit elõz
	 *  
	 */
	public void move(Car c) {
		System.out.println("Car.move()-Begin");
		c.pass(this); // Azonosítja magát a megelõzendõ kocsi
		System.out.println("Car.move()-End");
	}

	/**
	 * A léptetésért felelõs függvény
	 *  
	 */

	public void step()
	{
		System.out.println("Car.step()-Begin");
		
		rb.getNeighbour(); // elkéri a lehetséges célállomások címét a RoadBlocktól 
		
		Car elozendo = rb.getCar(); //megtudja milyen autó van (ha van) a cél RoadBlockon
		if (elozendo==null) //ha nincs autó halad tovább
		{
			rb.setCar(null);
			rb.setCar(this);
		}
		else
		{
			System.out.println("milyen kocsit elõzünk? 0:car 1:police 2:robber");
			int temp;
			try
			{
				temp=System.in.read();
				temp=temp-48;
				System.in.skip(System.in.available());
				if (temp==0) {
					Car C=new Car(rb);
					C.move(this);
				}
				if (temp==1) {
					Police C=new Police(rb);
					C.move(this);
				}
				if (temp==2) {
					Robber C=new Robber(rb);
					C.move(this);
				}
			}
			catch(IOException e)
			{
				System.out.println("Hibás bemenet");			
			}	

		}
			
		
		rb.getTraffic(); //megérkezés után megvizsgálja a forgalomirányító jeleket (kell e 
						//majd várakoznia
		rb.getBuilding(); //megvizsgálja célba ért-e
		
		System.out.println("Car.step()-End");
	
	}

	/**
	 * Ha egy autó elõtt van más autó itt kezeli le
	 *  
	 */
	public void pass(Car c) {
		System.out.println("Car.pass()-Begin");
		System.out.println("Car.pass()-End");
	}

	public void setSpeed() {
		throw new UnsupportedOperationException();
	}

	public int getSpeed() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Az autó megsemmisülése (ha rabló elõzi)  
	 * 
	 */

	public void destroy() {
		System.out.println("Car.destroy()-Begin");
		rb.setCar(null);
		System.out.println("Car.destroy()-End");
	}

}