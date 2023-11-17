package ph.com.sheen.jetpackcomposemultimodule

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ph.com.sheen.dashboard.dashboardNavigationRoute
import ph.com.sheen.designsystem.theme.ui.JetpackComposeMultiModuleTheme
import ph.com.sheen.login.loginNavigationRoute

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var destination: String = loginNavigationRoute
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            splashScreen.addSplashScreenEffect()
        } else {
            val splashScreen = installSplashScreen()
            splashScreen.setKeepOnScreenCondition {
                false
            }
        }
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeMultiModuleTheme {
                val navHostController = rememberNavController()
                val viewModel by viewModels<MainViewModel>()
                val result = viewModel.isUserLoggedIn.collectAsState()
                LaunchedEffect(result) {
                    destination =
                        if (result.value) dashboardNavigationRoute else loginNavigationRoute
                }
                AppNavHost(navController = navHostController, startDestination = destination)
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