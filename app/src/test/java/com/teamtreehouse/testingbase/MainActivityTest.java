package com.teamtreehouse.testingbase;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.internal.Shadow;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by NIKI on 8/30/2016.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class MainActivityTest {

    MainActivity activity;

    @Before
    public void setUp() {
        //Activity now exist with all the lifecycle methods needed
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void editTextUpdatesTextView() throws Exception {
        // Arrange
        String givenString = "test123";
        activity.editText.setText(givenString);

        // Act
        activity.editText.onEditorAction(EditorInfo.IME_ACTION_DONE);

        // Assert
        String actualString = activity.textView.getText().toString();
        assertEquals(givenString, actualString);
    }

    @Test
    public void spinnerUpdatesBackgroundColor() throws Exception {
        // Arrange
        int index = 2;
        int givingColor = Color.GREEN;

        // Act
        activity.colorSpinner.setSelection(index);

        // Assert
        int actualColor = ((ColorDrawable) activity.linearLayout.getBackground()).getColor();
        assertEquals(givingColor, actualColor);
    }

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {
        // Arrange
        Class clazz = OtherActivity.class;
        Intent expectedIntent = new Intent(activity, clazz);

        // Act
        activity.launchActivityButton.callOnClick();

        // Assert
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(expectedIntent.filterEquals(actualIntent));
    }
}
