package galacticgames.android.skilltree.screens.skilldetails.achievementstab;

import galacticgames.android.skilltree.skill.achievement.Achievement;
import galacticgames.android.skilltree.common.screensnavigator.ScreensNavigator;
import galacticgames.android.skilltree.common.toastshelper.ToastsHelper;

//TODO: add impl for fetch achievements
//Potentially just get skills which will ideally have the achievements.
//Might have to pass in what skill it is from parent to get the achievement list.

public class AchievementsTabController implements AchievementsTabViewMvc.Listener{

    //TODO: private final FetchUserSkillsFromLocalMemory mFetchUserSkillsFromLocalMemory;
    private final ScreensNavigator mScreensNavigator;
    private final ToastsHelper mToastsHelper;

    public AchievementsTabViewMvc mViewMvc;

    public AchievementsTabController(
            //TODO: FetchUserSkillsFromLocalMemory fetchUserSkillsFromLocalMemory,
                                      ScreensNavigator screensNavigator,
                                      ToastsHelper toastsHelper){
        //TODO: mFetchUserSkillsFromLocalMemory = fetchUserSkillsFromLocalMemory;
        mScreensNavigator = screensNavigator;
        mToastsHelper = toastsHelper;
    }

    public void bindView(AchievementsTabViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }

    public void onStart(){

    }

    public void onResume(){
        mViewMvc.registerListener(this);
        //TODO mFetchUserSkillsFromLocalMemory.registerListener(this);

        mViewMvc.showProgressIndication();
        //TODO mFetchUserSkillsFromLocalMemory.fetchUserSkillsAndNotify();
    }

    public void onPause(){
        mViewMvc.unregisterListener(this);
        //TODO mFetchUserSkillsFromLocalMemory.unregisterListener(this);
    }

    public void onStop(){

    }

    //TODO: on achievements fetched. see userskillscreencontroller

    @Override
    public void onAchievementClicked(Achievement achievement) {
        mToastsHelper.showTemporaryNavigation("In Progress...");
    }

    @Override
    public void onHomeClicked() {

    }
}
