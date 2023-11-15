package ph.com.sheen.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ph.com.sheen.designsystem.theme.ui.AppPreview

@Composable
fun LoginScreenRoute() {
    LoginScreen()
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    BuildLoginScreen {
        Container(modifier = modifier) {
            WelcomeLabel(modifier = Modifier.align(alignment = Alignment.TopCenter))
            TeachersAppLabel(modifier = Modifier.align(Alignment.Center))
            LoginButton(modifier = Modifier.align(Alignment.BottomCenter).padding(12.dp))
            AnimatedVisibility(visible = false) {
                LoadingSpinner(modifier = Modifier.align(alignment = Alignment.Center))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    AppPreview {
        LoginScreen()
    }
}