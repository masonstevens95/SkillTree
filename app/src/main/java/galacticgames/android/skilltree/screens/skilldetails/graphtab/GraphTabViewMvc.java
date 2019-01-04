package galacticgames.android.skilltree.screens.skilldetails.graphtab;

import galacticgames.android.skilltree.screens.common.views.ObservableViewMvc;

public interface GraphTabViewMvc extends ObservableViewMvc<GraphTabViewMvc.Listener> {

    public interface Listener{

    }

    void showProgressIndication();

    void hideProgressIndication();
}
