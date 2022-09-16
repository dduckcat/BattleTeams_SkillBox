package battle

import kotlin.random.Random

class Battle(lotTeam1: Int, lotTeam2: Int) {

    private val team1 = Pair("Team 1", Team(lotTeam1))
    private val team2 = Pair("Team 2", Team(lotTeam2))

    private val battleTheEnd: BattleState.TheEnd
        get() {
            return getStateBattle()
        }

    private var finish = false


    fun actionBattle(iterations: Int) {
        BattleState.Progress.info(team1.second, team2.second)
        for (i in 1..iterations) {
            if (finish) break
            println(
                """$i round
                |------
            """.trimMargin()
            )
            val firstShot = when (Random.nextBoolean()) {
                true -> team1
                false -> team2
            }
            val secondShot = if (firstShot == team1) team2 else team1
            volley(strikers = firstShot, targets = secondShot)
            volley(strikers = secondShot, targets = firstShot)
            println("===================================")
        }
        BattleState.Progress.info(team1.second, team2.second)
        println("###################################")
        when (battleTheEnd) {
            BattleState.WinFirstTeam -> println("The First team win!")
            BattleState.WinSecondTeam -> println("The Second team win")
            BattleState.NobodyWin -> println("Nobody win!")
        }
    }

    private fun volley(strikers: Pair<String, Team>, targets: Pair<String, Team>) {

        if (!strikers.second.areAliveWarriors()) {

            finish = true
            return
        }
        for (striker in strikers.second.listWarriors) {
            if (!targets.second.areAliveWarriors()) {

                finish = true
                break
            }

            val randomTargetIndex = Random.nextInt(targets.second.listWarriors.size)
            val randomTarget = targets.second.listWarriors[randomTargetIndex]
            striker.attack(randomTarget)
            targets.second.isDead(randomTarget)
        }
        if (targets.second.kills != 0) {
            println("${strikers.first} attacks! ${targets.second.kills} warriors killed")
            targets.second.kills = 0
        } else println("${strikers.first} attacks! No one was killed")
        println("-----------------------------------")
    }


    private fun getStateBattle(): BattleState.TheEnd {
        return if (team1.second.areAliveWarriors() && !team2.second.areAliveWarriors())
            BattleState.WinFirstTeam
        else if (!team1.second.areAliveWarriors() && team2.second.areAliveWarriors())
            BattleState.WinSecondTeam
        else
            BattleState.NobodyWin
    }
}