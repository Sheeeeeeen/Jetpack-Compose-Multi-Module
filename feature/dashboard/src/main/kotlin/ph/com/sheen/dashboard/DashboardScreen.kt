package ph.com.sheen.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ph.com.sheen.designsystem.theme.ui.AppPreview

@Composable
fun DashboardRoute() {
    DashboardScreen()
}

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Dashboard")
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    AppPreview {
        DashboardScreen()
    }
}