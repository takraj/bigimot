/**
 * Interfész, mely a grafikus változat elkészítéséhez tartalmaz függvényeket.
 */
public interface View {
	
	public void SetViews();
	public void UpdateViews();
	public void Draw();
	public boolean PrintMessage(String s);
	public String AskFor(String s);
	public void dispose();

}
