import java.io.*;

/**
 * A program bel�p�si pontja, a f�oszt�ly.
 * 
 * @author TakRaj
 * @version 1.0
 */
public class compare {
	
	/**
	 * A program bel�p�si pontja. Ha hiba volt (-1)-el l�p ki, ellenben (0)-val.
	 * 
	 * @param args Tartalmazza a parancssori param�tereket.
	 */
	public static void main(String args[]) {
		if (args.length != 2) {														// helytelen param�terez�s eset�n ki�rja a helyes szintaktik�t
			System.out.println("Error: Missing or too many argument(s).");
			System.out.println("Syntax: compare <file1> <file2>");
			System.out.println("Example: compare out.txt sample.txt");
		} else {
			try {
				System.out.println("Reading files...");

				InputFile input1 = new InputFile(args[0]);							// Els� param�terben megadott f�jl.
				InputFile input2 = new InputFile(args[1]);							// M�sodik param�terben megadott f�jl.

				int mismatch = 0;													// sz�molja az elt�r�seket

				System.out.println("Comparing file " + input1.GetFileName()
						+ " to file " + input2.GetFileName() + " ...");

				while (input1.GetNextLine() != null) {								// olvas�s soronk�nt
					if (input2.GetNextLine() != null) {
						if (!input1.GetCurrentLine().equals(
								input2.GetCurrentLine())) {							// ha nem egyezik egy soron a k�t f�jl
							mismatch++;												// nem egyezik, sz�ml�l� n�vel�se
							System.out.println();									// �j sor az �tl�that�s�g kedv��rt
							System.out.println("Row mismatch at line "				// �zenet a k�perny�re
									+ input1.GetPosition() + " in file "			// hol volt elt�r�s?
									+ input1.GetFileName()							// melyik f�jlban
									+ " compared to file "
									+ input2.GetFileName());						// melyikhez hasonl�tva
							System.out.println(input1.GetFileName() + ": "
									+ input1.GetCurrentLine());						// egyik f�jl tartalma ebben a sorban
							System.out.println(input2.GetFileName() + ": "
									+ input2.GetCurrentLine());						// m�sik f�jl tartalma ebben a sorban
							System.out.println();									// �j sor az �tl�that�s�g kedv��rt
						}
					} else {														// ha a m�sodik f�jl r�videbb az els�n�l
						mismatch++;													// nem egyezik, sz�ml�l� n�vel�se
						System.out.println("Warning: File "							// �zenet a k�perny�re
								+ input2.GetFileName()
								+ " is shorter than file "
								+ input1.GetFileName());
					}
				}

				if (input2.GetNextLine() != null) {									// ha befejezt�k a m�sodik f�jl olvas�s�t, de m�g az els� f�jlb�l tudn�nk olvasni...
					mismatch++;														// nem egyezik, sz�ml�l� n�vel�se
					System.out.println("Warning: File " + input1.GetFileName()		// �zenet a k�perny�re
							+ " is shorter than file " + input2.GetFileName());
				}

				if (mismatch == 0) {												// ha egyezik
					System.out.println("Full match.");								// �zenet a k�perny�re
					System.exit(0);													// kil�p�s (0)-val
				} else {															// ha nem egyezik
					System.out.println("Files are different.");						// �zenet a k�perny�re
					System.exit(-1);												// kil�p�s hibak�ddal (-1)
				}
			} catch (FileNotFoundException e) {										// ha nem tal�lhat� valamelyik f�jl
				System.out.println("Error: File not found.");						// �zenet a k�perny�re
				System.exit(-1);													// kil�p�s hibak�ddal (-1)
			} catch (Exception e) {													// egy�b hiba
				System.out.println("Exception: " + e.getMessage());					// �zenet a k�perny�re
				System.exit(-1);													// kil�p�s hibak�ddal (-1)
			}
		}
	}
}
