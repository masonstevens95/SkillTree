package galacticgames.android.skilltree.screens.userskills;

import galacticgames.android.skilltree.common.screensnavigator.ScreensNavigator;
import galacticgames.android.skilltree.common.toastshelper.ToastsHelper;
import galacticgames.android.skilltree.screens.common.controllers.HomePressDispatcher;
import galacticgames.android.skilltree.screens.common.controllers.HomePressedListener;
import galacticgames.android.skilltree.skills.Skill;

public class UserSkillsScreenController implements UserSkillsScreenViewMvc.Listener, HomePressedListener {

    private final ScreensNavigator mScreensNavigator;
    private final ToastsHelper mToastsHelper;
    private final HomePressDispatcher mHomePressDispatcher;

    public UserSkillsScreenViewMvc mViewMvc;

    public UserSkillsScreenController(ScreensNavigator screensNavigator,
                             ToastsHelper toastsHelper,
                             HomePressDispatcher homePressDispatcher){
        mScreensNavigator = screensNavigator;
        mToastsHelper = toastsHelper;
        mHomePressDispatcher = homePressDispatcher;
    }

    public void bindView(UserSkillsScreenViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }

    public void onStart(){
        mViewMvc.registerListener(this);
        mHomePressDispatcher.registerListener(this);

        mViewMvc.showProgressIndication();
    }

    public void onStop(){
        mViewMvc.unregisterListener(this);
        mHomePressDispatcher.unregisterListener(this);
    }

    @Override
    public void onHomeClicked() {
        mScreensNavigator.toHome();
    }

    @Override
    public void onSkillClicked(Skill skill) {
//TODO:        mScreensNavigator.toSkillDetails(skill.getId());
        mToastsHelper.showTemporaryNavigation("SkillDetails, " + skill.getTitle());
    }

    @Override
    public void onSkillListClicked() {
        //this is user skill list screen - no operation
    }

    @Override
    public boolean onHomePressed() {
        //TODO: nav to home, pop all off stack
        mScreensNavigator.toHome();
        return false;
    }
}
