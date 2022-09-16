package warrior

import weapon.Weapons

class Intern(maxHealth: Int = 300) : AbstractWarrior(maxHealth) {

    override val chanceToAvoidBeingHit = 60

    override val accuracy = 20
    override val weapon = Weapons.createAK47()
}