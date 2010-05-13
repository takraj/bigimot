import java.io.IOException;

public class Police extends Car {

	/**
	 * Konstruktor
	 *  @param keeper A rend�r�rt felel�s RoadBlock
	 */
	public Police(RoadBlock keeper) {
		System.out.println("Police()-Begin");
		
		rb=keeper;
		keeper.setCar(this);

		System.out.println("Police()-End");
	}

	/**
	 * Mikor a rabl�t elkapja a rend�r akkor h�v�dik meg, a j�t�k elveszt�s�hez
	 * vezet.
	 * @param r Referencia a rabl�ra  
	 */
	public void pass(Robber r) {
		System.out.println("Police.pass()-Begin");

		System.out.println("Busted - Game Over");
		System.exit(0);
		
		System.out.println("Police.pass()-End");
	}
	/**
	 * Mikor egy civil gyorsabb mint a rend�r (megel�zni nem tudja) akkor h�v�dik meg
	 * @param c Az adott civil j�rm�re mutat� referencia
	 */

	public void move(Car c) {
		System.out.println("Police.move()-Begin");
		c.pass(this);
		System.out.println("Police.move()-End");
	}
	/**
	 * Mikor a rabl� el�zni pr�b�lja a rend�rt akkor h�v�dik meg, a j�t�k elveszt�s�hez
	 * vezet.
	 * @param r Referencia a rabl�ra  
	 */
	public void move(Robber r) {
		System.out.println("Police.move()-Begin");
		r.pass(this);
		System.out.println("Police.move()-End");
	}

	/**
	 * A l�ptet� f�ggv�ny, sz�ks�ges fel�ldefini�lni a Car.step()-et mivel this-t adunk �t. 
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
			System.out.println("milyen kocsit el�z�nk? 0:car 1:police 2:robber");
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
				System.out.println("Hib�s bemenet");			
			}	

		}
			
		
		rb.getTraffic();
		rb.getBuilding();
		
		System.out.println("Car.step()-End");
	
	}

	
}