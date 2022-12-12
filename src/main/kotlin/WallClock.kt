import java.time.LocalDateTime
import java.time.ZoneId

/*
- Create a wall clock (not visual), specific to a given location (such as London, Beijing, etc.).
- It has an hour hand and a minute hand
- It is set to a particular start time
- Tells the time
*/

fun main(){
    println("Time on the clock in ${wallClock()}")
}

fun wallClock(): String {
    val now = LocalDateTime.now()
    return wallClock(now.atZone(ZoneId.systemDefault()).zone.toString(), now.hour, now.minute)
}

fun wallClock(location: String, startHour:Int, startMinute:Int) = "$location $startHour:$startMinute"
