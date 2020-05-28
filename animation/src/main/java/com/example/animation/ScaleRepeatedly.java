package com.example.animation;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class ScaleRepeatedly {

    public void start(Context context, View view) {
        scaleUp(context, view);
    }

    public void stop(View view) {
        Animation animation = view.getAnimation();
        if (animation != null) {
            animation.reset();
            animation.cancel();
        }
        view.clearAnimation();
        view.setAnimation(null);
    }

    private void scaleUp(final Context context, final View view) {
        Animation scaleUp = AnimationUtils.loadAnimation(context, R.anim.scale_up);
        scaleUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                scaleDown(context, view);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.setAnimation(scaleUp);
        scaleUp.start();
    }

    private void scaleDown(final Context context, final View view) {
        Animation scaleDown = AnimationUtils.loadAnimation(context, R.anim.scale_down);
        scaleDown.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                scaleUp(context, view);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.setAnimation(scaleDown);
        scaleDown.start();
    }

}