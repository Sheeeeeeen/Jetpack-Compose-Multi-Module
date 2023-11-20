package ph.com.sheen.database

import java.util.UUID

data class Classroom(val id: UUID, val lastUpdateDate: Long = System.currentTimeMillis())
