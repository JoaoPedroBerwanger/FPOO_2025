package semaphore.spot;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.awt.Point;

import org.junit.jupiter.api.Test;

import semaphore.light.AbstractLight;
import semaphore.light.e27.AbstractLightE27;
import semaphore.light.e27.E27LightBulb;
import semaphore.util.TurnOnOff;

class SpotLightTest {

	@Test
	void shouldTurnOn()
	{
		
	//given
	AbstractLightE27 light = new E27LightBulb();
	SpotLight spot = new SpotLight(null, null);
	spot.setLight(light);
	
	//do action
	light.turnOff();
	spot.turnOn();
	
	//check
	assertTrue(light.isOn());
	assertTrue(spot.isOn());
	
	}
	
	@Test
	void shouldTurnOff() 
	{
		AbstractLightE27 light = new E27LightBulb();
		SpotLight spot = new SpotLight(null, null);
		spot.setLight(light);
		
		light.turnOn();
		spot.turnOff();
		
		assertTrue(light.isOff());
		assertTrue(spot.isOff());
	}
	
	
	@Test
	void shouldReturnoCloneOfPosition()
	{
		//given
		SpotLight spot = new SpotLight(null,null);
		spot.setLight(new E27LightBulb());
		final int xLeft = 20;
		final int yTop = 50;
		spot.setPosition(xLeft, yTop);
		
		//do
		Point position = spot.getPosition();
		position.setLocation(new Point(30,30));
		
		//check
		assertEquals(xLeft, spot.getPosition().getX());
		assertEquals(yTop, spot.getPosition().getY());
	}
	
	@Test
	void shouldReturnoCloneOfDimension()
	{
		//given
		SpotLight spot = new SpotLight(null, null);
		spot.setLight(new E27LightBulb());
		spot.setDimension(new Dimension(30,40));
		
		//do
		Dimension clone = spot.getDimension();
		clone.setSize(60,80);
		
		//check
		int originalWidth = 30;
		int originalHeight = 40;
		
		int actualWidth = (int) spot.getDimension().getWidth();
		int actualHeight = (int) spot.getDimension().getHeight();
		
		assertEquals(originalWidth, actualWidth);
		assertEquals(originalHeight, actualHeight);
		
	}
	
}
