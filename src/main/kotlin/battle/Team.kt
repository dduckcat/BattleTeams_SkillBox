package battle

import warrior.*
import kotlin.random.Random

class Team(private val lot: Int) {

    var listWarriors = createTeam()
        private set

    var kills = 0

    val infoAboutTeam: String
        get() {
            return if (listWarriors.isNotEmpty()){
                """${listWarriors.filterIsInstance<General>().size} Generals
            |${listWarriors.filterIsInstance<Captain>().size} Captain
            |${listWarriors.filterIsInstance<Soldier>().size} Soldier
            |${listWarriors.filterIsInstance<Intern>().size} Intern
        """.trimMargin()
            } else ""
        }


    private fun createTeam(): MutableList<AbstractWarrior> {
        val team = mutableListOf<AbstractWarrior>()
        repeat(lot) {
            team.add(
                when (Random.nextInt(100)) {
                    in 0..5 -> General()
                    in 6..20 -> Captain()
                    in 21..50 -> Soldier()
                    else -> Intern()
                }
            )
        }
        return team
    }

//    fun infoAboutTeam(){
//        println("""${listWarriors.filterIsInstance<General>().size} Generals
//            |${listWarriors.filterIsInstance<Captain>().size} Captain
//            |${listWarriors.filterIsInstance<Soldier>().size} Soldier
//            |${listWarriors.filterIsInstance<Intern>().size} Intern
//        """.trimMargin())
//    }

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
