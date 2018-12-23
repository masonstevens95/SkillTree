package galacticgames.android.skilltree.screens.userskills;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import galacticgames.android.skilltree.screens.common.controllers.BaseFragment;

public class UserSkillsScreenFragment extends BaseFragment {

    public static Fragment newInstance() {
        return new UserSkillsScreenFragment();
    }

    private UserSkillsScreenController mUserSkillsScreenController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        UserSkillsScreenViewMvc viewMvc = getCompositionRoot()
                                            .getViewMvcFactory()
                                            .getUsersSkillViewMvc(container);

        mUserSkillsScreenController = getCompositionRoot().getUserSkillsScreenController();
        mUserSkillsScreenController.bindView(viewMvc);

        return viewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mUserSkillsScreenController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mUserSkillsScreenController.onStop();
    }
}
