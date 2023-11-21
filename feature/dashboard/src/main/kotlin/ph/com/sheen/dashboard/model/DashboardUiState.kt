package ph.com.sheen.dashboard.model

import ph.com.sheen.data.model.Classroom

data class DashboardUiState(val classrooms: List<Classroom> = emptyList())
