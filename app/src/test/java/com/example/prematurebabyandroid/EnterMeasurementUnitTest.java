package com.example.prematurebabyandroid;


import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class EnterMeasurementUnitTest {

    private static final String FAKE_STRING = "Entry was successful";

    @Mock
    Context mMockContext;

    @Test
    public void readStringFromContext_LocalizedString() {

        ClinicianNewMeasurementActivity myObjectUnderTest = new ClinicianNewMeasurementActivity(mMockContext);

        // ...when the string is returned from the object under test...


        String result = myObjectUnderTest.validate("event","notes", "00:00:00",
                0, 0, 0, 0);

        // ...then the result should be the expected one.
        assertThat(result, is(FAKE_STRING));
    }

}
