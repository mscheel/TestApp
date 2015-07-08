package com.mark.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.Observable;

public class MainActivity extends AppCompatActivity {

    Observable<String> mObservable;

    @Bind(R.id.textView) TextView mTextView;
    @Bind(R.id.button) Button mRedbutton;
    @Bind(R.id.button2) Button mBluebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        Observable<String> myObservable = Observable.create(
//                new Observable.OnSubscribe<String>() {
//                    @Override
//                    public void call(Subscriber<? super String> sub) {
//                        sub.onNext("Hello, world!!");
//                        sub.onCompleted();
//                    }
//                }
//        );

        mObservable =
                Observable.just("Hello, world!!");

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) { mTextView.setText(s); }

            @Override
            public void onCompleted() { }

            @Override
            public void onError(Throwable e) { }
        };

        mObservable.subscribe(mySubscriber);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void redClick(View v) {
//        Toast.makeText(this, "red", Toast.LENGTH_SHORT).show();
        mTextView.setText("red click");
    }

    public void blueClick(View v) {
//        Toast.makeText(this, "blue", Toast.LENGTH_SHORT).show();
        mTextView.setText("blue click");
    }

    public static String returnHello() {
        return "Hello";
    }
}
