package test;

import java.util.concurrent.CountDownLatch;

class Application implements Runnable{
	private String name;
	private CountDownLatch countdownlatch;
	
	public Application(String name, CountDownLatch countDownLatch) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.countdownlatch = countDownLatch;
	}

	@Override
	public void run() {
		try {
	         System.out.println(name + " started. ");
	         Thread.sleep(1000);
	      } catch (InterruptedException e) {
	         System.out.println(e.getMessage());
	      }
	      System.out.println( name + " is Up and running.");
	      //reduce the count by 1
	      countdownlatch.countDown();
	}
	
}
public class count_down_latch {
	public static void main(String args[]) {
	CountDownLatch countDownLatch = new CountDownLatch(4);
	Application app_1 = new Application("App1",  countDownLatch);
	Thread app1 = new Thread(app_1);
    Thread app2 = new Thread(new Application("App2",  countDownLatch));          
    Thread app3 = new Thread(new Application("App3",  countDownLatch));
    Thread app4 = new Thread(new Application("App4",  countDownLatch));  

    // initialize applications
    app1.start();
    app2.start();
    app3.start();
    app4.start();
    
    try {
        //wait until countDownLatch reduces to 0.
        countDownLatch.await();            
        //As all applications are up, print the message
        System.out.println("All applications are up and running.");
     } catch(InterruptedException e) {
        System.out.println(e.getMessage());
     } 
	}
}
