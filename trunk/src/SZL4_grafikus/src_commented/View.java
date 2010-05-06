/**
 * Interf�sz, mely a grafikus v�ltozat elk�sz�t�s�hez tartalmaz f�ggv�nyeket.
 */
public interface View {
	
	public void SetViews();
	public void UpdateViews();
	public void Draw();
	public boolean PrintMessage(String s);
	public String AskFor(String s);
	public void dispose();

}
