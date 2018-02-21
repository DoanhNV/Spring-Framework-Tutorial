package demo.modernization;

public class CounterThread  extends Thread {
	private Counter counter;
	private int numberIncrease;

	public CounterThread(Counter counter, int numberIncrease) {
		this.counter = counter;
		this.numberIncrease = numberIncrease;
	}

	@Override
	public void run() {
		for (int i = 0; i < numberIncrease ; i++) {
			counter.increase();
		}
	};
}
