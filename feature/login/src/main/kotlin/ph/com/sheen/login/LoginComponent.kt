package ph.com.sheen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun BuildLoginScreen(
    block: @Composable LoginComponent.() -> Unit = {},
) {
    val typeSafeScreen = LoginComponent()
    typeSafeScreen.block()
}

class LoginComponent {

    @Composable
    fun Container(modifier: Modifier = Modifier, content: @Composable BoxScope.() -> Unit) {
        Box(modifier = modifier.fillMaxSize()) {
            content()
        }
    }

    @Composable
    fun WelcomeLabel(modifier: Modifier = Modifier) {
        Text(
            modifier = modifier.fillMaxWidth().testTag("welcome_label"),
            text = "Welcome!",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 64.sp,
            textAlign = TextAlign.Center
        )
    }

    @Composable
    fun TeachersAppLabel(modifier: Modifier = Modifier) {
        Text(
            modifier = modifier.fillMaxWidth().testTag("teachers_label"),
            text = "Teacher's App",
            style = MaterialTheme.typography.displayLarge,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
    }

    @Composable
    fun LoginButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
        Button(
            modifier = modifier
                .fillMaxWidth().testTag("login_button"),
            onClick = onClick
        ) {
            Text(text = "Login")
        }
    }

    @Composable
    fun LoadingSpinner(modifier: Modifier = Modifier) {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background.copy(alpha = 0.8f))
                .testTag("login_loading")
        ) {
            CircularProgressIndicator(modifier = modifier)
        }
    }
}