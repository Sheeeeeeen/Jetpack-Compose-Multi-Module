package ph.com.sheen.notification

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ph.com.sheen.designsystem.theme.ui.AppPreview

@Composable
fun NotificationRoute() {
    NotificationScreen()
}

@Composable
fun NotificationScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Notification")
    }
}

@Preview(showBackground = true)
@Composable
private fun NotificationScreenPreview() {
    AppPreview {
        NotificationScreen()
    }
}