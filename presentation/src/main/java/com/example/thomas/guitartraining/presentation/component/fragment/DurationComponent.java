package com.example.thomas.guitartraining.presentation.component.fragment;

import android.os.Build;
import android.text.Html;
import android.widget.TextView;

import com.example.thomas.guitartraining.di.PerActivity;
import com.example.thomas.guitartraining.presentation.utils.DateTimeUtils;

/**
 * Component to handle the duration text view.
 */
@PerActivity
public class DurationComponent {

    @SuppressWarnings("deprecation")
    public long setDuration(int durationExercise, long durationLeft, TextView exerciseDuration, String durationText, TextView exerciseDurationLeft, String durationTextLeft) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            exerciseDuration.setText(
                    Html.fromHtml(
                            String.format(
                                    durationText,
                                    String.valueOf(durationExercise)
                            ), Html.FROM_HTML_MODE_COMPACT
                    )
            );
        } else {
            exerciseDuration.setText(
                    Html.fromHtml(
                            String.format(
                                    durationText,
                                    String.valueOf(durationExercise)
                            )
                    )
            );
        }

        if (durationLeft == DateTimeUtils.DEFAULT_DURATION_LEFT) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                exerciseDurationLeft.setText(
                        Html.fromHtml(
                                String.format(
                                        durationTextLeft,
                                        String.valueOf(durationExercise)
                                ), Html.FROM_HTML_MODE_COMPACT
                        )
                );
                durationLeft = durationExercise * DateTimeUtils.SECONDS_IN_ONE_MINUTE * DateTimeUtils.MINUTE_TO_MILLISECONDS;
            } else {
                exerciseDurationLeft.setText(
                        Html.fromHtml(
                                String.format(
                                        durationTextLeft,
                                        String.valueOf(durationExercise)
                                )
                        )
                );
                durationLeft = durationExercise * DateTimeUtils.SECONDS_IN_ONE_MINUTE * DateTimeUtils.MINUTE_TO_MILLISECONDS;
            }

        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                exerciseDurationLeft.setText(
                        Html.fromHtml(
                                String.format(
                                        durationTextLeft,
                                        String.valueOf(DateTimeUtils.convertMillisecondsToTimeFormat(durationLeft))
                                ), Html.FROM_HTML_MODE_COMPACT
                        )
                );
            } else {
                exerciseDurationLeft.setText(
                        Html.fromHtml(
                                String.format(
                                        durationTextLeft,
                                        String.valueOf(DateTimeUtils.convertMillisecondsToTimeFormat(durationLeft))
                                )
                        )
                );
            }
        }

        return durationLeft;
    }

    @SuppressWarnings("deprecation")
    public long setDurationLeft(TextView exerciseScaleDurationLeft, String durationTextLeft, long timeCountInMilliSeconds) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            exerciseScaleDurationLeft.setText(
                    Html.fromHtml(
                            String.format(
                                    durationTextLeft,
                                    String.valueOf(DateTimeUtils.convertMillisecondsToTimeFormat(timeCountInMilliSeconds))
                            ), Html.FROM_HTML_MODE_COMPACT
                    )
            );
        } else {
            exerciseScaleDurationLeft.setText(
                    Html.fromHtml(
                            String.format(
                                    durationTextLeft,
                                    String.valueOf(DateTimeUtils.convertMillisecondsToTimeFormat(timeCountInMilliSeconds))
                            )
                    )
            );
        }
        return timeCountInMilliSeconds;
    }
}
