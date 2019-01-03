package galacticgames.android.skilltree.skill;

import android.util.Log;

import java.util.List;

import galacticgames.android.skilltree.common.BaseObservable;

public class FetchUserSkillsFromLocalMemory extends BaseObservable<FetchUserSkillsFromLocalMemory.Listener> {

    public interface Listener{
        void onUserSkillsFetched(List<Skill> skills);
        void onUserSkillsFetchFailed();
    }

    private SkillRepository mRepository;
    private List<Skill> mAllSkills;

    public FetchUserSkillsFromLocalMemory(SkillRepository skillRepository){
        //need this?
        mRepository = skillRepository;
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
