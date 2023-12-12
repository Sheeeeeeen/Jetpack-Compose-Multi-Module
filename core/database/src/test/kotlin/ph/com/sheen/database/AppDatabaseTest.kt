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
import ph.com.sheen.database.util.createClassroomEntity
import java.io.IOException

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

        val classroomEntity = createClassroomEntity()

        val result = classroomDao.insert(classroomEntity = classroomEntity)

        assertTrue(result == 1L)
    }

    //retrieve entity by id
    @Test
    fun `test retrieval of classroom using query transaction`() = runTest {

        val classroomEntity = createClassroomEntity()

        classroomDao.insert(classroomEntity = classroomEntity)
        val entity = classroomDao.findClassroomById(id = classroomEntity.id)

        assertTrue(entity == classroomEntity)
    }

    //update
    @Test
    fun `test update of a classroom`() = runTest {

        val classroomEntity = createClassroomEntity()

        classroomDao.insert(classroomEntity = classroomEntity)
        val newUpdateDate = System.currentTimeMillis()
        val updateEntity = classroomEntity.copy(lastUpdateDate = newUpdateDate)
        classroomDao.updateClassroom(classroomEntity = updateEntity)
        val retrieveClassroom = classroomDao.findClassroomById(id = classroomEntity.id)

        assertTrue(updateEntity == retrieveClassroom)
    }

    //delete
    @Test
    fun `test deletion of a classroom`() = runTest {

        val newClassroomEntity = createClassroomEntity()

        classroomDao.insert(newClassroomEntity)
        classroomDao.deleteClassroom(newClassroomEntity)
        val retrieveClassroom = classroomDao.findClassroomById(id = newClassroomEntity.id)

        assertTrue(retrieveClassroom == null)

    }
}