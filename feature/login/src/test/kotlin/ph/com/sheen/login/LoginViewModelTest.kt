package ph.com.sheen.login

import app.cash.turbine.test
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ph.com.sheen.login.model.LoginStatus

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

    @Test
    fun `test Login ui state userloginStatus default value is UserNotLoggedIn`() {
        runBlocking {
            viewModel.uiState.test {
                val result = awaitItem()
                assertTrue(result.loginStatus == LoginStatus.UserNotLoggedIn)
            }
        }
    }
}