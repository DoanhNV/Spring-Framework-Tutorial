package demo.modernization;

import java.util.concurrent.atomic.AtomicInteger;

public class MethodCounter {
	private AtomicInteger atomicInteger = new AtomicInteger();
	private int count;
	
	public void increase () {
		atomicInteger.compareAndSet(count, count++);
	}
	
	public int getValue() {
		return count;
	}
	
	public AtomicInteger getAtomic() {
		return atomicInteger;
	}
}
