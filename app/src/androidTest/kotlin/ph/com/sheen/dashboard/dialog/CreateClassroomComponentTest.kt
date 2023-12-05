package ph.com.sheen.dashboard.dialog

import androidx.compose.ui.test.junit4.createComposeRule
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
    }
}