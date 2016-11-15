package com.agilefaqs.chatapp;

import android.content.Context;
import android.graphics.Color;
import android.provider.Settings;
import android.test.ActivityInstrumentationTestCase2;

import com.confengine.chatapp.R;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    @Test
    public void canAddTwoIntegers() throws Exception {
        assertEquals(4, 2 + 2);
    }
// Some Problems here :
// 1.   The MainActivity has methods with package level visibility at the max, making it hard to access, mock or unit test from outside.
//      Unless the visibility of the methods change its almost impossible to test that piece of code (although contrived unit test cases are possible through powermock, I am noyt attempting them here as they are actually contrived)
// 2.  Serious code refactoring and separation is required of the Main Activity to follow an MVC/MVP model as I see the model,view and controller/Presenter code into the Main activity not making it scalable from a code/test code standpoint.

    @Test
    public void downloadMessagesTest() {


    }
}
