package com.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextRandomView editAnimText1 = (TextRandomView) findViewById(R.id.tv_anim_id);
        final TextRandomView editAnimText2 = (TextRandomView) findViewById(R.id.tv_anim_1_id);
        final TextRandomView editAnimText3 = (TextRandomView) findViewById(R.id.tv_anim_2_id);

        editAnimText1.setText("Simple Text");

        editAnimText2.startTextAnimation("[ %s : %s]", "n5:n5");
        editAnimText2.setText("[ !!!!! : ##### ]");

        editAnimText3.startTextAnimation("http://%s/%s/%s.com ", "n7:A5:n3");

        findViewById(R.id.b_start_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editAnimText1.startTextAnimation();
                editAnimText2.startTextAnimation();
                editAnimText3.startTextAnimation();
            }
        });
        findViewById(R.id.b_stop_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editAnimText1.stopAnimation();
                editAnimText2.stopAnimation();
                editAnimText3.stopAnimation();
            }
        });
    }
}
