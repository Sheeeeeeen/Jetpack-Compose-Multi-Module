package ph.com.sheen.jetpackcomposemultimodule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ph.com.sheen.datastore.UserDataStore
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dataStore: UserDataStore) : ViewModel() {

    val isUserLoggedIn = dataStore.getIsUserLogin().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = false
    )

    val shouldKeepSplashScreen = MutableStateFlow(true)

    init {
        viewModelScope.launch {
            delay(3000L)
            shouldKeepSplashScreen.update {
                false
            }
        }
    }
}