package ph.com.sheen.jetpackcomposemultimodule.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import ph.com.sheen.dashboard.dashboardNavigationRoute
import ph.com.sheen.dashboard.navigateToDashboardScreen
import ph.com.sheen.jetpackcomposemultimodule.MainUiState
import ph.com.sheen.jetpackcomposemultimodule.navigation.TopLevelDestination
import ph.com.sheen.login.loginNavigationRoute
import ph.com.sheen.notification.navigateToNotificationScreen
import ph.com.sheen.notification.notificationNavigationRoute
import ph.com.sheen.profile.navigateToProfileScreen
import ph.com.sheen.profile.profileNavigationRoute


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
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination


    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            dashboardNavigationRoute -> TopLevelDestination.DASHBOARD
            notificationNavigationRoute -> TopLevelDestination.NOTIFICATION
            profileNavigationRoute -> TopLevelDestination.PROFILE
            else -> null
        }

    val startDestination = mainUiState.startDestination

    val topLevelDestination: List<TopLevelDestination> = TopLevelDestination.entries.toList()

    val isShowBottomBar = startDestination != loginNavigationRoute

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.DASHBOARD -> navController.navigateToDashboardScreen(
                topLevelNavOptions
            )

            TopLevelDestination.NOTIFICATION -> navController.navigateToNotificationScreen(
                topLevelNavOptions
            )

            TopLevelDestination.PROFILE -> navController.navigateToProfileScreen(topLevelNavOptions)
        }
    }
}