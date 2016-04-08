package shapiro.mco243.deadlock;

import java.util.logging.Logger;

public class Philosopher extends Thread {

	private static final Logger LOG = Logger.getLogger(Philosopher.class.getName());

	private Fork f1;
	private Fork f2;
	private String name;
	private Waiter waiter;

	public Philosopher(String name, Waiter waiter, Fork f1, Fork f2) {
		this.f1 = f1;
		this.f2 = f2;
		this.name = name;
		this.waiter = waiter;
	}

	public void run() {

		while (true) {
			think();
			try {
				eat();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void eat() throws InterruptedException {

		LOG.info(this.toString() + "attempting to eat...");
		if (waiter.tryToEat(f1, f2)) {
			waitForAFewSeconds(10);
			LOG.info(this.toString() + "eating");
			f1.setInUse(false);
			f2.setInUse(false);
		}
		LOG.info(this.toString() + "done eating");

		/*
		 * System.out.println(this + " trying to pick up " + f1); f1.tryLock(10,
		 * TimeUnit.SECONDS); System.out.println(this + " trying to pick up " +
		 * f2); if (f1.isLocked() { f2.tryLock(10, TimeUnit.SECONDS); }
		 * 
		 * System.out.println(this + " eating...");
		 * 
		 * if (f1.isLocked()) { f1.unlock(); System.out.println(this +
		 * " put down " + f1); } if (f2.isLocked()) { f2.unlock();
		 * System.out.println(this + " put down " + f2); }
		 */
	}

	public void think() {
		LOG.info(this.toString() + "thinking");
		waitForAFewSeconds(5);
	}

	private void waitForAFewSeconds(int seconds) {
		try {
			Thread.sleep((long) (seconds * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		return "Philosopher [name=" + name + "]";
	}
}
