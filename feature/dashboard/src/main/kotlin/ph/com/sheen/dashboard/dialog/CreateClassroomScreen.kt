package ph.com.sheen.dashboard.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ph.com.sheen.designsystem.theme.ui.AppPreview

@Composable
fun CreateClassroomRoute() {
    CreateClassroomScreen()
}

@Composable
fun CreateClassroomScreen(modifier: Modifier = Modifier) {
    BuildCreateClassroomScreen {
        Container {
            AppBar()
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