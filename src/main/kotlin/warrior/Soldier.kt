package warrior


import weapon.Weapons
import kotlin.random.Random

class Soldier(maxHealth: Int = 100) : AbstractWarrior(maxHealth) {


    override val chanceToAvoidBeingHit = 20

    override val accuracy = 40
    override val weapon = when (Random.nextInt(4)) {
        in 0..2 -> Weapons.createPistol()
        else -> Weapons.createPumpShotgun()
    }
}