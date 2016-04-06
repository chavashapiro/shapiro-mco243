package shapiro.mco243.weather;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	
	public static void main(String[] args) {
		
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		NotifyWeatherThread notifyWeather = new NotifyWeatherThread(queue);
		CheckWeatherThread checkWeather = new CheckWeatherThread(queue);
		
		checkWeather.start();
		notifyWeather.start();
	}

}
