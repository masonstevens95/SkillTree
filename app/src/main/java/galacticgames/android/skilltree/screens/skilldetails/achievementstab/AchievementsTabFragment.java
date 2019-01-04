package galacticgames.android.skilltree.screens.skilldetails.achievementstab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import galacticgames.android.skilltree.screens.common.controllers.BaseFragment;

public class AchievementsTabFragment extends BaseFragment {

    public static Fragment newInstance() {
        return new AchievementsTabFragment();
    }

    private AchievementsTabController mAchievementsTabController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        AchievementsTabViewMvc viewMvc = getCompositionRoot()
                .getViewMvcFactory()
                .getAchievementsTabViewMvc(container);

        mAchievementsTabController = getCompositionRoot().getAchievementsTabController();
        mAchievementsTabController.bindView(viewMvc);

        return viewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mAchievementsTabController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mAchievementsTabController.onStop();
    }

    @Override
    public void onResume(){
        super.onResume();
        mAchievementsTabController.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
        mAchievementsTabController.onPause();
    }

}
