package ph.com.sheen.notification

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val notificationNavigationRoute = "notification-route"

fun NavGraphBuilder.notificationGraph(nestedGraphs: NavGraphBuilder.() -> Unit = {}) {
    composable(route = notificationNavigationRoute) {
        NotificationRoute()
        nestedGraphs()
    }
}

fun NavController.navigateToNotificationScreen() {
    this.navigate(route = notificationNavigationRoute) {
        launchSingleTop = true
    }
}