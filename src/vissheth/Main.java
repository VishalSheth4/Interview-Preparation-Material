package vissheth;

class PrintSequenceRunnable implements Runnable {
	int remainder;
	PrintSequenceRunnable(int remainder){
		this.remainder = remainder;
	}
	public static int number=1;	
	static Object lock = new Object();
	
	@Override
	public void run() {
		synchronized(lock) {
			while(number < 10) {
				if(number % 3 != remainder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Hello World .... Thread "+remainder+" : "+number);
				number++;
				lock.notifyAll();
			}
		}

	}

}
public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
		PrintSequenceRunnable r1 = new PrintSequenceRunnable(1);
		PrintSequenceRunnable r2 = new PrintSequenceRunnable(2);
		PrintSequenceRunnable r3 = new PrintSequenceRunnable(3);

		Thread t3 = new Thread(r3);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();
		t3.start();
	}
}
