package com.agilefaqs.chatapp;

import android.os.Bundle;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.confengine.chatapp.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by santosh.vaidyanathan on 14/11/16.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTests {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    //A quick simple test case that fails as the messages relayed are not printed on the app's main activity.

    @Test
    public void testGreet() throws InterruptedException {

        Espresso.onView(ViewMatchers.withId(R.id.messageInput)).check(ViewAssertions.matches(ViewMatchers.withHint("Enter message here")));
        Espresso.onView(ViewMatchers.withId(R.id.messageInput)).perform(ViewActions.typeText("Hike"));
        Espresso.onView(ViewMatchers.withId(R.id.sendButton)).perform(ViewActions.click()).check(ViewAssertions.matches(ViewMatchers.withText("Hike")));
    }
}
