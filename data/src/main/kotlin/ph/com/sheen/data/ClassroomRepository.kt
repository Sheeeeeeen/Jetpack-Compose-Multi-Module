package ph.com.sheen.data

import kotlinx.coroutines.flow.Flow
import ph.com.sheen.data.model.Classroom
import java.util.UUID

interface ClassroomRepository {

    fun fetchClassroom(): Flow<List<Classroom>>

    suspend fun saveClassroom(classroom: Classroom)

    suspend fun deleteClassroom(classroom: Classroom)

    suspend fun updateClassroom(classroom: Classroom)

    suspend fun findClassroom(id: UUID): Classroom?
}