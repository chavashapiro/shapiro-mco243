package shapiro.mco243.deadlock;

/**
 * Philosophers must ask waiter before picking up the forks
 */
public class Waiter {

	public synchronized boolean tryToEat(Fork a, Fork b) {
		if (!a.isInUse() && !b.isInUse()) {
			a.setInUse(true);
			b.setInUse(true);
			return true;
		}

		return false;
	}

}
