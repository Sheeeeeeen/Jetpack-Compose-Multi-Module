@file:OptIn(ExperimentalFoundationApi::class)

package ph.com.sheen.dashboard.dialog

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeContentTestRule
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
        with(composeTestRule) {
            //close button
            composeTestRule.onNodeWithTag(testTag = "close_button").assertIsDisplayed()

            //title
            composeTestRule.onNodeWithText(text = "Create new classroom").assertIsDisplayed()

            //main content
            categoryDropdownField().assertIsDisplayed()
            courseNameTextField().assertIsNotDisplayed() //show the `courseNameTextField` if the selected category is College.
            yearLevelTextField().assertIsDisplayed()
            saveButton().assertIsDisplayed()
        }
    }

    @Test
    fun test_show_course_name_when_category_field_is_college() {

        with(composeTestRule) {
            //setup
            val selectedCategory = SelectionCategory.COLLEGE.value

            //action
            categoryDropdownField().performClick()
            composeTestRule.onNodeWithText(text = selectedCategory).performClick()

            //assert
            categoryDropdownField().assertIsDisplayed()
            courseNameTextField().assertIsDisplayed()
            yearLevelTextField().assertIsDisplayed()
            saveButton().assertIsDisplayed()
        }
    }

    @Test
    fun test_select_category_kinder_and_input_level() {

        with(composeTestRule) {
            //setup
            val typedLevel = "1"
            val typedCategory = SelectionCategory.KINDER.value

            //action
            yearLevelTextField().performTextInput(typedLevel)

            //assert
            categoryTextField().assert(hasText(typedCategory))
            yearLevelTextField().assert(hasText(typedLevel))

            categoryDropdownField().assertIsDisplayed()
            yearLevelTextField().assertIsDisplayed()
            saveButton().assertIsDisplayed()
        }
    }

    @Test
    fun test_select_category_junior_high_and_input_level() {
        with(composeTestRule) {
            //setup
            val typedLevel = "1"
            val selectedCategory = SelectionCategory.JUNIOR_HIGH.value

            //action
            categoryDropdownField().performClick()
            composeTestRule.onNodeWithText(text = selectedCategory).performClick()
            yearLevelTextField().performTextInput(typedLevel)

            //assert
            //main content
            categoryTextField().assert(hasText(selectedCategory))
            yearLevelTextField().assert(hasText(typedLevel))

            categoryDropdownField().assertIsDisplayed()
            yearLevelTextField().assertIsDisplayed()
            saveButton().assertIsDisplayed()
        }
    }

    @Test
    fun test_select_category_senior_high_and_input_level() {
        with(composeTestRule) {
            //setup
            val typedLevel = "1"
            val selectedCategory = SelectionCategory.SENIOR_HIGH.value

            //action
            categoryDropdownField().performClick()
            composeTestRule.onNodeWithText(text = selectedCategory).performClick()
            yearLevelTextField().performTextInput(typedLevel)

            //assert
            categoryTextField().assert(hasText(selectedCategory))
            yearLevelTextField().assert(hasText(typedLevel))

            categoryDropdownField().assertIsDisplayed()
            yearLevelTextField().assertIsDisplayed()
            saveButton().assertIsDisplayed()
        }
    }

    @Test
    fun test_select_category_college_high_and_input_level() {
        with(composeTestRule) {
            //setup
            val typedLevel = "1"
            val selectedCategory = SelectionCategory.COLLEGE.value
            val typeCourseName = "Coet"

            //action
            categoryDropdownField().performClick()
            composeTestRule.onNodeWithText(text = selectedCategory).performClick()
            yearLevelTextField().performTextInput(typedLevel)
            courseNameTextField().performTextInput(typeCourseName)

            //assert
            categoryTextField().assert(hasText(SelectionCategory.COLLEGE.value))
            yearLevelTextField().assert(hasText(typedLevel))
            courseNameTextField().assert(hasText(typeCourseName))
            courseNameTextField().assertIsDisplayed()

            categoryDropdownField().assertIsDisplayed()
            yearLevelTextField().assertIsDisplayed()
            saveButton().assertIsDisplayed()
        }
    }

    private fun ComposeContentTestRule.categoryDropdownField(): SemanticsNodeInteraction {
        return onNodeWithTag(testTag = "category_dropdown_menu_field_tag")
    }

    private fun ComposeContentTestRule.categoryTextField(): SemanticsNodeInteraction {
        return onNodeWithTag(testTag = "category_field_tag")
    }

    private fun ComposeContentTestRule.courseNameTextField(): SemanticsNodeInteraction {
        return onNodeWithTag(testTag = "course_name_field_tag")
    }

    private fun ComposeContentTestRule.yearLevelTextField(): SemanticsNodeInteraction {
        return onNodeWithTag(testTag = "year_level_field_tag")
    }

    private fun ComposeContentTestRule.saveButton(): SemanticsNodeInteraction {
        return onNodeWithTag(testTag = "text_save_button_tag")
    }
}
