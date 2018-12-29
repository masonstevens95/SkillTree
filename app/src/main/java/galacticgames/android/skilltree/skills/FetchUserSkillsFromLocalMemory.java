package galacticgames.android.skilltree.skills;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import galacticgames.android.skilltree.common.BaseObservable;

public class FetchUserSkillsFromLocalMemory extends BaseObservable<FetchUserSkillsFromLocalMemory.Listener> {

    public interface Listener{
        void onUserSkillsFetched(List<Skill> skills);
        void onUserSkillsFetchFailed();
    }

    //instead of stackoverflowAPI, do i use room?
    private SkillRepository mRepository;
    private List<Skill> mAllSkills;

    //TODO: populate constructor... check if application is what we need
    public FetchUserSkillsFromLocalMemory(Application application){
        //need this?
        mRepository = new SkillRepository(application);
        mAllSkills = mRepository.getAllSkills();
    }

    List<Skill> getAllSkills() {
        return mAllSkills;
    }

    public void fetchUserSkillsAndNotify() {
        try {
            mAllSkills = mRepository.getAllSkills();
            notifySuccess(mAllSkills);
        } catch (Exception e){
            notifyFailure();
        }
    }

    private void notifyFailure() {
        for (Listener listener : getListeners()){
            listener.onUserSkillsFetchFailed();
        }
    }

    private void notifySuccess(List<Skill> skills) {
        for (Listener listener : getListeners()) {
            listener.onUserSkillsFetched(skills);
        }
    }
}
