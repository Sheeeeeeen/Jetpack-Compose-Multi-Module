package ph.com.sheen.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import ph.com.sheen.designsystem.theme.ui.AppPreview

@Composable
fun LoginScreenRoute(viewModel: LoginViewModel = hiltViewModel()) {

    val scope = rememberCoroutineScope()

    val uiState by viewModel.uiState.collectAsState()

    LoginScreen(uiState = uiState, onLoginClick = { scope.launch { viewModel.login() } })
}

@Composable
fun LoginScreen(uiState: LoginUIState, onLoginClick: () -> Unit) {
    BuildLoginScreen {
        Container(modifier = Modifier) {
            WelcomeLabel(modifier = Modifier.align(alignment = Alignment.TopCenter))
            TeachersAppLabel(modifier = Modifier.align(Alignment.Center))
            LoginButton(
                modifier = Modifier.align(Alignment.BottomCenter).padding(12.dp),
                onClick = onLoginClick
            )
            //TODO add smooth animation to show loading screen
            AnimatedVisibility(visible = uiState.isLoading) {
                LoadingSpinner(modifier = Modifier.align(alignment = Alignment.Center))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    AppPreview {
        LoginScreen(uiState = LoginUIState(), onLoginClick = {})
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenIsLoadingPreview() {
    AppPreview {
        LoginScreen(uiState = LoginUIState(isLoading = true), onLoginClick = {})
    }
}