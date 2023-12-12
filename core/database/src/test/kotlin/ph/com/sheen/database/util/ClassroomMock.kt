package ph.com.sheen.database.util

import ph.com.sheen.database.entity.ClassroomEntity
import java.util.UUID
import kotlin.random.Random

fun createClassroomEntity(
    category: String = UUID.randomUUID().toString(),
    level: Byte = Random.nextBytes(10)[0],
    courseName: String = UUID.randomUUID().toString(),
    createdDate: Long = System.currentTimeMillis(),
    lastUpdateDate: Long = System.currentTimeMillis(),
): ClassroomEntity {
    val id = UUID.randomUUID()
    return ClassroomEntity(
        id = id,
        category = category,
        level = level,
        courseName = courseName,
        createdDate = createdDate,
        lastUpdateDate = lastUpdateDate
    )
}