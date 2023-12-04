package ph.com.sheen.jetpackcomposemultimodule.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import ph.com.sheen.designsystem.component.JetpackNavigationBar
import ph.com.sheen.designsystem.component.JetpackNavigationBarItem
import ph.com.sheen.jetpackcomposemultimodule.MainUiState
import ph.com.sheen.jetpackcomposemultimodule.navigation.AppNavHost
import ph.com.sheen.jetpackcomposemultimodule.navigation.TopLevelDestination

@Composable
fun JetpackComposeApp(
    mainUiState: MainUiState,
    appState: AppState = rememberAppState(mainUiState = mainUiState),
) {
    Scaffold(
        modifier = Modifier,
        bottomBar = {
            if (appState.isShowBottomBar.not())
                return@Scaffold
            JetpackBottomBar(
                destinations = appState.topLevelDestination,
                onNavigateToDestination = appState::navigateToTopLevelDestination,
                currentDestination = appState.currentDestination
            )
        }
    ) {
        AppNavHost(
            modifier = Modifier.padding(it),
            navController = appState.navController,
            startDestination = appState.startDestination
        )
    }
}

@Composable
private fun JetpackBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    JetpackNavigationBar(modifier = modifier) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            JetpackNavigationBarItem(
                modifier = Modifier,
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        imageVector = destination.unselectedIcon,
                        contentDescription = null
                    )
                },
                selectedIcon = {
                    Icon(
                        imageVector = destination.selectedIcon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(destination.titleTextId))
                },
                alwaysShowLabel = true
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false