import java.io.*;

/**
 * A program belépési pontja, a fõosztály.
 * 
 * @author TakRaj
 * @version 1.0
 */
public class compare {
	
	/**
	 * A program belépési pontja. Ha hiba volt (-1)-el lép ki, ellenben (0)-val.
	 * 
	 * @param args Tartalmazza a parancssori paramétereket.
	 */
	public static void main(String args[]) {
		if (args.length != 2) {														// helytelen paraméterezés esetén kiírja a helyes szintaktikát
			System.out.println("Error: Missing or too many argument(s).");
			System.out.println("Syntax: compare <file1> <file2>");
			System.out.println("Example: compare out.txt sample.txt");
		} else {
			try {
				System.out.println("Reading files...");

				InputFile input1 = new InputFile(args[0]);							// Elsõ paraméterben megadott fájl.
				InputFile input2 = new InputFile(args[1]);							// Második paraméterben megadott fájl.

				int mismatch = 0;													// számolja az eltéréseket

				System.out.println("Comparing file " + input1.GetFileName()
						+ " to file " + input2.GetFileName() + " ...");

				while (input1.GetNextLine() != null) {								// olvasás soronként
					if (input2.GetNextLine() != null) {
						if (!input1.GetCurrentLine().equals(
								input2.GetCurrentLine())) {							// ha nem egyezik egy soron a két fájl
							mismatch++;												// nem egyezik, számláló növelése
							System.out.println();									// új sor az átláthatóság kedvéért
							System.out.println("Row mismatch at line "				// üzenet a képernyõre
									+ input1.GetPosition() + " in file "			// hol volt eltérés?
									+ input1.GetFileName()							// melyik fájlban
									+ " compared to file "
									+ input2.GetFileName());						// melyikhez hasonlítva
							System.out.println(input1.GetFileName() + ": "
									+ input1.GetCurrentLine());						// egyik fájl tartalma ebben a sorban
							System.out.println(input2.GetFileName() + ": "
									+ input2.GetCurrentLine());						// másik fájl tartalma ebben a sorban
							System.out.println();									// új sor az átláthatóság kedvéért
						}
					} else {														// ha a második fájl rövidebb az elsõnél
						mismatch++;													// nem egyezik, számláló növelése
						System.out.println("Warning: File "							// üzenet a képernyõre
								+ input2.GetFileName()
								+ " is shorter than file "
								+ input1.GetFileName());
					}
				}

				if (input2.GetNextLine() != null) {									// ha befejeztük a második fájl olvasását, de még az elsõ fájlból tudnánk olvasni...
					mismatch++;														// nem egyezik, számláló növelése
					System.out.println("Warning: File " + input1.GetFileName()		// üzenet a képernyõre
							+ " is shorter than file " + input2.GetFileName());
				}

				if (mismatch == 0) {												// ha egyezik
					System.out.println("Full match.");								// üzenet a képernyõre
					System.exit(0);													// kilépés (0)-val
				} else {															// ha nem egyezik
					System.out.println("Files are different.");						// üzenet a képernyõre
					System.exit(-1);												// kilépés hibakóddal (-1)
				}
			} catch (FileNotFoundException e) {										// ha nem található valamelyik fájl
				System.out.println("Error: File not found.");						// üzenet a képernyõre
				System.exit(-1);													// kilépés hibakóddal (-1)
			} catch (Exception e) {													// egyéb hiba
				System.out.println("Exception: " + e.getMessage());					// üzenet a képernyõre
				System.exit(-1);													// kilépés hibakóddal (-1)
			}
		}
	}
}
