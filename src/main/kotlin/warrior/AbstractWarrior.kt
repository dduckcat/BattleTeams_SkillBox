package warrior

import chance
import exceptions.NoAmmoException
import weapon.AbstractWeapon

abstract class AbstractWarrior(maxHealth: Int) : Warrior {

    abstract val accuracy: Int
    abstract val weapon: AbstractWeapon

    override var isKilled = false

    var currentHealth = maxHealth.toDouble()


    override fun attack(warrior: Warrior) {
        try {
            weapon.getAmmoForFire().forEach { ammo ->
                if (accuracy.chance() && !warrior.chanceToAvoidBeingHit.chance())
                    warrior.takeDamage(ammo.getDamage())
            }
        } catch (n: NoAmmoException){
            weapon.reloadMagazine()
        }
    }

    override fun takeDamage(damage: Double) {
        currentHealth -= damage
        if (currentHealth <= 0) isKilled = true
    }

}
