package warrior

interface Warrior {

    var isKilled: Boolean
    val chanceToAvoidBeingHit: Int

    fun attack(warrior: Warrior)

    fun takeDamage(damage: Double)
}