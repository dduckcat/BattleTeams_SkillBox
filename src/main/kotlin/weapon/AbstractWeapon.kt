package weapon

import exceptions.NoAmmoException
import kotlin.random.Random

abstract class AbstractWeapon {

    abstract val maxAmmo: Int
    abstract val fireType: FireType

    private var magazineAmmo = Stack<Ammo>()

    fun getAmmoForFire(): List<Ammo> {
        val listAmmo = mutableListOf<Ammo>()
        val numberOfRounds = when (fireType) {
            FireType.SingleShot -> 1
            is FireType.BurstShot -> (fireType as FireType.BurstShot).burstSize
        }
        repeat(numberOfRounds) {
            val nextRound = magazineAmmo.pop()
            nextRound?.let {
                listAmmo.add(it)
            } ?: throw NoAmmoException()
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