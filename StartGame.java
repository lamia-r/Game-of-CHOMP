import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class StartGame extends JFrame
{
        private JPanel tPanel;
        private JLabel topLabel;
        private JButton b1,b2,b3;
        private ButtonGroup btnGroup;
	
        public StartGame()
	{
	    tPanel=new JPanel();
	    tPanel.setLayout(new FlowLayout()); 
	    topLabel=new JLabel("Select a Size: ");
            b1=new JButton("4 x 5");
            b2=new JButton("5 x 6");
            b3=new JButton("6 x 7");
            btnGroup=new ButtonGroup();
            btnGroup.add(b1);
            btnGroup.add(b2);
            btnGroup.add(b3);
        
        tPanel.add(topLabel);
        tPanel.add(b1);
        tPanel.add(b2);
        tPanel.add(b3);
        
        b1.addActionListener(event->{
            new WindowDemo(4,5);
            setVisible(false);});
        b2.addActionListener(event->{
            new WindowDemo(5,6);
            setVisible(false);});
        b3.addActionListener(event->{
            new WindowDemo(6,7);
            setVisible(false);});
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(tPanel, BorderLayout.CENTER);
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        
        pack();
        setLocationRelativeTo(null);
	setResizable( true);
	setSize(400,100);
	setVisible( true);
	
	}

}