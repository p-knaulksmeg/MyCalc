package by.paulk.mycalc.inputBuilder

import by.paulk.mycalc.contracts.IInputBuilder

class InputBuilder : IInputBuilder {

    val endsWithDigit = ".*\\d$".toRegex()
    val containsOperator = "[*/+\\-]".toRegex()
    val containsOneDot = "\\.".toRegex()

    override fun build (pressedButton: CharSequence,input: String): String{

        return when (pressedButton) {

            "+","-","*","/" -> (if (input.matches(endsWithDigit)){
                input.plus(pressedButton)
            }
                    else{

            }).toString()

            "0","1","2","3","4","5","6","7","8","9" -> (if (!input.endsWith("ERROR",true)) {
                input.plus(pressedButton)
            }
            else{

            }).toString()

            "." -> (if (input.matches(endsWithDigit)&& !input.contains(containsOneDot)){
                input.plus(pressedButton)
            }
            else{

            }).toString()

            "C" -> ""

            "=" -> (if (input.matches(endsWithDigit)&& input.contains(containsOperator)){
                input
            }
            else{

            }).toString()

            else -> ""
        }
    }
}