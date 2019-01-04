package galacticgames.android.skilltree.screens.skilldetails.graphtab;

import galacticgames.android.skilltree.common.screensnavigator.ScreensNavigator;
import galacticgames.android.skilltree.common.toastshelper.ToastsHelper;

public class GraphTabController
        implements GraphTabViewMvc.Listener{

    //TODO: private final FetchUserSkillsFromLocalMemory mFetchUserSkillsFromLocalMemory;
    private final ScreensNavigator mScreensNavigator;
    private final ToastsHelper mToastsHelper;

    public GraphTabViewMvc mViewMvc;

    public GraphTabController(
            //TODO: FetchUserSkillsFromLocalMemory fetchUserSkillsFromLocalMemory,
            ScreensNavigator screensNavigator,
            ToastsHelper toastsHelper){
        //TODO: mFetchUserSkillsFromLocalMemory = fetchUserSkillsFromLocalMemory;
        mScreensNavigator = screensNavigator;
        mToastsHelper = toastsHelper;
    }

    public void bindView(GraphTabViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }

    public void onStart(){

    }

    public void onResume(){
        mViewMvc.registerListener(this);
        //TODO mFetchUserSkillsFromLocalMemory.registerListener(this);

        //TODO mFetchUserSkillsFromLocalMemory.fetchUserSkillsAndNotify();
    }

    public void onPause(){
        mViewMvc.unregisterListener(this);
        //TODO mFetchUserSkillsFromLocalMemory.unregisterListener(this);
    }

    public void onStop(){

    }



}
