package ph.com.sheen.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(
    tableName = "classroom"
)
data class ClassroomEntity(
    @PrimaryKey val id: UUID,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "level") val level: Byte,
    @ColumnInfo(name = "course_name") val courseName: String,
    @ColumnInfo(name = "created_date") val createdDate: Long,
    @ColumnInfo(name = "last_update") val lastUpdateDate: Long,
)

