package semaphore.spot;

import static org.junit.jupiter.api.Assertions.*;

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
	SpotLight spot = new SpotLight(null);
	spot.setLight(light);
	
	//do action
	light.turnOff();
	spot.turnOn();
	
	//check
	assertTrue(light.isOn());
	assertTrue(spot.isOn());
	
	}

}
