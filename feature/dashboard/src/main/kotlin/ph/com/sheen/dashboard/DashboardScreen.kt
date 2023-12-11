package ph.com.sheen.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ph.com.sheen.dashboard.model.DashboardUiState
import ph.com.sheen.data.model.Classroom
import ph.com.sheen.data.model.createClassroom
import ph.com.sheen.designsystem.theme.ui.AppPreview

@Composable
fun DashboardRoute(viewModel: DashboardViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    DashboardScreen(
        uiState = uiState,
        onNotificationTapped = { viewModel.saveClassroom(classroom = createClassroom()) },
        onSwipeDelete = viewModel::deleteClassroom,
        onMoreTapped = viewModel::deleteClassroom,
    )
}

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    uiState: DashboardUiState,
    onNotificationTapped: () -> Unit = {},
    onMoreTapped: (Classroom) -> Unit = {},
    onSwipeDelete: (Classroom) -> Unit = {},
) {
    val scope = rememberCoroutineScope()

    BuildDashboardScreen {
        Container(
            modifier = modifier,
            topAppBar = { AppBar(onNotificationTapped = onNotificationTapped) }
        ) {
            val listOfClassroom = uiState.classrooms
            ClassroomList(
                modifier = Modifier,
                classrooms = listOfClassroom,
                onMoreTapped = onMoreTapped,
                onSwipeDelete = {
                    scope.launch {
                        //add delete to not interrupt the animation of animate visibility
                        delay(1000L)
                        onSwipeDelete(it)
                    }
                }
            )
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