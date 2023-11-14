package ph.com.sheen.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val loginNavigationRoute = "login-route"

fun NavGraphBuilder.loginGraph(
    nestedGraphs: NavGraphBuilder.() -> Unit = {},
) {
    composable(route = loginNavigationRoute) {
        LoginScreenRoute()
    }
}