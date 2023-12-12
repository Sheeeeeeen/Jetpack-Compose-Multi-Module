package ph.com.sheen.data.model

import ph.com.sheen.database.entity.ClassroomEntity
import java.util.UUID

data class Classroom(
    val id: UUID,
    val category: String,
    val level: Byte,
    val courseName: String,
    val createdDate: Long = System.currentTimeMillis(),
    val lastUpdateDate: Long = System.currentTimeMillis(),
)

fun ClassroomEntity.toModel(): Classroom {
    return Classroom(
        id = this.id,
        category = this.category,
        level = level,
        courseName = courseName,
        createdDate = createdDate,
        lastUpdateDate = lastUpdateDate
    )
}

fun Classroom.toEntityModel(): ClassroomEntity {
    return ClassroomEntity(
        id = this.id,
        category = this.category,
        level = level,
        courseName = courseName,
        createdDate = createdDate,
        lastUpdateDate = lastUpdateDate
    )
}

fun List<ClassroomEntity>.toModels(): List<Classroom> {
    return this.map {
        it.toModel()
    }
}

fun createClassroom(
    category: String,
    level: Byte,
    courseName: String,
    createdDate: Long = System.currentTimeMillis(),
    lastUpdateDate: Long = System.currentTimeMillis(),
): Classroom {
    val id = UUID.randomUUID()
    return Classroom(
        id = id,
        category = category,
        level = level,
        courseName = courseName,
        createdDate = createdDate,
        lastUpdateDate = lastUpdateDate
    )
}