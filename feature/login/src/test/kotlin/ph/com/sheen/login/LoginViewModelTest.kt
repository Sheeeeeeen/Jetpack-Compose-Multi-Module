package ph.com.sheen.login

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.test.core.app.ApplicationProvider
import app.cash.turbine.test
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ph.com.sheen.datastore.DefaultUserDataStore
import ph.com.sheen.login.model.LoginStatus

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class LoginViewModelTest {

    private val testCoroutineDispatcher: TestDispatcher = UnconfinedTestDispatcher()
    private val testCoroutineScope = TestScope(testCoroutineDispatcher + Job())

    private val testContext: Context = ApplicationProvider.getApplicationContext()

    private val testDataStore: DataStore<Preferences> =
        PreferenceDataStoreFactory.create(scope = testCoroutineScope,
            produceFile = { testContext.preferencesDataStoreFile(DefaultUserDataStore.PREFERENCE_USER_SETTING) })

    private lateinit var userDataStore: DefaultUserDataStore
    private lateinit var viewModel: LoginViewModel

    @Before
    fun setup() {
        userDataStore = DefaultUserDataStore(dataStore = testDataStore)
        viewModel = LoginViewModel(userDataStore = userDataStore)
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
            viewModel.login()
            viewModel.uiState.test {
                val result = awaitItem()
                assertTrue(result.isLoading.not())
            }
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

    @Test
    fun `test Login ui state when the login is successful and LoginStatus is Successful`() {
        runBlocking {
            viewModel.login()
            viewModel.uiState.test {
                val result = awaitItem()
                assertTrue(result.loginStatus == LoginStatus.Successful)
            }
        }
    }
}