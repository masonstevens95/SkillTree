package galacticgames.android.skilltree.legacy.log;

import java.util.Date;
import java.util.UUID;

import galacticgames.android.skilltree.legacy.skill.Skill;

public class Log {

    private UUID mId;
    private Skill mSkill;
    private int mHours;
    private int mMinutes;
    private Date mDate;
    private String mNotes;

    //constructor
    public Log(){
        this(UUID.randomUUID());
    }

    //constructor
    public Log(UUID id){
        mId = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public Skill getSkill() {
        return mSkill;
    }

    public void setSkill(Skill skill) {
        mSkill = skill;
    }

    public int getHours() {
        return mHours;
    }

    public void setHours(int hours) {
        mHours = hours;
    }

    public int getMinutes() {
        return mMinutes;
    }

    public void setMinutes(int minutes) {
        mMinutes = minutes;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getNotes() {
        return mNotes;
    }

    public void setNotes(String notes) {
        mNotes = notes;
    }
}
