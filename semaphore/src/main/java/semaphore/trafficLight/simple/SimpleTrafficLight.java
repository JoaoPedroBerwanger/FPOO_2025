package semaphore.trafficLight.simple;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

import semaphore.spot.SpotLight;

public class SimpleTrafficLight {

	private Point position;
	private Dimension dimension;
	private Image mask;
	private SpotLight yellow;
	private SpotLight green;
	private SpotLight red;
	
	private void create() 
	{
		//TO DO: will be implemented in the future
	}
	
	public SimpleTrafficLight() 
	{
		//constructor
	}
	
	public SimpleTrafficLight(Point position, Dimension dimension) 
	{
		this.position = position;
		this.dimension = dimension;
	}
	
	public void setPosition(Point position)
	{
		this.position = position;
	}
	
	public void setDimension(Dimension dimension) 
	{
		this.dimension = dimension;
	}
	
	public Point getPosition() 
	{
		return (Point) position.clone();
	}
	
	public Dimension getDimension() 
	{
		return (Dimension) dimension.clone();
	}

}
