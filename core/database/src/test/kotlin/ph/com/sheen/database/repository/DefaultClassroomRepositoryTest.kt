package ph.com.sheen.database.repository

import app.cash.turbine.test
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import ph.com.sheen.database.dao.ClassroomDao

class DefaultClassroomRepositoryTest {

    private lateinit var classroomDao: ClassroomDao
    private lateinit var defaultClassroomRepository: DefaultClassroomRepository

    @Before
    fun setup() {
        classroomDao = object : ClassroomDao {

        }
        defaultClassroomRepository = DefaultClassroomRepository(dao = classroomDao)
    }

    //retrieve list of classroom
    @Test
    fun `test retrieval of classrooms has empty list`() = runBlocking {
        val listOfClassroom = defaultClassroomRepository.fetchClassroom()
        listOfClassroom.test {
            assertTrue(awaitItem().isEmpty())
        }
    }

    //retrieve classroom via id

    //delete classroom

    //delete classrooms

    //update classroom
}