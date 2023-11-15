package ph.com.sheen.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DefaultUserDataStore.PREFERENCE_USER_SETTING)

class DefaultUserDataStore(private val dataStore: DataStore<Preferences>) : UserDataStore {
    companion object {
        val IS_USER_LOGIN_KEY = booleanPreferencesKey("isUserLogin")
        const val PREFERENCE_USER_SETTING = "userSettings"
    }

    override suspend fun setUserIsLoginStatus(isLogin: Boolean) {
        dataStore.edit { prefs ->
            prefs[IS_USER_LOGIN_KEY] = isLogin
        }
    }

    override fun getIsUserLogin(): Flow<Boolean> {
        return dataStore.data.map {
            it[IS_USER_LOGIN_KEY] ?: false
        }
    }
}