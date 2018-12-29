package galacticgames.android.skilltree.screens.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import galacticgames.android.skilltree.screens.common.ViewMvcFactory;

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