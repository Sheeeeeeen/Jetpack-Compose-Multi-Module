@file:OptIn(ExperimentalFoundationApi::class)

package ph.com.sheen.dashboard.dialog

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class CreateClassroomScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_top_app_bar_with_close_button_title_and_save_button() {
        composeTestRule.setContent {
            CreateClassroomScreen()
        }
        //close button
        composeTestRule.onNodeWithTag(testTag = "close_button").assertIsDisplayed()

        //title
        composeTestRule.onNodeWithText(text = "Create new classroom").assertIsDisplayed()

        //main content
        composeTestRule.onNodeWithTag(testTag = "category_dropdown_menu_field_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "course_name_field_tag").assertIsNotDisplayed()
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "text_save_button_tag").assertIsDisplayed()
    }

    @Test
    fun test_show_course_name_when_category_field_is_college() {
        composeTestRule.setContent {
            CreateClassroomScreen()
        }

        //tap the category field dropdown
        composeTestRule.onNodeWithTag(testTag = "category_dropdown_menu_field_tag").performClick()
        composeTestRule.onNodeWithText(text = "College").performClick()


        //close button
        composeTestRule.onNodeWithTag(testTag = "close_button").assertIsDisplayed()

        //title
        composeTestRule.onNodeWithText(text = "Create new classroom").assertIsDisplayed()

        //main content
        composeTestRule.onNodeWithTag(testTag = "category_dropdown_menu_field_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "course_name_field_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "text_save_button_tag").assertIsDisplayed()
    }
}