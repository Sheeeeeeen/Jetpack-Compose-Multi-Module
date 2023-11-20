package ph.com.sheen.dashboard

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {

    val uiState = MutableStateFlow(DashboardUiState())

}

data class DashboardUiState(val classrooms: List<String> = emptyList())