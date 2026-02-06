package com.example.kotlinviikkotehtavat.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.runtime.collectAsState

import com.example.kotlinviikkotehtavat.model.Task
import com.example.kotlinviikkotehtavat.viewmodel.TaskViewModel

@Composable
fun CalendarScreen(
    navController: NavController,
    taskViewModel: TaskViewModel
) {
    val tasks by taskViewModel.tasks.collectAsState()
    var selectedTask by remember { mutableStateOf<Task?>(null) }

    val grouped = tasks.groupBy { it.dueDate }

    Column(Modifier.fillMaxSize().padding(16.dp)) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Calendar", fontSize = 24.sp, modifier = Modifier.weight(1f))

            Button(onClick = { navController.popBackStack() }) {
                Text("List")
            }
        }

        LazyColumn {
            grouped.forEach { (date, tasksForDate) ->
                item {
                    Text(date, fontSize = 20.sp)
                }

                items(tasksForDate) { task ->
                    TaskRow(
                        task = task,
                        onClick = { selectedTask = task },
                        onToggle = { taskViewModel.toggleDone(task.id) }
                    )
                }
            }
        }
    }

    selectedTask?.let {
        DetailDialog(
            task = it,
            onDismiss = { selectedTask = null },
            onUpdate = { taskViewModel.updateTask(it) },
            onDelete = {
                taskViewModel.removeTask(it.id)
                selectedTask = null
            }
        )
    }
}