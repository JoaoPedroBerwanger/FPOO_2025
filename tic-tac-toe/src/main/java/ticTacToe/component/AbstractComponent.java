package ticTacToe.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import ticTacToe.gui.util.MouseClickAdapter;
import ticTacToe.gui.util.window.Paintable;

public abstract class AbstractComponent implements Paintable {
	
	protected Point position;
	protected Dimension dimension;
	protected boolean mouseOver = false;
	protected ImageIcon icon;

	public AbstractComponent() 
	{
		this.position = new Point(0, 0);
		this.dimension = new Dimension(20, 20);
	}
	
	public AbstractComponent(int x, int y) 
	{	
		this();
		setPosition(x, y);
	}
	
	public AbstractComponent(int x, int y, int width, int height) 
	{	
		this(x, y);
		setSize(width, height);
	}
	
	public void setPosition(int x, int y) 
	{
		this.position = new Point(x, y);
	}

	public Point getPosition() 
	{
		return (Point) this.position.clone();
	}
	
	public void setSize(int width, int height) 
	{
		this.dimension = new Dimension(width, height);
	}
	
	public Dimension getSize() 
	{
		return (Dimension) this.dimension.clone();
	}
	
	public int width()
	{
		return this.dimension.width;
	}
	
	public int height() 
	{
		return this.dimension.height;
	}
	
	protected List<AbstractComponent> children = new ArrayList<>();

	public void add(AbstractComponent child) {
	    children.add(child);
	}

	public void paintChildren(Graphics g) {
	    for (AbstractComponent child : children) {
	        child.paint(g);
	    }
	}
	
	public boolean isOver(Point point) 
	{
		int xLeft = this.position.x;
		int yTop = this.position.y;
		int xRight = xLeft + this.width();
		int yBottom = yTop + this.height();
		
		return ((point.x > xLeft && point.x < xRight) &&
				(point.y > yTop && point.y < yBottom));
	}
	
	public MouseListener mouseListener() 
	{
		return new MouseClickAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent me) 
			{
				if(isOver(me.getPoint()))
					onMouseClick(me);
			}	
		};
	}
	
	public MouseMotionListener mouseMotionListener() 
	{
		return new MouseMotionAdapter() 
		{
			@Override
			public void mouseMoved(MouseEvent me) 
			{
				mouseOver = isOver(me.getPoint());
					onMouseMove(me);
			}	
		}; 	 
	}
	
	//Polymorphic Method
	protected void onMouseClick(MouseEvent me) 
	{
		/** the standard behavior is to do nothing */
	}
	
	protected void onMouseMove(MouseEvent me)
	{
		/** the standard behavior is to do nothing */
	}
}
