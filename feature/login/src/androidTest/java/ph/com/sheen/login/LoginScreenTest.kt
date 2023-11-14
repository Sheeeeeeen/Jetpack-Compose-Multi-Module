package ph.com.sheen.login

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun check_login_screen() {
        composeTestRule.setContent {
            LoginScreen()
        }

        composeTestRule.onNodeWithText("Welcome!").assertIsDisplayed()
        composeTestRule.onNodeWithText("Teacher's App").assertIsDisplayed()
        composeTestRule.onNodeWithText("Login").assertIsDisplayed()
    }
}