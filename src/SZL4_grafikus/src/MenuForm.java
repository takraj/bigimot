import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MenuForm extends Frame implements View, ActionListener {
	
	private Button newGameBtn = new Button("New Game");
	private Button loadGameBtn = new Button("Load Game");
	
	public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newGameBtn) {
        	String map = game.AskFor("Map file:");
        	if (map != ""){
        		setVisible(false);
        		game.NewGame(map);
        	}
        }
        else if(ae.getSource() == loadGameBtn) {
        	String map = game.AskFor("Map file:");
        	String state = game.AskFor("State file:");
        	if ((map != "") && (state != "")){
        		setVisible(false);
        		game.LoadGame(map, state);
        	}
        }
    }
	
	public MenuForm(String name) {
		super(name);

		// layout beállítása

		setLayout(new FlowLayout());

		add(newGameBtn);
		add(loadGameBtn);

		addWindowListener(new MenuFormWindowCloser());
		newGameBtn.addActionListener(this);
		loadGameBtn.addActionListener(this);

		// megjelenítés

		pack();
		setResizable(false);
		Draw();
		setVisible(true);
	}
	
	class MenuFormWindowCloser extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	@Override
	public String AskFor(String s){
		String result = "";
		
			GTextInput input = new GTextInput(this, s);
			if ((input != null) && (input.isOk)){
				result = input.GetText();
				input.dispose();
			}
			return result;
	}
	
	@Override
	public void Draw() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean PrintMessage(String s){
		boolean result = false;
		
		GMessage message = new GMessage(this, s);
		if (message != null){
			result = message.isOk;
			message.dispose();
		}
		
		return result;
	}
	
	@Override
	public void SetViews() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void UpdateViews() {
		// TODO Auto-generated method stub
		
	}
	
}