package galacticgames.android.skilltree.screens.skilldetails.graphtab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import galacticgames.android.skilltree.screens.common.controllers.BaseFragment;
import galacticgames.android.skilltree.screens.skilldetails.achievementstab.AchievementsTabViewMvc;

public class GraphTabFragment extends BaseFragment {

    public static Fragment newInstance() {
        return new GraphTabFragment();
    }

    private GraphTabController mGraphTabController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        GraphTabViewMvc viewMvc = getCompositionRoot()
                .getViewMvcFactory()
                .getGraphTabViewMvc(container);

        mGraphTabController = getCompositionRoot().getGraphTabController();
        mGraphTabController.bindView(viewMvc);

        return viewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mGraphTabController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mGraphTabController.onStop();
    }

    @Override
    public void onResume(){
        super.onResume();
        mGraphTabController.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
        mGraphTabController.onPause();
    }

}
