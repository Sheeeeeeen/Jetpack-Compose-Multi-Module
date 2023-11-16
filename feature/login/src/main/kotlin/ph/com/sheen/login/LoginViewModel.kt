package ph.com.sheen.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _uiState: MutableStateFlow<LoginUIState> = MutableStateFlow(LoginUIState())
    val uiState: StateFlow<LoginUIState>
        get() = _uiState

    private fun setUiStateToLoading() {
        _uiState.update {
            it.copy(isLoading = true)
        }
    }

    fun login() {
        setUiStateToLoading()
    }
}

data class LoginUIState(
    val isLoading: Boolean = false,
) {

}
