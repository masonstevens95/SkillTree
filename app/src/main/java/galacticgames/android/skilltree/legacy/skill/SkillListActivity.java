package galacticgames.android.skilltree.legacy.skill;

import android.content.Intent;
import android.support.v4.app.Fragment;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.SingleFragmentActivity;
import galacticgames.android.skilltree.legacy.log.LogListActivity;
import galacticgames.android.skilltree.legacy.log.LogListFragment;

public class SkillListActivity extends SingleFragmentActivity
            implements SkillListFragment.Callbacks {

    //public static final String EXTRA_SKILL_ID =
    //        "galacticgames.android.skilltree.skill_id";

    @Override
    protected Fragment createFragment(){
        return new SkillListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_twopane;
    }

    //we delegate a little more to the activity now that we have a two pane interface (currently
        //two fragments, soon to be three). Eventually SkillListFragment will call this in onClick.
    @Override
    public void onSkillSelected(Skill skill){
        if (findViewById(R.id.fragment_detail) == null){
            Intent intent = LogListActivity.newIntent(this, skill.getId());
            startActivity(intent);
        }else {
            Fragment newDetail = LogListFragment.newInstance(skill.getId());

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_detail, newDetail)
                    .commit();
        }
    }
}
