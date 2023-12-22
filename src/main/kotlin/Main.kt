import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

@Composable
fun MyButton(text: String, icon: ImageVector) {
  Button(
    onClick = { /* Handle button click */ },
    modifier = Modifier
      .height(48.dp)
  ) {
    Icon(imageVector = icon, contentDescription = null)
    Spacer(modifier = Modifier.width(8.dp))
    Text(text = text)
  }
}

@Composable
@Preview
fun App() {
  MaterialTheme {
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .align(Alignment.TopCenter),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
      ) {
        Text(
          text = "TODO List App",
          style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
          color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          MyButton(text = "Button 1", icon = Icons.Default.Check)
          MyButton(text = "Button 2", icon = Icons.Default.Close)
        }
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
