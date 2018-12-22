package galacticgames.android.skilltree.legacy.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;
import java.util.UUID;

import galacticgames.android.skilltree.legacy.log.Log;
import galacticgames.android.skilltree.legacy.skill.Skill;
import galacticgames.android.skilltree.legacy.database.LogDbSchema.LogTable;

public class LogCursorWrapper extends CursorWrapper {

    public LogCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Log getLog(){
        String uuidString = getString(getColumnIndex(LogTable.Cols.UUID));
        String skillString = getString(getColumnIndex(LogTable.Cols.SKILLUUID));
        int hours = getInt(getColumnIndex(LogTable.Cols.HOURS));
        int minutes = getInt(getColumnIndex(LogTable.Cols.MINUTES));
        long date = getLong(getColumnIndex(LogTable.Cols.DATE));
        String notesString = getString(getColumnIndex(LogTable.Cols.NOTES));

        Log log = new Log(UUID.fromString(uuidString));
        Skill skill = new Skill(UUID.fromString(skillString));

        log.setSkill(skill);
        log.setHours(hours);
        log.setMinutes(minutes);
        log.setDate(new Date(date));
        log.setNotes(notesString);

        return log;
    }

}
