@file:OptIn(ExperimentalMaterial3Api::class)

package ph.com.sheen.dashboard.dialog

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
    fun AppBar(onTappedClose: () -> Unit = {}, onTappedSave: () -> Unit = {}) {
        TopAppBar(
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
}