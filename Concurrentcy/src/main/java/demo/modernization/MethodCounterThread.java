package demo.modernization;

public class MethodCounterThread  extends Thread {
	private MethodCounter counter;
	private int numberIncrease;

	public MethodCounterThread(MethodCounter counter, int numberIncrease) {
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
