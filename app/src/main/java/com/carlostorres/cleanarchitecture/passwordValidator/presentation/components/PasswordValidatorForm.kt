package com.carlostorres.cleanarchitecture.passwordValidator.presentation.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.carlostorres.cleanarchitecture.passwordValidator.presentation.PasswordValidatorEvent
import com.carlostorres.cleanarchitecture.passwordValidator.presentation.PasswordValidatorState

@Composable
fun PasswordValidatorForm(
    state : PasswordValidatorState,
    onEvent: (PasswordValidatorEvent) -> Unit
){

    TextField(
        value = state.password,
        onValueChange = {
            onEvent(PasswordValidatorEvent.ChangePassword(it))
        }
    )

    Button(
        onClick = {
            onEvent(PasswordValidatorEvent.ValidatePassword)
        }
    ){

        Text(text = "Validar y Guardar")

    }

    if (state.passwordError){
        Text(text = "La Contraseña es Inválida", color = Color.Red)
    }

}