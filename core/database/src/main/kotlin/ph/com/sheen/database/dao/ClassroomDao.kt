package ph.com.sheen.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ph.com.sheen.database.ClassroomEntity
import java.util.UUID

@Dao
interface ClassroomDao {

    @Query("SELECT * FROM classroom")
    fun getAllClassroom(): Flow<List<ClassroomEntity>>

    @Insert
    suspend fun insert(classroomEntity: ClassroomEntity): Long

    @Delete
    suspend fun deleteClassroom(classroomEntity: ClassroomEntity)

    @Update
    suspend fun updateClassroom(classroomEntity: ClassroomEntity)

    @Query("SELECT * FROM classroom WHERE id = :id")
    suspend fun findClassroomById(id: UUID): ClassroomEntity?

}
