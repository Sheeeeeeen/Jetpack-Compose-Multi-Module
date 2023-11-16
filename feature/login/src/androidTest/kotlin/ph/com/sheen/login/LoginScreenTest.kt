package ph.com.sheen.login

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_login_screen_default_state() {
        composeTestRule.setContent {
            LoginScreen(uiState = LoginUIState())
        }
        composeTestRule.onNodeWithTag("welcome_label").assertIsDisplayed()
        composeTestRule.onNodeWithTag("teachers_label").assertIsDisplayed()
        composeTestRule.onNodeWithTag("login_button").assertIsDisplayed()
    }
}