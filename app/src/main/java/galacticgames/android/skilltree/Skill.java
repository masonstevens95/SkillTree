/*

8/16/18: Created. Thinking about making a seperate Class for log items, but needs to be able to
    inherit from this class?

 */



package galacticgames.android.skilltree;

import java.util.UUID;

public class Skill {

    private UUID mId;
    private String mTitle;

    @Override
    public String toString() {
        return getTitle(); // You can add anything else like maybe getDrinkType()
    }

    //constructor
    public Skill(){
        this(UUID.randomUUID());
    }

    public Skill(UUID id){
        mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
