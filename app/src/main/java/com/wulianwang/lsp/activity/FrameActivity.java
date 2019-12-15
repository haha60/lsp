package com.wulianwang.lsp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.wulianwang.lsp.R;
import com.wulianwang.lsp.fragment.AndroidFragment;
import com.wulianwang.lsp.fragment.AppleFragment;

public class FrameActivity extends AppCompatActivity implements View.OnClickListener {

    AppleFragment appleFragment;
    AndroidFragment androidFragment;
    FragmentManager fm;
//    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        initView();
    }

    private void initView(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RadioButton rb1 = findViewById(R.id.bt1);
        RadioButton rb2 = findViewById(R.id.bt2);
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);

        fm = getSupportFragmentManager();


        addApple();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.bt1){
            addApple();
        }
        if(view.getId() == R.id.bt2){
            addAndroid();
        }
    }

    private void addApple(){
        FragmentTransaction ft = fm.beginTransaction();
        if(androidFragment != null){
            ft.hide(androidFragment);
        }
        if(appleFragment == null){
            appleFragment = new AppleFragment();
            ft.add(R.id.frame, appleFragment, "apple");
        }else {
            ft.show(appleFragment);
        }
        ft.commitAllowingStateLoss();
    }

    private void addAndroid(){
        FragmentTransaction ft = fm.beginTransaction();
        if(appleFragment != null){
            ft.hide(appleFragment);
        }
        if(androidFragment == null){
            androidFragment = new AndroidFragment();
            ft.add(R.id.frame, androidFragment, "android");
        }else{
            ft.show(androidFragment);
        }
        ft.commitAllowingStateLoss();
    }
}
