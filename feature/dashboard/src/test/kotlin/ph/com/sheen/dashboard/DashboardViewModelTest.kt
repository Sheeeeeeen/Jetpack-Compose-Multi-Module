package ph.com.sheen.dashboard

import app.cash.turbine.test
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import ph.com.sheen.dashboard.fake.FakeClassroomRepository
import ph.com.sheen.data.ClassroomRepository
import ph.com.sheen.data.model.Classroom
import java.util.UUID

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewModelTest {

    private lateinit var viewModel: DashboardViewModel

    private val classroomRepository: ClassroomRepository = FakeClassroomRepository()

    private val testCoroutineDispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testCoroutineDispatcher)
        viewModel = DashboardViewModel(classroomRepository = classroomRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    //retrieve list of classroom
    @Test
    fun `test to retrieve empty list of classroom`() = runTest {
        //setup

        //action

        //assert
        viewModel.uiState.test {
            assertTrue(awaitItem().classrooms.isEmpty())
        }
    }

    @Test
    fun `test inserting of classroom model and return non empty list`() = runTest {

        val classroom = createClassroomModel()

        viewModel.saveClassroom(classroom = classroom)

        viewModel.uiState.test {
            assertTrue(awaitItem().classrooms.isNotEmpty())
        }
    }

    @Test
    fun `test delete classroom on list`() = runTest {

        val classroom = createClassroomModel()

        viewModel.saveClassroom(classroom = classroom)
        viewModel.deleteClassroom(classroom = classroom)

        viewModel.uiState.test {
            assertTrue(awaitItem().classrooms.isEmpty())
        }
    }

    private fun createClassroomModel(): Classroom {
        val id = UUID.randomUUID()
        val updateDate = System.currentTimeMillis()
        return Classroom(id = id, lastUpdateDate = updateDate)
    }
}