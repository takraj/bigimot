
import java.lang.*;
import java.util.*;
import java.io.*;


public class City {

	private LinkedList<Car> car;
	private LinkedList<RoadBlock> road;
	private LinkedList<ITraffic> traffic;
	private LinkedList<Building> building;

	/**
	 * City konstruktora, ez hozza létre a RoadBlockokat, hideoutot, és a Car-okat
	 */

	public City()
	{
		
		System.out.println("City()-Begin");
		
		road = new LinkedList<RoadBlock>();
		road.add(new RoadBlock());

		building = new LinkedList<Building>();
		building.add(new Building(road.get(0) ) );
		
		car = new LinkedList<Car>();
		car.add(new Car(road.get(0)));
		car.add(new Police(road.get(0)));
		car.add(new Robber(road.get(0)));

		System.out.println("City()-End");
 	}

	/**
	 * Léptetõ függvény, ez biztosítja az órajelet
	 *  
	 */

	public void step() {
		System.out.println("City.step()-Begin");

		int temp;
		System.out.println("Mi mozdul? 0:Car 1:Police 2:Robber");
		try
		{
			temp=System.in.read();
			temp=temp-48;
			System.in.skip(System.in.available());
			if (temp==0)
			{
				car.get(0).step();
			}
			if (temp==1)
			{
				car.get(1).step();
			}
			if (temp==2)
			{
				car.get(2).step();
			}
		}
		catch(IOException e)
		{
			System.out.println("Hibás bemenet");			
		}	

		System.out.println("City.step()-End");
	}

}