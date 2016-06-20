package com.azoft.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.azoft.random.RandomEditView;
import com.azoft.random.RandomTextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RandomTextView attrSettingsTextView = (RandomTextView) findViewById(R.id.tv_anim_id);
        final RandomTextView dynamicSettingsTextView = (RandomTextView) findViewById(R.id.tv_anim_1_id);
        final RandomEditView editText = (RandomEditView) findViewById(R.id.tv_anim_2_id);

        attrSettingsTextView.setText("Simple Text");

        dynamicSettingsTextView.startTextAnimation(getString(R.string.template), getString(R.string.rules));
        dynamicSettingsTextView.setText("[ !!!!! : ##### ]");

        editText.startTextAnimation("http://%s/%s/%s.com ", "n7:A5:n3");
        editText.setText("EditView test text !!!!!  ");

        findViewById(R.id.b_start_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attrSettingsTextView.startTextAnimation();
                dynamicSettingsTextView.startTextAnimation();
                editText.startTextAnimation();
            }
        });
        findViewById(R.id.b_stop_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attrSettingsTextView.stopAnimation();
                dynamicSettingsTextView.stopAnimation();
                editText.stopAnimation();
            }
        });
    }
}
