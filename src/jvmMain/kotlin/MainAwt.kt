import java.awt.*
import java.awt.FileDialog.*

fun main() {
    val frame = Frame("Window")
    val dialog = FileDialog(frame, "Select a file", LOAD)
    dialog.isVisible = true
}
