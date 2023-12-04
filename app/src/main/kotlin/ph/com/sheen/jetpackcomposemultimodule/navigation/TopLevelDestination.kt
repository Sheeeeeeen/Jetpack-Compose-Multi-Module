package ph.com.sheen.jetpackcomposemultimodule.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import ph.com.sheen.designsystem.icon.AppIcons
import ph.com.sheen.dashboard.R as dashR
import ph.com.sheen.notification.R as notificationR
import ph.com.sheen.profile.R as profileR

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

    NOTIFICATION(
        selectedIcon = AppIcons.Notification,
        unselectedIcon = AppIcons.NotificationBorder,
        iconTextId = notificationR.string.notification,
        titleTextId = notificationR.string.notification,
    ),

    PROFILE(
        selectedIcon = AppIcons.profile,
        unselectedIcon = AppIcons.profileBorder,
        iconTextId = profileR.string.profile,
        titleTextId = profileR.string.profile,
    )
}