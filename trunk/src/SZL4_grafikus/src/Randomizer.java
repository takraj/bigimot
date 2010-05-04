
public class Randomizer {

	public static int[] CreatePermutation(int N){
	    int[] a = new int[N];

	    // insert integers 0..N-1
	    for (int i = 0; i < N; i++)
	         a[i] = i;

	    // shuffle
	    for (int i = 0; i < N; i++) {
	         int r = (int) (Math.random() * (i+1));     // int between 0 and i
	         int swap = a[r];
	         a[r] = a[i];
	         a[i] = swap;
	    }
		
		return a;
		
	}
}
