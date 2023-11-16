package ph.com.sheen.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import ph.com.sheen.login.model.LoginStatus
import ph.com.sheen.login.model.LoginUIState
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

    private fun setUiStateToNotLoading() {
        _uiState.update {
            it.copy(isLoading = false)
        }
    }

    suspend fun login() {
        setUiStateToLoading()
        delay(3000)
        setUiStateToNotLoading()
        setUserLoggedInStatus(userLoginStatus = LoginStatus.Successful)
    }

    private fun setUserLoggedInStatus(userLoginStatus: LoginStatus) {
        _uiState.update {
            it.copy(loginStatus = userLoginStatus)
        }
    }
}
