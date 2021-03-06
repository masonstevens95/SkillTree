package galacticgames.android.skilltree.screens.tempnewskill;

import java.util.Random;
import java.util.UUID;

import galacticgames.android.skilltree.common.screensnavigator.ScreensNavigator;
import galacticgames.android.skilltree.common.toastshelper.ToastsHelper;
import galacticgames.android.skilltree.screens.common.controllers.HomePressDispatcher;
import galacticgames.android.skilltree.screens.common.controllers.HomePressedListener;
import galacticgames.android.skilltree.skill.Skill;
import galacticgames.android.skilltree.skill.SkillRepository;

public class NewSkillScreenController implements NewSkillScreenViewMvc.Listener, HomePressedListener {

    private final ScreensNavigator mScreensNavigator;
    private final ToastsHelper mToastsHelper;
    private final HomePressDispatcher mHomePressDispatcher;
    private final SkillRepository mSkillRepository;

    public NewSkillScreenViewMvc mViewMvc;

    public NewSkillScreenController(ScreensNavigator screensNavigator,
                                    ToastsHelper toastsHelper,
                                    HomePressDispatcher homePressDispatcher,
                                    SkillRepository skillRepository){

        mScreensNavigator = screensNavigator;
        mToastsHelper = toastsHelper;
        mHomePressDispatcher = homePressDispatcher;
        mSkillRepository = skillRepository;
    }

    public void bindView(NewSkillScreenViewMvc viewMvc) {
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
    public void onSaveClicked(String s) {
        if (s.isEmpty()){
            mToastsHelper.showEmptyEditTextError();
        }else{
            Skill skill = new Skill(s);
            insert(skill);
        }

        mScreensNavigator.navigateUp();
    }

    public void insert(Skill skill) {
        mSkillRepository.insert(skill);
    }

    @Override
    public boolean onHomePressed() {
        mScreensNavigator.toHome();
        return false;
    }

}
