package ph.com.sheen.database

import java.util.UUID

data class ClassroomEntity(val id: UUID) {
    fun toModel(): Classroom {
        return Classroom(id = this.id)
    }

}

fun List<ClassroomEntity>.toModels(): List<Classroom> {
    return this.map {
        it.toModel()
    }
}
