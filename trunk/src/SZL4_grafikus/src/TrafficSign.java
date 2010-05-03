import java.io.BufferedWriter;
import java.io.IOException;

public class TrafficSign implements ITraffic {

	private int state;
	
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
}