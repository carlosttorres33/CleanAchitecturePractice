package com.carlostorres.cleanarchitecture.passwordValidator.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.carlostorres.cleanarchitecture.passwordValidator.presentation.components.PasswordValidatorForm

@Composable
fun PasswordValidatorScreen(
    viewModel: PasswordValidatorViewModel
){

    val state = viewModel.state

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        PasswordValidatorForm(
            state = state,
            onEvent = {
                viewModel.onEvent(it)
            }
        )

    }

}