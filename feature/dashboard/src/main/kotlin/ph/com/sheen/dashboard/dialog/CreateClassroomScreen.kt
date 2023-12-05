@file:OptIn(ExperimentalFoundationApi::class)

package ph.com.sheen.dashboard.dialog

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ph.com.sheen.designsystem.theme.ui.AppPreview

@Composable
fun CreateClassroomRoute() {
    CreateClassroomScreen()
}

@Composable
fun CreateClassroomScreen(modifier: Modifier = Modifier) {
    BuildCreateClassroomScreen {
        Container(modifier = Modifier.padding(16.dp)) {
            AppBar()
            MainContent(modifier = Modifier) {
                CategoryField()
                CourseNameField()
                YearLevelField()
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