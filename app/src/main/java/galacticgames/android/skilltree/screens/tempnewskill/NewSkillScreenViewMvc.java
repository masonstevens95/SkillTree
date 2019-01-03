package galacticgames.android.skilltree.screens.tempnewskill;

import java.util.List;

import galacticgames.android.skilltree.achievement.Achievement;
import galacticgames.android.skilltree.screens.common.views.ObservableViewMvc;

public interface NewSkillScreenViewMvc extends ObservableViewMvc<NewSkillScreenViewMvc.Listener> {

    public interface Listener {
        void onHomeClicked();

        void onSaveClicked(String s);
    }

    //TODO: add stuff to enter text? might not be necessary to have it in its own method

    void showProgressIndication();

    void hideProgressIndication();

}
