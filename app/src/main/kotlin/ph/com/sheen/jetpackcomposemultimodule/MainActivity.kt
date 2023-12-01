package ph.com.sheen.jetpackcomposemultimodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ph.com.sheen.designsystem.theme.ui.JetpackComposeMultiModuleTheme
import ph.com.sheen.jetpackcomposemultimodule.navigation.AppNavHost
import ph.com.sheen.jetpackcomposemultimodule.ui.JetpackComposeApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private var isLoading: Boolean by mutableStateOf(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        lifecycleScope.launch {
            viewModel.mainUiState.collect {
                isLoading = it.keepScreenShowing
            }
        }

        splashScreen.setKeepOnScreenCondition {
            isLoading
        }

        setContent {
            JetpackComposeMultiModuleTheme {
                val uiState by viewModel.mainUiState.collectAsState()
                JetpackComposeApp(
                    mainUiState = uiState
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navHostController = rememberNavController()
    AppNavHost(navController = navHostController)
}