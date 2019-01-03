package galacticgames.android.skilltree.screens.skilldetails;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import galacticgames.android.skilltree.screens.common.controllers.BaseFragment;

public class SkillDetailsScreenFragment extends BaseFragment {

    public static Fragment newInstance() {
        return new SkillDetailsScreenFragment();
    }

    private SkillDetailsScreenController mSkillDetailsScreenController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        SkillDetailsScreenViewMvc viewMvc = getCompositionRoot()
                .getViewMvcFactory()
                .getSkillDetailsScreenViewMvc(container);

        mSkillDetailsScreenController = getCompositionRoot().getSkillDetailsScreenController();
        mSkillDetailsScreenController.bindView(viewMvc);

        return viewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mSkillDetailsScreenController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mSkillDetailsScreenController.onStop();
    }

    @Override
    public void onResume(){
        super.onResume();
        mSkillDetailsScreenController.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
        mSkillDetailsScreenController.onPause();
    }
}
