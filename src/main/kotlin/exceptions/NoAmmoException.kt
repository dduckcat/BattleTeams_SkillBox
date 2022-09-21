package exceptions

class NoAmmoException : Throwable(
    message = "The weapon does not have the required number of rounds to fire."
){
}