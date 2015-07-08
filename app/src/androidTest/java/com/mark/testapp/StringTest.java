package com.mark.testapp;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by A596969 on 7/1/15.
 */
public class StringTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mFirstTestActivity;
    private TextView mFirstTestText;

    public StringTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);

        mFirstTestActivity = getActivity();
        mFirstTestText =
                (TextView) mFirstTestActivity
                        .findViewById(R.id.textView);

    }

    public void testlabelText() {
        final String expected =
                mFirstTestActivity.getString(R.string.hello_world);
        final String actual = mFirstTestText.getText().toString();
        assertEquals(expected, actual);
    }

    public void testClickedRed() {
        final Button redButton = (Button) mFirstTestActivity.findViewById(R.id.button);
        TouchUtils.clickView(this, redButton);
        assertEquals("red click", mFirstTestText.getText().toString());
    }


    public void testClickedBlue() {
        final Button blueButton = (Button) mFirstTestActivity.findViewById(R.id.button2);
        TouchUtils.clickView(this, blueButton);
        assertEquals("blue click", mFirstTestText.getText().toString());
    }
}
