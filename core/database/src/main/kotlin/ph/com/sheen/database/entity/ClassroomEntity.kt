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
    @ColumnInfo(name = "last_update") val lastUpdateDate: Long,
)

