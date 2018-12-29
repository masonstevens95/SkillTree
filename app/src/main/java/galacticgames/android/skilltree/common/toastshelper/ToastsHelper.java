package galacticgames.android.skilltree.common.toastshelper;

import android.content.Context;
import android.widget.Toast;

import galacticgames.android.skilltree.R;


public class ToastsHelper {

    private final Context mContext;

    public ToastsHelper(Context context) {
        mContext = context;
    }

    public void showUseCaseError() {
        Toast.makeText(mContext, R.string.error_network_call_failed, Toast.LENGTH_SHORT).show();
    }

    public void showTemporaryNavigation(String string) {
        Toast.makeText(mContext, "Temporary substitute for navigation to: " + string, Toast.LENGTH_SHORT).show();
    }

    public void showEmptyEditTextError() {
        Toast.makeText(mContext, "You can't save a skill that doesn't have a name!", Toast.LENGTH_SHORT).show();
    }
}
