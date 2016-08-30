package com.teamtreehouse.testingbase;

/**
 * Created by NIKI on 8/30/2016.
 */
public interface MainActivityView {
    void changeTextViewText(String text);
    void changeBackgroundColor(int color);
    void launchOtherActivity(Class activity);
}
