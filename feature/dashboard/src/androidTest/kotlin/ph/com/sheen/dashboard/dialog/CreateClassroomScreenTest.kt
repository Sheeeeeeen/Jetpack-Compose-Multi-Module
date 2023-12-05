package ph.com.sheen.dashboard.dialog

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class CreateClassroomScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_top_app_bar_with_close_button_title_and_save_button() {
        composeTestRule.setContent {
            BuildCreateClassroomScreen {
                Container {
                    AppBar()
                    MainContent {
                        CategoryField()
                        CourseNameField()
                        YearLevelField()
                    }
                }
            }
        }
        //close button
        composeTestRule.onNodeWithTag(testTag = "close_button").assertIsDisplayed()

        //title
        composeTestRule.onNodeWithText(text = "Create new classroom").assertIsDisplayed()

        //save button
        composeTestRule.onNodeWithTag(testTag = "save_button").assertIsDisplayed()
        composeTestRule.onNodeWithText(text = "Save").assertIsDisplayed()

        //main content
        composeTestRule.onNodeWithTag(testTag = "category_field_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "course_name_field_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").assertIsDisplayed()
    }
}