package ph.com.sheen.data.model

import ph.com.sheen.database.entity.ClassroomEntity
import java.util.UUID

data class Classroom(val id: UUID, val lastUpdateDate: Long = System.currentTimeMillis())

fun ClassroomEntity.toModel(): Classroom {
    return Classroom(id = this.id, lastUpdateDate = lastUpdateDate)
}

fun List<ClassroomEntity>.toModels(): List<Classroom> {
    return this.map {
        it.toModel()
    }
}

fun createClassroom(): Classroom {
    val id = UUID.randomUUID()
    val lastUpdate = System.currentTimeMillis()
    return Classroom(id = id, lastUpdateDate = lastUpdate)
}