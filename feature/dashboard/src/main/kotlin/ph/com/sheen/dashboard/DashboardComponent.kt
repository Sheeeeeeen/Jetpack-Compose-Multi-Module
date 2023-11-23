@file:OptIn(ExperimentalAnimationApi::class)

package ph.com.sheen.dashboard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ph.com.sheen.dashboard.model.ClassroomUi
import ph.com.sheen.dashboard.model.toUiModel
import ph.com.sheen.data.model.Classroom
import ph.com.sheen.data.model.createClassroom
import ph.com.sheen.designsystem.SwipeableContainer
import ph.com.sheen.designsystem.disableSplitMotionEvents
import ph.com.sheen.designsystem.theme.ui.AppPreview

@Composable
fun BuildLoginScreen(
    block: @Composable DashboardComponent.() -> Unit = {},
) {
    val typeSafeScreen = DashboardComponent()
    typeSafeScreen.block()
}

@OptIn(ExperimentalMaterial3Api::class)
class DashboardComponent {

    @Composable
    fun AppBar(
        modifier: Modifier = Modifier,
        onMenuTapped: () -> Unit = {},
        onNotificationTapped: () -> Unit = {},
    ) {
        TopAppBar(
            modifier = modifier,
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Dashboard",
                    style = MaterialTheme.typography.titleLarge
                )
            },
            navigationIcon = {
                IconButton(onClick = onMenuTapped) {
                    Icon(imageVector = Icons.Outlined.Menu, contentDescription = "menu")
                }
            },
            actions = {
                IconButton(onClick = onNotificationTapped) {
                    Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "menu")
                }
            }
        )
    }

    @Composable
    fun Container(
        modifier: Modifier = Modifier,
        topAppBar: @Composable () -> Unit,
        content: @Composable () -> Unit,
    ) {
        Scaffold(
            modifier = modifier, topBar = topAppBar
        ) {
            Box(modifier = modifier.fillMaxSize().padding(it)) {
                content()
            }
        }

    }

    @Composable
    fun ClassroomItem(
        modifier: Modifier = Modifier,
        classroomUi: ClassroomUi,
        onMoreTapped: () -> Unit = {},
        onSwipeDelete: () -> Unit = {},
    ) {
        SwipeableContainer(modifier = modifier) { modifier1 ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = "menu",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                IconButton(onClick = onSwipeDelete) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "menu",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            }
            Row(
                modifier = modifier1
                    .clickable { }
                    .background(color = MaterialTheme.colorScheme.surface)
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier,
                        text = classroomUi.header.value,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    modifier = Modifier.weight(1f),
                    text = classroomUi.classroomName.value,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                //TODO replace the action using swipe
                Icon(
                    modifier = Modifier.clickable { onMoreTapped() },
                    imageVector = Icons.Outlined.MoreVert,
                    contentDescription = "icon",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

    }

    @Composable
    fun ClassroomList(
        modifier: Modifier = Modifier,
        classrooms: List<Classroom> = emptyList(),
        onMoreTapped: (Classroom) -> Unit = {},
        onSwipeDelete: (Classroom) -> Unit = {},
    ) {
        LazyColumn(modifier = modifier.disableSplitMotionEvents()) {
            items(
                items = classrooms,
                key = { it.id }
            ) {
                val classroomUi = it.toUiModel()

                var visibility by remember { mutableStateOf(true) }

                AnimatedVisibility(
                    visible = visibility,
                ) {
                    ClassroomItem(
                        //TODO extract this animateEnterExit animation
                        modifier = Modifier.animateEnterExit(
                            exit = slideOutHorizontally(
                                targetOffsetX = { offset ->
                                    -offset / 1
                                }
                            )
                        ),
                        classroomUi = classroomUi,
                        onMoreTapped = { onMoreTapped(it) },
                        onSwipeDelete = {
                            visibility = false
                            onSwipeDelete(it)
                        },
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewClassroomItem() {
    AppPreview {
        BuildLoginScreen {
            ClassroomItem(
                modifier = Modifier,
                classroomUi = createClassroom().toUiModel()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewScreen() {
    AppPreview {
        BuildLoginScreen {
            Container(topAppBar = { AppBar() }) {
                LazyColumn(
                    modifier = Modifier.background(color = MaterialTheme.colorScheme.onBackground)
                ) {
                    repeat(100) {
                        item {
                            ClassroomItem(
                                modifier = Modifier,
                                classroomUi = createClassroom().toUiModel()
                            )
                        }
                    }
                }
            }

        }
    }
}