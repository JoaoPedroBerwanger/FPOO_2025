package algoritimos;

import java.util.function.Consumer;

public class Counter {

	private int start;
	private int end;
	private int step;
	
	public Counter() {
		
		start = 1;
		end = 10;
		step = 1;
	}
	
	public Counter(int start, int end, int step) {
		
		this.start = start;
		this.end = end;
		this.step = step;
	}
	
	public void setStart(int start) {
		
		this.start = start;
	}
	
	public void setEnd(int end) {
		
		this.end = end;
	}
	
	public void setStep(int step) {
		
		this.step = step;
	}
	
	public void count(Consumer<Integer> consumer) {
		
		for(int i=start; i <= end; i+=step)
			consumer.accept(i);
	}
}
