package com.carlostorres.cleanarchitecture.passwordValidator.presentation

sealed interface PasswordValidatorEvent {

    data class ChangePassword(val password: String) : PasswordValidatorEvent
    object ValidatePassword : PasswordValidatorEvent

}