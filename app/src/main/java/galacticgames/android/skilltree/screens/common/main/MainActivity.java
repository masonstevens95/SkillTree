package galacticgames.android.skilltree.screens.common.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;


import java.util.HashSet;
import java.util.Set;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.common.screensnavigator.ScreensNavigator;
import galacticgames.android.skilltree.screens.common.controllers.BackPressDispatcher;
import galacticgames.android.skilltree.screens.common.controllers.BackPressedListener;
import galacticgames.android.skilltree.screens.common.controllers.BaseActivity;
import galacticgames.android.skilltree.screens.common.controllers.HomePressDispatcher;
import galacticgames.android.skilltree.screens.common.controllers.HomePressedListener;
import galacticgames.android.skilltree.screens.common.fragmentframehelper.FragmentFrameWrapper;

public class MainActivity extends BaseActivity implements BackPressDispatcher,
        HomePressDispatcher, FragmentFrameWrapper {

    public static void startClearTop(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    private final Set<BackPressedListener> mBackPressedListeners = new HashSet<>();
    private final Set<HomePressedListener> mHomePressedListeners = new HashSet<>();
    private ScreensNavigator mScreensNavigator;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_common_content_frame);
        mScreensNavigator = getCompositionRoot().getScreensNavigator();

        if (savedInstanceState == null) {
            mScreensNavigator.toHome();
        }
    }

    @Override
    public void registerListener(BackPressedListener listener) {
        mBackPressedListeners.add(listener);
    }

    @Override
    public void unregisterListener(BackPressedListener listener) {
        mBackPressedListeners.remove(listener);
    }

    @Override
    public void onBackPressed() {
        boolean isBackPressConsumedByAnyListener = false;
        for (BackPressedListener listener : mBackPressedListeners) {
            if (listener.onBackPressed()) {
                isBackPressConsumedByAnyListener = true;
            }
        }
        if (!isBackPressConsumedByAnyListener) {
            super.onBackPressed();
        }
    }

    @Override
    public FrameLayout getFragmentFrame() {
        return findViewById(R.id.frame_content);
    }

    @Override
    public void registerListener(HomePressedListener listener) {
        mHomePressedListeners.add(listener);
    }

    @Override
    public void unregisterListener(HomePressedListener listener) {
        mHomePressedListeners.remove(listener);
    }

    //TODO: see if I can use this to pop all fragments off the stack.
//    public void onHomePressed() {
//        boolean isBackPressConsumedByAnyListener = false;
//        for (BackPressedListener listener : mBackPressedListeners) {
//            if (listener.onBackPressed()) {
//                isBackPressConsumedByAnyListener = true;
//            }
//        }
//        if (!isBackPressConsumedByAnyListener) {
//            super.onBackPressed();
//        }
//    }
}
