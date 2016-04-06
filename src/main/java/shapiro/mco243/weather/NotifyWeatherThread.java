package shapiro.mco243.weather;

import java.util.concurrent.LinkedBlockingQueue;

public class NotifyWeatherThread extends Thread {

	private LinkedBlockingQueue<String> queue;

	public NotifyWeatherThread(LinkedBlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {

		while (true) {
			String message;
			try {
				message = queue.take();
				soundAlarm(message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			

		}
	}

	private void soundAlarm(String message) {
		for (int i = 0; i < 1000000; i++) {
			// send an email...
		}
		
	}
}
