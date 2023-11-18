package ph.com.sheen.dashboard

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ph.com.sheen.designsystem.theme.ui.AppPreview

@Composable
fun DashboardRoute() {
    DashboardScreen()
}

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    BuildLoginScreen {
        Container(
            topAppBar = { AppBar() }
        ) {
            LazyColumn {
                repeat(100) {
                    item {
                        ClassroomItem(modifier = Modifier)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    AppPreview {
        DashboardScreen()
    }
}