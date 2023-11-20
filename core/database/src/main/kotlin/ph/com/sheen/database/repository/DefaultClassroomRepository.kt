package ph.com.sheen.database.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ph.com.sheen.database.Classroom
import ph.com.sheen.database.ClassroomEntity
import ph.com.sheen.database.ClassroomRepository
import ph.com.sheen.database.dao.ClassroomDao
import ph.com.sheen.database.toModels

class DefaultClassroomRepository(private val dao: ClassroomDao) : ClassroomRepository {
    override fun fetchClassroom(): Flow<List<Classroom>> {
        return dao.getAllClassroom().map {
            it.toModels()
        }
    }

    override suspend fun saveClassroom(classroom: Classroom) {
        //TODO to be enhance
        val updateDate = System.currentTimeMillis()
        val entity = ClassroomEntity(id = classroom.id, lastUpdateDate = updateDate)
        dao.insert(classroomEntity = entity)
    }

    override fun deleteClassroom(classroom: Classroom) {
        val updateDate = System.currentTimeMillis()
        val entity = ClassroomEntity(id = classroom.id, lastUpdateDate = updateDate)
        dao.deleteClassroom(classroomEntity = entity )
    }

    override suspend fun updateClassroom(classroom: Classroom) {
        val updateDate = System.currentTimeMillis()
        val entity = ClassroomEntity(id = classroom.id, lastUpdateDate = updateDate)
        dao.updateClassroom(classroomEntity = entity )
    }
}