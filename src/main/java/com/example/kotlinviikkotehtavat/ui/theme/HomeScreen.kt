package com.example.kotlinviikkotehtavat.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinviikkotehtavat.domain.Task
import com.example.kotlinviikkotehtavat.logic.addTask
import com.example.kotlinviikkotehtavat.logic.filterByDone
import com.example.kotlinviikkotehtavat.logic.sortByDueDate
import com.example.kotlinviikkotehtavat.logic.toggleDone
import androidx.compose.runtime.*

@Composable
fun HomeScreen(initialTasks: List<Task>) {
    var tasks by remember { mutableStateOf(initialTasks) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Task List",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(modifier = Modifier.padding(bottom = 16.dp)) {
            Button(onClick = {
                // demo
                val newTask = Task(
                    id = (tasks.maxOfOrNull { it.id } ?: 0) + 1,
                    title = "New Task",
                    description = "Description",
                    priority = 1,
                    dueDate = "2026-01-30",
                    done = false
                )
                tasks = addTask(tasks, newTask)
            }) {
                Text("Add Task")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = { tasks = sortByDueDate(tasks) }) {
                Text("Sort by DueDate")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = { tasks = filterByDone(tasks, done = true) }) {
                Text("Show Done")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = { tasks = filterByDone(tasks, done = false) }) {
                Text("Show Not Done")
            }
        }

        tasks.forEach { task ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (task.done) "|Done| ${task.title}" else "|In process| ${task.title}",
                    fontSize = 18.sp,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Button(onClick = { tasks = toggleDone(tasks, task.id) }) {
                    Text("Toggle Done")
                }
            }
        }
    }
}