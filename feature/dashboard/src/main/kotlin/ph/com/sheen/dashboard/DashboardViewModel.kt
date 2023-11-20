package ph.com.sheen.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ph.com.sheen.dashboard.model.ClassroomUi
import ph.com.sheen.dashboard.model.toListOfClassroomUiModel
import ph.com.sheen.data.ClassroomRepository
import ph.com.sheen.data.model.Classroom
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val classroomRepository: ClassroomRepository) :
    ViewModel() {


    private val classrooms = classroomRepository.fetchClassroom()

    val uiState = MutableStateFlow(DashboardUiState()).combine(classrooms) { uiState, classrooms ->
        uiState.copy(classrooms = classrooms.toListOfClassroomUiModel())
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = DashboardUiState()
    )

    init {
        classroomRepository.fetchClassroom()
    }

    fun saveClassroom(classroom: Classroom) {
        viewModelScope.launch {
            classroomRepository.saveClassroom(classroom)
        }
    }

    fun deleteClassroom(classroom: Classroom) {
        viewModelScope.launch {
            classroomRepository.deleteClassroom(classroom = classroom)
        }
    }
}

data class DashboardUiState(val classrooms: List<ClassroomUi> = emptyList())