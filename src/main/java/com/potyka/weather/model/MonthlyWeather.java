package com.potyka.weather.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class MonthlyWeather {

  private static final Logger logger = Logger.getLogger(MonthlyWeather.class);

  private List<DailyWeather> dailyWeatherData = new ArrayList<>();

  public void addDailyWeather(DailyWeather dailyWeather) {
    this.dailyWeatherData.add(dailyWeather);
  }

  public int getDaySerialWithSmallestSpread() {
    int daySerialWithSmallestSpread = 0;
    int smallestTemperatureSperad = 0;
    for (DailyWeather oneDayWeather : dailyWeatherData) {

      logger.debug(oneDayWeather.getDayNumber() + ". nap a különbség: " + oneDayWeather.getTemperatureSpread());

      if (daySerialWithSmallestSpread == 0
          || oneDayWeather.getTemperatureSpread() < smallestTemperatureSperad) {
        smallestTemperatureSperad = oneDayWeather.getTemperatureSpread();
        daySerialWithSmallestSpread = oneDayWeather.getDayNumber();
      }
    }

    return daySerialWithSmallestSpread;
  }

  @Override
  public String toString() {
    return "MonthlyWeather [dailyWeatherData=" + dailyWeatherData + "]";
  }

}
