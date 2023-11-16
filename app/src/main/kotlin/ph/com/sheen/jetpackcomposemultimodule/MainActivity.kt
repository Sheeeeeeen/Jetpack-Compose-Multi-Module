package ph.com.sheen.jetpackcomposemultimodule

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ph.com.sheen.designsystem.theme.ui.JetpackComposeMultiModuleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashScreen.addSplashScreenEffect()
        setContent {
            JetpackComposeMultiModuleTheme {
                val navHostController = rememberNavController()
                AppNavHost(navController = navHostController)
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