package galacticgames.android.skilltree.screens.common.controllers;

public interface HomePressDispatcher {
    void registerListener(HomePressedListener listener);
    void unregisterListener(HomePressedListener listener);
}
