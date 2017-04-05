package com.example.lining.customview;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;

/**
 * Created by 李宁 on 2017/3/10.
 */
public class Tools {
    public static void hideView(ViewGroup view) {

        hideView(view, 0);
    }

    public static void showView(ViewGroup view) {

        showView(view, 0);
    }

    public static void hideView(ViewGroup view, int startOffset) {

        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 0, 180);
        animator.setDuration(500);
        animator.setStartDelay(startOffset);
        animator.start();
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight());

        /*//设置不可以点击
        view.setEnabled(false);*/
    }

    public static void showView(ViewGroup view, int startOffset) {

       /* RotateAnimation animation = new RotateAnimation(180, 360, view.getWidth() / 2, view.getHeight());
        animation.setDuration(500);
        animation.setFillAfter(true);
        animation.setStartOffset(startOffset);
        view.startAnimation(animation);
        for (int i = 0; i < view.getChildCount(); i++) {
            View childAt = view.getChildAt(i);
            childAt.setEnabled(true);
        }*/
        //补间动画-->属性动画
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 180, 360);
        animator.setDuration(500);
        animator.setStartDelay(startOffset);
        animator.start();
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight());

        /*//设置可以点击
        view.setEnabled(true);*/
    }

}
