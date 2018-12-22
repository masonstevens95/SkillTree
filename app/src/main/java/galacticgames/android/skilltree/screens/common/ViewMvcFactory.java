package galacticgames.android.skilltree.screens.common;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
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

}
