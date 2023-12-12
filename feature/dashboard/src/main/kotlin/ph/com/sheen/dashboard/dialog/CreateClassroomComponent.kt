@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package ph.com.sheen.dashboard.dialog

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import ph.com.sheen.dashboard.R
import ph.com.sheen.dashboard.dropdown.CategoryDropdownRoute

@Composable
fun BuildCreateClassroomScreen(
    block: @Composable CreateClassroomComponent.() -> Unit = {},
) {
    val typeSafeScreen = CreateClassroomComponent()
    typeSafeScreen.block()
}

class CreateClassroomComponent {

    @Composable
    fun Container(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
        Surface(modifier = modifier) {
            Column(modifier = Modifier.fillMaxSize()) {
                content()
            }
        }
    }

    @Composable
    fun AppBar(
        modifier: Modifier = Modifier,
        onTappedClose: () -> Unit = {},
    ) {
        TopAppBar(
            modifier = modifier,
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
            }
        )
    }

    @Composable
    fun MainContent(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
        Column(modifier = modifier.fillMaxWidth(), content = content)
    }

    @Composable
    fun CategoryDropdownField(
        modifier: Modifier = Modifier,
        onValueChanged: (String) -> Unit = {},
        value: String = "",
        items: List<String> = listOf("Kinder", "Junior High", "Senior High", "College"),
    ) {
        CategoryDropdownRoute()
    }

    @Composable
    fun CourseNameField(
        modifier: Modifier = Modifier,
        onValueChanged: (String) -> Unit = {},
        value: String = "",
    ) {
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
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }

    @Composable
    fun SaveButton(modifier: Modifier = Modifier, onTappedSave: () -> Unit = {}) {
        TextButton(
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
