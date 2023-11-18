package ph.com.sheen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ph.com.sheen.datastore.UserDataStore
import ph.com.sheen.login.model.LoginStatus
import ph.com.sheen.login.model.LoginUIState
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userDataStore: UserDataStore) : ViewModel() {

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
        viewModelScope.launch { userDataStore.setUserIsLoginStatus(true) }
        _uiState.update {
            it.copy(loginStatus = userLoginStatus)
        }
    }
}
