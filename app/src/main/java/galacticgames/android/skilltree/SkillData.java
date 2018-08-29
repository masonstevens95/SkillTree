/*

This is the singleton for all skills that a user will have.

8/16/18: Created, added a list of potential dummy skills to constructor

 */

package galacticgames.android.skilltree;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import galacticgames.android.skilltree.database.SkillBaseHelper;
import galacticgames.android.skilltree.database.SkillCursorWrapper;
import galacticgames.android.skilltree.database.SkillDbSchema;
import galacticgames.android.skilltree.database.SkillDbSchema.SkillTable;

public class SkillData {
    private static SkillData sSkillData;

    //not ecessary with SQL db:  private List<Skill> mSkills;

    //for database
    private Context mContext;
    private SQLiteDatabase mDatabase;

    //get method, only allows one to be built
    public static SkillData get(Context context){
        if (sSkillData == null){
            sSkillData = new SkillData(context);
        }

        return sSkillData;
    }

    //constructor
    private SkillData(Context context) {
        //make new database using the helper
        mContext = context.getApplicationContext();
        mDatabase = new SkillBaseHelper(mContext)
                .getWritableDatabase();
    }

    public void addSkill(Skill skill){
        ContentValues values = getContentValues(skill);

        mDatabase.insert(SkillTable.NAME, null, values);
    }

    public List<Skill> getSkills(){
        List<Skill> skills = new ArrayList<>();

        SkillCursorWrapper cursor = querySkills(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                skills.add(cursor.getSkill());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return skills;
    }

    public Skill getSkill(UUID id){
        SkillCursorWrapper cursor = querySkills(
                SkillTable.Cols.UUID + " = ?",
                new String[] {id.toString()}
        );

        try {
            if (cursor.getCount() == 0){
                return null;
            }

            cursor.moveToFirst();
            return cursor.getSkill();
        }finally {
            cursor.close();
        }
    }

    public void updateSkill(Skill skill){
        String uuidString = skill.getId().toString();
        ContentValues values = getContentValues(skill);

        mDatabase.update(SkillTable.NAME, values,
                SkillTable.Cols.UUID + " = ?",
                new String[] {uuidString});

    }

    private SkillCursorWrapper querySkills(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                SkillDbSchema.SkillTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new SkillCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Skill skill){
        ContentValues values = new ContentValues();
        values.put(SkillTable.Cols.UUID, skill.getId().toString());
        values.put(SkillTable.Cols.TITLE, skill.getTitle());

        return values;
    }
}
