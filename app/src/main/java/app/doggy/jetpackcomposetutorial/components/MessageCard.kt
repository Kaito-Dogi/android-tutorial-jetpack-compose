package app.doggy.jetpackcomposetutorial.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
internal fun MessageCard(name: String) {
    Text(text = "Hello, $name!")
}
