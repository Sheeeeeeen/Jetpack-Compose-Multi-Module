package ph.com.sheen.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ph.com.sheen.designsystem.theme.ui.AppPreview

@Composable
fun LoginScreenRoute() {
    LoginScreen()
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        WelcomeLabel()
        TeachersAppLabel()
        LoginButton(modifier = Modifier.padding(12.dp))
    }
}

@Composable
private fun BoxScope.WelcomeLabel(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.fillMaxWidth().align(alignment = Alignment.TopCenter),
        text = "Welcome!",
        style = MaterialTheme.typography.titleLarge,
        fontSize = 64.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun BoxScope.TeachersAppLabel(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.fillMaxWidth().align(Alignment.Center),
        text = "Teacher's App",
        style = MaterialTheme.typography.displayLarge,
        fontSize = 24.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun BoxScope.LoginButton(modifier: Modifier = Modifier) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .align(alignment = Alignment.BottomCenter),
        onClick = {}
    ) {
        Text(text = "Login")
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    AppPreview {
        LoginScreen()
    }
}