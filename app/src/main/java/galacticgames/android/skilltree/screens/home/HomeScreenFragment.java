package galacticgames.android.skilltree.screens.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import galacticgames.android.skilltree.screens.common.controllers.BaseFragment;

public class HomeScreenFragment extends BaseFragment {

    public static Fragment newInstance(){
        return new HomeScreenFragment();
    }

    private HomeScreenController mHomeScreenController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        HomeScreenViewMvc viewMvc = getCompositionRoot()
                                    .getViewMvcFactory()
                                    .getHomeScreenViewMvc(container);

        mHomeScreenController = getCompositionRoot().getHomeScreenController();
        mHomeScreenController.bindView(viewMvc);

        return viewMvc.getRootView();
    }

    @Override
    public void onStart(){
        super.onStart();
        mHomeScreenController.onStart();
    }

    @Override
    public void onStop(){
        super.onStop();
        mHomeScreenController.onStop();
    }
}
