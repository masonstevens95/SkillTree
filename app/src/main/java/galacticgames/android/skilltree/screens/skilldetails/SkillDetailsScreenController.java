package galacticgames.android.skilltree.screens.skilldetails;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.common.screensnavigator.ScreensNavigator;
import galacticgames.android.skilltree.common.toastshelper.ToastsHelper;
import galacticgames.android.skilltree.screens.common.controllers.HomePressDispatcher;
import galacticgames.android.skilltree.screens.common.controllers.HomePressedListener;
import galacticgames.android.skilltree.screens.skilldetails.achievementstab.AchievementsTabFragment;
import galacticgames.android.skilltree.screens.skilldetails.graphtab.GraphTabFragment;
import galacticgames.android.skilltree.screens.skilldetails.logstab.LogsTabFragment;

//TODO: add fetch Logs and Achievements from local memory
public class SkillDetailsScreenController implements SkillDetailsScreenViewMvc.Listener,
        HomePressedListener {

    //TODO: private final FetchUserSkillsFromLocalMemory mFetchUserSkillsFromLocalMemory;
    private final ScreensNavigator mScreensNavigator;
//    private final ScreensNavigator mTabsScreensNavigator;
    private final ToastsHelper mToastsHelper;
    private final HomePressDispatcher mHomePressDispatcher;
    private final FragmentManager mFragmentManager;

    public SkillDetailsScreenViewMvc mViewMvc;

    public SkillDetailsScreenController(
            //TODO: FetchUserSkillsFromLocalMemory fetchUserSkillsFromLocalMemory,
                                      ScreensNavigator screensNavigator,
                                      ToastsHelper toastsHelper,
                                      HomePressDispatcher homePressDispatcher,
                                        FragmentManager fragmentManager){
        //TODO: mFetchUserSkillsFromLocalMemory = fetchUserSkillsFromLocalMemory;
        mScreensNavigator = screensNavigator;
        mToastsHelper = toastsHelper;
        mHomePressDispatcher = homePressDispatcher;
        mFragmentManager = fragmentManager;
    }

    public void bindView(SkillDetailsScreenViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }

    public void onStart(){

        Fragment fragment = AchievementsTabFragment.newInstance();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.tab_container, fragment);
        transaction.commit();

    }

    public void onResume(){
        mViewMvc.registerListener(this);
        //TODO: mFetchUserSkillsFromLocalMemory.registerListener(this);
        mHomePressDispatcher.registerListener(this);

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
        //mToastsHelper.showTemporaryNavigation("Achievement Tab");
        Fragment fragment = AchievementsTabFragment.newInstance();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.tab_container, fragment);
        transaction.commit();
    }

    @Override
    public void onGraphTabClicked() {
        //mToastsHelper.showTemporaryNavigation("Graph Tab");
        Fragment fragment = GraphTabFragment.newInstance();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.tab_container, fragment);
        transaction.commit();
    }

    @Override
    public void onLogTabClicked() {
        //mToastsHelper.showTemporaryNavigation("Log Tab");
        Fragment fragment = LogsTabFragment.newInstance();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.tab_container, fragment);
        transaction.commit();
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
