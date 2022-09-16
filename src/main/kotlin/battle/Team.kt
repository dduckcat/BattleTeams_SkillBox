package battle

import warrior.*
import kotlin.random.Random

class Team(private val lot: Int) {

    var listWarriors = createTeam()
        private set

    var kills = 0

    private fun createTeam(): MutableList<AbstractWarrior> {
        val team = mutableListOf<AbstractWarrior>()
        repeat(lot) {
            team.add(
                when (Random.nextInt(100)) {
                    in 0..10 -> General()
                    in 11..30 -> Captain()
                    in 31..60 -> Soldier()
                    else -> Intern()
                }
            )
        }
        return team
    }

    fun isDead(warrior: AbstractWarrior) {
        if (warrior.isKilled) {
            listWarriors.remove(warrior)
            kills++
        }
    }

    fun areAliveWarriors(): Boolean {
//        listWarriors = listWarriors.filter { !it.isKilled } as MutableList<AbstractWarrior>
        return listWarriors.isNotEmpty()
    }

    fun totalHealthTeam(): Double {
        return if (areAliveWarriors()) {
            listWarriors.sumOf { it.currentHealth }
        } else 0.0
    }

    fun sumAliveWarriors(): Int {
        return if (areAliveWarriors()) {
            listWarriors.size
        } else 0
    }

}