package com.carlostorres.cleanarchitecture.passwordValidator.domain.repository

interface PasswordValidatorRepository {

    suspend fun savePassword(password: String){

    }

}