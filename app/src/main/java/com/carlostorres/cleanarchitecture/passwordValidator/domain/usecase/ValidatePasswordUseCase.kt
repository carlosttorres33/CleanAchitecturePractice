package com.carlostorres.cleanarchitecture.passwordValidator.domain.usecase

class ValidatePasswordUseCase {

    //Al crear una funcion aparte dentro del caso de uso, al llamarla se debe ser más especifico con la sintaxis
//    fun validate(password : String) : Boolean{
//
//        return password.length > 8
//
//    }

    //Al sobreescribir la funcion invoke dentro del caso de uso, al usarla solo llamamos al caso de uso
    operator fun invoke(password : String) : Boolean{
        return password.length > 8
    }

}