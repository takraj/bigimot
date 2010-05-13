import java.io.*;
import java.util.*;

public class RoadBlock {

	private Car car;
	private ITraffic traffic;
	private Building building;
	private LinkedList<RoadBlock>  road;

	/**
	 * RoadBlock konstruktora
	 */
	public RoadBlock()
	{

		
		System.out.println("RoadBlock()-Begin");
		
		int temp;
		road=new LinkedList<RoadBlock>();
		System.out.println("Hány szomszédja van?(0-3)");
		
		try
		{

		int t=System.in.read();
		t=t-48;
		System.in.skip(System.in.available());
		System.out.println("beolvasott szám:"+t);
		setNeighbour(t);  //szomszédok felvétele
		}
		catch(IOException e)
		{
			System.out.println("Hibás bemenet");			
		}		
		
		
		System.out.println("milyen közlekedési jelzés van?(0:semmi; 1:sign; 2:table)");
		try{
			temp=System.in.read();
			temp=temp-48;
			System.in.skip(System.in.available());
			if(temp==1) traffic=new TrafficSign();
			if(temp==2) traffic=new TrafficTable();
			
		}	 
		catch(IOException e)
		{
			System.out.println("Hibás bemenet");			
		}		
		
		System.out.println("RoadBlock()-End");
	}

	/**
	 * Szomszédok felvétele
	 * @param i szomszédok száma
	 */

	public void setNeighbour(int i) {

		System.out.println("setNeighbour(int i)-Begin");
		
		if (i==0)
		{
			System.out.println("setNeighbour(int i)-End");
			return;
		}
		while((i-->0)) road.add(new RoadBlock());

		System.out.println("setNeighbour(int i)-End");
	}

	/**
	 * Az útszakaszhoz tartozó épület hozzárendelése
	 * @param b Az épületre mutató referencia
	 */

	public void setBuilding(Building b) {
		System.out.println("RoadBlock.setBuilding()-Begin");
		System.out.println("RoadBlock.setBuilding()-End");
	}

	/**
	 * Az útszakaszhoz tartozó autó hozzárendelése
	 * @param c Az autóra mutató referencia
	 */
	public void setCar(Car c) {
		System.out.println("RoadBlock.setCar()-Begin");
		System.out.println("RoadBlock.setCar()-End");
		}

	/**
	 * A lehetsége kimenetek (útszakaszok) meghatározása
	 */

	public RoadBlock getNeighbour() {
		System.out.println("RoadBlock.getNeighbour()-Begin");
		System.out.println("RoadBlock.getNeighbour()-End");
		return this;
	}
	/**
	 * Az útszakaszhoz tartozó épületek meghatározása, a hideout esetén a játék vége
	 */
	public Building getBuilding() {
		System.out.println("RoadBlock.getBuilding()-Begin");
		System.out.println("RoadBlock.getBuilding()-End");
		return building;
	}

	/**
	 * Az útszakasz foglaltságának vizsgálata
	 */

	public Car getCar() {
		System.out.println("RoadBlock.getCar()-Begin");
		System.out.println("van elõttünk kocsi? 0:nincs 1:van");
		int temp;
		try
		{
			temp=System.in.read();
			temp=temp-48;
			System.in.skip(System.in.available());
			if (temp==1) {
				System.out.println("RoadBlock.getCar()-End");
				return new Car(this);
			}
		}
		catch(IOException e)
		{
			System.out.println("Hibás bemenet");			
		}	

		System.out.println("RoadBlock.getCar()-End");
		return null;

	}
	
	/**
	 * Az útszakaszhoz tartozó közlekedési jelzések lekérése
	 */

	public ITraffic getTraffic() {
		System.out.println("RoadBlock.getTraffic()-Begin");
		System.out.println("RoadBlock.getTraffic()-End");
		return traffic;
	}

}