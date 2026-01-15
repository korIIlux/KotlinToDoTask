package com.example.kotlinviikkotehtavat
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinviikkotehtavat.ui.theme.KotlinviikkotehtavatTheme
import com.example.kotlinviikkotehtavat.data.mockTasks
import com.example.kotlinviikkotehtavat.ui.theme.HomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinviikkotehtavatTheme {
                HomeScreen(initialTasks = mockTasks)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinviikkotehtavatTheme {
        Greeting("Android")
    }
}