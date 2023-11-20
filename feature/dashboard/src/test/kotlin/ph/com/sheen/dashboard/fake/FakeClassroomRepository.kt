package ph.com.sheen.dashboard.fake

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import ph.com.sheen.data.ClassroomRepository
import ph.com.sheen.data.model.Classroom
import java.util.UUID

class FakeClassroomRepository : ClassroomRepository {

    private val classrooms: MutableList<Classroom> = mutableListOf()
    override fun fetchClassroom(): Flow<List<Classroom>> {
        return listOf(classrooms).asFlow()
    }

    override suspend fun saveClassroom(classroom: Classroom) {
        classrooms.add(classroom)
    }

    override suspend fun deleteClassroom(classroom: Classroom) {
        classrooms.removeIf {
            it == classroom
        }
    }

    override suspend fun updateClassroom(classroom: Classroom) {
        TODO("Not yet implemented")
    }

    override suspend fun findClassroom(id: UUID): Classroom? {
        TODO("Not yet implemented")
    }

}