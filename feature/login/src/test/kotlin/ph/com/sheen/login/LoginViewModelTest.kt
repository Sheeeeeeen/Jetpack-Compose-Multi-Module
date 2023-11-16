package ph.com.sheen.login

import android.util.Log
import app.cash.turbine.test
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.time.DurationUnit
import kotlin.time.toDuration

@RunWith(RobolectricTestRunner::class)
class LoginViewModelTest {

    private val testCoroutineDispatcher: TestDispatcher = UnconfinedTestDispatcher()
    private val testCoroutineScope = TestScope(testCoroutineDispatcher + Job())

    private lateinit var viewModel: LoginViewModel

    @Before
    fun setup() {
        viewModel = LoginViewModel()
    }

    @Test
    fun `test Login ui state isLoading default value is false`() {
        runBlocking {
            viewModel.uiState.test {
                assertFalse(awaitItem().isLoading)
            }
        }
    }

    @Test
    fun `test when user tap login button and show loading screen`() {
        runBlocking {
            viewModel.uiState.test {
                val result = awaitItem()
                assertTrue(result.isLoading.not())
            }
            viewModel.login()
        }
    }
}