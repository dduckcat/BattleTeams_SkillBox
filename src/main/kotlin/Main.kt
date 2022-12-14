import battle.Battle
import kotlin.random.Random

fun main() {

    while(true){
        println("Input the number of warriors for the First Team:")
        val lotTeam1 = readLine()!!.toInt()
        println("Input the number of warriors for the Second Team:")
        val lotTeam2 = readLine()!!.toInt()
        println("Input the number of rounds:")
        val rounds = readLine()!!.toInt()

        val battle = Battle(lotTeam1, lotTeam2)

        battle.actionBattle(rounds)
        while (true) {
            println(
                """_______________________________
            Repeat? (y/n)""".trimIndent()
            )
            when (readLine()!!) {
                "y" -> break
                "n" -> return
            }
        }
    }

}


fun Int.chance(): Boolean {
    return when (Random.nextInt(100)) {
        in 0 until this -> true
        else -> false
    }

}