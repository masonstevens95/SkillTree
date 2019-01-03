package galacticgames.android.skilltree.skill;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class SkillRepository {

    private static SkillDao mSkillDao;
    private static List<Skill> mAllSkills;

    public SkillRepository(Context context){
        SkillRoomDatabase db = SkillRoomDatabase.getDatabase(context);
        mSkillDao = db.mSkillDao();
        //TODO: fix this terrible hack-y solution. This will block main thread if there are a bunch of skills
        try {
            mAllSkills = new getAllSkillsAsyncTask(mSkillDao).execute().get();
        }catch (Exception e){
            Log.e("SKILREPO", "Exception: " + e);
        }
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

    private static class getAllSkillsAsyncTask extends AsyncTask<Void, Void, List<Skill>> {

        private SkillDao mAsyncTaskDao;

        getAllSkillsAsyncTask(SkillDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected List<Skill> doInBackground(Void... voids) {
            return mAsyncTaskDao.getAllSkills();
        }
    }

}
