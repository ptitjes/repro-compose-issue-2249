import androidx.compose.desktop.ui.tooling.preview.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.awt.*
import androidx.compose.ui.window.*
import java.awt.*

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App(window)
    }
}

@Composable
@Preview
fun App(window: ComposeWindow) {
    var open by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf<String?>(null) }

    Column {
        Button(
            onClick = { open = true }
        ) {
            Text("Open")
        }

        Text("Result: $result")
    }

    if (open) {
        AwtWindow(
            create = {
                object : FileDialog(window, "Select a file", LOAD) {
                    override fun setVisible(value: Boolean) {
                        super.setVisible(value)
                        if (value) {
                            result = file
                            open = false
                        }
                    }
                }
            }, dispose = FileDialog::dispose
        )
    }
}
