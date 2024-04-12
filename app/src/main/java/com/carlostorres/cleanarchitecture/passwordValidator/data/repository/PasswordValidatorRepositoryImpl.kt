package com.carlostorres.cleanarchitecture.passwordValidator.data.repository

import com.carlostorres.cleanarchitecture.passwordValidator.domain.repository.PasswordValidatorRepository

class PasswordValidatorRepositoryImpl : PasswordValidatorRepository{

    private val myPasswords : MutableList<String> = mutableListOf()

    override suspend fun savePassword(password: String){

        myPasswords.add(password)

    }

}