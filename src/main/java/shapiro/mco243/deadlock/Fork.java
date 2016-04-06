package shapiro.mco243.deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class Fork extends ReentrantLock {

	private int number;

	public Fork(int number) {
		this.number = number;
	}

	public String toString() {
		return "Fork [number=" + number + "]";
	}

}
