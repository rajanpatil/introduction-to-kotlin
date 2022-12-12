/*
Part - 1
Given a sum of money (in pennies), please exchange it for coins of particular denomination. 
When you can't make up the sum of money exactly in the denomination, just "keep the change". 
Start with 1p, 2p, and 5p coins only

Part - 2
Now, find the smallest number of coins that will make up the sum exactly.
*/

enum class Coin(val value: Int) {
    OneP(1),
    TwoP(2),
    FiveP(5)
}

fun exchangePart1(money: Int, coin: Coin): Int {
    return money / coin.value
}

fun exchangeWithImperativeApproach(money: Int): List<Pair<Coin, Int>> {
    var remainingMoney = money
    val fivePCoins = remainingMoney / Coin.FiveP.value
    remainingMoney -= (Coin.FiveP.value * fivePCoins)
    val twoPCoins = remainingMoney / Coin.TwoP.value
    remainingMoney -= (Coin.TwoP.value * twoPCoins)
    val onePCoins = remainingMoney
    remainingMoney -= (Coin.OneP.value * onePCoins)

    val exchangeDetails = listOf(
        Pair(Coin.FiveP, fivePCoins),
        Pair(Coin.TwoP, twoPCoins),
        Pair(Coin.OneP, onePCoins)
    )
    return exchangeDetails.filterNot { exchangeDetails -> exchangeDetails.second < 0 }
}

fun exchangeWithFunctionalApproach(money: Int): List<Pair<Coin, Int>> {
    val exchangeDetails = mutableListOf<Pair<Coin, Int>>()
    Coin.values()
        .sortedByDescending { it.value }
        .fold(money) { remainingMoney, coin ->
            exchangeDetails.add(Pair(coin, remainingMoney / coin.value));
            remainingMoney - (coin.value * (remainingMoney / coin.value))
        }
    return exchangeDetails.toList()
}

fun main() {
    val money = 18 // pennies
    
    println("============Part 1==============")
    Coin.values()
        .map { coin ->
            println("Number of ${coin.value}p coins that will give me: ${exchangePart1(money, coin)}")
        }

    println("============Part 2==============")
    println("Imperative Approach: ${exchangeWithImperativeApproach(money)}")
    println("Functional Approach: ${exchangeWithFunctionalApproach(money)}")
}
