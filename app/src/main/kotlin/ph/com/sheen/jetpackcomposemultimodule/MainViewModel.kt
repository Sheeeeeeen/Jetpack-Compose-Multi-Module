package ph.com.sheen.jetpackcomposemultimodule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ph.com.sheen.dashboard.dashboardNavigationRoute
import ph.com.sheen.datastore.UserDataStore
import ph.com.sheen.login.loginNavigationRoute
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dataStore: UserDataStore) : ViewModel() {

    val mainUiState = MutableStateFlow(MainUiState())

    init {
        viewModelScope.launch {
            dataStore.getIsUserLogin().collect { isUserLoggedIn ->
                val startDestination =
                    if (isUserLoggedIn) dashboardNavigationRoute else loginNavigationRoute
                mainUiState.update {
                    it.copy(
                        keepScreenShowing = false,
                        startDestination = startDestination
                    )
                }
            }
        }
    }
}