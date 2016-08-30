package com.teamtreehouse.testingbase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by NIKI on 8/30/2016.
 */
public class MainActivityPresenterTest {

    MainActivityPresenter presenter;
    MainActivityView view;

    class MockedView implements MainActivityView {


        @Override
        public void changeTextViewText(String text) {

        }

        @Override
        public void changeBackgroundColor(int color) {

        }

        @Override
        public void launchOtherActivity(Class activity) {

        }
    }

    @Before
    public void setUp() throws Exception {
            view = new MockedView();
            presenter = new MainActivityPresenter(view);
    }

    @Test
    public void testEditTextUpdated() throws Exception {
            //Arrange

            //Act

            //Assert
    }

    @Test
    public void testColorSelected() throws Exception {

    }

    @Test
    public void testLaunchOtherActivityButtonClicked() throws Exception {

    }
}