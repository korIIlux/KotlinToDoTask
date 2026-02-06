package com.example.kotlinviikkotehtavat.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*

import com.example.kotlinviikkotehtavat.model.Task
import java.time.LocalDate

@Composable
fun AddTaskDialog(
    onDismiss: () -> Unit,
    onSave: (Task) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var dueDate by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,

        confirmButton = {
            Button(onClick = {
                if (title.isNotBlank() && dueDate.isNotBlank()) {
                    onSave(
                        Task(
                            id = (0..999999).random(),
                            title = title,
                            description = "",
                            priority = 1,
                            createdDate = LocalDate.now().toString(),
                            dueDate = dueDate,
                            done = false
                        )
                    )
                    onDismiss()
                }
            }) { Text("Save") }
        },

        dismissButton = {
            Button(onClick = onDismiss) { Text("Cancel") }
        },

        title = { Text("New Task") },

        text = {
            Column {
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") }
                )

                TextField(
                    value = dueDate,
                    onValueChange = { dueDate = it },
                    label = { Text("Due date (YYYY-MM-DD)") }
                )
            }
        }
    )
}
