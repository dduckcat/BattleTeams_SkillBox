package weapon

object Weapons {

    fun createPistol(): AbstractWeapon = object : AbstractWeapon() {
        override val maxAmmo = 7
        override val fireType: FireType = FireType.SingleShot
    }


    fun createAK47(): AbstractWeapon = object : AbstractWeapon() {
        override val maxAmmo: Int = 30
        override val fireType: FireType = FireType.BurstShot(7)
    }

    fun createPumpShotgun(): AbstractWeapon = object : AbstractWeapon() {
        override val maxAmmo = 6
        override val fireType = FireType.BurstShot(3)
    }

    fun createMiniGun(): AbstractWeapon = object : AbstractWeapon(){
        override val maxAmmo = 100
        override val fireType = FireType.BurstShot(30)
    }
}