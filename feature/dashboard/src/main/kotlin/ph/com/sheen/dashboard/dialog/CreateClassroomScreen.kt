package ph.com.sheen.dashboard.dialog

import androidx.compose.runtime.Composable

@Composable
fun BuildCreateClassroomScreen(
    block: @Composable CreateClassroomComponent.() -> Unit = {},
) {
    val typeSafeScreen = CreateClassroomComponent()
    typeSafeScreen.block()
}

class CreateClassroomComponent {

    @Composable
    fun AppBar() {
        TODO("TBI")
    }
}