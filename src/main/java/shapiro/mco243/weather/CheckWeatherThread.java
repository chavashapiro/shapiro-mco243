package shapiro.mco243.weather;

import java.util.concurrent.LinkedBlockingQueue;

public class CheckWeatherThread extends Thread {

	private LinkedBlockingQueue<String> queue;

	public CheckWeatherThread(LinkedBlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			notifyBadWeather();
		}
	}

	private void notifyBadWeather() {
		queue.add("bad weather");
	}

}
