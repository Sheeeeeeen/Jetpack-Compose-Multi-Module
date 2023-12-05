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
            title = { Text(text = "Create new classroom") },
            navigationIcon = {
                IconButton(
                    modifier = Modifier.testTag("close_button"),
                    onClick = onTappedClose
                ) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "close_button")
                }
            },
            actions = {
                TextButton(
                    modifier = Modifier.testTag(tag = "save_button"),
                    onClick = onTappedSave
                ) {
                    Text(text = "Save")
                }
            }
        )
    }
}