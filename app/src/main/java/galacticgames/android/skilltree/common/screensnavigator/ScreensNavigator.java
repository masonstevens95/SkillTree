package galacticgames.android.skilltree.common.screensnavigator;


import galacticgames.android.skilltree.screens.common.fragmentframehelper.FragmentFrameHelper;

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
}
