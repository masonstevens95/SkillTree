package galacticgames.android.skilltree.screens.skilldetails.graphtab;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.screens.common.ViewMvcFactory;
import galacticgames.android.skilltree.screens.common.views.BaseObservableViewMvc;
import galacticgames.android.skilltree.screens.skilldetails.achievementstab.AchievementsTabViewMvc;
import galacticgames.android.skilltree.screens.skilldetails.achievementstab.SkillDetailsAchievementsTabRecyclerAdapter;

public class GraphTabViewMvcImpl extends BaseObservableViewMvc<GraphTabViewMvc.Listener>
                implements GraphTabViewMvc {

    //region final declarations

    private final ProgressBar mProgressBar;
    private final TextView mTextView;

    //endregion

    public GraphTabViewMvcImpl(LayoutInflater inflater,
                                      @Nullable ViewGroup parent,
                                      ViewMvcFactory viewMvcFactory){

        setRootView(inflater.inflate(R.layout.layout_skilldetails_graph_tab, parent, false));

        mTextView = findViewById(R.id.textView);

        mProgressBar = findViewById(R.id.progress);
    }

    @Override
    public void showProgressIndication() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressIndication() {
        mProgressBar.setVisibility(View.GONE);
    }


}
