package com.yuyife.flyui.anim;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;

/*
 旋转 y 轴  -90  -》 0
 */
public class FlipH  extends BaseEffects{

    @Override
    protected void setupAnimation(View view) {
        getAnimatorSet().playTogether(
                ObjectAnimator.ofFloat(view, "rotationY", -90, 0).setDuration(mDuration)

        );
    }
}
