package ph.com.sheen.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ph.com.sheen.database.Classroom
import ph.com.sheen.database.dao.ClassroomDao
import ph.com.sheen.database.entity.ClassroomEntity
import ph.com.sheen.database.entity.toModels
import java.util.UUID

class DefaultClassroomRepository(private val dao: ClassroomDao) : ClassroomRepository {

    override fun fetchClassroom(): Flow<List<Classroom>> {
        return dao.getAllClassroom().map {
            it.toModels()
        }
    }

    override suspend fun saveClassroom(classroom: Classroom) {
        val entity = ClassroomEntity(id = classroom.id, lastUpdateDate = classroom.lastUpdateDate)
        dao.insert(classroomEntity = entity)
    }

    override suspend fun deleteClassroom(classroom: Classroom) {
        val entity = ClassroomEntity(id = classroom.id, lastUpdateDate = classroom.lastUpdateDate)
        dao.deleteClassroom(classroomEntity = entity)
    }

    override suspend fun updateClassroom(classroom: Classroom) {
        val entity = ClassroomEntity(id = classroom.id, lastUpdateDate = classroom.lastUpdateDate)
        dao.updateClassroom(classroomEntity = entity)
    }

    override suspend fun findClassroom(id: UUID): Classroom? {
        return dao.findClassroomById(id = id)?.toModel()
    }
}