package ph.com.sheen.login.model

data class LoginUIState(
    val isLoading: Boolean = false,
    val loginStatus: LoginStatus = LoginStatus.UserNotLoggedIn,
)

sealed interface LoginStatus {
    object UserNotLoggedIn : LoginStatus
    object Successful : LoginStatus

    fun LoginStatus.isSuccessful(): Boolean {
        return this == Successful
    }
}