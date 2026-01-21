package com.example.kotlinviikkotehtavat.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinviikkotehtavat.domain.Task

@Composable
fun TaskRow(
    task: Task,
    onToggle: () -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = task.done,
            onCheckedChange = { onToggle() }
        )

        Text(
            text = task.title,
            modifier = Modifier.weight(1f)
        )

        IconButton(onClick = onDelete) {
            Text("X")
        }
    }
}