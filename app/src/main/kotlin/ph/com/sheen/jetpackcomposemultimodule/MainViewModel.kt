package ph.com.sheen.jetpackcomposemultimodule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ph.com.sheen.dashboard.dashboardNavigationRoute
import ph.com.sheen.datastore.UserDataStore
import ph.com.sheen.login.loginNavigationRoute
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dataStore: UserDataStore) : ViewModel() {

   val isUserLoggedIn = dataStore.getIsUserLogin().stateIn(
       scope = viewModelScope,
       started = SharingStarted.WhileSubscribed(5000L),
       initialValue = false
   )
}