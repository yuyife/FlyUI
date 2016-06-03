package com.yuyife.flyui.anim;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;

/*
右边平移出来
 */
public class SlideRight extends BaseEffects{

    @Override
    protected void setupAnimation(View view) {
        getAnimatorSet().playTogether(
                ObjectAnimator.ofFloat(view, "translationX",300,0).setDuration(mDuration),
                ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration*3/2)

        );
    }
}
