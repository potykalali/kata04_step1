package com.potyka.weather;

import com.potyka.weather.model.MonthlyWeather;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * @author horakb
 */
public class WeatherAnalyzerMain {

  private static final Logger logger = Logger.getLogger(WeatherAnalyzerMain.class);

  public static final File weatherDataFile = new File("e:\\_SRC\\git\\cc\\target\\classes\\weather.dat");

  public static void main(String[] args) {

    MonthlyWeather mw = new MonthlyWeatherFactory().create(weatherDataFile);
    logger.info("Ezen a napon volt a legkisebb: " + mw.getDaySerialWithSmallestSpread());

  }

}
