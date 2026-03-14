package com.google.engedu.anagrams;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class ApplicationTest {
    @Test
    public void useAppContext() {
        assertEquals("com.google.engedu.anagrams",
                InstrumentationRegistry.getInstrumentation()
                        .getTargetContext().getPackageName());
    }
}
