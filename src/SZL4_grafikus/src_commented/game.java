import java.io.*;
import java.util.*;

/**
 * A j�t�k oszt�ly. Az alapvet� input-output feladatokat l�tja el,
 * � tartalmazza a program bel�p�si pontj�t is.
 * 
 * @author TakRaj
 *
 */
public class game {
	
	private static City city = null;
	private static View view;
	
	/**
	 * Visszaadja a v�ros referenci�j�t.
	 * 
	 * @return Referencia a v�rosra.
	 */
	
	public static City GetCity(){
		return city;
	}
	
	/**
	 * Bet�lti a p�ly�t a file f�jlb�l, ha ez lehets�ges.
	 * 
	 * @param file A p�lyam�trix f�jl.
	 * @return Egy v�ros.
	 */
	
	public static City LoadMap(String file){
		int n;
		String actLine;
        
		Scanner sc = null;
		try {
			sc = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			PrintMessage("Cannot find file: "+file);
			System.exit(-1);
		}
        
		actLine=sc.nextLine();
		try {
			n=Integer.parseInt(actLine);
		} catch (Exception e) {
			PrintMessage("BAD FILE FORMAT!");
			return null;
		}
        
        String[] map=new String[n*n];
        
        for (int i=0;i<n*n;i++){
        	actLine=sc.nextLine();
        	map[i]=actLine;
        }

        return new City(map, n);
	}
	
	/**
	 * Bet�lt egy j�t�k�ll�st file-b�l, ha ez lehets�ges.
	 * 
	 * @param file A j�t�k�ll�st tartalaz� f�jl.
	 * @param city Melyik v�rosba t�ltse be.
	 */
	
	public static void LoadState(String file, City city){
		if (city == null) System.exit(-1);
		
		Scanner sc = null;
		String actLine = "";
		String[] parts = null;
		
		int LastRB = 0;	// utolj�ra beolvasott RoadBlock indexe
    	int LastCar = 0;	// utolj�ra beolvasott Car indexe
    	int LastTraffic = 0;	// utolj�ra beolvasott ITraffic indexe
		
		try {
			sc = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			PrintMessage("Cannot find file: "+file);
			System.exit(-1);
		}
		
		while (sc.hasNext()){	
        	actLine=sc.nextLine();
        	parts=actLine.trim().split(" ");
        	
        	// el kell d�nteni, hogy mi ez
        	
        	if (parts[0].compareToIgnoreCase("OBJECT") == 0){
        		// objektum defin�ci�ja
        		
        		if (parts[1].contains("traffic")){
        			// forgalomir�ny�t�s defin�ci�ja
        			
        			if (parts[1].length() == "traffic[00]".length())
        				LastTraffic = Integer.parseInt(parts[1].substring(parts[1].length()-3, parts[1].length()-1));
        			if (parts[1].length() == "traffic[0]".length())
        				LastTraffic = Integer.parseInt(parts[1].substring(parts[1].length()-2, parts[1].length()-1));
        		}
        		
        		if (parts[1].contains("road")){
        			// RoadBlock defin�ci�ja
        			
        			if (parts[1].length() == "road[00]".length())
        				LastRB = Integer.parseInt(parts[1].substring(parts[1].length()-3, parts[1].length()-1));
        			if (parts[1].length() == "road[0]".length())
        				LastRB = Integer.parseInt(parts[1].substring(parts[1].length()-2, parts[1].length()-1));
        		}
        		
        		if (parts[1].contains("car")){
        			// aut� defin�ci�ja
        			
        			if (parts[1].length() == "car[00]".length())
        				LastCar = Integer.parseInt(parts[1].substring(parts[1].length()-3, parts[1].length()-1));
        			if (parts[1].length() == "car[0]".length())
        				LastCar = Integer.parseInt(parts[1].substring(parts[1].length()-2, parts[1].length()-1));
        				
        			city.addCar(parts[3], LastCar);
        		}
        	}
        	
        	// property be�ll�t�sa
        	
        	if (parts[0].compareToIgnoreCase("speed") == 0){
        		// car.speed
        		
        		city.GetCar(LastCar).SetSpeed(Integer.parseInt(parts[1]));
        	}
        	
        	if (parts[0].compareToIgnoreCase("timetomove") == 0){
        		// car.timetomove
        		
        		city.GetCar(LastCar).SetTimeToMove(Integer.parseInt(parts[1]));
        	}
        	
        	if (parts[0].compareToIgnoreCase("health") == 0){
        		// car.health
        		
        		city.GetCar(LastCar).SetHealth(Integer.parseInt(parts[1]));
        	}
        	
        	if (parts[0].compareToIgnoreCase("car") == 0){
        		// road.car
        		
        		int index = 0;
        		
        		if (parts[1].length() == "car[00]".length())
    				index = Integer.parseInt(parts[1].substring(parts[1].length()-3, parts[1].length()-1));
    			if (parts[1].length() == "car[0]".length())
    				index = Integer.parseInt(parts[1].substring(parts[1].length()-2, parts[1].length()-1));
        		
        		city.GetRBAt(LastRB).setCar(city.GetCar(index));
        		city.GetCar(index).SetRB(city.GetRBAt(LastRB));
        	}
        	
        	if (parts[0].compareToIgnoreCase("state") == 0){
        		// traffic.state
        		
        		city.GetTraffic(LastTraffic).SetState(Integer.parseInt(parts[1]));
        	}
		}
	}
	
