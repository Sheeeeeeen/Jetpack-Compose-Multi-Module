package ph.com.sheen.login.model

data class LoginUIState(
    val isLoading: Boolean = false,
    val loginStatus: LoginStatus = LoginStatus.UserNotLoggedIn,
)

sealed interface LoginStatus {
    data object UserNotLoggedIn : LoginStatus
    data object Successful : LoginStatus

    fun LoginStatus.isSuccessful(): Boolean {
        return this == Successful
    }
}