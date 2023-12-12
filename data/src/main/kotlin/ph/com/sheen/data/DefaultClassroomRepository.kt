package ph.com.sheen.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ph.com.sheen.data.model.Classroom
import ph.com.sheen.data.model.toEntityModel
import ph.com.sheen.data.model.toModel
import ph.com.sheen.data.model.toModels
import ph.com.sheen.database.dao.ClassroomDao
import java.util.UUID

class DefaultClassroomRepository(private val dao: ClassroomDao) : ClassroomRepository {

    override fun fetchClassroom(): Flow<List<Classroom>> {
        return dao.getAllClassroom().map {
            it.toModels()
        }
    }

    override suspend fun saveClassroom(classroom: Classroom) {
        dao.insert(classroomEntity = classroom.toEntityModel())
    }

    override suspend fun deleteClassroom(classroom: Classroom) {
        dao.deleteClassroom(classroomEntity = classroom.toEntityModel())
    }

    override suspend fun updateClassroom(classroom: Classroom) {
        dao.updateClassroom(classroomEntity = classroom.toEntityModel())
    }

    override suspend fun findClassroom(id: UUID): Classroom? {
        return dao.findClassroomById(id = id)?.toModel()
    }
}