package semaphore.trafficLight.control.simple;

import java.time.LocalTime;

import semaphore.util.TurnOnOff;

public interface SemaphoreControl extends TurnOnOff {
	
	void setGreeenSeconds(int seconds);
	void setYellowSeconds(int seconds);
	void setRedSeconds(int seconds);
	
	void setAlertPeriod(LocalTime start,
						LocalTime end);

}
