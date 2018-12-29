package galacticgames.android.skilltree.skills;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Skill.class}, version = 1)
public abstract class SkillRoomDatabase extends RoomDatabase {

    public abstract SkillDao mSkillDao();

    private static volatile SkillRoomDatabase INSTANCE;

    static SkillRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SkillRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SkillRoomDatabase.class, "skill_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final SkillDao mDao;

        PopulateDbAsync(SkillRoomDatabase db) {
            mDao = db.mSkillDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            Skill skill = new Skill("aaaaaa", "Climbing");
            mDao.insert(skill);
            skill = new Skill("aaaaab", "Snowboarding");
            mDao.insert(skill);
            return null;
        }
    }

}
