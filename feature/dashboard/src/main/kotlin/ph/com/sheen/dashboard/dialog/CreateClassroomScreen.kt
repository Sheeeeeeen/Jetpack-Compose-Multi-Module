@file:OptIn(ExperimentalFoundationApi::class)

package ph.com.sheen.dashboard.dialog

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import ph.com.sheen.designsystem.theme.ui.AppPreview

@Composable
fun CreateClassroomDialog(onDismissRequest: () -> Unit) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        CreateClassroomScreen(onTappedClose = onDismissRequest)
    }
}

@Composable
fun CreateClassroomScreen(modifier: Modifier = Modifier, onTappedClose: () -> Unit = {}) {
    BuildCreateClassroomScreen {
        Container(modifier = modifier) {
            AppBar(onTappedClose = onTappedClose)
            MainContent(modifier = Modifier.padding(16.dp)) {
                CategoryDropdownField()
                CourseNameField()
                YearLevelField()
                FillUpSpace()
                SaveButton()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CreateClassroomScreenPreview() {
    AppPreview {
        CreateClassroomScreen()
    }
}