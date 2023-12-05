@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package ph.com.sheen.dashboard.dialog

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import ph.com.sheen.dashboard.R

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
        Column(modifier = modifier.fillMaxSize()) {
            content()
        }
    }

    @Composable
    fun AppBar(
        modifier: Modifier = Modifier,
        onTappedClose: () -> Unit = {},
        onTappedSave: () -> Unit = {},
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
            },
            actions = {
                TextButton(
                    modifier = Modifier.testTag(tag = stringResource(R.string.save_button_test_tag)),
                    onClick = onTappedSave
                ) {
                    Text(text = stringResource(R.string.save_button_title))
                }
            })
    }

    @Composable
    fun MainContent(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
        Column(modifier = modifier.fillMaxWidth(), content = content)
    }

    @Composable
    fun CategoryField(
        modifier: Modifier = Modifier,
        onValueChanged: (String) -> Unit = {},
        value: String = "",
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChanged,
            modifier = modifier.fillMaxWidth().testTag("category_field_tag"),
            textStyle = MaterialTheme.typography.bodyLarge,
            label = {
                Text("Classroom Name")
            },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "arrow_drop_down"
                    )
                }
            },
            readOnly = true
        )
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
}