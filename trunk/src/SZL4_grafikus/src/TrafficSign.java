import java.io.BufferedWriter;
import java.io.IOException;

public class TrafficSign implements ITraffic {

	private int state;
	private ElementView view;
	
	public TrafficSign()
	{
		state=0;
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

	public int getstate()
	{
		return state;
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
}