package com.teamtreehouse.testingbase;

import android.graphics.Color;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by NIKI on 8/30/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    MainActivityPresenter presenter;

    @Mock
    MainActivityView view;

    @Before
    public void setUp() throws Exception {
            presenter = new MainActivityPresenter(view);
    }

    @Test
    public void editTextUpdated() throws Exception {
            //Arrange
            String givenString = "test123";

            //Act
            presenter.editTextUpdated(givenString);

            //Assert
        Mockito.verify(view).changeTextViewText(givenString);
    }

    @Test
    public void colorSelected() throws Exception {
            // Arrange
            int index = 2;
            int givingColor = Color.GREEN;

            // Act
            presenter.colorSelected(index);

            // Assert
            Mockito.verify(view).changeBackgroundColor(givingColor);
    }

    @Test
    public void launchOtherActivityButtonClicked() throws Exception {
        // Arrange
        Class clazz = OtherActivity.class;

        // Act
        presenter.launchOtherActivityButtonClicked(clazz);

        // Assert
        Mockito.verify(view).launchOtherActivity(clazz);
    }
}