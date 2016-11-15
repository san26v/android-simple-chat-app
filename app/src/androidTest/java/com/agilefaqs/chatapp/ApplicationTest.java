package com.agilefaqs.chatapp;

import android.app.Application;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ApplicationTestCase;

import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

//public class ApplicationTest {
//
//    @Rule
//    public final ActivityTestRule<MainActivity> main =
//            new ActivityTestRule<>(MainActivity.class, false, false);
//}
//}
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);



    }
}
