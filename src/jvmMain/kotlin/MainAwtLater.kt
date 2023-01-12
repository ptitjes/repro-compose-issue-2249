import java.awt.*
import java.awt.FileDialog.*
import javax.swing.*

fun main() {
    SwingUtilities.invokeLater {
        val frame = Frame("Window")
        val dialog = FileDialog(frame, "Select a file", LOAD)
        SwingUtilities.invokeLater {
            dialog.isVisible = true
        }
    }
}
