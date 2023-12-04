package ph.com.sheen.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val profileNavigationRoute = "profile-route"

fun NavGraphBuilder.profileGraph(nestedGraphs: NavGraphBuilder.() -> Unit = {}) {
    composable(route = profileNavigationRoute) {
        ProfileRoute()
        nestedGraphs()
    }
}

fun NavController.navigateToProfileScreen(navOptions: NavOptions? = null) {
    this.navigate(route = profileNavigationRoute, navOptions = navOptions)
}