	/**
	 * Kimenti a j�t�k�ll�st file-ba.
	 * 
	 * @param file Kimeneti f�jl neve.
	 * @param city Kimentend� v�ros referenci�ja.
	 */
	
	public static void SaveState(String file, City city){
		if (city == null) return;
		
		String result = "";
		
		// aut�k ment�se
		
		for (int i=0;i<city.csize;i++){
			if (city.GetCar(i) != null)
				result += String.format("OBJECT car[%d] TYPE %s%s\n", i, city.GetCar(i).WhoAmI(), city.GetCar(i).toString());
		}
		
		// utak ment�se
		
		for (int i=0;i<city.GetSize();i++){
			if (city.GetRBAt(i) != null)
				result += String.format("OBJECT road[%d] TYPE %s%s\n", i, "RoadBlock", city.GetRBAt(i).toString());
		}
		
		// jelz�k ment�se
		
		for (int i=0;i<city.tsize;i++){
			if (city.GetTraffic(i) != null)
				result += String.format("OBJECT traffic[%d] TYPE %s%s\n", i, city.GetTraffic(i).WhoAmI(), city.GetTraffic(i).toString());
		}
		
		result = result.replace("\n", "\r\n"); // erre windowson sz�ks�g volt
		
		// �r�s f�jlba
		
		Writer output = null;
		File f = null;
		
		try {
			f = new File(file);
			output = new BufferedWriter(new FileWriter(f));
		} catch (Exception e) {
			PrintMessage("Cannot create save file.");
			return;
		}
		
		try {
			output.write(result);
		} catch (Exception e){
			PrintMessage("Write error.");
		} finally {
			try {
				output.close();
			} catch (Exception e){}
		}
	}
	
	/**
	 * Egyszer� interf�sz a j�t�k�ll�sok bet�lt�s�re.
	 * 
	 * @param map P�lyam�trix f�jl.
	 * @param state J�t�k�ll�st tartalmaz� f�jl.
	 */
	
	public static void LoadGame(String map, String state){
		city = null;
		city = LoadMap(map);
		LoadState(state, city);
		
		if (view != null) view.dispose();
		view = new GameForm("BIGIMOT, SZOFTVER LABOR 4", city);
		view.Draw();
		
		CreateTimer(1000, city, view);
	}
	
	/**
	 * �j j�t�k kezd�se map p�ly�n. Egyszer�s�tett interf�sz.
	 * 
	 * @param map P�lyam�trix f�jl.
	 */
	
	public static void NewGame(String map){
		city = null;
		city = LoadMap(map);
		if (city == null) System.exit(-1);
		
		if (view != null) view.dispose();
		view = new GameForm("BIGIMOT, SZOFTVER LABOR 4", city);
        view.Draw();
        
        CreateTimer(1000, city, view);
	}
	
	/**
	 * Egyszer�s�tett interf�sz a j�t�k�ll�s kiment�s�re.
	 * 
	 * @param file C�lf�jl.
	 */
	
	public static void SaveGame(String file){
		SaveState(file, city);
	}
	
	/**
	 * Id�z�t�t hoz l�tre, ami l�pteti a v�rost, majd �jrarajzolja a k�pet.
	 * 
	 * @param interval Milyen id�k�z�nk�nt l�ptessen.
	 * @param c Melyik v�rost l�ptesse.
	 * @param v Mi a v�ros n�zete.
	 */
	
	public static void CreateTimer(int interval, final City c, final View v){
		if (c == null) return;
		if (v == null) return;
		
		int delay = 1000;
		int period = interval;
		
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				c.step();
				v.UpdateViews();
				v.Draw();
			} }, delay, period); 
	}
	
	/**
	 * Egyszer�s�tett interf�sz �zenet ki�r�s�ra a k�perny�n.
	 * 
	 * @param s Mit �rjon ki.
	 * @return true, ha a felhaszn�l� reag�lt r� a fel�leten, vagy konzolra ker�lt ki�r�sra. false, egy�bk�nt.
	 */
	
	public static boolean PrintMessage(String s){
		if (view != null){
			return view.PrintMessage(s);
		}
		else {
			System.out.println(s);
			return true;
		}
	}
	
	/**
	 * Egyszer�s�tett interf�sz adatok bek�r�s�hez a k�perny�n.
	 * 
	 * @param s Mi a k�rd�s?
	 * @return A v�lasz, vagy "", ha nem adott meg semmit.
	 */
	
	public static String AskFor(String s){		
		if (view != null){
			return view.AskFor(s);
		}
		else {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String str = "";
				System.out.println(s);
				str = in.readLine();
				return str;
			} catch (IOException e) {
				System.out.println("IO Error.");
				return "";
			} 
		}
	}
	
	/**
	 * A program bel�p�si pontja.
	 * 
	 * @param args Nem haszn�lt.
	 */
	
	public static void main(String args[])
	{		
		view = new MenuForm("BIGIMOT, SZOFTVER LABOR 4");
	}

}
