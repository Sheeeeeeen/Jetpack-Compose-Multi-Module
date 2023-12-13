@file:OptIn(ExperimentalFoundationApi::class)

package ph.com.sheen.dashboard.dialog

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import ph.com.sheen.dashboard.dropdown.SelectionCategory

class CreateClassroomScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            CreateClassroomScreen()
        }
    }

    @Test
    fun test_initial_state_screen() {
        //close button
        composeTestRule.onNodeWithTag(testTag = "close_button").assertIsDisplayed()

        //title
        composeTestRule.onNodeWithText(text = "Create new classroom").assertIsDisplayed()

        //main content
        composeTestRule.onNodeWithTag(testTag = "category_dropdown_menu_field_tag")
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "course_name_field_tag").assertIsNotDisplayed()
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "text_save_button_tag").assertIsDisplayed()
    }

    @Test
    fun test_show_course_name_when_category_field_is_college() {
        //tap the category field dropdown
        composeTestRule.onNodeWithTag(testTag = "category_dropdown_menu_field_tag").performClick()
        composeTestRule.onNodeWithText(text = "College").performClick()


        //close button
        composeTestRule.onNodeWithTag(testTag = "close_button").assertIsDisplayed()

        //title
        composeTestRule.onNodeWithText(text = "Create new classroom").assertIsDisplayed()

        //main content
        composeTestRule.onNodeWithTag(testTag = "category_dropdown_menu_field_tag")
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "course_name_field_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "text_save_button_tag").assertIsDisplayed()
    }

    @Test
    fun test_select_category_kinder_and_input_level() {
        //setup
        //action
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").performTextInput("1")

        //assert
        //main content
        composeTestRule.onNodeWithTag(testTag = "category_field_tag").assert(hasText("Kinder"))
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").assert(hasText("1"))

        composeTestRule.onNodeWithTag(testTag = "category_dropdown_menu_field_tag")
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "text_save_button_tag").assertIsDisplayed()
    }

    @Test
    fun test_select_category_junior_high_and_input_level() {
        //setup
        //action
        composeTestRule.onNodeWithTag(testTag = "category_dropdown_menu_field_tag").performClick()
        composeTestRule.onNodeWithText(text = SelectionCategory.JUNIOR_HIGH.value).performClick()
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").performTextInput("1")

        //assert
        //main content
        composeTestRule.onNodeWithTag(testTag = "category_field_tag")
            .assert(hasText(SelectionCategory.JUNIOR_HIGH.value))
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").assert(hasText("1"))

        composeTestRule.onNodeWithTag(testTag = "category_dropdown_menu_field_tag")
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "text_save_button_tag").assertIsDisplayed()
    }

    @Test
    fun test_select_category_senior_high_and_input_level() {
        //setup
        //action
        composeTestRule.onNodeWithTag(testTag = "category_dropdown_menu_field_tag").performClick()
        composeTestRule.onNodeWithText(text = SelectionCategory.SENIOR_HIGH.value).performClick()
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").performTextInput("1")

        //assert
        //main content
        composeTestRule.onNodeWithTag(testTag = "category_field_tag")
            .assert(hasText(SelectionCategory.SENIOR_HIGH.value))
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").assert(hasText("1"))

        composeTestRule.onNodeWithTag(testTag = "category_dropdown_menu_field_tag")
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "text_save_button_tag").assertIsDisplayed()
    }

    @Test
    fun test_select_category_college_high_and_input_level() {
        //setup
        //action
        composeTestRule.onNodeWithTag(testTag = "category_dropdown_menu_field_tag").performClick()
        composeTestRule.onNodeWithText(text = SelectionCategory.COLLEGE.value).performClick()
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").performTextInput("1")
        composeTestRule.onNodeWithTag(testTag = "course_name_field_tag").performTextInput("Coet")
        //assert
        //main content
        composeTestRule.onNodeWithTag(testTag = "category_field_tag")
            .assert(hasText(SelectionCategory.COLLEGE.value))
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").assert(hasText("1"))
        composeTestRule.onNodeWithTag(testTag = "course_name_field_tag").assert(hasText("Coet"))
        composeTestRule.onNodeWithTag(testTag = "course_name_field_tag").assertIsDisplayed()

        composeTestRule.onNodeWithTag(testTag = "category_dropdown_menu_field_tag")
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "year_level_field_tag").assertIsDisplayed()
        composeTestRule.onNodeWithTag(testTag = "text_save_button_tag").assertIsDisplayed()
    }
}