@file:OptIn(ExperimentalFoundationApi::class)

package ph.com.sheen.dashboard.dialog

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.text.isDigitsOnly
import ph.com.sheen.dashboard.dropdown.SelectionCategory
import ph.com.sheen.dashboard.model.SavedCreatedClassroom
import ph.com.sheen.designsystem.theme.ui.AppPreview

@Composable
fun CreateClassroomDialog(
    onDismissRequest: () -> Unit,
    onTappedSave: (SavedCreatedClassroom) -> Unit = {},
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        CreateClassroomScreen(
            onTappedClose = onDismissRequest,
            onTappedSave = onTappedSave
        )
    }
}

@Composable
fun CreateClassroomScreen(
    modifier: Modifier = Modifier,
    onTappedClose: () -> Unit = {},
    onTappedSave: (SavedCreatedClassroom) -> Unit = {},
) {
    var selectedCategory by rememberSaveable { mutableStateOf("") }

    var level by rememberSaveable { mutableStateOf("") }

    var courseName by rememberSaveable { mutableStateOf("") }

    val isCollegeSelected by derivedStateOf { selectedCategory == SelectionCategory.COLLEGE.value }

    BuildCreateClassroomScreen {
        Container(modifier = modifier) {
            AppBar(onTappedClose = onTappedClose)
            MainContent(modifier = Modifier.padding(16.dp)) {
                CategoryDropdownField(onCategorySelected = { selectedCategory = it })
                CourseNameField(isVisible = isCollegeSelected,
                    value = courseName,
                    onValueChanged = { courseName = it })
                YearLevelField(value = level, onValueChanged = {
                    if (it.isDigitsOnly() && it.length <= 2) level = it
                })
                FillUpSpace()
                SaveButton(onTappedSave = {
                    val isFormCompleted = if (selectedCategory == SelectionCategory.COLLEGE.value) {
                        courseName.isNotBlank() && level.isNotBlank()
                    } else {
                        level.isNotBlank()
                    }
                    if (isFormCompleted.not())
                        return@SaveButton
                    onTappedSave(
                        SavedCreatedClassroom(
                            category = selectedCategory,
                            level = level.toByte(),
                            courseName = courseName
                        )
                    )
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CreateClassroomScreenPreview() {
    AppPreview {
        CreateClassroomScreen()
    }
}