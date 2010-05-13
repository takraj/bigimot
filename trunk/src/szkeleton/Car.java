import java.io.IOException;

public class Car {

	private int speed;
	private int timetomove;
	protected RoadBlock rb;

	public Car(){}
	
	/**
	 * A Car oszt�ly konstruktora
	 * @param keeper Az oszt�ly�rt felel�s RoadBlock
	 */
	public Car(RoadBlock keeper)
	{
		System.out.println("Car()-Begin");

		rb=keeper;
		keeper.setCar(this); //itt rendeli hozz� mag�t a felel�s roadblockhoz

		System.out.println("Car()-End");
	}
	
	
	/**
	 * Ez a f�ggv�ny felel�s az�rt hogy az �tk�zni/el�zni k�sz�l� kocsi tiszt�ban legyen
	 * azzal milyen kocsit el�z
	 *  
	 */
	public void move(Car c) {
		System.out.println("Car.move()-Begin");
		c.pass(this); // Azonos�tja mag�t a megel�zend� kocsi
		System.out.println("Car.move()-End");
	}

	/**
	 * A l�ptet�s�rt felel�s f�ggv�ny
	 *  
	 */

	public void step()
	{
		System.out.println("Car.step()-Begin");
		
		rb.getNeighbour(); // elk�ri a lehets�ges c�l�llom�sok c�m�t a RoadBlockt�l 
		
		Car elozendo = rb.getCar(); //megtudja milyen aut� van (ha van) a c�l RoadBlockon
		if (elozendo==null) //ha nincs aut� halad tov�bb
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
			
		
		rb.getTraffic(); //meg�rkez�s ut�n megvizsg�lja a forgalomir�ny�t� jeleket (kell e 
						//majd v�rakoznia
		rb.getBuilding(); //megvizsg�lja c�lba �rt-e
		
		System.out.println("Car.step()-End");
	
	}

	/**
	 * Ha egy aut� el�tt van m�s aut� itt kezeli le
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
	 * Az aut� megsemmis�l�se (ha rabl� el�zi)  
	 * 
	 */

	public void destroy() {
		System.out.println("Car.destroy()-Begin");
		rb.setCar(null);
		System.out.println("Car.destroy()-End");
	}

}