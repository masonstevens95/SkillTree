package galacticgames.android.skilltree.screens.common;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import galacticgames.android.skilltree.common.toolbar.ToolbarViewMvc;
import galacticgames.android.skilltree.screens.homescreen.HomeScreenViewMvc;
import galacticgames.android.skilltree.screens.homescreen.HomeScreenViewMvcImpl;
import galacticgames.android.skilltree.screens.tempnewskillscreen.NewSkillScreenViewMvc;
import galacticgames.android.skilltree.screens.tempnewskillscreen.NewSkillScreenViewMvcImpl;
import galacticgames.android.skilltree.screens.userskills.UserSkillsScreenViewMvc;
import galacticgames.android.skilltree.screens.userskills.UserSkillsScreenViewMvcImpl;
import galacticgames.android.skilltree.screens.userskills.userskillsitem.UserSkillsListItemViewMvc;
import galacticgames.android.skilltree.screens.userskills.userskillsitem.UserSkillsListItemViewMvcImpl;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    public HomeScreenViewMvc getHomeScreenViewMvc(@Nullable ViewGroup parent){
        return new HomeScreenViewMvcImpl(mLayoutInflater, parent, this);
    }

    public ToolbarViewMvc getToolbarViewMvc(@Nullable ViewGroup parent) {
        return new ToolbarViewMvc(mLayoutInflater, parent);
    }

    public UserSkillsScreenViewMvc getUsersSkillViewMvc(@Nullable ViewGroup parent){
        return new UserSkillsScreenViewMvcImpl(mLayoutInflater, parent, this);
    }

    public UserSkillsListItemViewMvc getUsersSkillListItemViewMvc(@Nullable ViewGroup parent){
        return new UserSkillsListItemViewMvcImpl(mLayoutInflater, parent);
    }

    public NewSkillScreenViewMvc getNewSkillScreenViewMvc(@Nullable ViewGroup parent) {
        return new NewSkillScreenViewMvcImpl(mLayoutInflater, parent, this);
    }
}
