import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BeginAgain extends JFrame
{
    private JPanel tPanel;
        private JLabel topLabel1, topLabel2;
        private JButton b1,b2;
        private ButtonGroup btnGroup;
	
        public BeginAgain(String whoWon)
	{
	    tPanel=new JPanel();
	    tPanel.setLayout(new FlowLayout()); 
	    topLabel1=new JLabel(whoWon);
	   
	    topLabel2=new JLabel("WOULD YOU LIKE TO PLAY AGAIN?");
            b1=new JButton("YES");
            b2=new JButton("NO");
            
            btnGroup=new ButtonGroup();
            btnGroup.add(b1);
            btnGroup.add(b2);
            
        
        tPanel.add(topLabel1);
        tPanel.add(topLabel2);
        tPanel.add(b1);
        tPanel.add(b2);
        
        b1.addActionListener(event->{
            new StartGame();
            setVisible(false);});
        b2.addActionListener(event->System.exit(0));
        
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(tPanel, BorderLayout.CENTER);
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
	setResizable( true);
	setSize(400,300);
	setVisible( true);
	
	
        
    }
}