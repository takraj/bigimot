import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GTextInput extends Dialog implements ActionListener {
    private Button ok,can;
    private TextField tb;
    public boolean isOk = false;

    /*
     * @param frame   parent frame 
     * @param msg     message to be displayed
     * @param okcan   true : ok cancel buttons, false : ok button only 
     */
    GTextInput(Frame frame, String msg, boolean okcan){
        super(frame, "Kérdés", true);
        setLayout(new FlowLayout());
        add("Center",new Label(msg));
        tb = new TextField(20);
        add(tb);
        addOKCancelPanel(okcan);
        createFrame();
        pack();
        setVisible(true);
    }
    
    GTextInput(Frame frame, String msg){
        this(frame, msg, true);
    }
    
    void addOKCancelPanel( boolean okcan ) {
        Panel p = new Panel();
        p.setLayout(new FlowLayout());
        createOKButton( p );
        if (okcan == true)
            createCancelButton( p );
        add("South",p);
    }

    void createOKButton(Panel p) {
        p.add(ok = new Button("OK"));
        ok.addActionListener(this); 
    }

    void createCancelButton(Panel p) {
        p.add(can = new Button("Cancel"));
        can.addActionListener(this);
    }

    void createFrame() {
        Dimension d = getToolkit().getScreenSize();
        setLocation(d.width/3,d.height/3);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == ok) {
            isOk = true;
            setVisible(false);
        }
        else if(ae.getSource() == can) {
            setVisible(false);
        }
    }
    
    public String GetText(){
    	return tb.getText();
    }
    
}
