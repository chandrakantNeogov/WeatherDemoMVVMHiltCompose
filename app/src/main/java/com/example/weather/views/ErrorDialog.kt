package com.example.weather.views

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.example.weather.R

@Composable
fun ErrorDialog(errorMessage: String) {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        // Show the error dialog if the openDialog value is true
        // create alert dialog with the error message
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = stringResource(id = R.string.error))
            },
            text = {
                Text(text = errorMessage)
            },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text(text = "OK")
                }
            }
        )
    }
}