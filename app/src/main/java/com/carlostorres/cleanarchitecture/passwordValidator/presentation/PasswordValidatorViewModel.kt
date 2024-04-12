package com.carlostorres.cleanarchitecture.passwordValidator.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlostorres.cleanarchitecture.passwordValidator.domain.repository.PasswordValidatorRepository
import com.carlostorres.cleanarchitecture.passwordValidator.domain.usecase.SavePasswordUseCase
import com.carlostorres.cleanarchitecture.passwordValidator.domain.usecase.ValidatePasswordUseCase
import kotlinx.coroutines.launch

class PasswordValidatorViewModel
    constructor(
        private val validatePasswordUseCase: ValidatePasswordUseCase,
        private val savePasswordUseCase: SavePasswordUseCase
    )
: ViewModel() {

    var state by mutableStateOf(PasswordValidatorState())
        private set

    fun onEvent(event: PasswordValidatorEvent){

        when(event){


            is PasswordValidatorEvent.ChangePassword -> {
                state = state.copy(
                    password = event.password
                )

            }

            PasswordValidatorEvent.ValidatePassword -> {

//              Al crear la función específica en el caso de uso se debe especificar ese metodo para usarlo
//                val isPasswordValid = validatePasswordUseCase.validate(state.password)

//                Al usar el invoke de la clase, esta sobreentiende que esa funcion es la que se ejecuta al llamar directamente al caso de uso
                val isPasswordValid = validatePasswordUseCase(state.password)

                state = state.copy(
                    passwordError = !isPasswordValid
                )

                if (isPasswordValid){

                    viewModelScope.launch {
                        savePasswordUseCase(state.password)
                    }

                }

            }

        }

    }

}

//ViewModel -> Screen = States
//Screen -> ViewModel = Events