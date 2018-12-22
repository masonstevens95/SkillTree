package galacticgames.android.skilltree.legacy.skill;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

import galacticgames.android.skilltree.SingleFragmentActivity;

public class SkillActivity extends SingleFragmentActivity {

    private static final String EXTRA_SKILL_ID =
            "galacticgames.android.skilltree.skill_id";

    public static Intent newIntent(Context packageContext, UUID skillId){
        //where does it come from?
        Intent intent = new Intent(packageContext, SkillActivity.class);
        intent.putExtra(EXTRA_SKILL_ID, skillId);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        UUID skillId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_SKILL_ID);

        return SkillFragment.newInstance(skillId);
    }

}
