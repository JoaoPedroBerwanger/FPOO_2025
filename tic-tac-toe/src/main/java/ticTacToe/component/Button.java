package ticTacToe.component;

import java.awt.Color;
import java.awt.Graphics;

public class Button extends AbstractComponent {
	
	public Button(int x, int y, int height, int width) 
	{
		super(x, y, height, width);
	}
	
	private void doMouseOverDecoration(Graphics g) 
	{
		Color color = g.getColor();
		g.setColor(Color.RED);
	    g.drawRect(position.x + 4, position.y + 4, dimension.width - 8, dimension.height - 8);
	    g.setColor(color);
	}
	
	@Override
	public void paint(Graphics g) 
	{
	    g.drawRect(position.x, position.y, dimension.width, dimension.height);
	    if(mouseOver) 
	    {
	        doMouseOverDecoration(g);
	    }
	}
}
