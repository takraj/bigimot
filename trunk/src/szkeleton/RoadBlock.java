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
		System.out.println("H�ny szomsz�dja van?(0-3)");
		
		try
		{

		int t=System.in.read();
		t=t-48;
		System.in.skip(System.in.available());
		System.out.println("beolvasott sz�m:"+t);
		setNeighbour(t);  //szomsz�dok felv�tele
		}
		catch(IOException e)
		{
			System.out.println("Hib�s bemenet");			
		}		
		
		
		System.out.println("milyen k�zleked�si jelz�s van?(0:semmi; 1:sign; 2:table)");
		try{
			temp=System.in.read();
			temp=temp-48;
			System.in.skip(System.in.available());
			if(temp==1) traffic=new TrafficSign();
			if(temp==2) traffic=new TrafficTable();
			
		}	 
		catch(IOException e)
		{
			System.out.println("Hib�s bemenet");			
		}		
		
		System.out.println("RoadBlock()-End");
	}

	/**
	 * Szomsz�dok felv�tele
	 * @param i szomsz�dok sz�ma
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
	 * Az �tszakaszhoz tartoz� �p�let hozz�rendel�se
	 * @param b Az �p�letre mutat� referencia
	 */

	public void setBuilding(Building b) {
		System.out.println("RoadBlock.setBuilding()-Begin");
		System.out.println("RoadBlock.setBuilding()-End");
	}

	/**
	 * Az �tszakaszhoz tartoz� aut� hozz�rendel�se
	 * @param c Az aut�ra mutat� referencia
	 */
	public void setCar(Car c) {
		System.out.println("RoadBlock.setCar()-Begin");
		System.out.println("RoadBlock.setCar()-End");
		}

	/**
	 * A lehets�ge kimenetek (�tszakaszok) meghat�roz�sa
	 */

	public RoadBlock getNeighbour() {
		System.out.println("RoadBlock.getNeighbour()-Begin");
		System.out.println("RoadBlock.getNeighbour()-End");
		return this;
	}
	/**
	 * Az �tszakaszhoz tartoz� �p�letek meghat�roz�sa, a hideout eset�n a j�t�k v�ge
	 */
	public Building getBuilding() {
		System.out.println("RoadBlock.getBuilding()-Begin");
		System.out.println("RoadBlock.getBuilding()-End");
		return building;
	}

	/**
	 * Az �tszakasz foglalts�g�nak vizsg�lata
	 */

	public Car getCar() {
		System.out.println("RoadBlock.getCar()-Begin");
		System.out.println("van el�tt�nk kocsi? 0:nincs 1:van");
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
			System.out.println("Hib�s bemenet");			
		}	

		System.out.println("RoadBlock.getCar()-End");
		return null;

	}
	
	/**
	 * Az �tszakaszhoz tartoz� k�zleked�si jelz�sek lek�r�se
	 */

	public ITraffic getTraffic() {
		System.out.println("RoadBlock.getTraffic()-Begin");
		System.out.println("RoadBlock.getTraffic()-End");
		return traffic;
	}

}