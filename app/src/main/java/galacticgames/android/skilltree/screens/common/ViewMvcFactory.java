package galacticgames.android.skilltree.screens.common;

import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import galacticgames.android.skilltree.common.toolbar.ToolbarViewMvc;
import galacticgames.android.skilltree.screens.homescreen.HomeScreenViewMvc;
import galacticgames.android.skilltree.screens.homescreen.HomeScreenViewMvcImpl;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    public HomeScreenViewMvc getHomeScreenViewMvc(@Nullable ViewGroup parent){
        return new HomeScreenViewMvcImpl(mLayoutInflater, parent, this);
    }

    public ToolbarViewMvc getToolbarViewMvc(@Nullable ViewGroup parent) {
        return new ToolbarViewMvc(mLayoutInflater, parent);
    }
}
