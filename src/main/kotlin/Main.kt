import java.nio.file.Path

fun main() {
    println("Hello, world!")

    val textInputFile = "src/main/resources/input.txt"
    val linesFromFile = readLinesFromFile(textInputFile)
    println("Lines read from $textInputFile:")
    println(linesFromFile)

}

fun readLinesFromFile(textInputFile: String) = Path.of(textInputFile).toFile().readLines()
