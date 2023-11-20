package ph.com.sheen.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ph.com.sheen.database.dao.ClassroomDao
import ph.com.sheen.database.entity.ClassroomEntity

@Database(entities = [ClassroomEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        val DB_NAME = "AppDatabase.db"
    }
    abstract fun classroomDao(): ClassroomDao
}