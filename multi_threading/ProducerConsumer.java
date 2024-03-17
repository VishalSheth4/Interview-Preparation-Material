package multi_threading;

import java.util.Scanner; 

public class ProducerConsumer {
	public static void main(String args[]) {
		final PC pc = new PC();
		
	}
	public static class PC{
		public void produce() throws InterruptedException {
			synchronized(this) {
				System.out.println("Producer thread running...!");
				wait();
//				and waits till some other method invokes notify().
				System.out.println("Producer Resumed");
			}
		}
		public void consumer() throws InterruptedException{
			Thread.sleep(1000);
		}
	}
}
