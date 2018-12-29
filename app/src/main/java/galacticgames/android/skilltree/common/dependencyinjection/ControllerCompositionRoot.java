package galacticgames.android.skilltree.common.dependencyinjection;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

import galacticgames.android.skilltree.common.screensnavigator.ScreensNavigator;
import galacticgames.android.skilltree.common.toastshelper.ToastsHelper;
import galacticgames.android.skilltree.screens.common.ViewMvcFactory;
import galacticgames.android.skilltree.screens.common.controllers.BackPressDispatcher;
import galacticgames.android.skilltree.screens.common.controllers.HomePressDispatcher;
import galacticgames.android.skilltree.screens.common.fragmentframehelper.FragmentFrameHelper;
import galacticgames.android.skilltree.screens.common.fragmentframehelper.FragmentFrameWrapper;
import galacticgames.android.skilltree.screens.homescreen.HomeScreenController;
import galacticgames.android.skilltree.screens.tempnewskillscreen.NewSkillScreenController;
import galacticgames.android.skilltree.screens.userskills.UserSkillsScreenController;
import galacticgames.android.skilltree.skills.FetchUserSkillsFromLocalMemory;
import galacticgames.android.skilltree.skills.SkillRepository;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private final FragmentActivity mActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, FragmentActivity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    private FragmentActivity getActivity() {
        return mActivity;
    }

    private Context getContext() {
        return mActivity;
    }

    private FragmentManager getFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(getContext());
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }

//    public FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase() {
//        return new FetchQuestionDetailsUseCase(getStackoverflowApi());
//    }
//
//    public FetchLastActiveQuestionsUseCase getFetchLastActiveQuestionsUseCase() {
//        return new FetchLastActiveQuestionsUseCase(getStackoverflowApi());
//    }

    public ToastsHelper getToastsHelper() {
        return new ToastsHelper(getContext());
    }

    public ScreensNavigator getScreensNavigator() {
        return new ScreensNavigator(getFragmentFrameHelper());
    }

    private FragmentFrameHelper getFragmentFrameHelper() {
        return new FragmentFrameHelper(getActivity(), getFragmentFrameWrapper(), getFragmentManager());
    }

    private FragmentFrameWrapper getFragmentFrameWrapper() {
        return (FragmentFrameWrapper) getActivity();
    }

    public BackPressDispatcher getBackPressDispatcher() {
        return (BackPressDispatcher) getActivity();
    }

    private HomePressDispatcher getHomePressDispatcher() {
        return (HomePressDispatcher) getActivity();
    }

    public HomeScreenController getHomeScreenController() {
        return new HomeScreenController(
                getScreensNavigator(),
                getToastsHelper()
        );
    }

    public SkillRepository getSkillRepository(){
        return new SkillRepository(getContext());
    }

    public FetchUserSkillsFromLocalMemory getFetchUserSkillsFromLocalMemory() {
        return new FetchUserSkillsFromLocalMemory(getSkillRepository());
    }

    public UserSkillsScreenController getUserSkillsScreenController() {
        return new UserSkillsScreenController(
                getFetchUserSkillsFromLocalMemory(),
                getScreensNavigator(),
                getToastsHelper(),
                getHomePressDispatcher()
        );
    }

    //must be async -- skill repository must run on separate thread
    public NewSkillScreenController getNewSkillScreenController() {
        return new NewSkillScreenController(
            getScreensNavigator(),
            getToastsHelper(),
            getHomePressDispatcher(),
            getSkillRepository()
        );
    }
}
