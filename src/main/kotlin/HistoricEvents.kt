import java.util.stream.Collectors.toList

/*
Problem statement:
2022 is almost over, and let's compile all of the events that made it into the history books. 
Each event has a short description, a month, and a year. Some of them are ...

Sort the events based on month
*/

class HistoricEvent(val description: String, val month: Int, val year: Int = 2022) {
    override fun toString(): String {
        return "HistoricEvent(description='$description')"
    }
}

fun main() {
    val theQueensFuneral = HistoricEvent("Queen's funeral", 9)
    val twitterTakenOver = HistoricEvent("Twitter takeover", 10)
    val ukraineRussiaWar = HistoricEvent("Ukraine war", 2)

    val allEvents = listOf(theQueensFuneral, twitterTakenOver, ukraineRussiaWar)

    val sortedByMonth = allEvents.sortedBy { it.month }

    println(sortedByMonth)
}
