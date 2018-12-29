package galacticgames.android.skilltree.skills;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class SkillRepository {

    private SkillDao mSkillDao;
    private static List<Skill> mAllSkills;

    //trying to replace Application with Context
//    public SkillRepository(Application application){
//        SkillRoomDatabase db = SkillRoomDatabase.getDatabase(application);
//        mSkillDao = db.mSkillDao();
//        mAllSkills = mSkillDao.getAllSkills();
//    }

    public SkillRepository(Context context){
        SkillRoomDatabase db = SkillRoomDatabase.getDatabase(context);
        mSkillDao = db.mSkillDao();
        new getAllSkillsAsyncTask(mSkillDao).execute();
    }

    List<Skill> getAllSkills() {
        return mAllSkills;
    }

    public void insert (Skill skill) {
        new insertAsyncTask(mSkillDao).execute(skill);
    }

    private static class insertAsyncTask extends AsyncTask<Skill, Void, Void> {

        private SkillDao mAsyncTaskDao;

        insertAsyncTask(SkillDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Skill... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class getAllSkillsAsyncTask extends AsyncTask<Void, Void, Void> {

        private SkillDao mAsyncTaskDao;

        getAllSkillsAsyncTask(SkillDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAllSkills = mAsyncTaskDao.getAllSkills();
            return null;
        }
    }

}
