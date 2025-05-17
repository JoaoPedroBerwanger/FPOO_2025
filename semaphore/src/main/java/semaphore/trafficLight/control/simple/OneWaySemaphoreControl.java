package semaphore.trafficLight.control.simple;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import semaphore.trafficLight.control.TrafficLightControl;

public class OneWaySemaphoreControl implements SemaphoreControl {

	private List<TrafficLightControl> trafficLights = new ArrayList<>();
	
	private int greenMilis = 10_000; 
	private int yellowMilis = 2_000;
	private int redMilis = 5_000;
	
	private LocalTime alertStart = LocalTime.of(0, 0);
	private LocalTime alertEnd = LocalTime.of(5, 30);
			
	private OnOff state = OnOff.OFF;
	
	public OneWaySemaphoreControl(List<TrafficLightControl> trafficLights)
	{
		this.trafficLights = trafficLights;
	}
	
	public OneWaySemaphoreControl(TrafficLightControl trafficLights) 
	{
		this(Arrays.asList(trafficLights));
	}
	
	private boolean isAlertPeriod() 
	{
		boolean START_MIDNIGHT_END = alertStart.isAfter(alertEnd);
		
		LocalTime now = LocalTime.now();
		
		if(START_MIDNIGHT_END)
			return (now.isAfter(alertStart) || now.isBefore(alertEnd));
		
		return (now.isAfter(alertStart) && now.isBefore(alertEnd));
	}
	
	private void doAlert() throws InterruptedException
	{
		while (isAlertPeriod()) 
		{
			trafficLights.forEach(e -> e.turnAlert());
			Thread.sleep(1_000);
		}
	}
	
	private void doYellowRedGreen() throws InterruptedException 
	{
		trafficLights.forEach(e -> e.turnYellow());
		Thread.sleep(yellowMilis);
		
		trafficLights.forEach(e -> e.turnRed());
		Thread.sleep(redMilis);
		
		trafficLights.forEach(e -> e.turnGreen());
		Thread.sleep(greenMilis);
	}
	
	private void run()
	{
		Runnable runnable = ()->{
			
			while (state == OnOff.ON) {
				try {
					doAlert();
					doYellowRedGreen();
				} 
				catch (InterruptedException exception) {
					
					trafficLights.forEach(e -> e.turnAlert());
				}
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
 	}
	
	@Override
	public void turnOn() {
		if(state == OnOff.OFF)
			state = OnOff.ON;
		run();
	}

	@Override
	public void turnOff() {
		if(state == OnOff.ON)
			state = OnOff.OFF;
	}

	@Override
	public boolean isOn() {
		return this.state == OnOff.ON;
	}

	@Override
	public boolean isOff() {
		return this.state == OnOff.OFF;
	}

	@Override
	public void setGreeenSeconds(int seconds) {
		this.greenMilis = seconds * 1000;
	}

	@Override
	public void setYellowSeconds(int seconds) {
		this.yellowMilis = seconds * 1000;
		
	}

	@Override
	public void setRedSeconds(int seconds) {
		this.redMilis = seconds * 1000;
	}

	@Override
	public void setAlertPeriod(LocalTime start, LocalTime end) {
		this.alertStart = start;
		this.alertEnd = end;
	}
}
