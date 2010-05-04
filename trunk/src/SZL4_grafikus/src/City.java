import java.io.*;


public class City {

	public Car[] car;
	private ITraffic[] traffic;
	
	private RoadBlock[] road;
	Building h;
	int rsize, tsize, bsize, csize;
	
	public int GetSize(){
		return rsize;
	}
	
	public RoadBlock GetRBAt(int i){
		return road[i];
	}
	
	public Car GetCar(int i){
		return car[i];
	}
	
	public ITraffic GetTraffic(int i){
		return traffic[i];
	}
	
	public Building GetHideout(){
		return h;
	}
	
	/**
	 * City konstruktora, ez hozza létre a RoadBlockokat, hideoutot, és a Car-okat
	 * n: oszlopok/sorok száma
	 */
	public City(String[] map, int n){
		road=new RoadBlock[n*n];
		for(int i=0;i<n*n;i++) road[i]=new RoadBlock();
		traffic=new ITraffic[10];
		rsize=n*n;
		tsize=bsize=0;
		csize=0;
		car=new Car[20];
		char c;
		
		for(int i=0;i<n*n;i++){
			for(int j=0;j<n*n;j++){
				c=map[i].charAt(j);
				switch (c){
				case 'b':
				case 'B':
					road[i].setBuilding(new Bank(road[i]));
					break;
				case 'h':
				case 'H':
					road[i].used=1;
					h=new Hideout(road[i]);
					road[i].setBuilding(h);
					break;
				case 's':
				case 'S':
					road[i].used=1;
					traffic[tsize]=new TrafficSign();
					road[i].setTraffic(traffic[tsize]);
					tsize++;
					break;
				case 't':
				case 'T':
					road[i].used=1;
					traffic[tsize]=new TrafficTable();
					road[i].setTraffic(traffic[tsize]);
					tsize++;
					break;
				case '1':
					road[i].used=1;
					// fel=0, bal=2, jobb=1, le=3
					if(j==i-3){
						road[i].setNeighbour(road[j], 0);
						road[j].setPrev(road[i], 3);
					}
					if(j==i-1){
						road[i].setNeighbour(road[j], 1);
						road[j].setPrev(road[i], 2);
					}
					if(j==i+1){
						road[i].setNeighbour(road[j], 2);
						road[j].setPrev(road[i], 1);
					}
					if(j==i+3){
						road[i].setNeighbour(road[j], 3);
						road[j].setPrev(road[i], 0);
					}
					break;
				default :
					
					break;
				}
			} 
		}
		
		
	}
	
	public void addCar(String t, int index){
		if (csize < (index+1)) csize = index+1;
		
		if(t.compareTo("Robber")==0) car[index]=new Robber();
		if(t.compareTo("Police")==0) car[index]=new Police();
		if(t.compareTo("Car")==0) car[index]=new Car();
		if(t.compareTo("Bunny")==0) car[index]=new bunny();
		
		if (car[index] != null){
			car[index].setIndex(index);
		}
	}
	
	public void setCar(String t, int i, int s){
		if(t.compareTo("Robber")==0) car[csize]=new Robber(road[i],s);
		if(t.compareTo("Police")==0) car[csize]=new Police(road[i],s);
		if(t.compareTo("Car")==0) car[csize]=new Car(road[i],s);
		if(t.compareTo("Bunny")==0) car[csize]=new bunny(road[i],s);
		
		road[i].setCar(car[csize]);
		csize++;
	}
	
	public void save(BufferedWriter out){
		try {
			out.write("OBJECT city TYPE City");
			out.newLine();
			
			for(int i=0;i<rsize;i++){
				if(road[i].used==1){
					out.write("road["+i+"] ");
					out.newLine();
				}
			}
			for(int i=0;i<tsize;i++){
				out.write("traffic["+i+"] ");
				out.newLine();
			}
			for(int i=0;i<bsize;i++){
				out.write("building["+i+"] ");
				out.newLine();
			}
			for(int i=0;i<csize;i++){
				out.write("car["+i+"] ");
				out.newLine();
			}
			for(int i=0;i<rsize;i++){
				if(road[i].used==1){
					out.write("OBJECT road["+i+"] TYPE RoadBlock");
					out.newLine();
					road[i].save(out);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Write error.");
		}
	}
	
	/**
	 * Léptetõ függvény, ez biztosítja az órajelet
	 *  
	 */

	public void robDir(int i){
		car[0].setirany(i);
	}
	
	public void step() {
		
		for(int i=0;i<csize;i++){
			if ((car[i] != null) && (car[i].getKeeper() != null))
				car[i].step();
		}
		for(int i=0;i<tsize;i++){
			if (traffic[i] != null)
					traffic[i].step();
		}
		
		/* debug kód */
		// System.out.println("City.step()");
		/* debug kód */
		
	}

}