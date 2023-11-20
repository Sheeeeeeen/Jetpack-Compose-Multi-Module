package ph.com.sheen.database.dao

import kotlinx.coroutines.flow.Flow
import ph.com.sheen.database.ClassroomEntity

interface ClassroomDao {

    fun getAllClassroom(): Flow<List<ClassroomEntity>>

    fun insert(classroomEntity: ClassroomEntity)

    fun deleteClassroom(classroomEntity: ClassroomEntity)

    fun updateClassroom(classroomEntity: ClassroomEntity)

}
