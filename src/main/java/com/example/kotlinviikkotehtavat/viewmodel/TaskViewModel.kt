package com.example.kotlinviikkotehtavat.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.kotlinviikkotehtavat.model.Task
import com.example.kotlinviikkotehtavat.data.mockTasks

class TaskViewModel : ViewModel() {

    private val allTasks = MutableStateFlow<List<Task>>(mockTasks)
    private val _tasks = MutableStateFlow<List<Task>>(mockTasks)
    val tasks: StateFlow<List<Task>> = _tasks

    fun addTask(task: Task) {
        allTasks.value = allTasks.value + task
        _tasks.value = allTasks.value
    }

    fun toggleDone(id: Int) {
        allTasks.value = allTasks.value.map {
            if (it.id == id) it.copy(done = !it.done) else it
        }
        _tasks.value = allTasks.value
    }

    fun removeTask(id: Int) {
        allTasks.value = allTasks.value.filterNot { it.id == id }
        _tasks.value = allTasks.value
    }

    fun updateTask(updatedTask: Task) {
        allTasks.value = allTasks.value.map {
            if (it.id == updatedTask.id) updatedTask else it
        }
        _tasks.value = allTasks.value
    }

    fun showAll() {
        _tasks.value = allTasks.value
    }

    fun filterByDone(done: Boolean) {
        _tasks.value = allTasks.value.filter { it.done == done }
    }

    fun sortByDueDate() {
        _tasks.value = allTasks.value.sortedBy { it.dueDate }
    }
}