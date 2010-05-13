import java.io.IOException;

public class Police extends Car {

	/**
	 * Konstruktor
	 *  @param keeper A rendõrért felelõs RoadBlock
	 */
	public Police(RoadBlock keeper) {
		System.out.println("Police()-Begin");
		
		rb=keeper;
		keeper.setCar(this);

		System.out.println("Police()-End");
	}

	/**
	 * Mikor a rablót elkapja a rendõr akkor hívódik meg, a játék elvesztéséhez
	 * vezet.
	 * @param r Referencia a rablóra  
	 */
	public void pass(Robber r) {
		System.out.println("Police.pass()-Begin");

		System.out.println("Busted - Game Over");
		System.exit(0);
		
		System.out.println("Police.pass()-End");
	}
	/**
	 * Mikor egy civil gyorsabb mint a rendõr (megelõzni nem tudja) akkor hívódik meg
	 * @param c Az adott civil jármûre mutató referencia
	 */

	public void move(Car c) {
		System.out.println("Police.move()-Begin");
		c.pass(this);
		System.out.println("Police.move()-End");
	}
	/**
	 * Mikor a rabló elõzni próbálja a rendõrt akkor hívódik meg, a játék elvesztéséhez
	 * vezet.
	 * @param r Referencia a rablóra  
	 */
	public void move(Robber r) {
		System.out.println("Police.move()-Begin");
		r.pass(this);
		System.out.println("Police.move()-End");
	}

	/**
	 * A léptetõ függvény, szükséges felüldefiniálni a Car.step()-et mivel this-t adunk át. 
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