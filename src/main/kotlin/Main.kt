import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

@Composable
fun TodoItem(text: String, onRemove: () -> Unit) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Button(onRemove) {
      Icon( imageVector = Icons.Default.Close, contentDescription = null )
    }
    Text( text, style = MaterialTheme.typography.body1 )
  }
}

@Composable
@Preview
fun App() {
  val items = remember { mutableStateListOf("Laundry", "Dishes", "Groceries") }
  var input by remember { mutableStateOf("") }

  MaterialTheme {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
      Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        Text(
          text = "TODO List App",
          style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
        )

        items.forEachIndexed { index, item -> TodoItem(item) { items.removeAt(index) } }

        TextField(
          value = input,
          onValueChange = { value -> run {
            if (value.last().toString() != "\n") {
              input = value
              return@TextField
            }

            if (input == "") return@TextField

            items.add(input)
            input = ""
          } },
          label = { Text("Enter new TODO") }
        )
      }
    }
  }
}

fun main() = application {
  val state = WindowState(size = DpSize(600.dp, 1200.dp))

  Window(
    onCloseRequest = ::exitApplication,
    resizable = false,
    state = state
  ) {
    App()
  }
}
