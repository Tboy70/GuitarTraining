package com.example.thomas.guitartraining.presentation.utils;

public enum ConstantTag {
    INTRO("Intro"),
    SCALE("Scale"),
    MODE("Mode"),
    PULL_OFF_HAMMER_ON("Pull_off_hammer_on"),
    BEND_SLIDE("Bend_slide"),
    BACK_FORTH("Back_forth"),
    PALM_MUTE("Palm_mute"),
    SKIP_STRING("Skip_string"),
    SWEEP_PICKING("Sweep_picking"),
    TAPPING("Tapping"),
    SPEED("Speed"),
    END("End"),
    DIALOG("Dialog");

    private final String tag;

    ConstantTag(String tag) {
        this.tag = tag;
    }

    public String toString() {
        return this.tag;
    }
}
