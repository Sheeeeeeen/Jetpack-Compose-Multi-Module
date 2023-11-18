package ph.com.sheen.jetpackcomposemultimodule

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ph.com.sheen.designsystem.theme.ui.JetpackComposeMultiModuleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            splashScreen.addSplashScreenEffect(
                startAnimation = { sView ->
                    sView.start()
                }
            )
        } else {
            val splashScreen = installSplashScreen()
            lifecycleScope.launch {
                viewModel.mainUiState.collect {
                    splashScreen.setKeepOnScreenCondition {
                        it.shouldNotDismiss
                    }
                }
            }
        }

        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeMultiModuleTheme {
                val uiState = viewModel.mainUiState.collectAsState()
                val navHostController = rememberNavController()
                if (uiState.value.startDestination.isEmpty().not()) {
                    AppNavHost(
                        navController = navHostController,
                        startDestination = uiState.value.startDestination
                    )
                }
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