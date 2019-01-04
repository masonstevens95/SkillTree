package galacticgames.android.skilltree.screens.skilldetails.logstab;

import galacticgames.android.skilltree.common.screensnavigator.ScreensNavigator;
import galacticgames.android.skilltree.common.toastshelper.ToastsHelper;
import galacticgames.android.skilltree.log.Log;

//TODO: add impl for fetch Logs

public class LogsTabController implements LogsTabViewMvc.Listener{

    //TODO: private final FetchUserSkillsFromLocalMemory mFetchUserSkillsFromLocalMemory;
    private final ScreensNavigator mScreensNavigator;
    private final ToastsHelper mToastsHelper;

    public LogsTabViewMvc mViewMvc;

    public LogsTabController(
            //TODO: FetchUserSkillsFromLocalMemory fetchUserSkillsFromLocalMemory,
            ScreensNavigator screensNavigator,
            ToastsHelper toastsHelper){
        //TODO: mFetchUserSkillsFromLocalMemory = fetchUserSkillsFromLocalMemory;
        mScreensNavigator = screensNavigator;
        mToastsHelper = toastsHelper;
    }

    public void bindView(LogsTabViewMvc viewMvc) {
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

    //TODO: on logs fetched. see userskillscreencontroller



    @Override
    public void onLogClicked(Log log) {
        mToastsHelper.showTemporaryNavigation("In Progress...");
    }

    @Override
    public void onNewLogClicked() {

    }

    @Override
    public void onHomeClicked() {

    }
}
