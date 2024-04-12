package com.carlostorres.cleanarchitecture.passwordValidator.domain.usecase

import com.carlostorres.cleanarchitecture.passwordValidator.domain.repository.PasswordValidatorRepository

class SavePasswordUseCase (private val repository: PasswordValidatorRepository ){

    suspend operator fun invoke(password: String){

        repository.savePassword(password)

    }

}