package com.sunnyweather.android.ui.login.ui.ui.login

/**
 * Data validation state of the login form.
 */
data class LoginFormState(
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false
)