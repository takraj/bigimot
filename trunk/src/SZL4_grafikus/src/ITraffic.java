import java.io.BufferedWriter;
import java.io.IOException;

public interface ITraffic {

	/**
	 * Forgalmi jelzéseket összefogó interfész
	 *  
	 */
	void step();
	void whattodo(Car c);
	public void save(BufferedWriter out);

}