import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GMessage extends Dialog implements ActionListener {
    private Button ok,can;
    public boolean isOk = false;

    /*
     * @param frame   parent frame 
     * @param msg     message to be displayed
     * @param okcan   true : ok cancel buttons, false : ok button only 
     */
    GMessage(Frame frame, String msg, boolean okcan){
        super(frame, "�zenet", true);
        setLayout(new BorderLayout());
        add("Center",new Label(msg));
        addOKCancelPanel(okcan);
        createFrame();
        pack();
        setVisible(true);
    }
    
    GMessage(Frame frame, String msg){
        this(frame, msg, false);
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
    /*
    public static void main(String args[]){
        Frame f = new Frame();
        f.setSize(200,200);
        f.setVisible(true);
        GMessage message = new GMessage
          (f , "Hey you user, are you sure ?", true);
        
        if (message.isOk) 
           System.out.println("Ok pressed");
        
        if (!message.isOk) 
           System.out.println("Cancel pressed");
        
        message.dispose();
    }
    */
}
