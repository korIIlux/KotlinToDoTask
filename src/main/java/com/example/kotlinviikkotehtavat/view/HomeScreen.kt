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
import com.example.kotlinviikkotehtavat.ROUTE_CALENDAR
import com.example.kotlinviikkotehtavat.viewmodel.TaskViewModel
import com.example.kotlinviikkotehtavat.model.Task

@Composable
fun HomeScreen(navController: NavController, taskViewModel: TaskViewModel) {
    val tasks by taskViewModel.tasks.collectAsState()
    var selectedTask by remember { mutableStateOf<Task?>(null) }
    var showAddDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Task List", fontSize = 24.sp, modifier = Modifier.weight(1f))

            Button(onClick = { navController.navigate(ROUTE_CALENDAR) }) {
                Text("Calendar")
            }
        }

        Spacer(Modifier.height(8.dp))

        Button(onClick = { showAddDialog = true }) {
            Text("Add Task")
        }

        Spacer(Modifier.height(8.dp))

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

    if (showAddDialog) {
        AddTaskDialog(
            onDismiss = { showAddDialog = false },
            onSave = { taskViewModel.addTask(it) }
        )
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