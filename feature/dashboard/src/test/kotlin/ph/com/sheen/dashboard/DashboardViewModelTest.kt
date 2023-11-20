//package ph.com.sheen.dashboard
//
//import android.content.Context
//import androidx.test.core.app.ApplicationProvider
//import kotlinx.coroutines.test.runTest
//import org.junit.Assert.assertTrue
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.robolectric.RobolectricTestRunner
//import ph.com.sheen.database.ClassroomRepository
//
//@RunWith(RobolectricTestRunner::class)
//class DashboardViewModelTest {
//
//    private lateinit var viewModel: DashboardViewModel
//
//    @Before
//    fun setup() {
//        val context: Context = ApplicationProvider.getApplicationContext()
//        viewModel = DashboardViewModel(classroomRepository = ClassroomRepository)
//    }
//
//    //retrieve list of classroom
//    @Test
//    fun `test to retrieve empty list of classroom`() = runTest {
//        //setup
//
//        //action
//
//        //assert
//        viewModel.uiState.test {
//            assertTrue(awaitItem().classrooms.isEmpty())
//        }
//    }
//}