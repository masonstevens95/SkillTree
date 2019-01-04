package galacticgames.android.skilltree.screens.skilldetails.achievementstab.achievementstabitem;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import galacticgames.android.skilltree.R;
import galacticgames.android.skilltree.skill.achievement.Achievement;
import galacticgames.android.skilltree.screens.common.views.BaseObservableViewMvc;

public class AchievementsTabListItemViewMvcImpl extends BaseObservableViewMvc<AchievementsTabListItemViewMvc.Listener>
                implements AchievementsTabListItemViewMvc{

    private final ImageView mImageView;
    private final TextView mTitle;
    private final TextView mDetails;

    private Achievement mAchievement;

    public AchievementsTabListItemViewMvcImpl(LayoutInflater inflater,
                                         @Nullable ViewGroup parent){
        setRootView(inflater.inflate(R.layout.layout_skilldetails_achievements_item, parent, false));

        mImageView = findViewById(R.id.achievement_imageView);
        mTitle = findViewById(R.id.achievement_title);
        mDetails = findViewById(R.id.achievement_details);
        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()) {
                    listener.onAchievementClicked(mAchievement);
                }
            }
        });
    }


    @Override
    public void bindAchievement(Achievement achievement) {
        mAchievement = achievement;
        //TODO: set image here. needs to be a property of achievement.
        //TODO: set title
        //mTitle.setText(mAchievement.getTitle());
        //TODO: set details
        //mDetails.setText(mAchievement.getDetails());
    }
}
