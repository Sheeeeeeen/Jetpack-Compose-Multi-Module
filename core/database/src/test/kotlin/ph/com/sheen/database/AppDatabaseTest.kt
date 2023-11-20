package ph.com.sheen.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ph.com.sheen.database.dao.ClassroomDao
import java.io.IOException
import java.util.UUID

@RunWith(RobolectricTestRunner::class)
class AppDatabaseTest {

    private lateinit var db: AppDatabase

    private lateinit var classroomDao: ClassroomDao

    @Before
    fun createDB() {
        val context: Context = ApplicationProvider.getApplicationContext()
        db = Room.inMemoryDatabaseBuilder(context = context, AppDatabase::class.java).build()
        classroomDao = db.classroomDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    //insert
    @Test
    fun `test insertion and retrieval to verify classroom entity record`() = runTest {
        //setup
        val id = UUID.randomUUID()
        val classroomEntity = ClassroomEntity(id = id)
        //action
        val result = classroomDao.insert(classroomEntity = classroomEntity)
        //assert
        assertTrue(result == 1L)
    }

    //retrieve entity by id
    //update
    //delete
}