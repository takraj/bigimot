import java.io.BufferedWriter;

public interface ITraffic {

	/**
	 * Forgalmi jelz�seket �sszefog� interf�sz
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