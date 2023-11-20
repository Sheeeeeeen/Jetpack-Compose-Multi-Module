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
    fun `test inserting of classroom entity`() = runTest {

        val id = UUID.randomUUID()
        val updateDate = System.currentTimeMillis()
        val classroomEntity = ClassroomEntity(id = id, lastUpdateDate = updateDate)

        val result = classroomDao.insert(classroomEntity = classroomEntity)

        assertTrue(result == 1L)
    }

    //retrieve entity by id
    @Test
    fun `test retrieval of classroom using query transaction`() = runTest {

        val id = UUID.randomUUID()
        val updateDate = System.currentTimeMillis()
        val classroomEntity = ClassroomEntity(id = id, lastUpdateDate = updateDate)

        classroomDao.insert(classroomEntity = classroomEntity)
        val entity = classroomDao.findClassroomById(id = id)

        assertTrue(entity == classroomEntity)
    }

    //update
    @Test
    fun `test update of a classroom`() = runTest {

        val id = UUID.randomUUID()
        val updateDate = System.currentTimeMillis()

        val classroomEntity = ClassroomEntity(id = id, lastUpdateDate = updateDate)

        classroomDao.insert(classroomEntity = classroomEntity)
        val newUpdateDate = System.currentTimeMillis()
        val updateEntity = classroomEntity.copy(lastUpdateDate = newUpdateDate)
        classroomDao.updateClassroom(classroomEntity = updateEntity)
        val retrieveClassroom = classroomDao.findClassroomById(id = id)

        assertTrue(updateEntity == retrieveClassroom)
    }

    //delete
    @Test
    fun `test deletion of a classroom`() = runTest {

        val id = UUID.randomUUID()
        val updateDate = System.currentTimeMillis()
        val newClassroomEntity = ClassroomEntity(id = id, lastUpdateDate = updateDate)

        classroomDao.insert(newClassroomEntity)
        classroomDao.deleteClassroom(newClassroomEntity)
        val retrieveClassroom = classroomDao.findClassroomById(id = id)

        assertTrue(retrieveClassroom == null)

    }
}