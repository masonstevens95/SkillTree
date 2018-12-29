package galacticgames.android.skilltree.skills;

import android.app.Application;
import android.content.Context;
import android.util.Log;

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
    public FetchUserSkillsFromLocalMemory(Context context){
        //need this?
        mRepository = new SkillRepository(context);
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
            Log.e("FetchUserSkills", "Fetch error: " + e);
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
