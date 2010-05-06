import java.util.Random;


public class City {
	
	private boolean robber_once = true;
	
	public Car[] car;
	private ITraffic[] traffic;
	
	Random irand = new Random();
	
	private RoadBlock[] road;
	Building h;
	int rsize, tsize, bsize, csize;
	
	public void DeleteCar(Car c){
		for (int i = 0; i<csize; i++){
			if (car[i] == c) car[i] = null;
		}
	}
	
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
	
	public Robber GetRobber(){
		for (int i=0; i<csize; i++){
			if ((car[i] != null) && (car[i].WhoAmI() == "Robber"))
				return (Robber)car[i];
		}
		return null;
	}
	
	public RoadBlock FirstIn(){
		for (int i=0; i<GetSize(); i++){
			if (road[i] != null){
				if ((road[i].GetNeighbour(0) != null) || (road[i].GetNeighbour(1) != null) || (road[i].GetNeighbour(2) != null) || (road[i].GetNeighbour(3) != null)) {
					return road[i];
				}
			}
		}
		return null;
	}
	
	public RoadBlock LastIn(){
		for (int i=(GetSize()-1); i>=0; i--){
			if (road[i] != null){
				if ((road[i].GetNeighbour(0) != null) || (road[i].GetNeighbour(1) != null) || (road[i].GetNeighbour(2) != null) || (road[i].GetNeighbour(3) != null)) {
					return road[i];
				}
			}
		}
		return null;
	}
	
	public int CountOfNotNull(Object[] o){
		int count = 0;
		
		for (int i = 0; i<o.length; i++){
			if (o[i] != null) count++;
		}
		
		return count;
	}
	
	public void GenerateCar(){
		RoadBlock where = null;

		if ((irand.nextBoolean()) && (FirstIn() != null)){
			where = FirstIn();
		} else if (LastIn() != null){
			where = LastIn();
		} else if (FirstIn() != null){
			where = FirstIn();
		} else {
			return;		// üres pálya
		}
		
		if ((where != null) && (where.getCar() == null)){
			if (irand.nextInt(5) == 0){
				// generate police
				
				int index = FirstEmpty(car);
				car[index] = new Police(where);
				if (car.length > csize) csize = car.length;
			}
			else {
				// generate civilian
				
				int index = FirstEmpty(car);
				car[index] = new Car(where);
				if (car.length > csize) csize = car.length;
			}
		}
	}
	
	public boolean IsFull(Object[] o){
		if (o != null){
			for (int i = 0; i<o.length; i++){
				if (o[i] == null) return false;
			}
		}
		return true;
	}
	
	public int FirstEmpty(Object[] o){
		if (o != null){
			for (int i = 0; i<o.length; i++){
				if (o[i] == null) return i;
			}
		}
		
		return -1;
	}
	
	public boolean IsThereBunny(){
		for (int i=0; i<csize; i++){
			if ((car[i] != null) && (car[i].WhoAmI() == "Bunny"))
				return true;
		}
		return false;
	}
	
	public void PlaceBunny(){
		int[] perm = Randomizer.CreatePermutation(GetSize());
		if ((perm != null) && (!IsFull(car))){
			for (int i = 0; i<perm.length; i++){
				if ((road[perm[i]] != null) && (road[perm[i]].getCar() == null) && (road[perm[i]].IsNotZombie())){
					int robber_index = FirstEmpty(car);
					car[robber_index] = new bunny();
					if (car.length > csize) csize = car.length;
					road[perm[i]].setCar(car[robber_index]);
					car[robber_index].SetRB(road[perm[i]]);
					return;
				}
			}
		}
	}
	
	public void PlaceRobber(){
		int[] perm = Randomizer.CreatePermutation(GetSize());
		if ((perm != null) && (!IsFull(car))){
			for (int i = 0; i<perm.length; i++){
				if ((road[perm[i]] != null) && (road[perm[i]].getCar() == null) && (road[perm[i]].IsNotZombie())){
					int bunny_index = FirstEmpty(car);
					car[bunny_index] = new Robber();
					if (car.length > csize) csize = car.length;
					road[perm[i]].setCar(car[bunny_index]);
					car[bunny_index].SetRB(road[perm[i]]);
					return;
				}
			}
		}
	}
	
	/**
	 * City konstruktora, ez hozza létre a RoadBlockokat, hideoutot, és a Car-okat
	 * n: oszlopok/sorok száma
	 */
	public City(String[] map, int n){
		road=new RoadBlock[n*n];
		for(int i=0;i<n*n;i++) road[i]=new RoadBlock();
		traffic=new ITraffic[n*n];
		rsize=n*n;
		tsize=bsize=0;
		csize=0;
		car=new Car[n*n];
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
		
		if(t.compareTo("Robber")==0) {car[index]=new Robber(); robber_once = false; }
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
	
	/**
	 * Léptetõ függvény, ez biztosítja az órajelet
	 *  
	 */

	public void robDir(int i){
		car[0].setirany(i);
	}
	
	public void step() {
		
		// rabló elhelyezése, ha még nem volt, véletlenszerû helyre
		
		if ((GetRobber() == null) && (robber_once)){
			robber_once = false;
			PlaceRobber();
		}
		
		// nyuszi elhelyezése véletlenszerû idõben véletlen helyre
		
		if ((!IsThereBunny()) && (irand.nextBoolean())){
			PlaceBunny();
		}
		
		// autók generálása
		
		if (CountOfNotNull(car) < Math.floor(Math.sqrt(rsize))){
			GenerateCar();
		}
		
		// léptetés
		
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