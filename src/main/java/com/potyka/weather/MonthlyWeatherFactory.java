package com.potyka.weather;

import com.potyka.weather.model.DailyWeather;
import com.potyka.weather.model.MonthlyWeather;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * NEM factory pattern, csakhát mégis ez "gyártja" le az adatot, ezért Factory-nak hívom. 
 * */
public class MonthlyWeatherFactory {

  private static final Logger logger = Logger.getLogger(MonthlyWeatherFactory.class);

  public MonthlyWeather create(File dataFile) {
    MonthlyWeather mw = new MonthlyWeather();
    try {
      for (String oneLine : Files.readAllLines(dataFile.toPath(), StandardCharsets.UTF_8)) {
        if (lineIsDataRecord(oneLine)) {
          mw.addDailyWeather(DailyWeather.create(oneLine));
        }
      }
    } catch (IOException e) {
      logger.error("Hiba az adatok beolvasása közben!", e);
    }
    return mw;
  }

  private boolean lineIsDataRecord(String oneLine) {
    try {
      return StringUtils.isNumeric(oneLine.replace(" ", "").substring(0, 1));
    } catch (Exception e) {
      return false;
    }
  }


}
