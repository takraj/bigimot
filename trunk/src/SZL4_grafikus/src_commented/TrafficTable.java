import java.io.BufferedWriter;
import java.io.IOException;
/**
 * Útvonalválasztó-tábla osztály
 */
public class TrafficTable implements ITraffic {

	private ElementView view;

	public TrafficTable()
	{
	
	}
	public void whattodo(Car c)
	{
		c.settimetomove(this);
	}
	@Override
	public void step() {
		
	}
	public void save(BufferedWriter out){
		try {
			out.write("table");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void SetView(ElementView v){
		view = v;
	}
	
	@Override
	public ElementView GetView(){
		return view;
	}
	
	@Override
	public String WhoAmI(){
		return "TrafficTable";
	}
	@Override
	public void SetState(int s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getstate() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	@Override
	public String toString(){
		return "";
	}

}