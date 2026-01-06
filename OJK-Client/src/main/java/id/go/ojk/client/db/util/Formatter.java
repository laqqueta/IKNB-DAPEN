package id.go.ojk.client.db.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Duration;

import org.apache.commons.lang3.time.DurationFormatUtils;

public class Formatter {
  public static final String NUMBER_FORMAT = "###,###.##";
  public static final String DURATION_FORMAT = "HH':'mm':'ss.S";

  public static String formatInteger(long number) {
    return new DecimalFormat(NUMBER_FORMAT, DecimalFormatSymbols.getInstance()).format(number);
  }

  public static String formatDecimal(BigDecimal number) {
    return new DecimalFormat(NUMBER_FORMAT, DecimalFormatSymbols.getInstance()).format(number);
  }

  public static String formatMillis(long millis) {
    return DurationFormatUtils.formatDuration(millis, DURATION_FORMAT);
  }

  public static String formatDuration(Duration duration) {
    return DurationFormatUtils.formatDuration(duration.toMillis(), DURATION_FORMAT);
  }
}
