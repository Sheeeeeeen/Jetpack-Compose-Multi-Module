package ph.com.sheen.dashboard

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import ph.com.sheen.designsystem.theme.ui.AppPreview

@Composable
fun DashboardRoute(viewModel: DashboardViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    DashboardScreen(uiState = uiState)
}

@Composable
fun DashboardScreen(modifier: Modifier = Modifier, uiState: DashboardUiState) {
    BuildLoginScreen {
        Container(
            topAppBar = { AppBar() }
        ) {
            LazyColumn {
                items(
                    items = uiState.classrooms,
                    key = {
                        it.header
                    }
                ) {
                    ClassroomItem(modifier = Modifier)
                }
            }
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