import java.io.BufferedWriter;
import java.io.IOException;
/**
 * Jelzõlámpa osztály.
 */
public class TrafficSign implements ITraffic {

	private int state;
	private ElementView view;
	
	public TrafficSign()
	{
		state = 0;
	}
	
	@Override
	public void whattodo(Car c)
	{
		c.settimetomove(this);
	}
	
	@Override
	public void step() {
		if(state==0) state++; else state--; //változtatja az állapotát
	}

	@Override
	public int getstate()
	{
		return state;
	}
	
	public void SetState(int s){
		state = s;
	}
	
	public void save(BufferedWriter out){
		try {
			out.write("sign");
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
		return "TrafficSign";
	}
	
	@Override
	public String toString(){
		String result = "";
		
		result += String.format("\nstate %d", state);
		
		return result;
	}
}