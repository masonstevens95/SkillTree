package galacticgames.android.skilltree.screens.tempnewskill;

import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.common.toolbar.ToolbarViewMvc;
import galacticgames.android.skilltree.screens.common.ViewMvcFactory;
import galacticgames.android.skilltree.screens.common.views.BaseObservableViewMvc;

public class NewSkillScreenViewMvcImpl extends BaseObservableViewMvc<NewSkillScreenViewMvc.Listener>
                implements NewSkillScreenViewMvc {

    //region final declarations

    private final ToolbarViewMvc mToolbarViewMvc;

    private final Toolbar mToolbar;
    private final ProgressBar mProgressBar;
    private final EditText titleEditText;

    //endregion

    public NewSkillScreenViewMvcImpl(LayoutInflater inflater,
                                       @Nullable ViewGroup parent,
                                       ViewMvcFactory viewMvcFactory){

        setRootView(inflater.inflate(R.layout.layout_tempnewskill_main, parent, false));

        titleEditText = findViewById(R.id.skill_title);

        mProgressBar = findViewById(R.id.progress);

        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getToolbarViewMvc(mToolbar);
        initToolbar();
    }

    private void initToolbar() {
        mToolbarViewMvc.setTitle(getString(R.string.new_skill_screen_title));
        mToolbar.addView(mToolbarViewMvc.getRootView());
        mToolbarViewMvc.enableHomeButtonAndListen(new ToolbarViewMvc.HomeClickListener(){
            @Override
            public void onHomeClicked() {
                for (Listener listener : getListeners()){
                    listener.onHomeClicked();
                }
            }
        } );
        mToolbarViewMvc.enableSaveButtonAndListen(new ToolbarViewMvc.SaveClickListener(){
           @Override
           public void onSaveClicked() {
               //TODO: implement save function?
               for (Listener listener : getListeners()){
                   listener.onSaveClicked(titleEditText.getText().toString());
               }
           }
        });
    }

    @Override
    public void showProgressIndication() {

    }

    @Override
    public void hideProgressIndication() {

    }
}
