package com.yuyife.flyui.anim;

import android.view.View;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.view.ViewHelper;

public abstract  class BaseEffects {

    private static final int DURATION = 1 * 500; //持续时间

    protected long mDuration =DURATION ;

    /*动画集合对象*/
    private AnimatorSet mAnimatorSet;
    /*普通代码块创建 动画集合对象*/
    {
        mAnimatorSet = new AnimatorSet();
    }

    protected abstract void setupAnimation(View view);

    public void start(View view) {
        reset(view);
        setupAnimation(view);
        mAnimatorSet.start();
    }
    public void reset(View view) {
        ViewHelper.setPivotX(view, view.getMeasuredWidth() / 2.0f);
        ViewHelper.setPivotY(view, view.getMeasuredHeight() / 2.0f);
    }


    public AnimatorSet getAnimatorSet() {
        return mAnimatorSet;
    }
    
    public void setDuration(long duration) {
        this.mDuration = duration;
    }

}
