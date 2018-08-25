package galacticgames.android.skilltree.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import galacticgames.android.skilltree.database.LogDbSchema.LogTable;

public class LogBaseHelper extends SQLiteOpenHelper{

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "logBase.db";

    //constructor to check version, upgrade version, create database if it doesnt exist
    public LogBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + LogTable.NAME + "(" +
            " _id integer primary key autoincrement, " +
                LogTable.Cols.UUID + ", " +
                LogTable.Cols.SKILLUUID + ", " +
                LogTable.Cols.HOURS + ", " +
                LogTable.Cols.MINUTES + ", " +
                LogTable.Cols.DATE + ", " +
                LogTable.Cols.NOTES + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
