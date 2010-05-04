import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;
import java.util.*;


public class game {
	
	private static City city = null;
	private static GameForm view;
	
	public static City LoadMap(String file){
		int n;
		String actLine;
        
		Scanner sc = null;
		try {
			sc = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			System.out.printf("Cannot find file: %s\n",file);
			System.exit(-1);
		}
        
		actLine=sc.nextLine();
		n=Integer.parseInt(actLine);
        
        String[] map=new String[n*n];
        
        for (int i=0;i<n*n;i++){
        	actLine=sc.nextLine();
        	map[i]=actLine;
        }

        return new City(map, n);
	}
	
	public static void LoadState(String file, City city){
		Scanner sc = null;
		String actLine = "";
		String[] parts = null;
		
		int LastRB = 0;	// utoljára beolvasott RoadBlock indexe
    	int LastCar = 0;	// utoljára beolvasott Car indexe
    	int LastTraffic = 0;	// utoljára beolvasott ITraffic indexe
		
		try {
			sc = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			System.out.printf("Cannot find file: %s\n",file);
			System.exit(-1);
		}
		
		while (sc.hasNext()){	
        	actLine=sc.nextLine();
        	parts=actLine.trim().split(" ");
        	
        	// el kell dönteni, hogy mi ez
        	
        	if (parts[0].compareToIgnoreCase("OBJECT") == 0){
        		// objektum definíciója
        		
        		if (parts[1].contains("traffic")){
        			// forgalomirányítás definíciója
        			
        			if (parts[1].length() == "traffic[00]".length())
        				LastTraffic = Integer.parseInt(parts[1].substring(parts[1].length()-3, parts[1].length()-1));
        			if (parts[1].length() == "traffic[0]".length())
        				LastTraffic = Integer.parseInt(parts[1].substring(parts[1].length()-2, parts[1].length()-1));
        		}
        		
        		if (parts[1].contains("road")){
        			// RoadBlock definíciója
        			
        			if (parts[1].length() == "road[00]".length())
        				LastRB = Integer.parseInt(parts[1].substring(parts[1].length()-3, parts[1].length()-1));
        			if (parts[1].length() == "road[0]".length())
        				LastRB = Integer.parseInt(parts[1].substring(parts[1].length()-2, parts[1].length()-1));
        		}
        		
        		if (parts[1].contains("car")){
        			// autó definíciója
        			
        			if (parts[1].length() == "car[00]".length())
        				LastCar = Integer.parseInt(parts[1].substring(parts[1].length()-3, parts[1].length()-1));
        			if (parts[1].length() == "car[0]".length())
        				LastCar = Integer.parseInt(parts[1].substring(parts[1].length()-2, parts[1].length()-1));
        				
        			city.addCar(parts[3], LastCar);
        		}
        	}
        	
        	// property beállítása
        	
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
	
	public static void SaveState(String file, City city){
		String result = "";
		
		// autók mentése
		
		for (int i=0;i<city.csize;i++){
			if (city.GetCar(i) != null)
				result += String.format("OBJECT car[%d] TYPE %s%s\n", i, city.GetCar(i).WhoAmI(), city.GetCar(i).toString());
		}
		
		// utak mentése
		
		for (int i=0;i<city.GetSize();i++){
			if (city.GetRBAt(i) != null)
				result += String.format("OBJECT road[%d] TYPE %s%s\n", i, "RoadBlock", city.GetRBAt(i).toString());
		}
		
		// jelzõk mentése
		
		for (int i=0;i<city.tsize;i++){
			if (city.GetTraffic(i) != null)
				result += String.format("OBJECT traffic[%d] TYPE %s%s\n", i, city.GetTraffic(i).WhoAmI(), city.GetTraffic(i).toString());
		}
		
		result = result.replace("\n", "\r\n"); // erre windowson szükség volt
		
		// írás fájlba
		
		Writer output = null;
		File f = null;
		
		try {
			f = new File(file);
			output = new BufferedWriter(new FileWriter(f));
		} catch (Exception e) {
			System.out.println("Cannot create save file.");
			return;
		}
		
		try {
			output.write(result);
		} catch (Exception e){
			System.out.println("Write error.");
		} finally {
			try {
				output.close();
			} catch (Exception e){}
		}
	}
	
	public static void LoadGame(String map, String state){
		city = null;
		city = LoadMap(map);
		LoadState(state, city);
		
		if (view != null) view.dispose();
		view = new GameForm("BIGIMOT, SZOFTVER LABOR 4", city);
		view.Draw();
		
		CreateTimer(1000, city, view);
	}
	
	public static void NewGame(String map){
		city = null;
		city = LoadMap(map);
		
		if (view != null) view.dispose();
		view = new GameForm("BIGIMOT, SZOFTVER LABOR 4", city);
        view.Draw();
	}
	
	public static void SaveGame(String file){
		SaveState(file, city);
	}
	
	public static void CreateTimer(int interval, final City c, final GameForm v){
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
	
	public static void main(String args[])
	{
		LoadGame("mapfile.txt","state3.txt");
	}

}
