import java.io.BufferedWriter;
import java.io.IOException;

public class TrafficTable implements ITraffic {


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

}