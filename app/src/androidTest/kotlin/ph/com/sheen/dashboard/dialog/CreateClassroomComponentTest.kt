package ph.com.sheen.dashboard.dialog

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class CreateClassroomComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_top_app_bar_with_close_button_title_and_save_button() {
        composeTestRule.setContent {
            BuildCreateClassroomScreen {
                AppBar()
            }
        }
        //close button
        composeTestRule.onNodeWithTag(testTag = "close_button").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "close_button").assertExists()
        composeTestRule.onNodeWithTag(testTag = "close_button").assertIsEnabled()

        //title
        composeTestRule.onNodeWithText(text = "Create new classroom").assertIsDisplayed()

        //save button
        composeTestRule.onNodeWithTag(testTag = "save_button")
    }
}