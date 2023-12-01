package ph.com.sheen.jetpackcomposemultimodule.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import ph.com.sheen.designsystem.icon.AppIcons
import ph.com.sheen.dashboard.R as dashR

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    DASHBOARD(
        selectedIcon = AppIcons.Home,
        unselectedIcon = AppIcons.HomeBorder,
        iconTextId = dashR.string.dashboard,
        titleTextId = dashR.string.dashboard,
    ),

    DASHBOARD2(
        selectedIcon = AppIcons.Home,
        unselectedIcon = AppIcons.HomeBorder,
        iconTextId = dashR.string.dashboard,
        titleTextId = dashR.string.dashboard,
    ),

    DASHBOARD3(
        selectedIcon = AppIcons.Home,
        unselectedIcon = AppIcons.HomeBorder,
        iconTextId = dashR.string.dashboard,
        titleTextId = dashR.string.dashboard,
    )
}