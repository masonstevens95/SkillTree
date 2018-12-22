package galacticgames.android.skilltree.legacy.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SkillBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "skillBase.db";

    //constructor to check version, upgrade version, create database if it doesnt exist
    public SkillBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + SkillDbSchema.SkillTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                SkillDbSchema.SkillTable.Cols.UUID + ", " +
                SkillDbSchema.SkillTable.Cols.TITLE + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
