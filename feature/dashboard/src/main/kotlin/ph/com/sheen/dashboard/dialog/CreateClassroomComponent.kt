@file:OptIn(ExperimentalMaterial3Api::class)

package ph.com.sheen.dashboard.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
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
            },
            actions = {
                TextButton(
                    modifier = Modifier.testTag(tag = stringResource(R.string.save_button_test_tag)),
                    onClick = onTappedSave
                ) {
                    Text(text = stringResource(R.string.save_button_title))
                }
            }
        )
    }

    @Composable
    fun MainContent(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
        Column(modifier = modifier, content = content)
    }

    @Composable
    fun CategoryField() {
        TODO()
    }

    @Composable
    fun CourseNameField() {
        TODO()
    }

    @Composable
    fun YearLevelField() {
        TODO()
    }
}