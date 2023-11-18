package ph.com.sheen.database.repository

import kotlinx.coroutines.flow.Flow
import ph.com.sheen.database.Classroom
import ph.com.sheen.database.ClassroomRepository
import ph.com.sheen.database.dao.ClassroomDao

class DefaultClassroomRepository(dao: ClassroomDao) : ClassroomRepository {
    override fun fetchClassroom(): Flow<List<Classroom>> {
        TODO("Not yet implemented")
    }

}