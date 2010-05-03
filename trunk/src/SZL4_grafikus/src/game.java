import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class game {
	public static void main(String args[])
	{		
		int n;
		String actLine;
        
		Scanner sc = null;
		try {
			sc = new Scanner(new File("mapfile.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find: mapfile.txt");
			System.exit(-1);
		}
        
		actLine=sc.nextLine();
		n=Integer.parseInt(actLine);
        
        String[] map=new String[n*n];
        
        for (int i=0;i<n*n;i++){
        	actLine=sc.nextLine();
        	map[i]=actLine;
        }

        City city=new City(map, n);
        GameForm gf = new GameForm("BIGIMOT, SZOFTVER LABOR 4", city);
        
        /* TESZT */
        city.setCar("Robber", 4, 9);
        city.GetRBAt(4).getCar().setirany(1);
        /* TESZT */
        
        gf.Draw();
        
        /* EZ MOST NEM KELL
        try {
			sc = new Scanner(new File(statefile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
        
		actLine=sc.nextLine();
		n=Integer.parseInt(actLine);
		String[] parts=null;
        for (int i=0;i<n;i++){
        	
        	actLine=sc.nextLine();
        	parts=actLine.trim().split(" ");
        	city.setCar(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        } */
        
        /* EZ MI A FENE???
        for(int i=0;i<st;i++){
        	if((parts[0].compareTo("Robber")==0)&&(i==0)) city.robDir(2);
        	if((parts[0].compareTo("Robber")==0)&&(i==1)) city.robDir(2);
        	if((parts[0].compareTo("Robber")==0)&&(i==2)) city.robDir(0);
        	city.step();
        }	*/
        
	}

}
