package shapiro.mco243.deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class Fork extends ReentrantLock {

	private int number;
	private boolean inUse;

	public Fork(int number) {
		this.number = number;
	}

	public String toString() {
		return "Fork [number=" + number + "]";
	}

	public boolean isInUse() {
		return inUse;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

}
