package galacticgames.android.skilltree.legacy.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.UUID;

import galacticgames.android.skilltree.legacy.skill.Skill;

public class SkillCursorWrapper extends CursorWrapper {

    public SkillCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Skill getSkill(){
        String uuidString = getString(getColumnIndex(SkillDbSchema.SkillTable.Cols.UUID));
        String titleString = getString(getColumnIndex(SkillDbSchema.SkillTable.Cols.TITLE));

        Skill skill = new Skill(UUID.fromString(uuidString));
        skill.setTitle(titleString);

        return skill;
    }

}
