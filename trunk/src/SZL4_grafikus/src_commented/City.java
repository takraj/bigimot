import java.util.Random;

/**
 * A v�rost reprezent�l� oszt�ly.
 * 
 * @author TakRaj
 */

public class City {
	
	private boolean robber_once = true;
	
	public Car[] car;
	private ITraffic[] traffic;
	
	Random irand = new Random();
	
	private RoadBlock[] road;
	Building h;
	int rsize, tsize, bsize, csize;
	
	/**
	 * T�r�l egy aut�t.
	 * 
	 * @param c Melyik aut�t?
	 */
	
	public void DeleteCar(Car c){
		for (int i = 0; i<csize; i++){
			if (car[i] == c) car[i] = null;
		}
	}
	
	/**
	 * Visszaadja a v�ros m�ret�t. N�gyzetsz�m.
	 * 
	 * @return A v�ros m�rete n�gyzetsz�mmal.
	 */
	
	public int GetSize(){
		return rsize;
	}
	
	/**
	 * Visszaadja az i-edik indexen l�v� RoadBlock referenci�j�t.
	 * 
	 * @param i RoadBlock indexe.
	 * @return RoadBlock referencia.
	 */
	
	public RoadBlock GetRBAt(int i){
		return road[i];
	}
	
	/**
	 * Visszaadja az i-edik indexen l�v� Aut�t.
	 * 
	 * @param i Car indexe.
	 * @return Aut� referenci�ja.
	 */
	
	public Car GetCar(int i){
		return car[i];
	}
	
	/**
	 * Visszaadja az i-edik indexen l�v� ITraffic-ot.
	 * 
	 * @param i ITraffic indexe.
	 * @return ITraffic referenci�ja.
	 */
	
	public ITraffic GetTraffic(int i){
		return traffic[i];
	}
	
	/**
	 * Visszaadja a rejtekhely referenci�j�t.
	 * 
	 * @return Rejtekhely referenci�ja.
	 */
	
	public Building GetHideout(){
		return h;
	}
	
	/**
	 * Visszaadja a rabl� referenci�j�t.
	 * 
	 * @return Rabl� referenci�ja.
	 */
	
	public Robber GetRobber(){
		for (int i=0; i<csize; i++){
			if ((car[i] != null) && (car[i].WhoAmI() == "Robber"))
				return (Robber)car[i];
		}
		return null;
	}
	
	/**
	 * Visszaadja a RoadBlockok k�z�l az els� olyat, aminek van kij�rata.
	 * 
	 * @return Els� nyit� RoadBlock.
	 */
	
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
	
	/**
	 * Visszaadja a RoadBlockok k�z�l az utols� olyat, aminek van kij�rata.
	 * 
	 * @return Utols� nyit� RoadBlock.
	 */
	
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
	
	/**
	 * Megadja egy t�mbben a nem NULL elemek sz�m�t.
	 * 
	 * @param o Tetsz�leges t�mb.
	 * @return Nem NULL elemek sz�ma.
	 */
	
	public int CountOfNotNull(Object[] o){
		int count = 0;
		
		for (int i = 0; i<o.length; i++){
			if (o[i] != null) count++;
		}
		
		return count;
	}
	
	/**
	 * Aut�t gener�l az els� vagy utols� nyit� RoadBlock-ra.
	 */
	
