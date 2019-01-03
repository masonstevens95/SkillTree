package galacticgames.android.skilltree.screens.userskills;

import java.util.List;

import galacticgames.android.skilltree.common.screensnavigator.ScreensNavigator;
import galacticgames.android.skilltree.common.toastshelper.ToastsHelper;
import galacticgames.android.skilltree.screens.common.controllers.HomePressDispatcher;
import galacticgames.android.skilltree.screens.common.controllers.HomePressedListener;
import galacticgames.android.skilltree.skill.FetchUserSkillsFromLocalMemory;
import galacticgames.android.skilltree.skill.Skill;

public class UserSkillsScreenController implements UserSkillsScreenViewMvc.Listener,
        FetchUserSkillsFromLocalMemory.Listener,
        HomePressedListener {

    private final FetchUserSkillsFromLocalMemory mFetchUserSkillsFromLocalMemory;
    private final ScreensNavigator mScreensNavigator;
    private final ToastsHelper mToastsHelper;
    private final HomePressDispatcher mHomePressDispatcher;

    public UserSkillsScreenViewMvc mViewMvc;

    public UserSkillsScreenController(FetchUserSkillsFromLocalMemory fetchUserSkillsFromLocalMemory,
                            ScreensNavigator screensNavigator,
                             ToastsHelper toastsHelper,
                             HomePressDispatcher homePressDispatcher){
        mFetchUserSkillsFromLocalMemory = fetchUserSkillsFromLocalMemory;
        mScreensNavigator = screensNavigator;
        mToastsHelper = toastsHelper;
        mHomePressDispatcher = homePressDispatcher;
    }

    public void bindView(UserSkillsScreenViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }

    public void onStart(){

    }

    public void onResume(){
        mViewMvc.registerListener(this);
        mFetchUserSkillsFromLocalMemory.registerListener(this);
        mHomePressDispatcher.registerListener(this);

        mViewMvc.showProgressIndication();
        mFetchUserSkillsFromLocalMemory.fetchUserSkillsAndNotify();
    }

    public void onPause(){
        mViewMvc.unregisterListener(this);
        mFetchUserSkillsFromLocalMemory.unregisterListener(this);
        mHomePressDispatcher.unregisterListener(this);
    }

    public void onStop(){

    }

    @Override
    public void onHomeClicked() {
        mScreensNavigator.toHome();
    }

    @Override
    public void onSkillClicked(Skill skill) {
        //TODO: mScreensNavigator.toSkillDetails(skill.getId());
        //mToastsHelper.showTemporaryNavigation("SkillDetails, " + skill.getTitle());
        mScreensNavigator.toSkillDetails(skill.getId());
    }

    @Override
    public void onNewSkillClicked() {
        mScreensNavigator.toNewSkillScreen();
    }

    @Override
    public void onSkillListClicked() {
        //this is user skill list screen - no operation
    }

    //TODO: bindSkills
    @Override
    public void onUserSkillsFetched(List<Skill> skills) {
        mViewMvc.hideProgressIndication();
        mViewMvc.bindSkills(skills);
    }

    @Override
    public void onUserSkillsFetchFailed() {
        mViewMvc.hideProgressIndication();
        mToastsHelper.showUseCaseError();
    }

    @Override
    public boolean onHomePressed() {
        //TODO: nav to home, pop all off stack
        mScreensNavigator.toHome();
        return false;
    }
}
