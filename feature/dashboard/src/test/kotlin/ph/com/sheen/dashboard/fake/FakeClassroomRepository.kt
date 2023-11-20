package ph.com.sheen.dashboard.fake

import kotlinx.coroutines.flow.Flow
import ph.com.sheen.data.ClassroomRepository
import ph.com.sheen.data.model.Classroom
import java.util.UUID

class FakeClassroomRepository : ClassroomRepository {
    override fun fetchClassroom(): Flow<List<Classroom>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveClassroom(classroom: Classroom) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteClassroom(classroom: Classroom) {
        TODO("Not yet implemented")
    }

    override suspend fun updateClassroom(classroom: Classroom) {
        TODO("Not yet implemented")
    }

    override suspend fun findClassroom(id: UUID): Classroom? {
        TODO("Not yet implemented")
    }

}