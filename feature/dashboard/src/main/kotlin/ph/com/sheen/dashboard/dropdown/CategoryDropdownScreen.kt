@file:OptIn(ExperimentalMaterial3Api::class)

package ph.com.sheen.dashboard.dropdown

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import ph.com.sheen.designsystem.theme.ui.AppPreview


@Composable
fun CategoryDropdownScreen(
    value: String,
    items: List<String>,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    onItemSelected: (String) -> Unit = {},
    onExpanded: (Boolean) -> Unit = {},
) {

    ExposedDropdownMenuBox(
        modifier = modifier.fillMaxWidth(),
        expanded = expanded,
        onExpandedChange = { onExpanded(expanded.not()) }
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth().menuAnchor().testTag("category_field_tag"),
            textStyle = MaterialTheme.typography.bodyLarge,
            label = label,
            singleLine = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            readOnly = true
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { onExpanded(false) }
        ) {
            items.forEach {
                DropdownMenuItem(
                    text = { Text(it) },
                    onClick = {
                        onItemSelected(it)
                        onExpanded(false)
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryDropdownScreenPreview() {
    AppPreview {
        val items = SelectionCategory.entries.map { it.value }
        CategoryDropdownScreen(
            value = "Sample",
            items = items,
            expanded = true,
            label = {
                Text("Classroom Name")
            }
        )
    }
}