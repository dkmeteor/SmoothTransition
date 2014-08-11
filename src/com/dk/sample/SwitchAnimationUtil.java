package com.dk.sample;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;

/**
 * 
 * @author Dean.Ding
 * 
 */
public class SwitchAnimationUtil {
    private int orderIndex = 0;

    public SwitchAnimationUtil() {

    }

    public void startAnimation(View root, AnimationType type) {
        orderIndex = 0;
        bindAnimation(root, 0, type);
    }

    private void bindAnimation(View view, int depth, AnimationType type) {
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                bindAnimation(group.getChildAt(i), depth + 1, type);
            }
        } else {
            runAnimation(view, 200 * orderIndex, type);
            orderIndex++;
        }
    }

    private void runAnimation(View view, long delay, AnimationType type) {
        switch (type) {
        case ROTATE:
            runRotateAnimation(view, delay);
            break;
        case ALPHA:
            runAlphaAnimation(view, delay);
            break;
        case HORZION_LEFT:
            runHorizonLeftAnimation(view, delay);
            break;
        case HORZION_Right:
            runHorizonRightAnimation(view, delay);
            break;
        case HORZON_CROSS:
            // NOT SUPPORT NOW
            break;
        case SCALE:
            runScaleAnimation(view, delay);
            break;
        default:
            break;
        }
    }

    private void runHorizonLeftAnimation(View view, long delay) {
        view.setAlpha(0);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "translationX", -ViewUtils.getScreenWidth(), 0);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.start();
        ObjectAnimator objectAnimatorAlpha = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(400);
        set.setStartDelay(delay);
        set.playTogether(objectAnimator, objectAnimatorAlpha);
        set.start();
    }

    private void runHorizonRightAnimation(View view, long delay) {
        view.setAlpha(0);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "translationX", ViewUtils.getScreenWidth(), 0);
        objectAnimator.setInterpolator(new LinearInterpolator());
        ObjectAnimator objectAnimatorAlpha = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.setStartDelay(delay);
        set.setDuration(400);
        set.playTogether(objectAnimator, objectAnimatorAlpha);
        set.start();
    }

    private void runAlphaAnimation(View view, long delay) {
        view.setAlpha(0);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "alpha", 0, 1);
        objectAnimator.setStartDelay(delay);
        objectAnimator.setDuration(400);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.start();
    }

    private void runRotateAnimation(View view, long delay) {
        view.setAlpha(0);
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);

        objectAnimator2.setInterpolator(new AccelerateInterpolator(1.0f));
        objectAnimator3.setInterpolator(new AccelerateInterpolator(1.0f));

        set.setDuration(400);
        set.playTogether(objectAnimator, objectAnimator2, objectAnimator3, objectAnimator4);
        set.setStartDelay(delay);
        set.start();
    }

    private void runScaleAnimation(View view, long delay) {
        view.setAlpha(0);
        AnimatorSet set = new AnimatorSet();

        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f);
        set.setDuration(400);
        set.playTogether(objectAnimator2, objectAnimator3, objectAnimator4);
        set.setStartDelay(delay);
        set.start();
    }

    public enum AnimationType {
        ALPHA, ROTATE, HORZION_LEFT, HORZION_Right, HORZON_CROSS, SCALE
    }
}
