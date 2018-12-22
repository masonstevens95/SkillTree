package galacticgames.android.skilltree.common;

import android.app.Application;

import galacticgames.android.skilltree.common.dependencyinjection.CompositionRoot;


public class CustomApplication extends Application {

    private CompositionRoot mCompositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        mCompositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return mCompositionRoot;
    }
}
