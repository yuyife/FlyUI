package com.yuyife.flyui.anim;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;

/*
 旋转 x 轴  -90  -》 0
 */
public class FlipV extends BaseEffects{

    @Override
    protected void setupAnimation(View view) {
        getAnimatorSet().playTogether(
                ObjectAnimator.ofFloat(view, "rotationX", -90, 0).setDuration(mDuration)

        );
    }
}