	public void GenerateCar(){
		RoadBlock where = null;

		if ((irand.nextBoolean()) && (FirstIn() != null)){
			where = FirstIn();
		} else if (LastIn() != null){
			where = LastIn();
		} else if (FirstIn() != null){
			where = FirstIn();
		} else {
			return;		// �res p�lya
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
	
	/**
	 * Megadja, hogy egy fix hossz� t�mb tele van-e.
	 * 
	 * @param o Tetsz�leges t�mb.
	 * @return true, ha nincs benne NULL elem, false egy�b�nt.
	 */
	
	public boolean IsFull(Object[] o){
		if (o != null){
			for (int i = 0; i<o.length; i++){
				if (o[i] == null) return false;
			}
		}
		return true;
	}
	
	/**
	 * Megadja az o t�mb els� olyan index�t, ami NULL.
	 * 
	 * @param o Tetsz�leges t�mb.
	 * @return Index, ha van, -1 egy�bk�nt.
	 */
	
	public int FirstEmpty(Object[] o){
		if (o != null){
			for (int i = 0; i<o.length; i++){
				if (o[i] == null) return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Megadja, hogy van-e m�r nyuszi a p�ly�n.
	 * 
	 * @return true, ha van, false egy�bk�nt.
	 */
	
	public boolean IsThereBunny(){
		for (int i=0; i<csize; i++){
			if ((car[i] != null) && (car[i].WhoAmI() == "Bunny"))
				return true;
		}
		return false;
	}
	
	/**
	 * V�letlenszer� helyre pakol egy nyulat a p�ly�n.
	 */
	
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
	
	/**
	 * V�letlenszer� helyre pakol egy rabl�t a p�ly�n.
	 */
	
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
	 * City konstruktora, ez hozza l�tre a RoadBlockokat, hideoutot, �s a Car-okat
	 * 
	 * @param map P�ly�t reprezent�l� string.
	 * @param n P�lya m�rete, n�gyzetsz�mban.
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
	
	/**
	 * Egy azonos�t�string�vel megadott aut�t pakol a p�lya indexedik RoadBlock-j�ra.
	 * 
	 * @param t Azonos�t� string: "Robber", "Police", "Car", "Bunny"
	 * @param index RoadBlock indexe.
	 */
	
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
	
	/**
	 * Egy azonos�t� stringb�l aut�t hoz l�tre, a p�lya i-edik RoadBlock-j�n, s sebess�ggel.
	 * 
	 * @param t Azonos�t� string: "Robber", "Police", "Car", "Bunny"
	 * @param i RoadBlock indexe.
	 * @param s Aut� sebess�ge.
	 */
	
	public void setCar(String t, int i, int s){
		if(t.compareTo("Robber")==0) car[csize]=new Robber(road[i],s);
		if(t.compareTo("Police")==0) car[csize]=new Police(road[i],s);
		if(t.compareTo("Car")==0) car[csize]=new Car(road[i],s);
		if(t.compareTo("Bunny")==0) car[csize]=new bunny(road[i],s);
		
		road[i].setCar(car[csize]);
		csize++;
	}
	
	/**
	 * A rabl� ir�ny�t �ll�tja be.
	 * 
	 * @param i L�sd: Car.setirany()
	 */

	public void robDir(int i){
		car[0].setirany(i);
	}
	
	/**
	 * L�ptet� f�ggv�ny, ez biztos�tja az �rajelet
	 *  
	 */
	
	public void step() {
		
		/*
		 *  rabl� elhelyez�se, ha m�g nem volt, v�letlenszer� helyre
		 * 
		 */
		if ((GetRobber() == null) && (robber_once)){
			robber_once = false;
			PlaceRobber();
		}
		
		// nyuszi elhelyez�se v�letlenszer� id�ben v�letlen helyre
		
		if ((!IsThereBunny()) && (irand.nextBoolean())){
			PlaceBunny();
		}
		
		// aut�k gener�l�sa
		
		if (CountOfNotNull(car) < Math.floor(Math.sqrt(rsize))){
			GenerateCar();
		}
		
		// l�ptet�s
		
		for(int i=0;i<csize;i++){
			if ((car[i] != null) && (car[i].getKeeper() != null))
				car[i].step();
		}
		for(int i=0;i<tsize;i++){
			if (traffic[i] != null)
					traffic[i].step();
		}
		
		/* debug k�d */
		// System.out.println("City.step()");
		/* debug k�d */
		
	}

}