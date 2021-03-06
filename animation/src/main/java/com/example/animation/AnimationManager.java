package com.example.animation;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class AnimationManager {

    public void start(Context context, AnimationType animationType, View view) {
        if (context != null && animationType != null && view != null) {
            stop(view);
            int animRes = 0;
            switch (animationType) {
                case SHAKE:
                    animRes = R.anim.shake;
                    break;
                case SHAKE_INFINITE:
                    animRes = R.anim.shake_infinite;
                    break;
                case SCALE_INFINITE:
                    animRes = R.anim.scale_infinite;
                    break;
                case SCALE_UP_BOUNCE:
                    animRes = R.anim.scale_up_bounce;
                    break;
                case SCALE_DOWN_BOUNCE:
                    animRes = R.anim.scale_down_bounce;
                    break;
                case SCALE_UP:
                    animRes = R.anim.scale_up;
                    break;
                case SCALE_DOWN:
                    animRes = R.anim.scale_down;
                    break;
                case ROTATE_180_CLOCKWISE:
                    animRes = R.anim.rotate_to_180_clockwise;
                    break;
                case ROTATE_180_ANTI_CLOCKWISE:
                    animRes = R.anim.rotate_to_0_anti_clockwise;
                    break;
            }
            Animation animation = AnimationUtils.loadAnimation(context, animRes);
            view.setAnimation(animation);
            animation.start();
        }
    }

    public void stop(View view) {
        if (view != null) {
            Animation animation = view.getAnimation();
            if (animation != null) {
                animation.reset();
                animation.cancel();
            }
            view.clearAnimation();
            view.setAnimation(null);
        }
    }

}