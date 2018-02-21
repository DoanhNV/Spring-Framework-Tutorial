package demo.modernization;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	private AtomicInteger count = new AtomicInteger();
	
	public void increase() {
		count.incrementAndGet();
	}
	
	public int getValue() {
		return count.intValue();
	}
}
