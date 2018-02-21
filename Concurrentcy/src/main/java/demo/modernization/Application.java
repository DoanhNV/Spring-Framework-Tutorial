package demo.modernization;

public class Application {

	public static void main(String[] args) {
		Counter counter = new Counter();
		CounterThread thread1 = new CounterThread(counter,100);
		CounterThread thread2 = new CounterThread(counter,1000);
		thread1.run();
		thread2.run();
		System.out.println(counter.getValue());
		
		// using method compare and set
		MethodCounter counter2 = new MethodCounter();
		MethodCounterThread thread3 = new MethodCounterThread(counter2, 100);
		MethodCounterThread thread4 = new MethodCounterThread(counter2, 1000);
		thread3.run();
		thread4.run();
		System.out.println(counter2.getValue());
	}
}
