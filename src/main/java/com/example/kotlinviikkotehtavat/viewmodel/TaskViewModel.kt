package com.example.kotlinviikkotehtavat.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotlinviikkotehtavat.data.mockTasks
import com.example.kotlinviikkotehtavat.domain.Task

class TaskViewModel : ViewModel() {
    var tasks by mutableStateOf<List<Task>>(emptyList())
        private set

    init {
        tasks = mockTasks
    }

    fun addTask(task: Task) {
        tasks = tasks + task
    }

    fun toggleDone(id: Int) {
        tasks = tasks.map {
            if (it.id == id) it.copy(done = !it.done) else it
        }
    }

    fun removeTask(id: Int) {
        tasks = tasks.filterNot { it.id == id}
    }

    fun sortByDueDate() {
        tasks = tasks.sortedBy { it.dueDate}
    }

    fun filterByDone(done: Boolean) {
        tasks = tasks.filter { it.done == done }
    }
}