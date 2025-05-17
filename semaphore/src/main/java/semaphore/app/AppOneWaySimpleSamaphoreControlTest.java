package semaphore.app;

import java.io.IOException;
import java.time.LocalTime;

import semaphore.trafficLight.control.SimpleTrafficLightControl;
import semaphore.trafficLight.control.TrafficLightControl;
import semaphore.trafficLight.control.simple.OneWaySemaphoreControl;
import semaphore.trafficLight.control.simple.SemaphoreControl;
import semaphore.trafficLight.simple.SimpleTrafficLight;
import semaphore.util.gui.MyWindow;

public class AppOneWaySimpleSamaphoreControlTest {

	static private void oneWaySimpleSemaphoreTest() throws IOException 
	{
		SimpleTrafficLight defaultOne = new SimpleTrafficLight();
		TrafficLightControl trafficLightControl = new SimpleTrafficLightControl(defaultOne);
		SemaphoreControl semaphoreControl = new OneWaySemaphoreControl(trafficLightControl);
		
		semaphoreControl.setAlertPeriod(LocalTime.now(), 
										LocalTime.now().plusSeconds(1));
		
		MyWindow window = new MyWindow();
		window.add(defaultOne);
		
		semaphoreControl.turnOn();
	}
	
	static public void main(String[] args) throws IOException
	{
		oneWaySimpleSemaphoreTest();
	}
}
