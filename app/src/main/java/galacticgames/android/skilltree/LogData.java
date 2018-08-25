package galacticgames.android.skilltree;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import galacticgames.android.skilltree.database.LogBaseHelper;
import galacticgames.android.skilltree.database.LogCursorWrapper;
import galacticgames.android.skilltree.database.LogDbSchema;
import galacticgames.android.skilltree.database.LogDbSchema.LogTable;

public class LogData {

    private static LogData sLogData;

    // not necessary with db: private List<Log> mLogs;

    //for database
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private Skill skill;

    //get method, only allows one to be built
    public static LogData get(Context context){
        if (sLogData == null){
            sLogData = new LogData(context);
        }

        return sLogData;
    }

    //constructor
    private LogData(Context context) {
        //make new database using the helper
        mContext = context.getApplicationContext();
        mDatabase = new LogBaseHelper(mContext)
                .getWritableDatabase();
    }

    //adding the ability to add logs
    public void addLog(Log log, Skill skill){
        ContentValues values = getContentValues(log, skill);

        mDatabase.insert(LogTable.NAME, null, values);
    }

    public List<Log> getLogs(){
        List<Log> logs = new ArrayList<>();

        LogCursorWrapper cursor = queryLogs(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                logs.add(cursor.getLog());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return logs;
    }

    public Log getLog(UUID id){
        LogCursorWrapper cursor = queryLogs(
                LogTable.Cols.UUID + " = ?",
                new String[] {id.toString()}
        );

        try {
            if (cursor.getCount() == 0){
                return null;
            }

            cursor.moveToFirst();
            return cursor.getLog();
        }finally {
            cursor.close();
        }
    }

    public void updateLog(Log log){
        String uuidString = log.getId().toString();
        ContentValues values = getContentValues(log, log.getSkill());

        mDatabase.update(LogTable.NAME, values,
                LogTable.Cols.UUID + " = ?",
                new String[] {uuidString});


    }

    private LogCursorWrapper queryLogs(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                LogTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new LogCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Log log, Skill skill){
        ContentValues values = new ContentValues();
        values.put(LogTable.Cols.UUID, log.getId().toString());
        values.put(LogTable.Cols.SKILLUUID, skill.getId().toString());
        values.put(LogTable.Cols.HOURS, log.getHours());
        values.put(LogTable.Cols.MINUTES, log.getMinutes());
        values.put(LogTable.Cols.DATE, log.getDate().getTime());
        values.put(LogTable.Cols.NOTES, log.getNotes());

        return values;
    }

}
