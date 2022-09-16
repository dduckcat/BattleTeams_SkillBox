package weapon

import chance

enum class Ammo(private val damage: Int, private val chance: Int, private val coefficient: Double) {

    LIGHT(10, 20, 1.25),
    MEDIUM(20, 40, 1.5),
    HEAVY(30, 60, 1.75),
    FATALITY(40,80,2.0);

    fun getDamage(): Double {
        return if (chance.chance()) damage * coefficient else damage.toDouble()
    }

}