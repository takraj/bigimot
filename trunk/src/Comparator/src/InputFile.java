import java.io.*;

/**
 * Bemeneti fájlt reprezentáló osztály a könnyû beolvasás érdekében.
 * 
 * @author TakRaj
 * @version 1.0
 */
public class InputFile {
	private String filename;										// fájlnév
	private FileInputStream fstream;
	private DataInputStream in;
	private BufferedReader br;
	private String current_line;									// jelenlegi sor
	private int line_number;										// jelenlegi sorszám

	/**
	 * Az osztály destruktora, lezárja a megnyitott fájlt, ha van ilyen.
	 */
	protected void finalize() throws Throwable {
		try {
			in.close();												// fájl lezárása
		} catch (Exception e) {
			throw e;												// kivétel továbbdobása
		} finally {
			super.finalize();
		}
	}

	/**
	 * Az osztály konstruktora, bemeneti paramétere a megnyitandó fájl neve.
	 * 
	 * @param name A megnyitandó fájl neve, relatív elérési úttal.
	 * @throws Exception
	 */
	public InputFile(String name) throws Exception {
		filename = name;

		fstream = new FileInputStream(filename);					// fájl megnyitása
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));

		current_line = null;										// alapértékek
		line_number = 0;
	}

	/**
	 * Az utoljára beolvasott sort adja vissza.
	 * 
	 * @return Egy sztring, melyben az utoljára beolvasott sor található. Null, ha nincs ilyen.
	 */
	public String GetCurrentLine() {
		return current_line;
	}

	/**
	 * A következõ sorra ugrik, és az azon található szöveget adja vissza.
	 * 
	 * @return Egy sztring, melyben a következõ sor található. Null, ha nincs több sor.
	 * @throws Exception
	 */
	public String GetNextLine() throws Exception {
		current_line = br.readLine();
		line_number++;
		return current_line;
	}

	/**
	 * Visszaadja, hogy hanyadik soron állunk éppen.
	 * 
	 * @return Egy integer, melyben a sorszmám található..
	 */
	public int GetPosition() {
		return line_number;
	}

	/**
	 * Visszaadja az aktuálisan olvasott fájl nevét.
	 * 
	 * @return Egy sztring, melyben a fájlnév található, relatív elérési úttal.
	 */
	public String GetFileName() {
		return filename;
	}
}
