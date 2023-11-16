package ph.com.sheen.dashboard

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val dashboardNavigationRoute = "dashboard-route"
fun NavGraphBuilder.dashboardGraph(
    nestedGraphs: NavGraphBuilder.() -> Unit = {},
) {
    composable(route = dashboardNavigationRoute) {
        DashboardRoute()
    }
}

fun NavController.navigateToDashboardScreen(){
    this.navigate(route = dashboardNavigationRoute){
        launchSingleTop = true
    }
}

