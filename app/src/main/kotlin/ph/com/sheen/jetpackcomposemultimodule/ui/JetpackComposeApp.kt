package ph.com.sheen.jetpackcomposemultimodule.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ph.com.sheen.jetpackcomposemultimodule.MainUiState
import ph.com.sheen.jetpackcomposemultimodule.navigation.AppNavHost

@Composable
fun JetpackComposeApp(
    mainUiState: MainUiState,
    appState: AppState = rememberAppState(mainUiState = mainUiState),
) {
    Scaffold(
        modifier = Modifier,
        bottomBar = {

        }
    ) {
        AppNavHost(
            modifier = Modifier.padding(it),
            navController = appState.navController,
            startDestination = appState.startDestination
        )
    }
}