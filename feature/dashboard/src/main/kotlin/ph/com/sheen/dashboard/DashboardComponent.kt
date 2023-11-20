package ph.com.sheen.dashboard

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    fun AppBar(modifier: Modifier = Modifier) {
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
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Outlined.Menu, contentDescription = "menu")
                }
            },
            actions = {
                IconButton(onClick = {}) {
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
    fun ClassroomItem(modifier: Modifier = Modifier) {
        Row(
            modifier = modifier
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
                    text = "A",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                modifier = Modifier.weight(1f),
                text = "Headline",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            Icon(
                imageVector = Icons.Outlined.MoreVert,
                contentDescription = "icon",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
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
                            ClassroomItem(modifier = Modifier)
                        }
                    }
                }
            }

        }
    }
}