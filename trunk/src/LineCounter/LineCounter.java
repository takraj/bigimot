import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

public class LineCounter {

    static int totalLines = 0; 

    private static void dirList(String fname) {
        FilenameFilter filter = new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.endsWith(".java");
                }
            };
        
	    String format = "%1$-40s%2$-10s line(s)\n";
        File dir = new File(fname);
        String[] chld = dir.list(filter);
        int linesInFile = 0;
        
        for (int i = 0; i < chld.length; i++) {
            try {
                BufferedReader input = new BufferedReader(new FileReader(new File(chld[i])));
                while(input.readLine() != null) {
                    linesInFile++;
                }
                System.out.format(format, chld[i], String.valueOf(linesInFile));
                totalLines += linesInFile;
                linesInFile = 0;
                input.close();
            } catch(IOException ioe) {
                System.out.println("FATAL ERROR: could not open file " + chld[i]);
                System.exit(1);
            }
        }
        
        System.out.println("======================================");
        System.out.println("TOTAL " + totalLines + " lines of java code in current directory.\n");        
    }

    public static void main(String[] args) {
		
		System.out.println();
		
        dirList(".");

		try{
			System.out.println("Press any key to continue...");
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
			int ch = stdin.read();
		} catch(IOException e) {}		
		
    }
}
