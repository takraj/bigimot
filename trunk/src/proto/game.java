import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class game {
	public static void main(String args[])
	{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String mapfile = null;
	    String statefile = null;
	    String savefile = null;
	    String stepnum = null;

	    //  read the username from the command-line; need to use try/catch with the
	    //  readLine() method
	    System.out.println("Kérem a bemenetet: mapfile/statefile/savefiel/stepnum");
	    try {
	       mapfile = br.readLine();
	       statefile = br.readLine();
	       savefile = br.readLine();
	       stepnum = br.readLine();
	    } catch (IOException ioe) {
	       System.out.println("IO error!");
	       System.exit(1);
	    }
		 
	    //System.out.println("dsa"+mapfile+statefile+savefile+stepnum);
		
		int n;
		String actLine;
        
		Scanner sc = null;
		try {
			sc = new Scanner(new File(mapfile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
		actLine=sc.nextLine();
        n=Integer.parseInt(actLine);
        
        String[] map=new String[n*n];
        
        for (int i=0;i<n*n;i++){
        	actLine=sc.nextLine();
        	map[i]=actLine;
        }

        City city=new City(map, n, 0);
        
        //city.mutassad();
        
        try {
			sc = new Scanner(new File(statefile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
		actLine=sc.nextLine();
		n=Integer.parseInt(actLine);
		String[] parts=null;
        for (int i=0;i<n;i++){
        	
        	actLine=sc.nextLine();
        	parts=actLine.trim().split(" ");
        	//System.out.println("dsa "+parts[0]+" "+Integer.parseInt(parts[1])+" "+Integer.parseInt(parts[2]));
        	city.setCar(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        }
        
        FileWriter fstream=null;
        
        int st=Integer.parseInt(stepnum);
        
        for(int i=0;i<st;i++){
        	//if((parts[0].compareTo("Robber")==0)&&(i==0)) city.robDir(3);
        	if((parts[0].compareTo("Robber")==0)&&(i==0)) city.robDir(2);
        	if((parts[0].compareTo("Robber")==0)&&(i==1)) city.robDir(2);
        	if((parts[0].compareTo("Robber")==0)&&(i==2)) city.robDir(0);
        	city.step();
        }

		try {
			fstream = new FileWriter(savefile);
			BufferedWriter out = new BufferedWriter(fstream);
			city.save(out);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
