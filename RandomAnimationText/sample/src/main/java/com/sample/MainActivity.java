package com.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.random.anim.RandomEditView;
import com.random.anim.RandomTextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RandomTextView randomTextView = (RandomTextView) findViewById(R.id.tv_anim_id);
        final RandomTextView randomTextView1 = (RandomTextView) findViewById(R.id.tv_anim_1_id);
        final RandomEditView randomEditView = (RandomEditView) findViewById(R.id.tv_anim_2_id);

        randomTextView.setText("Simple Text");

        randomTextView1.startTextAnimation(getString(R.string.template), getString(R.string.rules));

        randomTextView1.setText("[ !!!!! : ##### ]");

        randomEditView.startTextAnimation("http://%s/%s/%s.com ", "n7:A5:n3");
        randomEditView.setText("EditView test text !!!!!  ");

        findViewById(R.id.b_start_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomTextView.startTextAnimation();
                randomTextView1.startTextAnimation();
                randomEditView.startTextAnimation();
            }
        });
        findViewById(R.id.b_stop_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomTextView.stopAnimation();
                randomTextView1.stopAnimation();
                randomEditView.stopAnimation();
            }
        });
    }
}
