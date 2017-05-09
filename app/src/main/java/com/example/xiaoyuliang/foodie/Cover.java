package com.example.xiaoyuliang.foodie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.github.paolorotolo.appintro.AppIntro;

/**
 * Created by xiaoyuliang on 5/9/17.
 */

public class Cover extends AppIntro {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPref sharedPref=new SharedPref(this);

        if(sharedPref.getLoginStatus()){
            startActivity(new Intent(Cover.this,MainActivity.class));
            finish();
        }else if(sharedPref.getLoginSkipStatus()){
            startActivity(new Intent(Cover.this,LoginActivity.class));
            finish();
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        addSlide(new Intro1());
        addSlide(new Intro2());
        addSlide(new Intro3());

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);

        startActivity(new Intent(Cover.this,LoginActivity.class));
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        startActivity(new Intent(Cover.this,LoginActivity.class));
        finish();

    }

    public static class Intro1 extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment1, container, false);
        }
    }

    public static class Intro2 extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment2, container, false);
        }

    }

    public static class Intro3 extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment3, container, false);
        }
    }
}
