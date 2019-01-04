package galacticgames.android.skilltree.screens.skilldetails.logstab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import galacticgames.android.skilltree.screens.common.controllers.BaseFragment;
import galacticgames.android.skilltree.screens.skilldetails.achievementstab.AchievementsTabViewMvc;

public class LogsTabFragment extends BaseFragment {

    public static Fragment newInstance() {
        return new LogsTabFragment();
    }

    private LogsTabController mLogsTabController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        LogsTabViewMvc viewMvc = getCompositionRoot()
                .getViewMvcFactory()
                .getLogsTabViewMvc(container);

        mLogsTabController = getCompositionRoot().getLogsTabController();
        mLogsTabController.bindView(viewMvc);

        return viewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mLogsTabController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mLogsTabController.onStop();
    }

    @Override
    public void onResume(){
        super.onResume();
        mLogsTabController.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
        mLogsTabController.onPause();
    }

}
