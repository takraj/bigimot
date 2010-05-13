import java.io.IOException;

public class Robber extends Car {

	/**
	 * konstruktor
	 */

	public Robber(RoadBlock keeper) {
		System.out.println("Robber()-Begin");
		
		rb=keeper;
		keeper.setCar(this);

		System.out.println("Robber()-End");
	}

	/**
	 * Ha rendõrt akart elõzni a játék vége
	 */
	public void pass(Police p) {
		System.out.println("Robber.pass()-Begin");

		System.out.println("Busted - Game Over");
		System.exit(0);
		
		System.out.println("Robber.pass()-End");
		}
	

	/**
	 * Ha civilt elõz a civil megsemmisül, õ tovább halad
	 */
	
	public void pass(Car c) {
		System.out.println("Robber.pass()-Begin");

		c.destroy();
		rb.setCar(null);
		rb.setCar(this);
		
		System.out.println("Robber.pass()-End");
		}

	/**
	 * Ha civil akarja elõzni
	 */
	public void move(Car c) {
		System.out.println("Police.move()-Begin");
		c.pass(this);
		System.out.println("Police.move()-End");
	}
	/**
	 * Ha rendõr elkapja
	 */
	public void move(Police p) {
		System.out.println("Police.move()-Begin");
		p.pass(this);
		System.out.println("Police.move()-End");
	}
	/**
	 * A haladásért felelõs függvény a Car.step() felüldefiniálása
	 */
	public void step()
	{
		System.out.println("Car.step()-Begin");
		
		rb.getNeighbour();
		
		Car elozendo = rb.getCar();
		if (elozendo==null) 
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
			
		
		rb.getTraffic();
		rb.getBuilding();
		
		System.out.println("Car.step()-End");
	
	}

}