import java.io.BufferedWriter;

public interface ITraffic {

	/**
	 * Forgalmi jelzéseket összefogó interfész
	 *  
	 */
	void step();
	void whattodo(Car c);
	public void save(BufferedWriter out);
	
	public void SetView(ElementView v);
	public ElementView GetView();
	
	public String WhoAmI();
	public int getstate();
	public void SetState(int s);

}