package semaphore.trafficLight.control;

import java.util.Timer;
import java.util.TimerTask;

import semaphore.trafficLight.TrafficLight;
import semaphore.util.TurnOnOff;

public class SimpleTrafficLightControl implements TrafficLightControl {


	private State state = State.OFF;
	private final TrafficLight trafficLight;
	private final TurnOnOff green, yellow, red;
	
	public SimpleTrafficLightControl (TrafficLight trafficLight) 
	{
		this.trafficLight = trafficLight;
	
		this.green = trafficLight.spotGreen();
		this.yellow = trafficLight.spotYellow();
		this.red = trafficLight.spotRed();
	}
	
	@Override
	public void turnAlert() {
		
		if(state == State.ALERT)
			return;
		
		this.reset();
		this.configureAlert();
		state = State.ALERT;
		
	}
	
	private Timer timer = null;
	
	private void configureAlert() {
		
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				red.turnOff();
				green.turnOff();
				
				if (yellow.isOn())
					yellow.turnOff();
				else
					yellow.turnOn();
			}
		}, 0, 1_000);
	}
	
	private void stopAlert() {
		
		if (timer != null) {
			timer.cancel();
		
		yellow.turnOff();
		
		}
	}

	private void reset() {
		
		if (state == State.ALERT)
			stopAlert();
		
		green.turnOff();
		yellow.turnOff();
		red.turnOff();
		
		state = State.OFF;
	}
	
	@Override
	public void turnGreen() {
		
		this.reset();
		green.turnOn();
		state = State.GREEN;
	}

	@Override
	public void turnYellow() {
		
		this.reset();
		yellow.turnOn();
		state = State.YELLOW;
	}

	@Override
	public void turnRed() {
		
		this.reset();
		red.turnOn();
		state = State.RED;
	}

	@Override
	public void turnOff() {
		
		this.reset();
	}

}
