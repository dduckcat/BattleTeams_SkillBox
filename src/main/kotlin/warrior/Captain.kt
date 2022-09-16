package warrior

import weapon.Weapons
import kotlin.random.Random

class Captain(maxHealth: Int = 150) : AbstractWarrior(maxHealth) {

    override val chanceToAvoidBeingHit = 30

    override val accuracy = 50
    override val weapon = when (Random.nextInt(4)) {
        in 0..2 -> Weapons.createPumpShotgun()
        else -> Weapons.createAK47()
    }
}