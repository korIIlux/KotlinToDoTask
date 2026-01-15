package com.example.kotlinviikkotehtavat.data
import com.example.kotlinviikkotehtavat.domain.Task

val mockTasks = listOf(
    Task(
        id = 1,
        title = "Test",
        description = "First test",
        priority = 2,
        dueDate = "2026-01-20",
        done = false
    ),
    Task(
        id = 2,
        title = "Test 2",
        description = "Second test",
        priority = 1,
        dueDate = "2026-01-22",
        done = false
    ),
    Task(
        id = 3,
        title = "Test 3",
        description = "Third test",
        priority = 3,
        dueDate = "2026-01-18",
        done = false
    ),
    Task(
        id = 4,
        title = "Test 4",
        description = "Fourth test",
        priority = 1,
        dueDate = "2026-01-21",
        done = false
    ),
    Task(
        id = 5,
        title = "Test 5",
        description = "Fifth test",
        priority = 4,
        dueDate = "2026-01-25",
        done = false
    )
)