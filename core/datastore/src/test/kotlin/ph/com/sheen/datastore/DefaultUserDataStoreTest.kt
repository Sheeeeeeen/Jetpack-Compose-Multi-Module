package ph.com.sheen.datastore

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class DefaultUserDataStoreTest {

    val temporaryDatastore: MutableMap<String, Any> = mutableMapOf()

    lateinit var userDataStore: UserDataStore

    @Before
    fun setup() {
        userDataStore = object : UserDataStore {
            override suspend fun setIsLogin() {
                temporaryDatastore["isUserLogin"] = true
            }
        }
    }

    @Test
    fun is_user_login_to_true() = runBlocking {
        userDataStore.setIsLogin()
        val isUserLogin = temporaryDatastore["isUserLogin"] as Boolean
        assertTrue(isUserLogin)
    }
}