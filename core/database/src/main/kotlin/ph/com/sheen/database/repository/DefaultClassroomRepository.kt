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

    override fun saveClassroom(classroom: Classroom) {
        //TODO to be enhance
        val entity = ClassroomEntity(id = classroom.id)
        dao.insert(classroomEntity = entity)
    }
}