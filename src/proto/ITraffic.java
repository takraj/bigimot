import java.io.BufferedWriter;
import java.io.IOException;

public interface ITraffic {

	/**
	 * Forgalmi jelz�seket �sszefog� interf�sz
	 *  
	 */
	void step();
	void whattodo(Car c);
	public void save(BufferedWriter out);

}