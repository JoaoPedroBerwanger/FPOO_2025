package ticTacToe.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.text.Position;

import ticTacToe.gui.Paintable;

public class Button implements Paintable {
	
	private Point position = null;
	private Dimension dimension = null;;
	
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
	
	public MouseListener mouseListener() {
			
		return new MouseListenerAdapter() {
				
			@Override
			public void mouseClicker(MouseEvent me) {
				
				if(!isOver(me.getPoint()))
					return;
				
				System.out.println("oie!");
			}	
		}
	};
	}
	


	@Override
	public void paint(Graphics g) {
		
		g.drawRect(	position.x, position.y, 
					dimension.width, dimension.height );
	}
}
