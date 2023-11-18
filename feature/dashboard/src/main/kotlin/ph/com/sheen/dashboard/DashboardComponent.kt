package ph.com.sheen.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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

class DashboardComponent {

    @Composable
    fun Container(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
        Box(modifier = modifier.fillMaxSize()) {
            content()
        }
    }

    @Composable
    fun ClassroomItem(modifier: Modifier = Modifier) {
        Row(
            modifier = modifier.clickable { }
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(vertical = 8.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier.size(40.dp).background(
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
                imageVector = Icons.Outlined.Add,
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
            LazyColumn {
                repeat(100) {
                    item {
                        Container {
                            ClassroomItem(modifier = Modifier)
                        }
                    }
                }
            }
        }
    }
}