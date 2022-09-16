package warrior

import chance
import weapon.AbstractWeapon

abstract class AbstractWarrior(maxHealth: Int) : Warrior {

    abstract val accuracy: Int
    abstract val weapon: AbstractWeapon

    override var isKilled = false

    var currentHealth = maxHealth.toDouble()

    override fun attack(warrior: Warrior) {
        if (weapon.isEmpty) {
            weapon.reloadMagazine()
        } else {
            weapon.getAmmoForFire().forEach { ammo ->
                ammo?.let { ammoNotNull ->
                    if (accuracy.chance() && !warrior.chanceToAvoidBeingHit.chance())
                        warrior.takeDamage(ammoNotNull.getDamage())
                } ?: weapon.reloadMagazine()
            }
        }
    }

    override fun takeDamage(damage: Double) {
        currentHealth -= damage
        if (currentHealth <= 0) isKilled = true
    }

}
