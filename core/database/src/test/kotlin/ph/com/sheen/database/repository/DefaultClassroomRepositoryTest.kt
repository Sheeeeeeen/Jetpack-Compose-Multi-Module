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

            fun insertEmpty() {
                classrooms.add(listOf())
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

    //retrieve classroom via id

    //delete classroom

    //delete classrooms

    //update classroom
}