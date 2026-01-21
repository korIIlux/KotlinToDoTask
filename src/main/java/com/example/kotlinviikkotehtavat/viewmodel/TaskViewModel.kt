package com.example.kotlinviikkotehtavat.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotlinviikkotehtavat.data.mockTasks
import com.example.kotlinviikkotehtavat.domain.Task

class TaskViewModel : ViewModel() {
    private var allTasks by mutableStateOf<List<Task>>(emptyList())
    var tasks by mutableStateOf<List<Task>>(emptyList())
        private set

    init {
        allTasks = mockTasks
        tasks = allTasks
    }

    fun addTask(task: Task) {
        allTasks = allTasks + task
        tasks = allTasks
    }

    fun toggleDone(id: Int) {
        allTasks = allTasks.map {
            if (it.id == id) it.copy(done = !it.done) else it
        }
        tasks = allTasks
    }

    fun removeTask(id: Int) {
        allTasks = allTasks.filterNot { it.id == id }
        tasks = allTasks
    }

    fun sortByDueDate() {
        tasks = tasks.sortedBy { it.dueDate }
    }

    fun showAll() {
        tasks = allTasks
    }

    fun filterByDone(done: Boolean) {
        tasks = allTasks.filter { it.done == done }
    }
}