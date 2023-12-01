package ph.com.sheen.jetpackcomposemultimodule.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ph.com.sheen.dashboard.dashboardNavigationRoute
import ph.com.sheen.jetpackcomposemultimodule.MainUiState
import ph.com.sheen.jetpackcomposemultimodule.navigation.TopLevelDestination


@Composable
fun rememberAppState(
    mainUiState: MainUiState,
    navController: NavHostController = rememberNavController(),
): AppState {
    return remember(navController, mainUiState) {
        AppState(mainUiState = mainUiState, navController = navController)
    }
}

@Stable
class AppState(
    val mainUiState: MainUiState,
    val navController: NavHostController,
) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination


    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            dashboardNavigationRoute -> TopLevelDestination.DASHBOARD
            else -> null
        }

    val startDestination = mainUiState.startDestination
}