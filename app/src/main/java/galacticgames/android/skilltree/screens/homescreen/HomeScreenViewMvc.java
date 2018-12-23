package galacticgames.android.skilltree.screens.homescreen;

import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

import galacticgames.android.skilltree.screens.common.views.ObservableViewMvc;

public interface HomeScreenViewMvc extends ObservableViewMvc<HomeScreenViewMvc.Listener> {

    public interface Listener {
        void onImageButtonClicked(ImageButton imageButton);
    }

    void bindButtons(List<ImageButton> buttons);



    //TODO: add animations, outward flare

}
