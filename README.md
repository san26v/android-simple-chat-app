You'll need to run the server (https://github.com/nashjain/java-legacy-chat-server) locally and then update the code with your local IP address.

How to run server:
===
* download and double click on target/chat-server.jar
or
* java -jar target/chat-server.jar

API example:
==
* http://localhost:4567/send?message=Yo_this_is_a_message&senderName=naresh
* http://localhost:4567/fetchAllMessages

APPENDIX
===

MainActivityTests
==
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

Unit Tests
===

// Some Problems here :
// 1.   The MainActivity has methods with package level visibility at the max, making it hard to access, mock or unit test from outside.
//      Unless the visibility of the methods change its almost impossible to test that piece of code (although contrived unit test cases are possible through powermock, I am noyt attempting them here as they are actually contrived)
// 2.  Serious code refactoring and separation is required of the Main Activity to follow an MVC/MVP model as I see the model,view and controller/Presenter code into the Main activity not making it scalable from a code/test code standpoint.


