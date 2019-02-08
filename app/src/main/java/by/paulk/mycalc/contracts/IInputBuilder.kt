package by.paulk.mycalc.contracts

interface IInputBuilder {
    fun build (pressedButton: CharSequence,input: String): String
}