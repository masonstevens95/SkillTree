/*

This is the singleton for all skills that a user will have.

8/16/18: Created, added a list of potential dummy skills to constructor

 */

package galacticgames.android.skilltree;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SkillData {
    private static SkillData sSkillData;

    private List<Skill> mSkills;

    //get method, only allows one to be built
    public static SkillData get(Context context){
        if (sSkillData == null){
            sSkillData = new SkillData(context);
        }

        return sSkillData;
    }

    //constructor
    private SkillData(Context context) {
        mSkills = new ArrayList<>();

        //quick list of 10 dummy skills
        for(int i = 0; i < 10; i++){
            Skill skill = new Skill();
            skill.setTitle("Skill #" + i);
            mSkills.add(skill);
        }
    }

    public List<Skill> getSkills(){
        return mSkills;
    }

    public Skill getSkill(UUID id){
        for (Skill skill : mSkills){
            if (skill.getId().equals(id)){
                return skill;
            }
        }

        return null;
    }
}
