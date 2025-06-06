package semaphore.app;

import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;

import semaphore.trafficLight.simple.SimpleTrafficLight;
import semaphore.util.gui.MyWindow;

public class APPSimpleTrafficLight {

	public static void main(String[] args) throws IOException
	{
		SimpleTrafficLight defaultOne = new SimpleTrafficLight();
		
		Point position = new Point(100, 80);
		Dimension dimension = new Dimension(100, 350);
		SimpleTrafficLight customOne = new SimpleTrafficLight(position, dimension);
		
		MyWindow window = new MyWindow();
		window.add(defaultOne);
		window.add(customOne);
	}
}
