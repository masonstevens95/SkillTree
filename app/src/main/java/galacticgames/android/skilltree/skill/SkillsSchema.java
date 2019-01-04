package galacticgames.android.skilltree.skill;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import galacticgames.android.skilltree.skill.achievement.Achievement;

public class SkillsSchema {

    @SerializedName("title")
    private final String mTitle;

    @SerializedName("skill_id")
    private final String mId;

    @SerializedName("achievements")
    private final List<Achievement> mAchievementsList;

    public SkillsSchema(String title, String id, List<Achievement> achievements) {
        mTitle = title;
        mId = id;
        mAchievementsList = achievements;
    }

    public String getTitle(){
        return mTitle;
    }

    public String getId() {
        return mId;
    }

    public List<Achievement> getAchievementsList(){
        return mAchievementsList;
    }
}
