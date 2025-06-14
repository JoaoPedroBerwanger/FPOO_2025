package ticTacToe.gui.util;

import java.awt.Graphics;

import ticTacToe.component.AbstractComponent;

public class table extends AbstractComponent{

	public table(int x, int y, int widht, int heigt) 
	{
		super();
	} 
	
	@Override
	public void paint(Graphics g)
	{
		if(icon == null)
			return;
	
		int xLeft = position.x;
		int yTop = position.y;
		int width = dimension.width;
		int heigth = dimension.height;
	
		g.drawImage(icon.getImage(), xLeft, yTop, width, heigth, null);
	}
}
