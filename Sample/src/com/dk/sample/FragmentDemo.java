package com.dk.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

import com.dk.animation.SwitchAnimationUtil;

public class FragmentDemo extends FragmentActivity {
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        mFragmentManager = getSupportFragmentManager();

        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.fragment_container, new FlowerFragment());
        mFragmentTransaction.commit();
    }

}

class FlowerFragment extends Fragment {
    private View mConverView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mConverView = LayoutInflater.from(getActivity()).inflate(R.layout.view_fragment, null);
        mConverView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                new SwitchAnimationUtil().startAnimation(mConverView, Constant.mType);
            }
        });

        return mConverView;
    }

}
