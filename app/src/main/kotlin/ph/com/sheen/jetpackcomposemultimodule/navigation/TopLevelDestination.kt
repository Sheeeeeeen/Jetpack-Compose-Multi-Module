package ph.com.sheen.jetpackcomposemultimodule.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import ph.com.sheen.dashboard.R as dashR
import ph.com.sheen.designsystem.icon.AppIcons
import ph.com.sheen.jetpackcomposemultimodule.R

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
        titleTextId = R.string.app_name,
    )
}