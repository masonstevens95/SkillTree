package galacticgames.android.skilltree.screens.tempnewskillscreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import galacticgames.android.skilltree.screens.common.controllers.BaseFragment;

public class NewSkillFragment extends BaseFragment {

    public static Fragment newInstance() {
        return new NewSkillFragment();
    }

    private NewSkillScreenController mNewSkillScreenController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        NewSkillScreenViewMvc viewMvc = getCompositionRoot()
                .getViewMvcFactory()
                .getNewSkillScreenViewMvc(container);

        mNewSkillScreenController = getCompositionRoot().getNewSkillScreenController();
        mNewSkillScreenController.bindView(viewMvc);

        return viewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mNewSkillScreenController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mNewSkillScreenController.onStop();
    }
}
