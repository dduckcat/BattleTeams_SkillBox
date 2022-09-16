package warrior


import weapon.Weapons
import kotlin.random.Random

class General(maxHealth: Int = 200) : AbstractWarrior(maxHealth) {

    override val chanceToAvoidBeingHit = 40

    override val accuracy = 60
    override val weapon = when (Random.nextInt(4)) {
        in 0..2 -> Weapons.createAK47()
        else -> Weapons.createMiniGun()
    }
}