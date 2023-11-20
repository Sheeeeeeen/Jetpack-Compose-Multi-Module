package ph.com.sheen.database.repository

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ph.com.sheen.database.AppDatabase
import ph.com.sheen.database.entity.ClassroomEntity
import ph.com.sheen.database.dao.ClassroomDao
import java.util.UUID

@RunWith(RobolectricTestRunner::class)
class DefaultClassroomRepositoryTest {

    private lateinit var appDatabase: AppDatabase

    private lateinit var classroomDao: ClassroomDao

    private lateinit var defaultClassroomRepository: DefaultClassroomRepository

    @Before
    fun setup() {
        val context: Context = ApplicationProvider.getApplicationContext()
        appDatabase =
            Room.inMemoryDatabaseBuilder(context = context, AppDatabase::class.java).build()
        classroomDao = appDatabase.classroomDao()
        defaultClassroomRepository = DefaultClassroomRepository(dao = classroomDao)
    }


    @Test
    fun `test retrieval of classrooms has empty list`() = runTest {

        val listOfClassroom = defaultClassroomRepository.fetchClassroom()

        listOfClassroom.test {
            assertTrue(awaitItem().isEmpty())
            cancelAndIgnoreRemainingEvents()
        }
    }

    //add classroom
    @Test
    fun `test add classroom with 1 item on list`() = runTest {

        val insertedClassroomEntity = createClassroomEntity()
        val classroomModel = insertedClassroomEntity.toModel()

        defaultClassroomRepository.saveClassroom(classroom = classroomModel)
        val listOfClassroom = defaultClassroomRepository.fetchClassroom()

        listOfClassroom.test {
            val classrooms = awaitItem()
            val id = insertedClassroomEntity.id
            val filterClassroom = classrooms.first { it.id == id }
            assertTrue(filterClassroom == insertedClassroomEntity.toModel())
            assertTrue(classrooms.isNotEmpty())
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `test retrieve classroom via id`() = runTest {

        val listOfClassroom = defaultClassroomRepository.fetchClassroom()

        listOfClassroom.test {
            val classrooms = awaitItem()
            assertTrue(classrooms.isEmpty())
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `test delete classroom`() = runTest {

        val insertedClassroomEntity = createClassroomEntity()
        val classroomModel = insertedClassroomEntity.toModel()

        defaultClassroomRepository.saveClassroom(classroom = classroomModel)
        defaultClassroomRepository.deleteClassroom(classroom = classroomModel)
        val listOfClassroom = defaultClassroomRepository.fetchClassroom()

        listOfClassroom.test {
            val classrooms = awaitItem()
            assertTrue(classrooms.isEmpty())
            cancelAndConsumeRemainingEvents()
        }
    }

    //update classroom
    @Test
    fun `test update classroom`() = runTest {

        val newUpdateDate = System.currentTimeMillis()

        val insertedClassroomEntity = createClassroomEntity()
        val classroomModel = insertedClassroomEntity.toModel()

        defaultClassroomRepository.saveClassroom(classroom = classroomModel)

        val updatedClassroom = classroomModel.copy(lastUpdateDate = newUpdateDate)
        defaultClassroomRepository.updateClassroom(classroom = updatedClassroom)

        val retrieveClassroom = defaultClassroomRepository.findClassroom(id = updatedClassroom.id)
        assertTrue(retrieveClassroom == updatedClassroom)
    }

    private fun createClassroomEntity(): ClassroomEntity {
        val id = UUID.randomUUID()
        val updateDate = System.currentTimeMillis()
        return ClassroomEntity(id = id, lastUpdateDate = updateDate)
    }
}