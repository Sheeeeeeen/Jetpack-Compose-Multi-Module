package ph.com.sheen.database

import kotlinx.coroutines.flow.Flow

interface ClassroomRepository {
    fun fetchClassroom(): Flow<List<Classroom>>

    suspend fun saveClassroom(classroom: Classroom)

    fun deleteClassroom(classroom: Classroom)

    suspend fun updateClassroom(classroom: Classroom)
}