package galacticgames.android.skilltree.screens.common.controllers;

import android.support.v7.app.AppCompatActivity;

import galacticgames.android.skilltree.common.CustomApplication;
import galacticgames.android.skilltree.common.dependencyinjection.ControllerCompositionRoot;


public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if (mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(
                    ((CustomApplication) getApplication()).getCompositionRoot(),
                    this
            );
        }
        return mControllerCompositionRoot;
    }

}
