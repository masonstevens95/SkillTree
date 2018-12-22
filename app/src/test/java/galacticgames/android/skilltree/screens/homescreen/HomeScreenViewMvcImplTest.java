package galacticgames.android.skilltree.screens.homescreen;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import galacticgames.android.skilltree.screens.common.ViewMvcFactory;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HomeScreenViewMvcImplTest {

    //region Constants


    //endregion Constants


    //region Helper Fields

    LayoutInflater layoutInflater;
    ViewGroup parent;
    ViewMvcFactory viewMvcFactory;

    //endregion Helper Fields

    HomeScreenViewMvcImpl SUT;

    @Before
    public void setup() throws Exception {
        SUT = new HomeScreenViewMvcImpl(layoutInflater, parent, viewMvcFactory);

    }

    //tests

    //initToolbar_setsTitleToSkillTree
    //initToolBar_enablesProfileButtonAndListens

    //onSkillsClicked_listenerRegistersSkillClicked
    //onGetNewClicked_listenerRegistersGetNewClicked
    //onFriendsClicked_listenerRegistersFriendsClicked
    //onProfileClicked_listenerRegistersProfileClicked

    //region Helper Methods


    //endregion Helper Methods


    //region Helper Classes


    //endregion Helper Classes

}