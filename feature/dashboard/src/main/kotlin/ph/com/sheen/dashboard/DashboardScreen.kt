package ph.com.sheen.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import ph.com.sheen.data.model.createClassroom
import ph.com.sheen.designsystem.theme.ui.AppPreview

@Composable
fun DashboardRoute(viewModel: DashboardViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    DashboardScreen(
        uiState = uiState,
        onNotificationTapped = { viewModel.saveClassroom(classroom = createClassroom()) })
}

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    uiState: DashboardUiState,
    onNotificationTapped: () -> Unit = {},
) {
    BuildLoginScreen {
        Container(
            topAppBar = { AppBar(onNotificationTapped = onNotificationTapped) }
        ) {
            ClassroomList(modifier = Modifier, classrooms = uiState.classrooms)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    AppPreview {
        DashboardScreen(uiState = DashboardUiState())
    }
}