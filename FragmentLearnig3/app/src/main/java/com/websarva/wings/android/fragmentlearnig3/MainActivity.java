package com.websarva.wings.android.fragmentlearnig3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //バック処理追加
            fragmentTransaction.addToBackStack(null);
            //カウント初期値
            int count = 0;

            fragmentTransaction.replace(R.id.changeActivity, FragmentActivity.newInstance(count));
            fragmentTransaction.commit();
        }
    }
}
