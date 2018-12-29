package galacticgames.android.skilltree.screens.home;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HomeScreenControllerTest {

    //region Constants


    //endregion Constants


    //region Helper Fields


    //endregion Helper Fields

    HomeScreenController SUT;

    @Before
    public void setup() throws Exception {
        SUT = new HomeScreenController();

    }

    //tests
    //onStart_registersViewMvcListener
    //onStart_registersOnHomePressedListener
    //onStart_showsProgressIndication

    //onStop_unregistersViewMvcListener
    //onStop_unregisterOnHomePressedListener

    //onSkillsClicked_sendsEventToScreensNavigator
    //onGetNewClicked_sendsEventToScreensNavigator
    //onFriendsClicked_sendsEventToScreensNavigator
    //onProfileClicked_sendsEventToScreensNavigator

    //onHomePressed_doNothing


    //region Helper Methods


    //endregion Helper Methods


    //region Helper Classes


    //endregion Helper Classes

}