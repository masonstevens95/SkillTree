package galacticgames.android.skilltree.screens.homescreen;

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

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

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