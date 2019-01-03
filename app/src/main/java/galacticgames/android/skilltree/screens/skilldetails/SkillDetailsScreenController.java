package galacticgames.android.skilltree.screens.skilldetails;

import galacticgames.android.skilltree.achievement.Achievement;
import galacticgames.android.skilltree.common.screensnavigator.ScreensNavigator;
import galacticgames.android.skilltree.common.toastshelper.ToastsHelper;
import galacticgames.android.skilltree.log.Log;
import galacticgames.android.skilltree.screens.common.controllers.HomePressDispatcher;
import galacticgames.android.skilltree.screens.common.controllers.HomePressedListener;

//TODO: add fetch Logs and Achievements from local memory
public class SkillDetailsScreenController implements SkillDetailsScreenViewMvc.Listener,
        HomePressedListener {

    //TODO: private final FetchUserSkillsFromLocalMemory mFetchUserSkillsFromLocalMemory;
    private final ScreensNavigator mScreensNavigator;
    private final ToastsHelper mToastsHelper;
    private final HomePressDispatcher mHomePressDispatcher;

    public SkillDetailsScreenViewMvc mViewMvc;

    public SkillDetailsScreenController(
            //TODO: FetchUserSkillsFromLocalMemory fetchUserSkillsFromLocalMemory,
                                      ScreensNavigator screensNavigator,
                                      ToastsHelper toastsHelper,
                                      HomePressDispatcher homePressDispatcher){
        //TODO: mFetchUserSkillsFromLocalMemory = fetchUserSkillsFromLocalMemory;
        mScreensNavigator = screensNavigator;
        mToastsHelper = toastsHelper;
        mHomePressDispatcher = homePressDispatcher;
    }

    public void bindView(SkillDetailsScreenViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }

    public void onStart(){

    }

    public void onResume(){
        mViewMvc.registerListener(this);
        //TODO: mFetchUserSkillsFromLocalMemory.registerListener(this);
        mHomePressDispatcher.registerListener(this);

        mViewMvc.showProgressIndication();
        //TODO: mFetchUserSkillsFromLocalMemory.fetchUserSkillsAndNotify();
    }

    public void onPause(){
        mViewMvc.unregisterListener(this);
        //TODO: mFetchUserSkillsFromLocalMemory.unregisterListener(this);
        mHomePressDispatcher.unregisterListener(this);
    }

    public void onStop(){

    }

    @Override
    public void onHomeClicked() {
        mScreensNavigator.toHome();
    }

    @Override
    public void onAchievementTabClicked() {
        mToastsHelper.showTemporaryNavigation("Achievement Tab");

    }

    @Override
    public void onAchievementClicked(Achievement achievement) {
        //mToastsHelper.showTemporaryNavigation("Achievement Tab");
    }

    @Override
    public void onGraphTabClicked() {
        mToastsHelper.showTemporaryNavigation("Graph Tab");
    }

    @Override
    public void onLogTabClicked() {
        mToastsHelper.showTemporaryNavigation("Log Tab");
    }

    @Override
    public void onLogClicked(Log log) {
        //mToastsHelper.showTemporaryNavigation("Log Tab");
    }

    @Override
    public void onAddClicked() {
        mToastsHelper.showTemporaryNavigation("Does nothing right now");
    }

    @Override
    public boolean onHomePressed() {
        mScreensNavigator.toHome();
        return false;
    }
}
