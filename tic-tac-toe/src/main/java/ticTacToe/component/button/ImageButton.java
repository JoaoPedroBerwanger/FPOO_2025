package ticTacToe.component.button;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class ImageButton extends Button {
	
	private ImageIcon image;

	public ImageButton(int x, int y, int height, int width, String path) 
	{  
		super(x, y, height, width);
		setImage(path);
	}

	public void setImage(String path) 
	{
		image = new ImageIcon(getClass().getResource(path));
	}

	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
    
		if (image != null) {
			g.drawImage(image.getImage(), position.x, position.y, dimension.width, dimension.height, null);
    
		}
	}
}