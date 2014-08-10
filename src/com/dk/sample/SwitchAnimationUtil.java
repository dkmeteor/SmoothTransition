package com.dk.sample;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;

public class SwitchAnimationUtil {
	private static int count = 0;

	public static void startAnimation(View root) {

		bindAnimation(root, 0);
	}

	private static void bindAnimation(View view, int depth) {
		if (view instanceof ViewGroup) {
			ViewGroup group = (ViewGroup) view;
			for (int i = 0; i < group.getChildCount(); i++) {
				bindAnimation(group.getChildAt(i), depth + 1);
			}
		} else {
			runAnimation(view, 200 * count);
			count++;
		}
	}

	// private static void runAnimation(View view,long delay)
	// {
	// view.setAlpha(0);
	// ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view,
	// "alpha", 0, 1);
	// objectAnimator.setStartDelay(delay);
	// objectAnimator.setDuration(400);
	// objectAnimator.setInterpolator(new LinearInterpolator());
	// objectAnimator.start();
	// }

	private static void runAnimation(View view, long delay) {
		view.setAlpha(0);
		AnimatorSet set = new AnimatorSet();
		ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view,
				"rotation", 0f, 360f);
		objectAnimator.setDuration(400);

		ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view, "scaleX",
				0f, 1f);
		objectAnimator.setDuration(400);

		ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(view, "scaleY",
				0f, 1f);
		objectAnimator.setDuration(400);

		ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(view, "alpha",
				0f, 1f);
		objectAnimator.setDuration(400);

		set.playTogether(objectAnimator, objectAnimator2, objectAnimator3,
				objectAnimator4);
		set.setStartDelay(delay);
		set.start();

	}
}
