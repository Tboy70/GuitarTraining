package com.example.thomas.guitartraining.presentation.utils;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateTimeUtils {

    public static final int DEFAULT_DURATION_LEFT = -1;
    public static final int SECONDS_IN_ONE_MINUTE = 60;
    public static final int MINUTE_TO_MILLISECONDS = 1000;

    public static String convertMillisecondsToTimeFormat(long milliSeconds) {
        return String.format(Locale.getDefault(), "%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));
    }
}
