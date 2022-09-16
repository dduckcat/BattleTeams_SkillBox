package weapon

import kotlin.random.Random

abstract class AbstractWeapon {

    abstract val maxAmmo: Int
    abstract val fireType: FireType

    private var magazineAmmo = Stack<Ammo>()
    val isEmpty: Boolean
    get() {
        return magazineAmmo.isEmpty()
    }


    fun getAmmoForFire(): List<Ammo?> {
        val listAmmo = mutableListOf<Ammo?>()
        when (fireType) {
            FireType.SingleShot -> listAmmo.add(magazineAmmo.pop())
            is FireType.BurstShot -> repeat((fireType as FireType.BurstShot).burstSize) {
                listAmmo.add(magazineAmmo.pop())
            }
        }
        return listAmmo.toList()
    }

    fun reloadMagazine() =
        repeat(maxAmmo) {
            magazineAmmo.push(
                createAmmo(
                    Ammo.values()[Random.nextInt(
                        Ammo.values().size
                    )]
                )
            )
        }

    private fun createAmmo(ammo: Ammo): Ammo =
        when (ammo) {
            Ammo.LIGHT -> Ammo.LIGHT
            Ammo.MEDIUM -> Ammo.MEDIUM
            Ammo.HEAVY -> Ammo.HEAVY
            Ammo.FATALITY -> Ammo.FATALITY
        }
}