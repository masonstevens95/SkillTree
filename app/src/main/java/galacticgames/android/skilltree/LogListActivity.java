package galacticgames.android.skilltree;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class LogListActivity extends SingleFragmentActivity{

    private static final String EXTRA_SKILL_ID =
            "galacticgames.android.skilltree.skill_id";

    public static Intent newIntent(Context packageContext, UUID skillId){
        Intent intent = new Intent(packageContext, SkillListActivity.class);
        intent.putExtra(EXTRA_SKILL_ID, skillId);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        UUID logId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_SKILL_ID);

        return LogListFragment.newInstance(logId);
    }

}
