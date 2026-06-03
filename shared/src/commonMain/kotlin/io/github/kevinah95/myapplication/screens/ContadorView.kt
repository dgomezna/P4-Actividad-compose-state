package io.github.kevinah95.myapplication.screens



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ContadorView(count: Int,
                 nombre: String,
                 onIncrement: () -> Unit,
                 onNombreChange: (String) -> Unit,
                 modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    // No funciona: Al ser una variable "comun" osea var se reinicia cada vez que se
    // recomponen los componentes, por lo tanto el contador no incrementa, siempre se muestra 0.

    var nombre by rememberSaveable() { mutableStateOf("") } // Funciona: Al usar rememberSaveable,
    // el valor de "nombre" se guarda incluso después de que la composición se destruya y se vuelva a crear,
    // lo que permite que el valor persista a través de recomposiciones.

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Campo de nombre — no se pierde al rotar
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Tu nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = if (nombre.isBlank()) "Contador: $count" else "Hola, $nombre! \nContador: $count",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { count++ }) {
            Text("Incrementar")
        }
    }
}
