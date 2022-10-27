package curso.kotlin.basicstatecodelab

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf

class WellnessTask(
    val id: Int,
    val label: String,
    var initialChecked: Boolean = false
) {
    var checked by mutableStateOf(initialChecked)
}