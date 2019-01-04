package galacticgames.android.skilltree.skill;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

@Entity(tableName = "skill_table")
public class Skill {

    //TODO: maybe make an abstraction where Skills is from server side and UserSkill inherits and can take log time values/ achievements

//    private UUID mId;
    //TODO: figure out if i want uuid or just string ids

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String mId;

    @ColumnInfo(name = "title")
    private final String mTitle;

    @Override
    public String toString() {
        return getTitle(); // You can add anything else like maybe getDrinkType()
    }

    //constructor
    public Skill(String title){
        mId = UUID.randomUUID().toString();
        mTitle = title;
    }

//    public Skill(UUID id){
//        mId = id;
//    }
//
//    public UUID getId() {
//        return mId;
//    }

    public void setId(String id){
        //mId = id;
    }

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