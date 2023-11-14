package ph.com.sheen.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val loginNavigationRoute = "login-route"

fun NavGraphBuilder.loginGraph() {
    composable(route = loginNavigationRoute) {
        LoginScreenRoute()
    }
}