package by.paulk.mycalc.inputBuilder

import by.paulk.mycalc.contracts.IInputBuilder

class InputBuilder : IInputBuilder {

    override fun build (pressedButton: CharSequence,input: String): String{

        val endsWithDigit = ".*\\d$".toRegex()
        val containsOperator = "[*/+\\-]".toRegex()
        val containsOneDot = "\\.".toRegex()

        var result:String = input

        when (pressedButton) {
            "+","-","*","/" -> if (input.matches(endsWithDigit)){
                result = input.plus(pressedButton)
            }
            "0","1","2","3","4","5","6","7","8","9" -> if (!input.endsWith("ERROR",true)) {
                result = input.plus(pressedButton)
            }
            "." -> if (input.matches(endsWithDigit)&& !input.contains(containsOneDot)){
                result = input.plus(pressedButton)
            }
            "C" -> result = ""

            "=" -> result = if (input.matches(endsWithDigit)&& input.contains(containsOperator)){
                input
            } else {
                ""
            }
        }
        return result
    }
}