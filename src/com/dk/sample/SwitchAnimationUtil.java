package com.dk.sample;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

public class SwitchAnimationUtil {
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
			ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view,
					"alpha", 0, 1);
			objectAnimator.setDuration(1000);
			objectAnimator.setInterpolator(new LinearInterpolator());
			objectAnimator.start();
		}
	}
}
