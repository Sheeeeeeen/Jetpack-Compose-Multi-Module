@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package ph.com.sheen.dashboard.dialog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import ph.com.sheen.dashboard.R
import ph.com.sheen.dashboard.dropdown.CategoryDropdownScreen
import ph.com.sheen.dashboard.dropdown.SelectionCategory

@Composable
fun BuildCreateClassroomScreen(
    block: @Composable CreateClassroomComponent.() -> Unit = {},
) {
    val typeSafeScreen = CreateClassroomComponent()
    typeSafeScreen.block()
}

class CreateClassroomComponent {

    @Composable
    fun Container(
        modifier: Modifier = Modifier,
        topBar: @Composable () -> Unit,
        content: @Composable ColumnScope.() -> Unit,
    ) {
        Scaffold(
            modifier = modifier,
            topBar = topBar
        ) {
            Column(modifier = Modifier.fillMaxSize().padding(it)) {
                content()
            }
        }
    }

    @Composable
    fun AppBar(
        modifier: Modifier = Modifier,
        onTappedClose: () -> Unit = {},
    ) {
        TopAppBar(modifier = modifier,
            title = { Text(text = stringResource(R.string.create_new_classroom)) },
            navigationIcon = {
                IconButton(
                    modifier = Modifier.testTag(stringResource(R.string.close_button_test_tag)),
                    onClick = onTappedClose
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.close_button_description)
                    )
                }
            })
    }

    @Composable
    fun MainContent(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
        Column(modifier = modifier.fillMaxWidth(), content = content)
    }

    @Composable
    fun CategoryDropdownField(
        modifier: Modifier = Modifier,
        onCategorySelected: (String) -> Unit = {},
        categoryItems: List<String> = SelectionCategory.entries.map { it.value },
    ) {

        var selectedCategory by rememberSaveable { mutableStateOf(categoryItems[0]) }

        var expanded by rememberSaveable { mutableStateOf(false) }

        CategoryDropdownScreen(modifier = modifier.testTag("category_dropdown_menu_field_tag"),
            value = selectedCategory,
            items = categoryItems,
            expanded = expanded,
            label = { Text("Classroom Name") },
            onItemSelected = {
                selectedCategory = it
                onCategorySelected(it)
            },
            onExpanded = { expanded = it })
    }

    @Composable
    fun CourseNameField(
        modifier: Modifier = Modifier,
        onValueChanged: (String) -> Unit = {},
        value: String = "",
        isVisible: Boolean,
    ) {
        AnimatedVisibility(visible = isVisible) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChanged,
                modifier = modifier.fillMaxWidth().testTag("course_name_field_tag"),
                textStyle = MaterialTheme.typography.bodyLarge,
                label = {
                    Text("Course Name")
                },
                singleLine = true,
            )
        }
    }

    @Composable
    fun YearLevelField(
        modifier: Modifier = Modifier,
        onValueChanged: (String) -> Unit = {},
        value: String = "",
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChanged,
            modifier = modifier.fillMaxWidth().testTag("year_level_field_tag"),
            textStyle = MaterialTheme.typography.bodyLarge,
            label = {
                Text("Year Level")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
    }

    @Composable
    fun SaveButton(modifier: Modifier = Modifier, onTappedSave: () -> Unit = {}) {
        FilledTonalButton(
            modifier = modifier.fillMaxWidth().testTag("text_save_button_tag"),
            onClick = onTappedSave
        ) {
            Text(text = "SAVE")
        }
    }

    @Composable
    fun ColumnScope.FillUpSpace(modifier: Modifier = Modifier) {
        Spacer(modifier = modifier.weight(1f))
    }
}
