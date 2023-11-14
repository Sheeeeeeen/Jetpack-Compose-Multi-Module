package ph.com.sheen.jetpackcomposemultimodule

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ph.com.sheen.login.loginGraph
import ph.com.sheen.login.loginNavigationRoute

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = loginNavigationRoute
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ){
        loginGraph(nestedGraphs = { /** add login graph here  **/ })
    }
}