package com.carlostorres.cleanarchitecture.passwordValidator.presentation

data class PasswordValidatorState(

    val password: String = "",
    val passwordError: Boolean = false

)
