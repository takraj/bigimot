import java.io.*;

/**
 * Bemeneti f�jlt reprezent�l� oszt�ly a k�nny� beolvas�s �rdek�ben.
 * 
 * @author TakRaj
 * @version 1.0
 */
public class InputFile {
	private String filename;										// f�jln�v
	private FileInputStream fstream;
	private DataInputStream in;
	private BufferedReader br;
	private String current_line;									// jelenlegi sor
	private int line_number;										// jelenlegi sorsz�m

	/**
	 * Az oszt�ly destruktora, lez�rja a megnyitott f�jlt, ha van ilyen.
	 */
	protected void finalize() throws Throwable {
		try {
			in.close();												// f�jl lez�r�sa
		} catch (Exception e) {
			throw e;												// kiv�tel tov�bbdob�sa
		} finally {
			super.finalize();
		}
	}

	/**
	 * Az oszt�ly konstruktora, bemeneti param�tere a megnyitand� f�jl neve.
	 * 
	 * @param name A megnyitand� f�jl neve, relat�v el�r�si �ttal.
	 * @throws Exception
	 */
	public InputFile(String name) throws Exception {
		filename = name;

		fstream = new FileInputStream(filename);					// f�jl megnyit�sa
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));

		current_line = null;										// alap�rt�kek
		line_number = 0;
	}

	/**
	 * Az utolj�ra beolvasott sort adja vissza.
	 * 
	 * @return Egy sztring, melyben az utolj�ra beolvasott sor tal�lhat�. Null, ha nincs ilyen.
	 */
	public String GetCurrentLine() {
		return current_line;
	}

	/**
	 * A k�vetkez� sorra ugrik, �s az azon tal�lhat� sz�veget adja vissza.
	 * 
	 * @return Egy sztring, melyben a k�vetkez� sor tal�lhat�. Null, ha nincs t�bb sor.
	 * @throws Exception
	 */
	public String GetNextLine() throws Exception {
		current_line = br.readLine();
		line_number++;
		return current_line;
	}

	/**
	 * Visszaadja, hogy hanyadik soron �llunk �ppen.
	 * 
	 * @return Egy integer, melyben a sorszm�m tal�lhat�..
	 */
	public int GetPosition() {
		return line_number;
	}

	/**
	 * Visszaadja az aktu�lisan olvasott f�jl nev�t.
	 * 
	 * @return Egy sztring, melyben a f�jln�v tal�lhat�, relat�v el�r�si �ttal.
	 */
	public String GetFileName() {
		return filename;
	}
}
