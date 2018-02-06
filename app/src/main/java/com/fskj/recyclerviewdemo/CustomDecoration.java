package com.fskj.recyclerviewdemo;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * author: Administrator
 * date: 2018/2/6 0006
 * desc:
 */

public class CustomDecoration extends RecyclerView.ItemDecoration {
    private Drawable drawable;

    public CustomDecoration(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        // 计算需要绘制的区域
        Rect rect = new Rect();
        rect.left = parent.getPaddingLeft();
        rect.right = parent.getWidth() - parent.getPaddingRight();
        for (int i = 0; i < childCount; i++) {
            View childView = parent.getChildAt(i);
            rect.top = childView.getBottom();
            rect.bottom = rect.top + drawable.getIntrinsicHeight();
            drawable.setBounds(rect.left,rect.top, rect.right, rect.bottom);
            // 直接利用Canvas去绘制
            drawable.draw(c);
        }

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        // 在每个子View的下面留出来画分割线
        outRect.bottom += drawable.getIntrinsicHeight();
    }
}
