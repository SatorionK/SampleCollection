package com.websarva.wings.android.fragmentlearnig3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.zip.Inflater;

public class FragmentActivity extends Fragment {
    private int coun = 0;

//--------------------------------------------------------------------------------------------------
    public static FragmentActivity newInstance(int count){
        //①インスタンス化
        FragmentActivity fragmentActivity = new FragmentActivity();

        //②バンドル設定
        Bundle bundle = new Bundle();
        bundle.putInt("カウンタ" ,count);

        //③①の変数にデータセット
        fragmentActivity.setArguments(bundle);

        return fragmentActivity;
    }

//--------------------------------------------------------------------------------------------------
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        return inflater.inflate(R.layout.fragmentlayout_st, container,  false);
    }

//--------------------------------------------------------------------------------------------------
    @Override
    public void onViewCreated(View view, Bundle bundle){
        super.onViewCreated(view, bundle);
        Bundle bundle1 = getArguments();

        //ここでbundle内のデータを処理する
        if(bundle1 != null){
            int con = bundle1.getInt("カウンタ");
            String str = String.valueOf(con);
            //この時点で足されるため、テキスト反映時には、足されていない。
            coun = con + 1;

            TextView textView = view.findViewById(R.id.couttext);
            textView.setText(str);
        }

//==================================================================================================
        //カウントアップボタンを入れる
        Button button10 = view.findViewById(R.id.actA);
        button10.setOnClickListener(new View.OnClickListener(){
        @Override
         public void onClick(View view){
            //いつもの
            FragmentManager fragmentManager = getFragmentManager();
            //ここで確認
            if(fragmentManager != null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //バック処理
                fragmentTransaction.addToBackStack(null);
                //切り替え処理。場所は同じ。新たなフラグメントとカウントアップ状態で引数を渡す。
                fragmentTransaction.replace(R.id.changeActivity, FragmentActivity2.newInstance(coun));
                fragmentTransaction.commit();
            }
        }
    });

//==================================================================================================
        Button button11 = view.findViewById(R.id.actD);
        button11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager != null) {
                    fragmentManager.popBackStack();
                }
            }
        });
//==================================================================================================
}
//--------------------------------------------------------------------------------------------------
}