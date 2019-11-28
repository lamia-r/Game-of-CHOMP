import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class WindowDemo extends JFrame
{
    private JPanel bottomPanel;
    private GridSquare [][] gridSquares;
    private int x,y;
    

    public WindowDemo(int x, int y)
    {
        this.x=x;
        this.y=y;

        bottomPanel=new JPanel();
        bottomPanel.setLayout(new GridLayout(x,y));

        gridSquares=new GridSquare[x][y];
        gridSquares = new GridSquare [x][y];
        for ( int column = 0; column < x; column ++)
        {
            for ( int row = 0; row < y; row ++)
            {
                gridSquares [column][row] = new GridSquare(column,row);
                gridSquares [column][row].setSize( 20, 20);
                gridSquares [column][row].setColor( column + row);
                gridSquares [column][row].setOpaque( true);            
                gridSquares [column][row].setBorderPainted( true);
                
                int n1=column;
                int n2=row;
                gridSquares [column][row].addActionListener(event->
                    {
                        Player(n1, n2);
                        boolean isFalse=!(n1== 0 && n2==0);
                        if (isFalse)
                        {comp();}
                    });     

                bottomPanel.add( gridSquares [column][row]);
            }
        }

        getContentPane().setLayout( new BorderLayout());
        getContentPane().add( bottomPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        setResizable( true);
        setSize(800,400);
        setVisible( true);

        int choose=new Random().nextInt(2);
        if (choose==0)
        {
            JOptionPane.showMessageDialog(null, "COMPUTER GOES FIRST", "WHO GOES FIRST?", JOptionPane.INFORMATION_MESSAGE);
            comp();
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "YOU GO FIRST", "WHO GOES FIRST?", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    public void Player(int n1,int n2)
    {
        if(gameOn())
        {boolean trigger = !(n1 == 0 && n2 == 0);
        if (gridSquares[n1][n2].doesExist() && trigger)
        {whenBitten(n1,n2);}}

        else
        {BeginAgain bgnagain=new BeginAgain("ALAS!!! COMPUTER HAS WON. ");
         }
    }

    public void whenBitten(int n1, int n2)
    {

        for(int num1=n1; num1<x; num1++)
        {
            for(int num2=n2; num2<y; num2++)
            {
                gridSquares[num1][num2].deactivate();
            }
        }
    }

    public void comp()
    {
        Random rand=new Random();

        int n1=rand.nextInt(this.x);
        int n2=rand.nextInt(this.y);

        if (gameOn())
        {
            while (true)
            {
                boolean invalid = !(n1 == 0 && n2 == 0);
                if (gridSquares[n1][n2].doesExist() && invalid)
                {
                    
                    whenBitten(n1,n2);
                    break;
                }

                else
                {
                    n1=rand.nextInt(this.x);
                    n2=rand.nextInt(this.y);
                }
            }
        
            
        }
        
        else
        {
            BeginAgain bgnagain=new BeginAgain("CONGRATULATIONS!!! YOU HAVE WON. ");
            
           
        }
        }
        
        

    

    public boolean gameOn()
    {
        for(int i=0;i<this.x; i++)
        {
            for( int j=0; j<this.y; j++)
            {
                boolean invalid=!(i == 0 && j == 0);
                if (gridSquares[i][j].doesExist() && invalid)
                {return true;}

            }
        }
        return false;
    }

}  
