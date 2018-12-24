package galacticgames.android.skilltree.skills;

import java.util.UUID;


public class Skill {

    //TODO: maybe make an abstraction where Skills is from server side and UserSkill inherits and can take log time values/ achievements



//    private UUID mId;
    //TODO: figure out if i want uuid or just string ids

    private final String mId;

    private final String mTitle;

    @Override
    public String toString() {
        return getTitle(); // You can add anything else like maybe getDrinkType()
    }

    //constructor
    public Skill(String id, String title){
//        this(UUID.randomUUID());
        mId = id;
        mTitle = title;
    }

//    public Skill(UUID id){
//        mId = id;
//    }
//
//    public UUID getId() {
//        return mId;
//    }

    public String getId(){
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }
//
//    public void setTitle(String title) {
//        mTitle = title;
//    }
}