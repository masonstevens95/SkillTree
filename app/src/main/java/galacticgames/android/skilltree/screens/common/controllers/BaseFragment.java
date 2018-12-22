package galacticgames.android.skilltree.screens.common.controllers;

import android.support.v4.app.Fragment;

import galacticgames.android.skilltree.common.CustomApplication;
import galacticgames.android.skilltree.common.dependencyinjection.ControllerCompositionRoot;

public class BaseFragment extends Fragment {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if (mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(
                    ((CustomApplication) requireActivity().getApplication()).getCompositionRoot(),
                    requireActivity()
            );
        }
        return mControllerCompositionRoot;
    }
}
