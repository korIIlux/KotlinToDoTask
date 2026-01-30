package com.example.kotlinviikkotehtavat.view

import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.kotlinviikkotehtavat.model.Task

@Composable
fun DetailDialog(
    task: Task,
    onDismiss: () -> Unit,
    onUpdate: (Task) -> Unit,
    onDelete: () -> Unit
) {
    var title by remember { mutableStateOf(task.title) }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = {
                onUpdate(task.copy(title = title))
                onDismiss()
            }) {
                Text("Save")
            }
        },
        dismissButton = {
            Button(onClick = onDelete) {
                Text("Delete")
            }
        },
        title = { Text("Edit task") },
        text = {
            TextField(value = title, onValueChange = { title = it })
        }
    )
}
