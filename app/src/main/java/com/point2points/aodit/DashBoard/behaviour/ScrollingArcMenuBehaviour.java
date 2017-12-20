package com.point2points.aodit.DashBoard.behaviour;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.point2points.aodit.DashBoard.behaviour.Utils;
import com.sa90.materialarcmenu.ArcMenu;

/**
 * Created by Edwin on 15/9/2016.
 */
public class ScrollingArcMenuBehaviour extends CoordinatorLayout.Behavior<ArcMenu> {
    private int toolBarHeight;

    public ScrollingArcMenuBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.toolBarHeight = Utils.getToolbarHeight(context);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ArcMenu fab, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ArcMenu fab, View dependency) {
        if (dependency instanceof AppBarLayout) {
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
            int fabBottomMargin = lp.bottomMargin;
            int distanceToScroll = fab.getHeight() + fabBottomMargin;
            float ratio = (float)dependency.getY()/(float)toolBarHeight;
            fab.setTranslationY(-distanceToScroll * ratio);
        }
        return true;
    }
}
