import java.io.BufferedWriter;
	/**
	 * Forgalmi jelz�seket �sszefog� interf�sz
	 *  
	 */
public interface ITraffic {


	void step();
	void whattodo(Car c);
	public void save(BufferedWriter out);
	
	public void SetView(ElementView v);
	public ElementView GetView();
	
	public String WhoAmI();
	public int getstate();
	public void SetState(int s);

}