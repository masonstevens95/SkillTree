package galacticgames.android.skilltree.screens.homescreen;

import android.widget.Button;
import android.widget.ImageButton;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.common.screensnavigator.ScreensNavigator;
import galacticgames.android.skilltree.common.toastshelper.ToastsHelper;
import galacticgames.android.skilltree.screens.common.controllers.HomePressedListener;

public class HomeScreenController implements HomeScreenViewMvc.Listener, HomePressedListener {

    private final ScreensNavigator mScreensNavigator;
    private final ToastsHelper mToastsHelper;
    //TODO: private final HomePressDispatcher mHomePressDispatcher

    private HomeScreenViewMvc mViewMvc;

    public HomeScreenController(ScreensNavigator screensNavigator,
                                ToastsHelper toastsHelper){
        mScreensNavigator = screensNavigator;
        mToastsHelper = toastsHelper;

        //TODO: mHomePressDispatcher
    }

    public void bindView(HomeScreenViewMvc viewMvc){
        mViewMvc = viewMvc;
    }

    public void onStart(){
        mViewMvc.registerListener(this);
        //TODO: register HomePressDispatcher

        //TODO: mViewMvc.animations()
    }

    public void onStop(){
        mViewMvc.unregisterListener(this);
        //TODO: unregister HomePressDispatcher
    }

    @Override
    public void onImageButtonClicked(ImageButton button) {
        //TODO: replace toast with ScreensNavigator

        switch (button.getId()){
            case R.id.skillsButton:
                mScreensNavigator.toUserSkillList();
                break;
            case R.id.searchButton:
                mToastsHelper.showTemporaryNavigation("searchButton");
                break;
            case R.id.friendsButton:
                mToastsHelper.showTemporaryNavigation("friendsButton");
                break;
            case R.id.profileButton:
                mToastsHelper.showTemporaryNavigation("profileButton");
                break;
            default:
                mToastsHelper.showTemporaryNavigation("Not sure where you just clicked...");
        }
    }

    @Override
    public boolean onHomePressed() {
        //this is home - no operation
        return false;
    }
}
