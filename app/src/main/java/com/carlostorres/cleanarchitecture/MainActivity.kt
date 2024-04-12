package com.carlostorres.cleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.carlostorres.cleanarchitecture.passwordValidator.data.repository.PasswordValidatorRepositoryImpl
import com.carlostorres.cleanarchitecture.passwordValidator.domain.usecase.SavePasswordUseCase
import com.carlostorres.cleanarchitecture.passwordValidator.domain.usecase.ValidatePasswordUseCase
import com.carlostorres.cleanarchitecture.passwordValidator.presentation.PasswordValidatorScreen
import com.carlostorres.cleanarchitecture.passwordValidator.presentation.PasswordValidatorViewModel
import com.carlostorres.cleanarchitecture.ui.theme.CleanArchitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = PasswordValidatorViewModel(
            validatePasswordUseCase = ValidatePasswordUseCase(),
            savePasswordUseCase = SavePasswordUseCase(PasswordValidatorRepositoryImpl())
        )

        setContent {
            CleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PasswordValidatorScreen(viewModel)
                }
            }
        }
    }
}