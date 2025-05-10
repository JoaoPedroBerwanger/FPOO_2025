package semaphore.trafficLight.control;

import java.util.Timer;
import java.util.TimerTask;

import semaphore.trafficLight.TrafficLight;

public class SimpleTrafficLightControl implements TrafficLightControl {

	public static enum State {
		GREEN, YELLOW, RED, ALERT, OFF
	}
	
	State state = State.OFF;
	
	private final TrafficLight trafficLight;
	
	public SimpleTrafficLightControl (TrafficLight trafficLight) 
	{
		this.trafficLight = trafficLight;
	}
	
	@Override
	public void turnAlert() {
		
		stopAlert();
		configureAlert();
		
	}
	
	private Timer alertTimer;
	
	private void configureAlert() {
		
		trafficLight.spotGreen().turnOff();
		trafficLight.spotYellow().turnOff();
		trafficLight.spotRed().turnOff();
		
		state = State.ALERT;
		
		final long blinkTimer = 1000;
		alertTimer = new Timer();
		
	    alertTimer.scheduleAtFixedRate(new TimerTask() {
	    	
	        @Override
	        public void run() {
	            if (trafficLight.spotYellow().isOff())
	                trafficLight.spotYellow().turnOn();
	            else
	                trafficLight.spotYellow().turnOff();
	        }
	    }, 0, (long) blinkTimer);
	}
	
	private void stopAlert() {
		if (alertTimer != null) {
			
		alertTimer.cancel();
		alertTimer = null;
		
		}
	}

	@Override
	public void turnGreen() {
		
		stopAlert();
		trafficLight.spotGreen().turnOn();
		trafficLight.spotYellow().turnOff();
		trafficLight.spotRed().turnOff();
		state = State.GREEN;
	}

	@Override
	public void turnYellow() {
		
		stopAlert();
		trafficLight.spotGreen().turnOff();
		trafficLight.spotYellow().turnOn();
		trafficLight.spotRed().turnOff();
		state = State.YELLOW;
	}

	@Override
	public void turnRed() {
		
		stopAlert();
		trafficLight.spotGreen().turnOff();
		trafficLight.spotYellow().turnOff();
		trafficLight.spotRed().turnOn();
		state = State.RED;
	}

	@Override
	public void turnOff() {
		
		stopAlert();
		trafficLight.spotGreen().turnOff();
		trafficLight.spotYellow().turnOff();
		trafficLight.spotRed().turnOff();
		state = State.OFF;
	}

}
