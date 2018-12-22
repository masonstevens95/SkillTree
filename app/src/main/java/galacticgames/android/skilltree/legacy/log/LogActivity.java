package galacticgames.android.skilltree.legacy.log;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

import galacticgames.android.skilltree.SingleFragmentActivity;

public class LogActivity extends SingleFragmentActivity {

    private static final String EXTRA_LOG_ID =
            "galacticgames.android.skilltree.log_id";

    public static Intent newIntent(Context packageContext, UUID logId){
        //where does it come from?
        Intent intent = new Intent(packageContext, LogActivity.class);
        intent.putExtra(EXTRA_LOG_ID, logId);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        UUID logId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_LOG_ID);

        return LogFragment.newInstance(logId);
    }

}
