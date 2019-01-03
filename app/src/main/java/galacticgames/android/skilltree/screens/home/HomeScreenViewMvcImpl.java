package galacticgames.android.skilltree.screens.home;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.List;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.common.toolbar.ToolbarViewMvc;
import galacticgames.android.skilltree.screens.common.ViewMvcFactory;
import galacticgames.android.skilltree.screens.common.views.BaseObservableViewMvc;

public class HomeScreenViewMvcImpl extends BaseObservableViewMvc<HomeScreenViewMvc.Listener>
        implements HomeScreenViewMvc, HomeScreenViewMvc.Listener{

    //region final constants

    private final ToolbarViewMvc mToolbarViewMvc;

    private final Toolbar mToolbar;
    private final ImageButton mSkillsButton, mSearchButton, mFriendsButton, mProfileButton;

    //endregion

    public HomeScreenViewMvcImpl(LayoutInflater layoutInflater,
                                 ViewGroup parent,
                                 ViewMvcFactory viewMvcFactory) {

        setRootView(layoutInflater.inflate(R.layout.layout_home_main, parent, false));

        mSkillsButton = findViewById(R.id.skillsButton);
        mSearchButton = findViewById(R.id.searchButton);
        mFriendsButton = findViewById(R.id.friendsButton);
        mProfileButton = findViewById(R.id.profileButton);

        mSkillsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageButtonClicked(mSkillsButton);
            }
        });

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageButtonClicked(mSearchButton);
            }
        });

        mFriendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageButtonClicked(mFriendsButton);
            }
        });

        mProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageButtonClicked(mProfileButton);
            }
        });

        //TODO: add animation setup

        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getToolbarViewMvc(mToolbar);
        initToolbar();
    }

    private void initToolbar() {
        mToolbarViewMvc.setTitle(getString(R.string.home_screen_title));
        mToolbar.addView(mToolbarViewMvc.getRootView());
        mToolbarViewMvc.enableHomeButtonAndListen(new ToolbarViewMvc.HomeClickListener() {
            @Override
            public void onHomeClicked(){
                //TODO: Nav to home if this doesn't work
                //don't need to do anything, already home. Maybe reanimate?
            }
        });
    }

    //TODO: on all buttons clicked methods

    @Override
    public void onImageButtonClicked(ImageButton imageButton) {
        for (Listener listener : getListeners()) {
            listener.onImageButtonClicked(imageButton);
        }
    }
}
