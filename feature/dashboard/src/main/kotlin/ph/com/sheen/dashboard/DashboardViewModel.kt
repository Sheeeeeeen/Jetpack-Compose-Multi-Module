package ph.com.sheen.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ph.com.sheen.data.ClassroomRepository
import ph.com.sheen.data.model.Classroom
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val classroomRepository: ClassroomRepository) :
    ViewModel() {


    private val classrooms = classroomRepository.fetchClassroom().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

    val uiState = MutableStateFlow(DashboardUiState()).combine(classrooms) { uiState, classrooms ->
        uiState.copy(classrooms = classrooms)
    }

    init {
        classroomRepository.fetchClassroom()
    }

    fun saveClassroom(classroom: Classroom) {
        viewModelScope.launch {
            classroomRepository.saveClassroom(classroom)
        }
    }
}

data class DashboardUiState(val classrooms: List<Classroom> = emptyList())