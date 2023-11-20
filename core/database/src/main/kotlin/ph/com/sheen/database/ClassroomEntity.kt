package ph.com.sheen.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(
    tableName = "classroom"
)
data class ClassroomEntity(
    @PrimaryKey val id: UUID
) {
    fun toModel(): Classroom {
        return Classroom(id = this.id)
    }

}

fun List<ClassroomEntity>.toModels(): List<Classroom> {
    return this.map {
        it.toModel()
    }
}
