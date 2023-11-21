package ph.com.sheen.dashboard.model

import ph.com.sheen.data.model.Classroom
import java.util.UUID

@JvmInline
value class ClassroomHeader(val value: String)

@JvmInline
value class ClassroomName(val value: String)

data class ClassroomUi(
    val id: UUID,
    val header: ClassroomHeader,
    val classroomName: ClassroomName,
)

fun Classroom.toUiModel(): ClassroomUi {
    return ClassroomUi(
        id = id,
        header = ClassroomHeader(value = id.toString().substring(0, 1)),
        classroomName = ClassroomName(value = id.toString())
    )
}

fun List<Classroom>.toListOfClassroomUiModel(): List<ClassroomUi> {
    return this.map { it.toUiModel() }
}
