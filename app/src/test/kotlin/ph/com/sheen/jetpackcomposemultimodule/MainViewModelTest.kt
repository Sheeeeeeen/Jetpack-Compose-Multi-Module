package ph.com.sheen.jetpackcomposemultimodule

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ph.com.sheen.dashboard.dashboardNavigationRoute
import ph.com.sheen.datastore.DefaultUserDataStore
import ph.com.sheen.datastore.UserDataStore
import ph.com.sheen.login.loginNavigationRoute

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class MainViewModelTest {

    private val testContext: Context = ApplicationProvider.getApplicationContext()
    private val testCoroutineDispatcher: TestDispatcher = UnconfinedTestDispatcher()
    private val testCoroutineScope = TestScope(testCoroutineDispatcher + Job())

    private val testDataStore: DataStore<Preferences> =
        PreferenceDataStoreFactory.create(scope = testCoroutineScope,
            produceFile = { testContext.preferencesDataStoreFile(DefaultUserDataStore.PREFERENCE_USER_SETTING) })

    private lateinit var viewModel: MainViewModel
    private lateinit var dataStore: DefaultUserDataStore

    @Before
    fun setup() {
        Dispatchers.setMain(testCoroutineDispatcher)
        dataStore = DefaultUserDataStore(testDataStore)
        viewModel = MainViewModel(dataStore)
    }

    @Test
    fun `test viewmodel to retrieve start destination if user is not yet logged in`() =
        runBlocking {
            val route =
                if (viewModel.isUserLoggedIn.value) dashboardNavigationRoute else loginNavigationRoute
            assertTrue(route == loginNavigationRoute)
        }

    @Test
    fun `test viewmodel to retrieve start destination if user is logged in`() = runBlocking {
        val route =
            if (viewModel.isUserLoggedIn.value) dashboardNavigationRoute else loginNavigationRoute
        assertTrue(route == dashboardNavigationRoute)
    }
}
