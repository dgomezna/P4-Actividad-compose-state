package io.github.kevinah95.myapplication.screens

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

// ✅ Stateful: dueño del estado. Delega la UI a ContadorView.
@Composable
fun ContadorScreen() {
    var count by rememberSaveable { mutableStateOf(0) }
    var nombre by rememberSaveable { mutableStateOf("") }

    ContadorView(
        count = count,
        nombre = nombre,
        onIncrement = { count++ },
        onNombreChange = { nombre = it }
    )
}