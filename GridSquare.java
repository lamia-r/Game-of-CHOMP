import java.awt.Color;
import javax.swing.*;

public class GridSquare extends JButton
{
	private int xcoord, ycoord;
	private boolean isActive=true;
	
	public GridSquare( int xcoord, int ycoord)
	{
		super();
		this.xcoord = xcoord;
		this.ycoord = ycoord;
	}
	
	public void setColor( int decider)
	{
		Color colour = (int) (decider) != 0 ? Color.WHITE : Color.BLACK;
		this.setBackground( colour);
	}
	
	public void deactivate()
	{
	    this.setSize(0,0);
	    isActive=false;
	}
	
	public boolean doesExist()
	{
	    return this.isActive;
	}
}