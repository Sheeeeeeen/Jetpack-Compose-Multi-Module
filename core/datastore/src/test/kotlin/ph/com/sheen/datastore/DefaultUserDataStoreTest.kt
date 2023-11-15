package ph.com.sheen.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.test.core.app.ApplicationProvider
import app.cash.turbine.test
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@OptIn(ExperimentalCoroutinesApi::class)

@RunWith(RobolectricTestRunner::class)
class DefaultUserDataStoreTest {

    private val testContext: Context = ApplicationProvider.getApplicationContext()
    private val testCoroutineDispatcher: TestDispatcher = UnconfinedTestDispatcher()
    private val testCoroutineScope = TestScope(testCoroutineDispatcher + Job())

    private lateinit var userDataStore: UserDataStore

    private val testDataStore: DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            scope = testCoroutineScope,
            produceFile = { testContext.preferencesDataStoreFile(PREFERENCE_USER_SETTING) }
        )

    @Before
    fun setup() {
        Dispatchers.setMain(testCoroutineDispatcher)
        userDataStore = DefaultUserDataStore(testDataStore)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test datastore default value of isUserLogin is false`() {
        testCoroutineScope.runTest {
            userDataStore.getIsUserLogin().test {
                assertFalse(awaitItem())
            }
        }
    }

    @Test
    fun `test datastore value if user set status to true`() {
        testCoroutineScope.runTest {
            userDataStore.setUserIsLoginStatus(isLogin = true)
            userDataStore.getIsUserLogin().test {
                assertTrue(awaitItem())
            }
        }
    }

    @Test
    fun `test datastore value if user set status to false`() {
        testCoroutineScope.runTest {
            userDataStore.setUserIsLoginStatus(isLogin = false)
            userDataStore.getIsUserLogin().test {
                assertFalse(awaitItem())
            }
        }
    }
}