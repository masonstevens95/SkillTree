package galacticgames.android.skilltree.skills;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SkillsSchema {

    @SerializedName("title")
    private final String mTitle;

    @SerializedName("skill_id")
    private final String mId;

    @SerializedName("achievements")
    private final List<Achievements> mAchievementsList;

    public SkillsSchema(String title, String id, List<Achievements> achievements) {
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

    public List<Achievements> getAchievementsList(){
        return mAchievementsList;
    }
}
