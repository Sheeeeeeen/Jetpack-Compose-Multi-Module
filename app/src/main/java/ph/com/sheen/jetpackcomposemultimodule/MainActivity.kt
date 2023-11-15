package ph.com.sheen.jetpackcomposemultimodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ph.com.sheen.designsystem.theme.ui.JetpackComposeMultiModuleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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