package com.example.kotlinviikkotehtavat.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinviikkotehtavat.model.Task

@Composable
fun TaskRow(
    task: Task,
    onClick: () -> Unit,
    onToggle: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Checkbox(checked = task.done, onCheckedChange = { onToggle() })
        Text(task.title, modifier = Modifier.padding(start = 8.dp))
    }
}