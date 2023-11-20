package ph.com.sheen.datastore

import kotlinx.coroutines.flow.Flow

interface UserDataStore {

    suspend fun setUserIsLoginStatus(isLogin: Boolean)

    fun getIsUserLogin(): Flow<Boolean>
}