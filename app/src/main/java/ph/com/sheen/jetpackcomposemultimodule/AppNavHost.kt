package ph.com.sheen.jetpackcomposemultimodule

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ph.com.sheen.dashboard.dashboardGraph
import ph.com.sheen.dashboard.navigateToDashboardScreen
import ph.com.sheen.login.loginGraph
import ph.com.sheen.login.loginNavigationRoute

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = loginNavigationRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier.fillMaxSize(),
    ) {
        loginGraph(
            navToDashboard = {
                navController.navigateToDashboardScreen()
            },
            nestedGraphs = { /** add login graph here  **/ }
        )
        dashboardGraph(nestedGraphs = { /** add dashboard graph here  **/ })
    }
}