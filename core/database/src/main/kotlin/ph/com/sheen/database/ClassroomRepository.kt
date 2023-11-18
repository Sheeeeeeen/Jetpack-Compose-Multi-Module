package ph.com.sheen.database

import kotlinx.coroutines.flow.Flow

interface ClassroomRepository {
    fun fetchClassroom(): Flow<List<Classroom>>
}