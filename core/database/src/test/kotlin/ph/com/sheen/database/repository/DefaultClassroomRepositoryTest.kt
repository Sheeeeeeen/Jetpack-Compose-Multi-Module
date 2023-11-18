package ph.com.sheen.database.repository

import app.cash.turbine.test
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import ph.com.sheen.database.ClassroomEntity
import ph.com.sheen.database.dao.ClassroomDao
import java.util.UUID

@OptIn(ExperimentalCoroutinesApi::class)
class DefaultClassroomRepositoryTest {

    private lateinit var classroomDao: ClassroomDao
    private lateinit var defaultClassroomRepository: DefaultClassroomRepository

    @Before
    fun setup() {
        val classrooms = mutableListOf<List<ClassroomEntity>>()
        classroomDao = object : ClassroomDao {
            override fun getAllClassroom(): Flow<List<ClassroomEntity>> {
                insertEmpty()
                return classrooms.asFlow()
            }

            override fun insert(classroomEntity: ClassroomEntity) {
                classrooms.add(index = 0, element = listOf(classroomEntity))
            }

            fun insertEmpty(list: List<ClassroomEntity> = emptyList()) {
                classrooms.add(list)
            }
        }
        defaultClassroomRepository = DefaultClassroomRepository(dao = classroomDao)
    }

    //retrieve list of classroom
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
    fun `test add classroom`() = runTest {
        val id = UUID.randomUUID()
        val classroomEntity = ClassroomEntity(id = id)
        defaultClassroomRepository.saveClassroom(classroom = classroomEntity.toModel())
        val listOfClassroom = defaultClassroomRepository.fetchClassroom()
        listOfClassroom.test {
            val classroom = awaitItem().first { it.id == id }
            assertTrue(classroom == classroomEntity.toModel())
            cancelAndConsumeRemainingEvents()
        }
    }

    //retrieve classroom via id

    //delete classroom

    //delete classrooms

    //update classroom
}