package com.example.kotlinviikkotehtavat.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlinviikkotehtavat.model.Task
import java.time.LocalDate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun TaskRow(
    task: Task,
    onClick: () -> Unit,
    onToggle: () -> Unit
) {
    val isOverdue =
        LocalDate.parse(task.dueDate).isBefore(LocalDate.now()) && !task.done

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Checkbox(
            checked = task.done,
            onCheckedChange = { onToggle() }
        )

        Column(Modifier.padding(start = 8.dp)) {
            Text(
                text = task.title,
                color = if (isOverdue) Color.Red else Color.Unspecified
            )

            Text(
                text = "Due: ${task.dueDate}",
                fontSize = 12.sp
            )
        }
    }
}