package galacticgames.android.skilltree.common.screensnavigator;


import galacticgames.android.skilltree.screens.common.fragmentframehelper.FragmentFrameHelper;
import galacticgames.android.skilltree.screens.home.HomeScreenFragment;
import galacticgames.android.skilltree.screens.skilldetails.SkillDetailsScreenFragment;
import galacticgames.android.skilltree.screens.tempnewskill.NewSkillFragment;
import galacticgames.android.skilltree.screens.userskills.UserSkillsScreenFragment;

public class ScreensNavigator {

    private FragmentFrameHelper mFragmentFrameHelper;

    public ScreensNavigator(FragmentFrameHelper fragmentFrameHelper) {
        mFragmentFrameHelper = fragmentFrameHelper;
    }

//    public void toQuestionDetails(String questionId) {
//        mFragmentFrameHelper.replaceFragment(QuestionDetailsFragment.newInstance(questionId));
//    }



    public void navigateUp() {
        mFragmentFrameHelper.navigateUp();
    }

    public void toHome() {
        mFragmentFrameHelper.replaceFragmentAndClearBackstack(HomeScreenFragment.newInstance());
    }

    public void toUserSkillList() {
        mFragmentFrameHelper.replaceFragment(UserSkillsScreenFragment.newInstance());
    }

    public void toNewSkillScreen() {
        mFragmentFrameHelper.replaceFragment(NewSkillFragment.newInstance());
    }

    public void toSkillDetails(String id) {
        mFragmentFrameHelper.replaceFragment(SkillDetailsScreenFragment.newInstance());
    }

    //TODO: enable this when layout is ready
//    public void toSkillDetails(String id) {
//        mFragmentFrameHelper.replaceFragment(UserSkillsDetailsScreenFragment.newInstance(id));
//    }
}
