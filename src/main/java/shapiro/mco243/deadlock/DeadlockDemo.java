package shapiro.mco243.deadlock;

public class DeadlockDemo {

	public synchronized static void neverReturn() {
		try {
			Thread.sleep(1000000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized static void notGoingToHappen() {
		System.out.println("Never prints");
	}

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				DeadlockDemo.neverReturn();
			}
		}.start();

		new Thread() {
			public void run() {
				DeadlockDemo.notGoingToHappen();
			}
		}.start();
	}

}
