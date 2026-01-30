package com.example.kotlinviikkotehtavat.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlinviikkotehtavat.viewmodel.TaskViewModel
import com.example.kotlinviikkotehtavat.model.Task

@Composable
fun HomeScreen(taskViewModel: TaskViewModel = viewModel()) {
    val tasks by taskViewModel.tasks.collectAsState()
    var selectedTask by remember { mutableStateOf<Task?>(null) }
    var newTaskTitle by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Task List", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))
        Row {
            TextField(
                value = newTaskTitle,
                onValueChange = { newTaskTitle = it },
                modifier = Modifier.weight(1f),
                label = { Text("New task") }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                if (newTaskTitle.isNotBlank()) {
                    taskViewModel.addTask(
                        Task(
                            id = (tasks.maxOfOrNull { it.id } ?: 0) + 1,
                            title = newTaskTitle,
                            description = "",
                            priority = 1,
                            dueDate = "2026-01-30",
                            done = false
                        )
                    )
                    newTaskTitle = ""
                }
            }) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = { taskViewModel.showAll() }) {
                Text("All")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { taskViewModel.filterByDone(true) }) {
                Text("Done")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { taskViewModel.filterByDone(false) }) {
                Text("Not done")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { taskViewModel.sortByDueDate() }) {
                Text("Sort")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(tasks) { task ->
                TaskRow(
                    task = task,
                    onClick = { selectedTask = task },
                    onToggle = { taskViewModel.toggleDone(task.id) }
                )
            }
        }
    }

    selectedTask?.let {
        DetailDialog(
            task = it,
            onDismiss = { selectedTask = null },
            onUpdate = { updated -> taskViewModel.updateTask(updated) },
            onDelete = {
                taskViewModel.removeTask(it.id)
                selectedTask = null
            }
        )
    }
}