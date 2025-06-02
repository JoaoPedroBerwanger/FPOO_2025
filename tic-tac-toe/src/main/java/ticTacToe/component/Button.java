package ticTacToe.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.text.Position;

import ticTacToe.gui.Paintable;
import ticTacToe.gui.util.MouseClickAdapter;

public class Button implements Paintable {
	
	private Point position = null;
	private Dimension dimension = null;;
	private boolean mouseOver = false;
	
	public Button() {
		this.position = new Point(0, 0);	
		this.dimension = new Dimension(20, 20);
	}
	
	public Button(int x, int y) {
		this();
		setPosition(x, y);
	}
	
	public Button(int x, int y, int widht, int height) {
		this(x, y);
		setSize(widht, height);
	}
	
	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
	}
	
	public Point getPosition() {
		return (Point) this.position.clone();
	}
	
	public void setSize(int widht, int height) {
		this.dimension = new Dimension(widht, height);
	}

	public Dimension getSize() {
		return (Dimension) this.dimension.clone();
	}
	
	public int width() {
		return this.dimension.width;
	}
	
	public int height() {
		return this.dimension.height;
	}
	
	public boolean isOver(Point point) {
		
		int xLeft = this.position.x;
		int yTop = this.position.y;
		int xRight = xLeft + this.width();
		int yBottom = yTop + this.height();
		
		return ((point.x > xLeft && point.x < xRight) &&
				(point.y > yTop && point.y < yBottom));
	}
	
	public MouseListener mouseListener() {
			
		return new MouseClickAdapter() {
				
			@Override
			public void mouseClicked(MouseEvent me) {
				
				if(!isOver(me.getPoint()))
					return;
				
				System.out.println("oie!");
			}	
		};
	}
	
	public MouseMotionListener mouseMotionListener() {
		
		return new MouseMotionAdapter() {
		
			@Override
			public void mouseMoved(MouseEvent me) {
				mouseOver = isOver(me.getPoint());
			}	
		}; 	 
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.drawRect(	position.x, position.y, 
				dimension.width, dimension.height);
		
		if(mouseOver) {
			
			Color color = g.getColor();
			
			g.setColor(Color.RED);
			g.drawRect(	position.x + 8, position.y + 8, 
					dimension.width - 16 , dimension.height - 16);
			
			g.setColor(color);
		}
		
	}
}
